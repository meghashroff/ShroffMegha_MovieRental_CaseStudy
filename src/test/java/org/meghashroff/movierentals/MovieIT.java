package org.meghashroff.movierentals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meghashroff.movierentals.config.WebAppConfig;
import org.meghashroff.movierentals.models.Movie;
import org.meghashroff.movierentals.repositories.MovieRepository;
import org.meghashroff.movierentals.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieIT {

	private MovieService movieService;
	private Movie movie1;
	private Movie movie2;
	
	@Autowired
	public MovieIT(MovieService movieService) {
		this.movieService= movieService;
	}

	@BeforeAll
	 void setUp(){
		this.movie1 = new Movie("MovieTest", "Test", "2021", 
				"images/test.jpg", "TestDesc");
		this.movie2 = new Movie("ABCDTest2", "Test2", "2021", 
						"images/test2.jpg", "Test2Desc");
		movie1= movieService.saveMovie(movie1);
		movie2= movieService.saveMovie(movie2);
	}
	
	@AfterAll
	void clearSetup() {
		movieService.deleteByMovieId(movie1.getMovieId());
		movieService.deleteByMovieId(movie2.getMovieId());
	}
	
	@Test
	void testApplicationContext() {
		Assertions.assertNotNull(movieService);
	}
	
//	@Test
//	void testFindByMovieNameOrderByMovieName() {
////		findAllOrderByMovieName();
//		assertNotNull(movieService.findByMovieNameOrderByMovieName("ABCDTest"));
//	}

	@Test
	void testFindByMovieId() {
		Movie actual = movieService.findByMovieId(movie1.getMovieId());
		assertEquals(movie1, actual);
	}
}
