package org.meghashroff.movierentals.services.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.meghashroff.movierentals.models.RentalTransaction;
import org.meghashroff.movierentals.repositories.RentalTransactionRepository;
import org.meghashroff.movierentals.services.RentalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * This class provides the implementation for the methods of RentalTransactionService
 * */
@Service
public class RentalTransactionServiceImpl implements RentalTransactionService{

	private RentalTransactionRepository rentalTransactionRepository;

	@Autowired
	public RentalTransactionServiceImpl(RentalTransactionRepository rentalTransactionRepository) {
		this.rentalTransactionRepository = rentalTransactionRepository;
	}

	@Override
	public RentalTransaction saveRentalTransaction(RentalTransaction rentalTransaction) {
		return rentalTransactionRepository.save(rentalTransaction);
	}

	@Override
	public RentalTransaction findByRentalTransactionId(int id) {
		Optional<RentalTransaction> rentalOpt = rentalTransactionRepository.findById(id);
		if (rentalOpt.isPresent()) {
			return rentalOpt.get();
		}
		throw new EntityNotFoundException();
	}	
	
	
}
