package org.meghashroff.movierentals.repositories;

import org.meghashroff.movierentals.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	public Movie findByMovieName(String movieName);
}
