package org.meghashroff.movierentals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meghashroff.movierentals.config.WebAppConfig;
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
public class UserIT {

	private RentalTransactionService rentalTransactionService;
	private MovieService movieService;
	private UserService userService;
	@Autowired
	private JpaTransactionManager manager;
//	private Movie movie1;
//	private Movie movie2;

	@Autowired
	public UserIT(RentalTransactionService rentalTransactionService, 
			UserService userService) {
		this.rentalTransactionService = rentalTransactionService;
		this.userService = userService;
	}
	
	@Test
	public void testDeleteUser() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john@email.com");
		user.setPassword("john1234");
		user.setPhoneNo("5552349876");
//		userService.remove
	}

}
