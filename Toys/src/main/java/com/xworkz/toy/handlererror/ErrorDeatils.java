package com.xworkz.toy.handlererror;

import java.sql.Date;
import java.time.LocalDate;


public class ErrorDeatils {
	
	
private	LocalDate timeStamp;
private	String message;
private	String details;
	
	
	
	
	
	public ErrorDeatils() {
		super();
		// TODO Auto-generated constructor stub
	}





	public ErrorDeatils(LocalDate timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}





	public LocalDate getTimeStamp() {
		return timeStamp;
	}





	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}





	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}





	public String getDetails() {
		return details;
	}





	public void setDetails(String details) {
		this.details = details;
	}





	@Override
	public String toString() {
		return "ErrorDeatils [timeStamp=" + timeStamp + ", message=" + message + ", details=" + details + "]";
	}
	
	
	
	

}
