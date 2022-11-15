package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.IndigoAirlineDTO;
import com.example.dto.PassengerDTO;
import com.example.entity.Passenger;
import com.example.repo.PassengerRepo;

@Service
public class PassengerService {

	@Autowired
	PassengerRepo passRepo;
	@Autowired
	RestTemplate restTemplate;

	String url = "http://localhost:8001/airline";

	public Passenger addPassenegerDetailsInDB(Passenger passenger) {
		Passenger savedObj = passRepo.save(passenger);
		return savedObj;
	}

	public PassengerDTO bookMyFlightTicket(int passengerNo, int flightNo, String origin, String destination) {
		Optional<Passenger> optPassenger = passRepo.findById(passengerNo);
		if (optPassenger.isPresent()) {
			Passenger passenger = optPassenger.get();
			PassengerDTO passengerDTO = passenger.convertToDTO(passenger);
			IndigoAirlineDTO indiDTO = new IndigoAirlineDTO();
			indiDTO.setPassengerNo(passengerNo);
			indiDTO.setFlightNo(flightNo);
			indiDTO.setDestination(destination);
			indiDTO.setOrigin(origin);
			IndigoAirlineDTO response = restTemplate.postForObject(url, indiDTO, IndigoAirlineDTO.class);
			passengerDTO.setAirlineinfo(response);
			return passengerDTO;
		}
		return null;
	}

}
