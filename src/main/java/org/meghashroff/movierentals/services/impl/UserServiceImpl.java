package org.meghashroff.movierentals.services.impl;

import org.meghashroff.movierentals.repositories.UserRepository;
import org.meghashroff.movierentals.services.UserService;
import org.meghashroff.movierentals.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByUserId(Integer userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUserEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public void deleteUserAccountById(Integer userId) {
		userRepository.deleteById(userId);
	}

}
