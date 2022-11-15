package com.example.ManytoOneEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HdfcCustomer {

	@Id
	private int customerId;
	private String emailId;
	private String name;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
