package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.models.User;

public interface UserService {

	public User createUser(User user);
	public User findByEmail(String email);
	public User findByUserId(Integer userId);
	public User save(User user);
	public User findByUserEmailAndPassword(String email, String password);
//	public User merge(User user);
}
