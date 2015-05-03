package com.egalitech.ttc.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Route {

    @Id
    @SequenceGenerator(name="route_seq", sequenceName="route_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="route_seq")
    private int routeId;
	private String tag;
	private String title;

	@OneToMany
	private Set<Stop> stops;
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
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
	public Set<Stop> getStops() {
		return stops;
	}
	public void setStops(Set<Stop> stops) {
		this.stops = stops;
	}
}
