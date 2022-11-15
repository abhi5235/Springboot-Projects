package com.example.ManytoOneEntity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loan {
	@Id
	private int loan_Id;
	private int amount;
	private LocalDate issuedDate;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cust_id")
	private HdfcCustomer customer;
	private String status;
	

	public int getLoan_Id() {
		return loan_Id;
	}

	public void setLoan_Id(int loan_Id) {
		this.loan_Id = loan_Id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}

	public HdfcCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(HdfcCustomer customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
