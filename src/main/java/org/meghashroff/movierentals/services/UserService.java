package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.exceptions.UserAlreadyExists;
import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.User;

public interface UserService {

	/*  This method will create a new user */
	public User createUser(User user) throws UserAlreadyExists;
	
	/* This method will delete user account using the user id */
	public void deleteUserAccountById(Integer userId);
	
	/* This method will find the user using the user id */
	public User findByUserId(Integer id);
	
	/* This method will find the user using the user username*/
	public User findByUsername(String username);
	
	/* This method will get the current user */
	public User getCurrentUserInSession();
	
	/* This method will update the user information */
	public User updateUser(User user) throws UserNotFoundException;
}
