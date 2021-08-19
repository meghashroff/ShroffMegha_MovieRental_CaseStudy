package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.models.Movie;

public interface MovieService {

	public Iterable<Movie> getAllMovies();
	public Movie getMovieInformationById(int movieId);
	Movie save(Movie movie);
}
