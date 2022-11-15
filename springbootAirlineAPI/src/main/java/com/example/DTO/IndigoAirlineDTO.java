package com.example.DTO;


import com.example.entity.IndigoAirline;

public class IndigoAirlineDTO {

	private static int seatNo = 100;
	private int passengerNo;
	private int flightNo;
	private String origin;
	private String destination;
	private static int availableSeats = 5;

	public int getPassengerNo() {
		return passengerNo;
	}

	public void setPassengerNo(int passengerNo) {
		this.passengerNo = passengerNo;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
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

	public static int getAvailableSeats() {
		return availableSeats;
	}

	public static void setAvailableSeats(int availableSeats) {
		IndigoAirlineDTO.availableSeats = availableSeats;
	}

	public IndigoAirline createEntity() {
		IndigoAirline indigo=new IndigoAirline();
		indigo.setSeatNo(seatNo);
		seatNo++;
		indigo.setDestination(this.getDestination());
		indigo.setFlightNo(this.getFlightNo());
		indigo.setOrigin(this.getOrigin());
		indigo.setPassengerNo(this.getPassengerNo());
		availableSeats--;
		return indigo;
	}
}
