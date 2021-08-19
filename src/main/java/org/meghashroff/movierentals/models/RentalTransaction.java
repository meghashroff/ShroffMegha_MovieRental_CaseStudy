package org.meghashroff.movierentals.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//Megha Shroff
@Entity
@Table(name = "rentalTransactions") 
public class RentalTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rentalTransactionId;
	private double amount;
	private String paymentStatus;
	private LocalDateTime paymentDate; 
	// Needed to remove CascadeType.ALL to allow object to attach when retrieved from db
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			  name = "movies_rentals", 
			  joinColumns = @JoinColumn(name = "rentalTransactionId"), 
			  inverseJoinColumns = @JoinColumn(name = "movieId"))
	private Set<Movie> movies;
	
	public RentalTransaction() {
		this.movies = new HashSet<>();
	}

	public RentalTransaction(double amount, String paymentStatus,
			LocalDateTime paymentDate, Set<Movie> movies) {
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.movies = movies;
	}
	
	public RentalTransaction(Integer rentalTransactionId, double amount, String paymentStatus,
			LocalDateTime paymentDate, Set<Movie> movies) {
		super();
		this.rentalTransactionId = rentalTransactionId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.movies = movies;
	}

	public Integer getRentalTransactionId() {
		return rentalTransactionId;
	}

	public void setRentalTransactionId(Integer rentalTransactionId) {
		this.rentalTransactionId = rentalTransactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
		result = prime * result + ((rentalTransactionId == null) ? 0 : rentalTransactionId.hashCode());
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
		RentalTransaction other = (RentalTransaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (paymentStatus == null) {
			if (other.paymentStatus != null)
				return false;
		} else if (!paymentStatus.equals(other.paymentStatus))
			return false;
		if (rentalTransactionId == null) {
			if (other.rentalTransactionId != null)
				return false;
		} else if (!rentalTransactionId.equals(other.rentalTransactionId))
			return false;
		return true;
	}

	@Override
	public String toString() {

		System.out.println("Hello in tran");
//		return "Hello";
				return "RentalTransaction [rentalTransactionId=" + rentalTransactionId + ", amount=" + Double.toString(amount)
				+ ", paymentStatus=" + paymentStatus + ", paymentDate=" + paymentDate + "]";
	}

	
		
}
