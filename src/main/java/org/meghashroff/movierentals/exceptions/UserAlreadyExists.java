package org.meghashroff.movierentals.exceptions;

/*
 * This is a custom exception class
 * If the user already exists, this exception will be thrown
 * 
 * */
public class UserAlreadyExists extends Exception{
	private static final long serialVersionUID = 1L;

	
	public UserAlreadyExists() {
		super("There is already a user registered with the user name provided");
	}
	
	public UserAlreadyExists(String message) {
		super(message);
	}
}

