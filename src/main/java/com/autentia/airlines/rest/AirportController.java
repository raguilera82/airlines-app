package com.autentia.airlines.rest;

import com.autentia.airlines.model.Airport;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class AirportController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${airports-url}")
	String airportsUrl;
	
	@Value("${saludo}")
	String saludo;
	
	@GetMapping("/airports")
	@HystrixCommand(fallbackMethod="getAirportsEmpty")
	public Airport[] getAirports() {
		return restTemplate.getForObject(this.airportsUrl + "/airport", Airport[].class);
			
	}
	
	private Airport[] getAirportsEmpty() {
		return new Airport[0];
	}
	
	@GetMapping("/hola")
	public String getHola() {
		return this.saludo;
	}
	

}
