package org.meghashroff.movierentals.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.meghashroff.movierentals.config.WebAppConfig;
import org.meghashroff.movierentals.exceptions.UserAlreadyExists;
import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.Movie;
import org.meghashroff.movierentals.models.RentalTransaction;
import org.meghashroff.movierentals.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserIT {

	private RentalTransactionService rentalTransactionService;
	private UserService userService;
	private MovieService movieService;
	private static Validator validator;
	private Movie movie1;
	private Movie movie2;
	private User user;
//	private User testUser;
	
	@Autowired
	public UserIT(RentalTransactionService rentalTransactionService, 
			UserService userService, MovieService movieService) {
		this.rentalTransactionService = rentalTransactionService;
		this.userService = userService;
		this.movieService= movieService;
	}
	
//	@Test
//	void testCreateUser() throws UserAlreadyExists {
//		testUser = new User("ME","Sh","meg","meg@email.com","test1234","2345678901");
//		User expected = userService.createUser(testUser);
//		User actual = userService.findByUsername(testUser.getUsername());
//		assertEquals(expected,actual);
//	}
	
	
	
	@BeforeAll
	void setupAll() throws UserAlreadyExists {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		user = new User("TestFirstName","TestLastName","test","test@email.com","test1234","2345678901");
		this.movie1 = new Movie("Test", "Test", "2021", 
				"images/test.jpg", "TestDesc");
		this.movie2 = new Movie("Test2", "Test2", "2021", 
						"images/test2.jpg", "Test2Desc");

		movie1= movieService.saveMovie(movie1);
		movie2= movieService.saveMovie(movie2);
		
		Set<Movie> movieSet = new HashSet<Movie>(); 
		movieSet.add(movie1);
		movieSet.add(movie2);
		RentalTransaction rentalTransaction = new RentalTransaction(LocalDateTime.now(), movieSet);
		rentalTransactionService.saveRentalTransaction(rentalTransaction);
		List<RentalTransaction> trans = new ArrayList<RentalTransaction>();
		trans.add(rentalTransaction);
		user.setRentalTrans(trans);
		userService.createUser(user);
	}
	
	
	@AfterAll
	public void clearSetUp() {
		userService.deleteUserAccountById(user.getUserId());
		movieService.deleteByMovieId(movie1.getMovieId());
		movieService.deleteByMovieId(movie2.getMovieId());
	}

	@ParameterizedTest
	@ValueSource(strings = {"Name cant be empty", "Password cant be empty", "Username cant be empty","Should be 10 digits","Invalid email"})
	public void testUserInputsNotEmpty(String message) {
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		assertNotEquals(message, violations.toString());
	}
	
//	@Test
//	void testUserFirstNameNotEmpty() {
//		Set<ConstraintViolation<User>> violations = validator.validate(user);
//		System.out.println(violations.toString());
//		assertFalse(violations.toString().contains("Name cant be empty."));
//	}
//	
//	@Test
//	void testUserPasswordNameNotEmpty() {
//		Set<ConstraintViolation<User>> violations = validator.validate(user);
//		System.out.println(violations.toString());
//		assertFalse(violations.toString().contains("Password cant be empty"));
//	}
//	
//	@Test
//	void testUsernameNotEmpty() {
//		Set<ConstraintViolation<User>> violations = validator.validate(user);
//		System.out.println(violations.toString());
//		assertFalse(violations.toString().contains("Username cant be empty."));
//	}
//	
//	@Test
//	void testUserInvalidEmailPattern() {
//		Set<ConstraintViolation<User>> violations = validator.validate(user);
//		assertFalse(violations.toString().contains("Invalid email"));
//	}
//	
//	@Test
//	void testUserPhoneNoHas10Digits() {
//		Set<ConstraintViolation<User>> violations = validator.validate(user);
//		assertFalse(violations.toString().contains("Should be 10 digits"));
//	}
	
	@Test
	public void testFindById() {
		User actualUser = userService.findByUserId(user.getUserId());
			assertEquals(user, actualUser);
		}
	
	@Test
	public void testFindByUsername() throws UserNotFoundException {
		User actualUser = userService.findByUsername(user.getUsername());
		assertEquals(user, actualUser);
	}
	
	@Test
	void testCreateUserThrowsException(){
		assertThrows(UserAlreadyExists.class, () -> {
			userService.createUser(user);
		});
		
	}
	
	@Test
	void testUpdateUserThrowsException(){
		assertThrows(UserNotFoundException.class, () -> {
			userService.updateUser(new User());
		});
	}

}
