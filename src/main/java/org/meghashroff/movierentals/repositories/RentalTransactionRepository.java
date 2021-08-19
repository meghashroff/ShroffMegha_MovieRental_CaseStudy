package org.meghashroff.movierentals.repositories;

import org.meghashroff.movierentals.models.RentalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalTransactionRepository extends JpaRepository<RentalTransaction, Integer>{

}
