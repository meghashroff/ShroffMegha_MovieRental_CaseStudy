package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.models.RentalTransaction;

public interface RentalTransactionService {

	/* This method will create the rental */
	public RentalTransaction saveRentalTransaction(RentalTransaction rentalTransaction);
	
	/* This method will find the rental information using the rental id */
	public RentalTransaction findByRentalTransactionId(int id);
}
