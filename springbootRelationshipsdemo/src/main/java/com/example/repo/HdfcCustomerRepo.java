package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.ManytoOneEntity.HdfcCustomer;

public interface HdfcCustomerRepo extends CrudRepository<HdfcCustomer, Integer> {

}
