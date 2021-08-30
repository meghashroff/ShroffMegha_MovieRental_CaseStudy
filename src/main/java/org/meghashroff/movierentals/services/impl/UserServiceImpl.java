package org.meghashroff.movierentals.services.impl;

import org.meghashroff.movierentals.repositories.UserRepository;
import org.meghashroff.movierentals.services.UserService;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.meghashroff.movierentals.exceptions.UserAlreadyExists;
import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
		
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	
	}
	
	@Override
	public User createUser(User user) throws UserAlreadyExists{
		User existingUser= userRepository.findByUsername(user.getUsername());
		if(existingUser!=null)
			throw new UserAlreadyExists();
		return userRepository.save(user);
	}

	
	@Override
	public User findByUserId(Integer id)  { 
		Optional<User> optUser = userRepository.findById(id);
		if (optUser.isPresent()) {
			return optUser.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public void deleteUserAccountById(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User findByUsername(String username) {
			User foundUser = userRepository.findByUsername(username);
			return foundUser;
	}
	
	public User getCurrentUserInSession() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user=null;
		if(!principal.equals("anonymousUser"))
		{
			UserDetails userDetails = (UserDetails)principal;
			user = userRepository.findByUsername(userDetails.getUsername());
		}
		return user;
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		User existingUser= userRepository.findByUsername(user.getUsername());
		if(existingUser==null)
			throw new UserNotFoundException();
		return userRepository.save(user);
	}

}
