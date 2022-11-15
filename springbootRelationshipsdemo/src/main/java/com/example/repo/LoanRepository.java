package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.ManytoOneEntity.HdfcCustomer;
import com.example.ManytoOneEntity.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer>{

	@Query(value = "select * from Loan where cust_id=?1", nativeQuery = true)
	List<Loan> fetchById(int id);

	List<Loan> findByCustomer(HdfcCustomer hdfcCustomer);


}
