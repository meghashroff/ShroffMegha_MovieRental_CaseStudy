package org.meghashroff.movierentals.services;

import java.util.Set;

import org.meghashroff.movierentals.models.Movie;
import org.springframework.data.domain.Page;

public interface MovieService {

	public Iterable<Movie> findAllMovies();
	public Movie findByMovieId(int movieId);
	public Movie saveMovie(Movie movie);
	public void deleteByMovieId(Integer movieId);
//	public Iterable<Movie> findByMovieNameOrderByMovieName(String movieName);

//	public Set<String> findMovieGenres();
}
