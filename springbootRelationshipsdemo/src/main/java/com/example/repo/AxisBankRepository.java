package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.OnetoManyEntity.AxisBankCustomer;

public interface AxisBankRepository extends CrudRepository<AxisBankCustomer, Integer>{


}
