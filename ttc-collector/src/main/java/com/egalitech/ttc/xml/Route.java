package com.egalitech.ttc.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Route {

	@XmlElement(name="stop")
	private List<Stop> stops;
	
	@XmlAttribute private String tag;
	@XmlAttribute private String title;
	@XmlAttribute private String color;
	@XmlAttribute private String oppositeColor;
	@XmlAttribute private float latMin;
	@XmlAttribute private float lonMin;
	@XmlAttribute private float latMax;
	@XmlAttribute private float lonMax;

	public List<Stop> getStops() {
		return stops;
	}
	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOppositeColor() {
		return oppositeColor;
	}
	public void setOppositeColor(String oppositeColor) {
		this.oppositeColor = oppositeColor;
	}
	public float getLatMin() {
		return latMin;
	}
	public void setLatMin(float latMin) {
		this.latMin = latMin;
	}
	public float getLonMin() {
		return lonMin;
	}
	public void setLonMin(float lonMin) {
		this.lonMin = lonMin;
	}
	public float getLatMax() {
		return latMax;
	}
	public void setLatMax(float latMax) {
		this.latMax = latMax;
	}
	public float getLonMax() {
		return lonMax;
	}
	public void setLonMax(float lonMax) {
		this.lonMax = lonMax;
	}
}
