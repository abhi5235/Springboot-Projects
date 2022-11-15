package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
