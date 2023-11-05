package com.zensar.tp.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	  private String message;
	    public InvalidException() {
	        this.message = "";
	    }
	    
	    public InvalidException(String message) {
	        this.message = message;
	    }

	   @Override
	    public String toString() {
	        return "Resource Not Found " + message;
	    }
}

