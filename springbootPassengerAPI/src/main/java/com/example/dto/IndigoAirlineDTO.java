package com.example.dto;

public class IndigoAirlineDTO {

	private int seatNo;
	private int passengerNo;
	private int flightNo;
	private String origin;
	private String destination;
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getPassengerNo() {
		return passengerNo;
	}
	public void setPassengerNo(int passengerNo) {
		this.passengerNo = passengerNo;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo2) {
		this.flightNo = flightNo2;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
