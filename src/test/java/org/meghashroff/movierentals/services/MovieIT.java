package org.meghashroff.movierentals.services;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meghashroff.movierentals.config.WebAppConfig;
import org.meghashroff.movierentals.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MovieIT {

	private MovieService movieService;
	private Movie movie1;
	private Movie movie2;
	
	@Autowired
	public MovieIT(MovieService movieService) {
		this.movieService= movieService;
	}

	@BeforeAll
	 void setUp(){
		this.movie1 = new Movie("Family Movie Test", "test_family", "2021", 
				"images/movie1.jpg", "This is a family movie");
		this.movie2 = new Movie("Action Movie Test", "test_action", "2021", 
						"images/movie2.jpg", "This is an action movie");
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
	
	@Test
	void testFindByMovieId() {
		Movie actual = movieService.findByMovieId(movie1.getMovieId());
		assertEquals(movie1, actual);
	}
	
	@Test
	void testFindByMovieGenre() {
		List<Movie> actual = (List<Movie>)movieService.findByMovieGenre(movie1.getMovieGenre());
		assertEquals(movie1,actual.get(0));
	}
}
