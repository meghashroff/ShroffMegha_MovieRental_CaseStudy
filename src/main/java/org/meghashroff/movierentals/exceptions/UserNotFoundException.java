package org.meghashroff.movierentals.exceptions;

/*
 * This is a custom exception class 
 * If the user is not found, this exception will be thrown
 * 
 * */
public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;


	public UserNotFoundException() {
		super("User not found.");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
