package org.meghashroff.movierentals.services.impl;

import org.meghashroff.movierentals.repositories.MovieRepository;
import org.meghashroff.movierentals.services.MovieService;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.meghashroff.movierentals.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Iterable<Movie> findAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	@Transactional
	public Movie findByMovieId(int movieId) {
		Optional<Movie> optMovie = movieRepository.findById(movieId);
		if (optMovie.isPresent()) {
			return optMovie.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void deleteByMovieId(Integer movieId) {
		movieRepository.deleteById(movieId);
	}

//	@Override
//	public Set<String> findMovieGenres() {
//		Set<String> movieGenres = movieRepository.findMovieGenres();
//		return movieGenres;
//	}

//	@Override
//	public Iterable<Movie> findByMovieNameOrderByMovieName(String movieName) {
//		// TODO Auto-generated method stub
//		return movieRepository.findByMovieNameOrderByMovieName(movieName);
//	}

//	@Override
//	public Page<Movie> findAllMoviesPagination() {
//		Pageable pageable = PageRequest.of(0, 3, Sort.by("movieName").ascending());
//		Page<Movie> moviePage = movieRepository.findAllMoviesWithPagination(pageable);
//		return moviePage;
//	}



//	@Override
//	public Movie getMovieInformation(String movieName) {
//		return movieRepository.findByMovieName(movieName);
//	}

}
