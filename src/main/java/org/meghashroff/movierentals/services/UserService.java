package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.exceptions.UserAlreadyExists;
import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.User;

public interface UserService {

	public User createUser(User user) throws UserAlreadyExists;
	public void deleteUserAccountById(Integer userId);
	public User findByUserId(Integer id);
	public User findByUsername(String username);
	public User getCurrentUserInSession();
	public User updateUser(User user) throws UserNotFoundException;
}
