package com.example.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorInfo {

	HttpStatus errorcode;
	String message;
	String time;
	public HttpStatus getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(HttpStatus errorcode) {
		this.errorcode = errorcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String string) {
		this.time = string;
	}
}
