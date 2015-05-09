package com.egalitech.ttc.dao;

import org.springframework.data.repository.CrudRepository;

import com.egalitech.ttc.model.Route;

public interface RouteRepository extends CrudRepository<Route,Long>{

	Route findByTag(String tag);

}
