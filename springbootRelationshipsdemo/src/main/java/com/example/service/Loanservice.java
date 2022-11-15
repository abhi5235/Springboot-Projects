package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ManytoOneEntity.HdfcCustomer;
import com.example.ManytoOneEntity.Loan;
import com.example.repo.HdfcCustomerRepo;
import com.example.repo.LoanRepository;

@Service
public class Loanservice {
	@Autowired
	LoanRepository loanrepo;
	@Autowired
	HdfcCustomerRepo hdfcRepo;

	public Loan addLoanCustomerDataInDB(Loan loan) {
		Loan savedObj = loanrepo.save(loan);
		return savedObj;
	}

	public Loan getLoanCustomer(int id) {
		Optional<Loan> optionalLaonCustomer = loanrepo.findById(id);
		Loan loan = optionalLaonCustomer.get();
		return loan;

	}

	public List<Loan> fetchAllLoanFromDB(int id) {
		return loanrepo.fetchById(id);
	}

	public List<Loan> getLoansfromRepoWithCustomerId(int customerId) {
		Optional<HdfcCustomer> OptionalCustomer = hdfcRepo.findById(customerId);
		if (OptionalCustomer.isPresent()) {
			HdfcCustomer hdfcCustomer = OptionalCustomer.get();
			return loanrepo.findByCustomer(hdfcCustomer);
		}
		return null;
	}

}
