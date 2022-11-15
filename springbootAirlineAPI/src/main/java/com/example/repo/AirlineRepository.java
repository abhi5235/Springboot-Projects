package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.IndigoAirline;

public interface AirlineRepository extends CrudRepository<IndigoAirline, Integer>{

}
