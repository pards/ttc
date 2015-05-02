package com.egalitech.ttc.collector;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

import com.egalitech.ttc.dao.VehicleLocationRepository;
import com.egalitech.ttc.model.VehicleLocation;
import com.egalitech.ttc.xml.Vehicle;
import com.egalitech.ttc.xml.VehicleLocations;
import com.vividsolutions.jts.geom.Point;

@Component
public class DataCollector {

	private static final Logger logger = LoggerFactory.getLogger(DataCollector.class);
	
	@Value("${ttc.url.vehicle.locations}")
	private String url;
	
	private long lastTime = 0;
	
	@Autowired
	private Unmarshaller unmarshaller;
	
	@Autowired
	private VehicleLocationRepository repo;
	
	//@Scheduled( fixedDelay=10000, initialDelay=1000)
	public void run() {
		try {
			save(new StreamSource(new URL(url + lastTime).openStream()));
		} catch (XmlMappingException | IOException e) {
			logger.error("Error reading URL {}{}", url, lastTime, e);
		}
	}
	
	public void save(Source source) throws XmlMappingException, IOException {
		VehicleLocations l = (VehicleLocations)unmarshaller.unmarshal( source);
		lastTime = l.getLastTime().getTime();
		
		List<VehicleLocation> vehicleLocations = new ArrayList<>();
		List<Vehicle> xmlVehicles = l.getVehicles();
		if( xmlVehicles != null) {
			for( Vehicle xml : xmlVehicles) {
				VehicleLocation model = new VehicleLocation();
				model.setDirTag( xml.getDirTag());
				model.setHeading( xml.getHeading());
				model.setId(xml.getId());
				model.setLat( xml.getLat());
				model.setLon( xml.getLon());
				model.setPredictable(xml.isPredictable());
				model.setRouteTag( xml.getRouteTag());
				model.setSecsSinceReport( xml.getSecsSinceReport());
				model.setTime( lastTime);
				model.setLocation( new Point(xml.getLon(), xml.getLat()));
				vehicleLocations.add(model);
			}
		}
		logger.debug("Saving {} vehicle location reports", vehicleLocations.size());
		repo.save(vehicleLocations);
	}
}
