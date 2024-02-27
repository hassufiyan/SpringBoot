package com.xworkz.toy.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToyNotFoundException extends RuntimeException {
	
	
	String msg;
	
	public ToyNotFoundException(String msg) {
		this.msg=msg;
	}
	
public String getMessage() {
	return msg;
}
}
