package org.meghashroff.movierentals.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyString;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.repositories.UserRepository;
import org.meghashroff.movierentals.services.impl.UserServiceImpl;
import org.mockito.Mockito;


public class UsersMockitoTest {

	private static UserService userService;
	private static UserRepository userRepository;
	
	@BeforeAll
	static void setup() {
		userRepository = Mockito.mock(UserRepository.class);
		userService = new UserServiceImpl(userRepository);
	}
	
	@Test
	void testFindByUsername() throws UserNotFoundException {
		
		Mockito.when(userRepository.findByUsername(anyString())).thenReturn(
				new User("Megha", "Shroff", "meghashroff", "megha@email.com", "megha1234", "234567654"));
		User actual = userService.findByUsername("meghashroff");
		User expected = new User("Megha", "Shroff", "meghashroff", "megha@email.com", "megha1234", "234567654");
		assertEquals(expected, actual);
	}
	
}

