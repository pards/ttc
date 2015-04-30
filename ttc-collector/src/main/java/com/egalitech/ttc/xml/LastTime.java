package com.egalitech.ttc.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class LastTime {

	private static final DateTimeZone TORONTO = DateTimeZone.forID("America/Toronto");
	
	@XmlAttribute private long time;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public DateTime getDateTime() {
		return new DateTime(getTime(), TORONTO);
	}
}
