package com.example.exception;


public class StudentNotAvailableException extends RuntimeException {

	public StudentNotAvailableException(String message) {
		super(message);
	}

}
