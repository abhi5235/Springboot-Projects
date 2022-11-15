package com.example.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.StudentNotAvailableException;

//Central exception handler class
@RestControllerAdvice
public class ExceptionController {

	//exception handler method
	
	@ExceptionHandler(StudentNotAvailableException.class)
	public ResponseEntity<String> studentNotAvailableException(StudentNotAvailableException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
		
	}
}
