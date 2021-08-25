package org.meghashroff.movierentals.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;

	@Column(name = "movieName", nullable=false, length=255)
	private String movieName;
	
	@Column(name = "movieGenre", nullable=false, length=100)
	private String movieGenre;
	
	@Column(name = "movieReleaseYear", nullable=false, length=100)
	private String movieReleaseYear;
	
	@Column(name = "movieImagePath", nullable=false, length=255)
	private String movieImagePath;
	
	@Column(name= "movieDescription", length=500)
	private String movieDescription;

	/* Needed to remove CascadeType.ALL to allow object to attach when retrieved 
	 * from database. Also had to change fetch to EAGER
	 */

	@ManyToMany(mappedBy = "movies", fetch=FetchType.EAGER)
	private Set<RentalTransaction> rentals;
	
	public Movie() {
		this.rentals = new HashSet<>();
	}

	public Movie(String movieName, String movieGenre, String movieReleaseYear, String movieImagePath,
			String movieDescription) {
		this();
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieReleaseYear = movieReleaseYear;
		this.movieImagePath = movieImagePath;
		this.movieDescription = movieDescription;
	}
	
	public Movie(Integer movieId, String movieName, String movieGenre, String movieReleaseYear, String movieImagePath,
			String movieLink, String movieDescription, Set<RentalTransaction> rentals) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieReleaseYear = movieReleaseYear;
		this.movieImagePath = movieImagePath;
		this.movieDescription = movieDescription;
		this.rentals = rentals;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieReleaseYear() {
		return movieReleaseYear;
	}

	public void setMovieReleaseYear(String movieReleaseYear) {
		this.movieReleaseYear = movieReleaseYear;
	}

	public String getMovieImagePath() {
		return movieImagePath;
	}

	public void setMovieImagePath(String movieImagePath) {
		this.movieImagePath = movieImagePath;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public Set<RentalTransaction> getRentals() {
		return rentals;
	}

	public void setRentals(Set<RentalTransaction> rentals) {
		this.rentals = rentals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieDescription == null) ? 0 : movieDescription.hashCode());
		result = prime * result + ((movieGenre == null) ? 0 : movieGenre.hashCode());
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result + ((movieImagePath == null) ? 0 : movieImagePath.hashCode());
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((movieReleaseYear == null) ? 0 : movieReleaseYear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (movieDescription == null) {
			if (other.movieDescription != null)
				return false;
		} else if (!movieDescription.equals(other.movieDescription))
			return false;
		if (movieGenre == null) {
			if (other.movieGenre != null)
				return false;
		} else if (!movieGenre.equals(other.movieGenre))
			return false;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (movieImagePath == null) {
			if (other.movieImagePath != null)
				return false;
		} else if (!movieImagePath.equals(other.movieImagePath))
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (movieReleaseYear == null) {
			if (other.movieReleaseYear != null)
				return false;
		} else if (!movieReleaseYear.equals(other.movieReleaseYear))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre
				+ ", movieReleaseYear=" + movieReleaseYear + ", movieImagePath=" + movieImagePath
				+ ", movieDescription=" + movieDescription + "]";
	}
}
