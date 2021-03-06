package com.egalitech.ttc.collector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.xml.transform.StringSource;

@Component
public class FileLoader {

	private static final Logger logger = LoggerFactory.getLogger(FileLoader.class);
	
	@Autowired
	private DataCollector dataCollector;
	
	//@PostConstruct
	public void loadFile() {
		logger.info("Loading file");
		try (
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(in))
		) {
			String line;
			int count = 0;
			while ((line = br.readLine()) != null ) {
				try{
					dataCollector.saveVehicleLocations( new StringSource( line));
					if( count % 1000 == 0) {
						logger.info("Processed line {}", count);
					}
				}
				catch(Exception x) {
					logger.error("{}: {}", x.toString(), line);
				}
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("File loaded");
	}
}
