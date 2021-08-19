package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.models.RentalTransaction;

public interface RentalTransactionService {

	public RentalTransaction saveTransaction(RentalTransaction rentalTransaction);
	public RentalTransaction findById(int id);
}
