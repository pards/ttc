package com.egalitech.ttc.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="body")
public class Body {

	@XmlElement(name="route")
	private List<Route> routes;

	@XmlElement(name="vehicle")
	private List<Vehicle> vehicles;
	
	@XmlElement
	private LastTime lastTime;

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public LastTime getLastTime() {
		return lastTime;
	}

	public void setLastTime(LastTime lastTime) {
		this.lastTime = lastTime;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
	
}
