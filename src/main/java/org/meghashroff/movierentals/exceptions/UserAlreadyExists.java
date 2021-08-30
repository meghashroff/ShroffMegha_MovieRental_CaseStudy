package org.meghashroff.movierentals.exceptions;

public class UserAlreadyExists extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public UserAlreadyExists() {
		super("There is already a user registered with the user name provided");
	}
	
	public UserAlreadyExists(String message) {
		super(message);
	}
}

