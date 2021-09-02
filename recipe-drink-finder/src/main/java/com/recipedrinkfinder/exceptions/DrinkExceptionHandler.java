package com.recipedrinkfinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DrinkExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<DrinkErrorResponse> handleExcpetion(DrinkNotFoundException exc){
		
		DrinkErrorResponse error = new DrinkErrorResponse(
										HttpStatus.NOT_FOUND.value(),
										exc.getMessage(),
										System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<DrinkErrorResponse> handleExcpetion(Exception exc){
		
		DrinkErrorResponse error = new DrinkErrorResponse(
										HttpStatus.BAD_REQUEST.value(),
										exc.getMessage(),
										System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);		
	}
}
