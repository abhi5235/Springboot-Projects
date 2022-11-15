package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.IndigoAirlineDTO;
import com.example.entity.IndigoAirline;
import com.example.service.AirlineService;

@RestController
public class AirlineController {

	@Autowired
	AirlineService airlineService;

	@PostMapping("/airline")
	public IndigoAirline addAirlineDetails(@RequestBody IndigoAirlineDTO airlineDTO) {
		return airlineService.addAirlineDetailsInDB(airlineDTO);
	}
	@GetMapping("/getAirline/{id}")
	public IndigoAirline getAirlineDetails(@PathVariable int id) {
		return airlineService.getAirlineDetailsFromDB(id);
	}
	
}
