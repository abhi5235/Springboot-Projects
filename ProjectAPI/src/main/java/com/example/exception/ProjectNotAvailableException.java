package com.example.exception;

public class ProjectNotAvailableException extends RuntimeException {

	public ProjectNotAvailableException(String message) {
		super(message);
	}

}
