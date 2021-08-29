package org.meghashroff.movierentals.repositories;

import java.util.List;

import org.meghashroff.movierentals.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

	public Iterable<Movie> findByMovieGenre(String movieGenre);

}
