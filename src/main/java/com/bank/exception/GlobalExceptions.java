package com.bank.exception;

import java.net.http.HttpHeaders;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptions extends  ResponseEntityExceptionHandler{
	public final ResponseEntity<Object> handleAllExceptions(CustomErrorDetails ex) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
				"from method argument not valid exception", ex.getMessage());
	    return new ResponseEntity<Object>(customErrorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleUserNootFoundException(NotFoundException ex, WebRequest request){
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
				"Not found exception", ex.getLocalizedMessage());
		
		return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
	}	

}
