package com.zensar.tp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidUserDataException extends RuntimeException{
	 private static final long serialVersionUID = 1L;
	    private String message;
	public InvalidUserDataException() {
		this.message= "";
	}
	public InvalidUserDataException(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return "Invalid User Data: " + message;
	}
}
