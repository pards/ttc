package com.egalitech.ttc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.egalitech.ttc.xml.LastTime;
import com.egalitech.ttc.xml.Route;
import com.egalitech.ttc.xml.RouteConfig;
import com.egalitech.ttc.xml.Stop;
import com.egalitech.ttc.xml.Vehicle;
import com.egalitech.ttc.xml.VehicleLocations;

@Configuration
@EnableAsync
@EnableScheduling
public class AppConfig {

	@Bean
	public Unmarshaller jaxbUnmarshaller() {
		Jaxb2Marshaller result = new Jaxb2Marshaller();
		result.setClassesToBeBound(
			LastTime.class,
			Route.class,
			RouteConfig.class,
			Stop.class,
			Vehicle.class,
			VehicleLocations.class
		);
		return result;
	}
}
