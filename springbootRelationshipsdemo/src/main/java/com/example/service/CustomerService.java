package com.example.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repo.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository custRepo;

	public Customer addCustomerDataInDB(Customer cust) {
		Customer savedObj = custRepo.save(cust);
		return savedObj;

	}

	public Customer getCustomerDatafromDB(int id) {
		Optional<Customer> OptionalCustomer = custRepo.findById(id);
		Customer customer = OptionalCustomer.get();
		return customer;
	}
    @Transactional
	public Customer updateDataofCustomer(Customer customer ) {
		Optional<Customer> OptionalCustomer = custRepo.findById(customer.getCustomer_id());
		if (OptionalCustomer.isPresent()) {
			Customer cust = OptionalCustomer.get();
			cust.setCustomer_id(customer.getCustomer_id());
			cust.setCustomername(customer.getCustomername());
			cust.setCustomeremail(customer.getCustomeremail());
			cust.setAddr(customer.getAddr());
			return cust;
		}
		return null;
	
	}

	

}
