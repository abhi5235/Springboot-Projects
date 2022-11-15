package com.example.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.dto.AddressPassengerDTO;
import com.example.dto.PassengerDTO;

@Entity
public class Passenger {

	@Id
	private int id;
	private String passengerName;
	private int phoneNo;
	@Embedded
	private AddressPassenger addr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public AddressPassenger getAddr() {
		return addr;
	}

	public void setAddr(AddressPassenger addr) {
		this.addr = addr;
	}

	public PassengerDTO convertToDTO(Passenger passenger) {
		PassengerDTO passengerDTO=new PassengerDTO();
		passengerDTO.setId(passenger.getId());
		passengerDTO.setPassengerName(passenger.getPassengerName());
		passengerDTO.setPhoneNo(passenger.getPhoneNo());
		AddressPassengerDTO addrDTO=new AddressPassengerDTO();
		addrDTO.setCity(passenger.getAddr().getCity());
		addrDTO.setPincode(passenger.getAddr().getPincode());
		addrDTO.setState(passenger.getAddr().getState());
		passengerDTO.setAddr(addrDTO);
		return passengerDTO;
	}
}
