package com.xworkz.toy.handler;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.xworkz.toy.handlererror.ErrorDeatils;



@ControllerAdvice

public  class CustomiseResponseEntityExceptionhandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ToyNotFoundException.class)
public final ResponseEntity<ErrorDeatils> handleToyNotFoundException(ToyNotFoundException ex, WebRequest request)throws Exception{
		
		ErrorDeatils error=new ErrorDeatils(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		
	return 	new ResponseEntity<ErrorDeatils>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																HttpHeaders headers, HttpStatusCode status, 
																				WebRequest request){
	ErrorDeatils error=new ErrorDeatils(LocalDate.now(),"number of errors are : "+ex.getErrorCount()+"and is follows :"+ex.getFieldError().getDefaultMessage() ,request.getDescription(false));
	
	return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	
	}
}
