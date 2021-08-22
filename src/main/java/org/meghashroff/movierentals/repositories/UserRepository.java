package org.meghashroff.movierentals.repositories;

import org.meghashroff.movierentals.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	public User findByUserId(int id);
	public User findByEmailAndPassword(String email, String password);
}
