package org.meghashroff.movierentals.services.impl;

import org.meghashroff.movierentals.repositories.UserRepository;
import org.meghashroff.movierentals.services.UserService;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.meghashroff.movierentals.exceptions.UserNotFoundException;
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
	public User createOrUpdateUser(User user) {
		return userRepository.save(user);
	}

//	@Override
//	public User findByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}

//	@Override
//	public User findByUserId(Integer userId) {
//		return userRepository.findByUserId(userId);
//	}
	
	@Override
	public User findByUserId(Integer id)  { 
		Optional<User> optUser = userRepository.findById(id);
		if (optUser.isPresent()) {
			return optUser.get();
		}
		throw new EntityNotFoundException();
//		throw new UserNotFoundException();
	}

//	@Override
//	public User updateUser(User user) {
//		return userRepository.save(user);
//	}

//	@Override
//	public User findByUserEmailAndPassword(String email, String password) {
//		return userRepository.findByEmailAndPassword(email, password);
//	}

	@Override
	public void deleteUserAccountById(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User findByUsername(String username) throws UserNotFoundException {

			User foundUser = userRepository.findByUsername(username);
			if(foundUser !=null)
				return foundUser;
			throw new UserNotFoundException("User not found");
	}

}
