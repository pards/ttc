package com.egalitech.ttc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class VehicleLocation {

    @Id
    @SequenceGenerator(name="vehicle_location_seq", sequenceName="vehicle_location_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vehicle_location_seq")
    private Integer vehicleId;
	
	private String id;
	private String routeTag;
	private String dirTag;
	private double lat;
	private double lon;
	private double heading;
	private int secsSinceReport;
	private boolean predictable;
	private long time;
	
//	@Type(type="org.hibernate.spatial.GeometryType")
//	private Point location;
	
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
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
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getHeading() {
		return heading;
	}
	public void setHeading(double heading) {
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
//	public Point getLocation() {
//		return location;
//	}
//	public void setLocation(Point location) {
//		this.location = location;
//	}
}
