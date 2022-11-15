package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManytoOneEntity.Loan;
import com.example.service.Loanservice;

@RestController
public class LoanController {
	@Autowired
	Loanservice loanservice;

	@PostMapping("/Hdfc")
	public Loan addLoanCustomerDeatils(@RequestBody Loan loan) {
		Loan addedObj=loanservice.addLoanCustomerDataInDB(loan);
		return addedObj;
	}
	@GetMapping("/LoanCust/{id}")
	public Loan getData(@PathVariable int id) {
		return loanservice.getLoanCustomer(id);
		
	}
	@GetMapping("/loanCustId/{id}")
	public List<Loan> fetchAllLoan(@PathVariable int id) {
		return loanservice.fetchAllLoanFromDB(id);
	}
	@GetMapping("/loan/{CustomerId}")
	public List<Loan> getLoans(@PathVariable int customerId) {
		return loanservice.getLoansfromRepoWithCustomerId(customerId);
	}
}
