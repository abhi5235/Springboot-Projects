package com.example.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.EmployeeAPIException;


@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public ResponseEntity<ErrorInfo> handleHttpClientErrorException(Exception exception){
		ErrorInfo error=new ErrorInfo();
		error.setErrorcode(HttpStatus.NOT_FOUND);
		error.setMessage(exception.getMessage());
		error.setTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> handleHttpClientErrorException(EmployeeAPIException exception){
		ErrorInfo error=new ErrorInfo();
		error.setErrorcode(HttpStatus.NOT_FOUND);
		error.setMessage(exception.getMessage());
		error.setTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> handleEmployeeAPIException(MethodArgumentNotValidException exception){
		ErrorInfo error=new ErrorInfo();
		String message = exception.getBindingResult().getAllErrors().stream().map(m -> m.getDefaultMessage())
				.collect(Collectors.joining(","));
		error.setErrorcode(HttpStatus.BAD_REQUEST);
		error.setMessage(message);
		error.setTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
}
