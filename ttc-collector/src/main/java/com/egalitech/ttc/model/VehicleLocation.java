package com.egalitech.ttc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleLocation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String vehicleId;
	
	private String id;
	private String routeTag;
	private String dirTag;
	private float lat;
	private float lon;
	private float heading;
	private int secsSinceReport;
	private boolean predictable;
	private long time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRouteTag() {
		return routeTag;
	}
	public void setRouteTag(String routeTag) {
		this.routeTag = routeTag;
	}
	public String getDirTag() {
		return dirTag;
	}
	public void setDirTag(String dirTag) {
		this.dirTag = dirTag;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	public float getHeading() {
		return heading;
	}
	public void setHeading(float heading) {
		this.heading = heading;
	}
	public int getSecsSinceReport() {
		return secsSinceReport;
	}
	public void setSecsSinceReport(int secsSinceReport) {
		this.secsSinceReport = secsSinceReport;
	}
	public boolean isPredictable() {
		return predictable;
	}
	public void setPredictable(boolean predictable) {
		this.predictable = predictable;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}

}
