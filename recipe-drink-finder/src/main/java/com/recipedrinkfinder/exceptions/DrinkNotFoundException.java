package com.recipedrinkfinder.exceptions;

public class DrinkNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DrinkNotFoundException(String message) {
		super(message);
	}
	
	

}
