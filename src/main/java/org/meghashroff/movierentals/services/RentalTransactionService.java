package org.meghashroff.movierentals.services;

import org.meghashroff.movierentals.models.RentalTransaction;

public interface RentalTransactionService {

	public RentalTransaction saveRentalTransaction(RentalTransaction rentalTransaction);
	public RentalTransaction findByRentalTransactionId(int id);
}
