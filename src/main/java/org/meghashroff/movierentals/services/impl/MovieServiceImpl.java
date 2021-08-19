package org.meghashroff.movierentals.services.impl;

import org.meghashroff.movierentals.repositories.MovieRepository;
import org.meghashroff.movierentals.services.MovieService;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.meghashroff.movierentals.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;
	
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository= movieRepository;
	}
	
	@Override
	public Iterable<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	@Transactional
	public Movie getMovieInformationById(int movieId) {
		Optional<Movie> optMovie = movieRepository.findById(movieId);
		if (optMovie.isPresent()) {
			return optMovie.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

//	@Override
//	public Movie getMovieInformation(String movieName) {
//		return movieRepository.findByMovieName(movieName);
//	}

}
