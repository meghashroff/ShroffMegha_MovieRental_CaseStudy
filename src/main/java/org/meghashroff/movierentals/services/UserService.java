package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.User;

public interface UserService {

	public User createOrUpdateUser(User user);
//	public User findByEmail(String email);
//	public User findByUserId(Integer userId);
//	public User updateUser(User user);
//	public User findByUserEmailAndPassword(String email, String password);
	public void deleteUserAccountById(Integer userId);
	public User findByUserId(Integer id);
	public User findByUsername(String username) throws UserNotFoundException;
		
}
