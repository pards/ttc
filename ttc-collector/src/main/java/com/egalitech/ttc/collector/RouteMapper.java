package com.egalitech.ttc.collector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.egalitech.ttc.dao.RouteRepository;
import com.egalitech.ttc.dao.StopRepository;
import com.egalitech.ttc.xml.Body;
import com.egalitech.ttc.xml.Stop;
import com.vividsolutions.jts.io.ParseException;

@Component
public class RouteMapper {

	@Autowired
	private RouteRepository routeRepo;
	
	@Autowired
	private StopRepository stopRepo;
	
	@Autowired
	private Unmarshaller unmarshaller;
	
	public List<String> getRouteTags(Source source) throws XmlMappingException, IOException, ParseException {
		Body l = (Body)unmarshaller.unmarshal( source);
		List<String> result = new ArrayList<>();
		List<com.egalitech.ttc.xml.Route> xmlList = l.getRoutes();
		if( xmlList != null) {
			for( com.egalitech.ttc.xml.Route xml : xmlList) {
				result.add( xml.getTag());
			}
		}
		return result;
	}
	
	@Async
	public void saveRoutesAndStops(Source source) throws XmlMappingException, IOException, ParseException {
		Body l = (Body)unmarshaller.unmarshal( source);
		
		List<com.egalitech.ttc.xml.Route> xmlList = l.getRoutes();
		if( xmlList != null) {
			for( com.egalitech.ttc.xml.Route xml : xmlList) {
				com.egalitech.ttc.model.Route model = routeRepo.findByTag( xml.getTag());
				if( model == null) {
					model = new com.egalitech.ttc.model.Route();
				}
				model.setTag( xml.getTag());
				model.setTitle( xml.getTitle());
				routeRepo.save(model);
				
				List<Stop> stops = xml.getStops();
				if( stops != null) {
					for (Stop xmlStop : stops) {
						com.egalitech.ttc.model.Stop modelStop = stopRepo.findById( xmlStop.getStopId());
						if( modelStop == null) {
							modelStop = new com.egalitech.ttc.model.Stop();
						}
						modelStop.setId( xmlStop.getStopId());
						modelStop.setLat( xmlStop.getLat());
						modelStop.setLon( xmlStop.getLon());
						modelStop.setTag( xmlStop.getTag());
						modelStop.setTitle( xmlStop.getTitle());
						modelStop.setRoute(model);
						stopRepo.save(modelStop);
					}
				}
			}
		}
	}
}
