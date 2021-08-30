package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.models.Movie;

public interface MovieService {

	/* This method will retrieve all the movies in the system*/
	public Iterable<Movie> findAllMovies();
	
	/* This method will find a movie and its information using the movie id */
	public Movie findByMovieId(int movieId);
	
	/* The method will save the movie */
	public Movie saveMovie(Movie movie);
	
	/* This method will delete the movie using its id */
	public void deleteByMovieId(Integer movieId);
	
	/* This method will find list of movies based on genre */
	public Iterable<Movie> findByMovieGenre(String movieGenre);

}
