package com.egalitech.ttc.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Vehicle {

	@XmlAttribute private String id;
	@XmlAttribute private String routeTag;
	@XmlAttribute private String dirTag;
	@XmlAttribute private float lat;
	@XmlAttribute private float lon;
	@XmlAttribute private float heading;
	@XmlAttribute private int secsSinceReport;
	@XmlAttribute private boolean predictable;
	
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
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) { return false; }
	    if (obj == this) { return true; }
	    if (obj.getClass() != getClass()) {
	      return false;
	    }
	    Vehicle rhs = (Vehicle) obj;
	    return new EqualsBuilder()
	                  .appendSuper(super.equals(obj))
	                  .append(id, rhs.id)
	                  .isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
		.append(id)
		.toHashCode();
	}

}
