package com.example.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.IndigoAirlineDTO;
import com.example.entity.IndigoAirline;
import com.example.repo.AirlineRepository;

@Service
public class AirlineService {

	@Autowired
	AirlineRepository airlineRepo;

	public IndigoAirline addAirlineDetailsInDB(IndigoAirlineDTO airlineDTO) {
		IndigoAirline indigoAirline=null;
		if(IndigoAirlineDTO.getAvailableSeats()>0) {
			indigoAirline=airlineDTO.createEntity();
			return airlineRepo.save(indigoAirline);
		}
		return null;
	}

	public IndigoAirline getAirlineDetailsFromDB(int id) {
		Optional<IndigoAirline> optionalAirline = airlineRepo.findById(id);
		IndigoAirline indigoAirline = optionalAirline.get();
		return indigoAirline;
		
	}

}
