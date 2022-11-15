package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnetoManyEntity.AxisBankCustomer;
import com.example.service.AxisBankService;

@RestController
public class AxisBankController {
	@Autowired
	AxisBankService axisservice;

	@PostMapping("/axisBank")
	public AxisBankCustomer addBankCustomer(@RequestBody AxisBankCustomer axis) {
		return axisservice.addBankCustomerInDB(axis);

	}
	@GetMapping("/axisGet/{id}")
	public AxisBankCustomer getBankCustomer(@PathVariable int id) {
		return axisservice.getBankCustomerDetails(id);
	}
	@GetMapping("/axisValid/{id}")
	public AxisBankCustomer getValidCards(@PathVariable int id){
		return axisservice.getCardDetails(id);
	}
	@PutMapping("/update")
	public AxisBankCustomer updateDetails(@RequestBody AxisBankCustomer customerfromPayLoad) {
		return axisservice.updateCardDetails(customerfromPayLoad);
		
	}
}

