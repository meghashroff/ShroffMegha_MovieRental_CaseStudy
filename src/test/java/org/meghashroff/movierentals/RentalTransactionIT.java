package org.meghashroff.movierentals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.meghashroff.movierentals.config.WebAppConfig;
import org.meghashroff.movierentals.models.Movie;
import org.meghashroff.movierentals.models.RentalTransaction;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.services.MovieService;
import org.meghashroff.movierentals.services.RentalTransactionService;
import org.meghashroff.movierentals.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RentalTransactionIT {

	private RentalTransactionService rentalTransactionService;
	private MovieService movieService;
	private UserService userService;
	@Autowired
	private JpaTransactionManager manager;
//	private Movie movie1;
//	private Movie movie2;

	@Autowired
	public RentalTransactionIT(RentalTransactionService rentalTransactionService, 
			MovieService movieService,
			UserService userService) {
		this.rentalTransactionService = rentalTransactionService;
		this.movieService = movieService;
		this.userService = userService;
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

	@Test
//	@Transactional
	void testSaveRentalTransaction() {
		/**
		 * @see: https://stackoverflow.com/questions/25709976/spring-boot-spring-
		 * data-how-are-hibernate-sessions-managed
		 * @see: https://thorben-janssen.com/transactions-spring-data-jpa/
		 * @see: https://stackoverflow.com/questions/23645091/spring-data-jpa-
		 * and-hibernate-detached-entity-passed-to-persist-on-manytomany-re
		 */
		
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john@email.com");
		user.setPassword("john1234");
		user.setPhoneNo("5552349876");
		user = userService.save(user);
//		Movie movie = new Movie();
		Movie movie = movieService.getMovieInformationById(1);
		System.out.println("Movie ID: " + movie.getMovieId());
		
		
		RentalTransaction rental = new RentalTransaction();
		rental.getMovies().add(movie); 
		rental.setPaymentDate(LocalDateTime.now());
		rental.setAmount(20.00);
		rental.setPaymentStatus("Paid");
		
		movie.getRentals().add(rental);
		
//		movieService.save(movie);
		
		rentalTransactionService.saveTransaction(rental);
		
		user.getRentalTrans().add(rental);
		user = userService.save(user);
	}
	
//	@Test
//	void testSaveOneRentalTransaction() {
//		Movie movie = new Movie("Honey, I Shrunk The Kids", "Family", "1989", 
//				"images/honey_shrunk_kids.jpg", null, "The scientist father of a "
//						+ "teenage girl and boy accidentally shrinks his and two "
//						+ "other neighborhood teens to the size of insects. Now "
//						+ "the teens must fight diminutive dangers as  the father "
//						+ "searches for them.");
//
//		RentalTransaction rental = new RentalTransaction();
//		rental.getMovies().add(movie);
//		rental.setPaymentDate(LocalDateTime.now());
//		rental.setAmount(20.00);
//		rental.setPaymentStatus("Paid");
//		rentalTransactionService.saveTransaction(rental);
//	}
}
