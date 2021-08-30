package org.meghashroff.movierentals.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.meghashroff.movierentals.config.WebAppConfig;
import org.meghashroff.movierentals.exceptions.UserAlreadyExists;
import org.meghashroff.movierentals.models.Movie;
import org.meghashroff.movierentals.models.RentalTransaction;
import org.meghashroff.movierentals.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RentalTransactionIT {



	private RentalTransactionService rentalTransactionService;
	private UserService userService;
	private MovieService movieService;
	private Movie movie1;
	private Movie movie2;
	private RentalTransaction rentalTransaction;
	private User user;
	
	@Autowired
	public RentalTransactionIT(RentalTransactionService rentalTransactionService, 
			MovieService movieService,
			UserService userService) {
		this.rentalTransactionService = rentalTransactionService;
		this.movieService = movieService;
		this.userService = userService;
	}
	
	
	@BeforeAll
	void setupAll() throws UserAlreadyExists {
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
		rentalTransaction = new RentalTransaction(LocalDateTime.now(), movieSet);
		rentalTransaction = rentalTransactionService.saveRentalTransaction(rentalTransaction);
		List<RentalTransaction> trans = new ArrayList<RentalTransaction>();
		trans.add(rentalTransaction);
		user.setRentalTrans(trans);
		userService.createUser(user);
	}
	
	
	@AfterAll
	public void deleteUserTransaction() {
		userService.deleteUserAccountById(user.getUserId());
		movieService.deleteByMovieId(movie1.getMovieId());
		movieService.deleteByMovieId(movie2.getMovieId());
	}

	
//	@BeforeAll
//	void setupAll() {
//		this.movie1 = new Movie("Honey, I Shrunk The Kids", "Family", "1989", 
//				"images/honey_shrunk_kids.jpg", null, "The scientist father of a "
//						+ "teenage girl and boy accidentally shrinks his and two "
//						+ "other neighborhood teens to the size of insects. Now "
//						+ "the teens must fight diminutive dangers as  the father "
//						+ "searches for them.");
//		this.movie2 = new Movie("Jurassic World", "Action", "2015", 
//				"images/jurassicworld1.jpg", null, "A new theme park, built on "
//						+ "the original site of Jurassic Park, creates a genetically "
//						+ "modified hybrid dinosaur, the Indominus Rex, which "
//						+ "escapes containment and goes on a killing spree.");
//	}

	@Test
	void testApplicationContext() {
		assertNotNull(rentalTransactionService);
		assertNotNull(movieService);
		assertNotNull(userService);
	}

//	@Test
//	void testSaveRentalTransaction() {
//		/**
//		 * @see: https://stackoverflow.com/questions/25709976/spring-boot-spring-
//		 * data-how-are-hibernate-sessions-managed
//		 * @see: https://thorben-janssen.com/transactions-spring-data-jpa/
//		 * @see: https://stackoverflow.com/questions/23645091/spring-data-jpa-
//		 * and-hibernate-detached-entity-passed-to-persist-on-manytomany-re
//		 */
//		
//		User user = new User();
//		user.setFirstName("John");
//		user.setLastName("Doe");
//		user.setEmail("john@email.com");
//		user.setPassword("john1234");
//		user.setPhoneNo("5552349876");
//		user = userService.save(user);
////		Movie movie = new Movie();
//		Movie movie = movieService.getMovieInformationById(1);
//		System.out.println("Movie ID: " + movie.getMovieId());
//		
//		
//		RentalTransaction rental = new RentalTransaction();
//		rental.getMovies().add(movie); 
//		rental.setPaymentDate(LocalDateTime.now());
//		
//		movie.getRentals().add(rental);
//		
////		movieService.save(movie);
//		
//		rentalTransactionService.saveTransaction(rental);
//		
//		user.getRentalTrans().add(rental);
//		user = userService.save(user);
//	}

	@Test
	void testFindByRentalTransactionId() {
		RentalTransaction actual = rentalTransactionService.findByRentalTransactionId(rentalTransaction.getRentalTransactionId());
//		assertEquals(rentalTransaction, actual);
		assertNotNull(actual);
	}
}
