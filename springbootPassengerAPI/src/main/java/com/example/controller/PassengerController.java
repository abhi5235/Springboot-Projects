package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PassengerDTO;
import com.example.entity.Passenger;
import com.example.service.PassengerService;

@RestController
public class PassengerController {

	@Autowired
	PassengerService passService;
	
	@PostMapping("/passenger")
	public Passenger addPassengerDetails(@RequestBody Passenger passenger) {
		passService.addPassenegerDetailsInDB(passenger);
		return passenger;
		
	}
	
	@GetMapping("/bookMyTicket")
	public PassengerDTO bookMyTicket(int passengerNo,int flightNo,String origin,String destination ) {
		return passService.bookMyFlightTicket(passengerNo,flightNo,origin,destination);
		
	}
}
