package com.example.dto;

public class PassengerDTO {

	private int id;
	private String passengerName;
	private int phoneNo;
	private AddressPassengerDTO addr;
	private IndigoAirlineDTO airlineinfo;
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
	public AddressPassengerDTO getAddr() {
		return addr;
	}
	public void setAddr(AddressPassengerDTO addr) {
		this.addr = addr;
	}
	public IndigoAirlineDTO getAirlineinfo() {
		return airlineinfo;
	}
	public void setAirlineinfo(IndigoAirlineDTO airlineinfo) {
		this.airlineinfo = airlineinfo;
	}
}
