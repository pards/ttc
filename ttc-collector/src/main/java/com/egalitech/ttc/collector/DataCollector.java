package com.egalitech.ttc.collector;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.egalitech.ttc.dao.VehicleLocationRepository;
import com.egalitech.ttc.model.VehicleLocation;
import com.vividsolutions.jts.io.ParseException;

@Component
public class DataCollector {

	private static final Logger logger = LoggerFactory.getLogger(DataCollector.class);
	
	@Value("${ttc.url.vehicle.locations}")
	private String vehicleLocationsUrl;
	
	@Value("${ttc.url.routes}")
	private String routesUrl;
	
	@Value("${ttc.url.stops}")
	private String stopsUrl;
	
	private long lastTime = 0;
	
	@Autowired
	private Unmarshaller unmarshaller;
	
	@Autowired
	private VehicleLocationRepository vehicleLocationRepo;
	
	@Autowired
	private VehicleLocationMapper vehicleLocationMapper;
	
	@Autowired
	private RouteMapper routesMapper;
	
	@Scheduled( fixedDelay=10000, initialDelay=1000)
	public void getVehicleLocations() {
		try {
			Source source = new StreamSource(new URL(vehicleLocationsUrl + lastTime).openStream());
			saveVehicleLocations(source);
		} catch (XmlMappingException | IOException | ParseException e) {
			logger.error("Error reading URL {}{}", vehicleLocationsUrl, lastTime, e);
		}
	}

	public void saveVehicleLocations(Source source) throws XmlMappingException, IOException, ParseException {
		List<VehicleLocation> vehicleLocations = vehicleLocationMapper.map(source);
		logger.debug("Saving {} vehicle location reports", vehicleLocations.size());
		vehicleLocationRepo.save(vehicleLocations);
	}
	
	// Once per day
	@Scheduled( fixedDelay=86400000, initialDelay=30000)
	public void saveRoutesAndStop() {
		logger.info("Loading routes");
		try {
			Source source = new StreamSource(new URL(routesUrl).openStream());
			List<String> routeTags = routesMapper.getRouteTags(source);
			if( routeTags != null) {
				for( String routeTag : routeTags) {
					logger.debug("Route {}", routeTag);
					source = new StreamSource(new URL(stopsUrl + routeTag).openStream());
					routesMapper.saveRoutesAndStops(source);
				}
			}
		} catch (XmlMappingException | IOException | ParseException e) {
			logger.error("Error reading URL {}", routesUrl, e);
		}
		logger.info("Done loading routes");
	}
}
