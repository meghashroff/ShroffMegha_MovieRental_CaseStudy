package org.meghashroff.movierentals.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.Movie;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.repositories.MovieRepository;
import org.meghashroff.movierentals.repositories.UserRepository;
import org.meghashroff.movierentals.services.impl.MovieServiceImpl;
import org.meghashroff.movierentals.services.impl.UserServiceImpl;
import org.mockito.Mockito;

public class MoviesMockitoTest {

	private static MovieService movieService;
	private static MovieRepository movieRepository;
	private Movie movie1;
	private Movie movie2;

	@BeforeAll
	static void setup() {
		movieRepository = Mockito.mock(MovieRepository.class);
		movieService = new MovieServiceImpl(movieRepository);
	}
	
	@Test
	void testFindByMovieGenre(){
		this.movie1 = new Movie("First Family Movie Test", "test_family", "2021", 
				"images/movie1.jpg", "This is a second family movie");
		this.movie2 = new Movie("Second Family Movie Test", "test_family", "2021", 
						"images/movie2.jpg", "This is the second family movie ");

		Mockito.when(movieRepository.findByMovieGenre(anyString())).thenReturn(List.of(movie1,movie2));
		
		Iterable<Movie> actual = movieService.findByMovieGenre("family");
		Iterable<Movie> expected = List.of(new Movie("First Family Movie Test", "test_family", "2021", "images/movie1.jpg", "This is a second family movie"),
											new Movie("Second Family Movie Test", "test_family", "2021", "images/movie2.jpg", "This is the second family movie "));
		assertEquals(expected, actual);
	}
	
}
