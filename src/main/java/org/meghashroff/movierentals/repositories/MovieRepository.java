package org.meghashroff.movierentals.repositories;

import java.util.List;
import java.util.Set;

import org.meghashroff.movierentals.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

	//	public Iterable<Movie> findByMovieNameOrderByMovieName(String movieName); 

}
