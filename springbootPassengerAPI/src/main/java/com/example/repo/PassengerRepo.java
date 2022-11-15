package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Passenger;

public interface PassengerRepo extends CrudRepository<Passenger, Integer> {

}
