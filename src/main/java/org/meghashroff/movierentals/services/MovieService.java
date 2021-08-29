package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.models.Movie;

public interface MovieService {

	public Iterable<Movie> findAllMovies();
	public Movie findByMovieId(int movieId);
	public Movie saveMovie(Movie movie);
	public void deleteByMovieId(Integer movieId);
	public Iterable<Movie> findByMovieGenre(String movieGenre);

}
