package com.egalitech.ttc.collector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

import com.egalitech.ttc.model.VehicleLocation;
import com.egalitech.ttc.xml.Body;
import com.egalitech.ttc.xml.Vehicle;
import com.vividsolutions.jts.io.ParseException;

@Component
public class VehicleLocationMapper {

	protected static final Logger logger = LoggerFactory.getLogger(VehicleLocationMapper.class);
	private long lastTime = 0;
	
	@Autowired
	private Unmarshaller unmarshaller;
	
	public List<VehicleLocation> map(Source source) throws XmlMappingException, IOException, ParseException {
		Body l = (Body)unmarshaller.unmarshal( source);
		lastTime = l.getLastTime().getTime();
		
		List<VehicleLocation> vehicleLocations = new ArrayList<>();
		List<Vehicle> xmlVehicles = l.getVehicles();
//		WKTReader wkt = new WKTReader();
//		final String fmt = "POINT(%f %f)";
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
				
//				String pointStr = String.format( fmt, xml.getLon(), xml.getLat());
//				Point point = (Point)wkt.read( pointStr);
//				model.setLocation( point);
				
				vehicleLocations.add(model);
			}
		}
		return vehicleLocations;
	}
}
