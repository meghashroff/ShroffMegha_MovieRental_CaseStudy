package org.meghashroff.movierentals.services.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.meghashroff.movierentals.models.RentalTransaction;
import org.meghashroff.movierentals.repositories.RentalTransactionRepository;
import org.meghashroff.movierentals.services.RentalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalTransactionServiceImpl implements RentalTransactionService{

	private RentalTransactionRepository rentalTransactionRepository;

	@Autowired
	public RentalTransactionServiceImpl(RentalTransactionRepository rentalTransactionRepository) {
		this.rentalTransactionRepository = rentalTransactionRepository;
	}

	@Override
	public RentalTransaction saveTransaction(RentalTransaction rentalTransaction) {
		return rentalTransactionRepository.save(rentalTransaction);
	}

	@Override
	public RentalTransaction findById(int id) {
		Optional<RentalTransaction> rentalOpt = rentalTransactionRepository.findById(id);
		if (rentalOpt.isPresent()) {
			return rentalOpt.get();
		}
		throw new EntityNotFoundException();
	}	
	
	
}