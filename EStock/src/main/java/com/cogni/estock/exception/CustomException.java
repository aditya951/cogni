package com.cogni.estock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CustomException extends RuntimeException{

	
	public CustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
