package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer;
import com.example.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService custservice;

	@PostMapping("/customer")
	public Customer addCustomerDeatils(@RequestBody Customer cust) {
		Customer addedObj = custservice.addCustomerDataInDB(cust);
		return addedObj;
	}

	@GetMapping("/customerGet/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return custservice.getCustomerDatafromDB(id);

	}
	@PutMapping("/CustomeUpdate")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return custservice.updateDataofCustomer(customer);

	}
}
