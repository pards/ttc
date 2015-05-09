package com.egalitech.ttc.controller;

import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

	@RequestMapping(value="/ping", method=RequestMethod.GET, produces="application/json")
	public String ping() {
		return new DateTime().toString();
	}
}
