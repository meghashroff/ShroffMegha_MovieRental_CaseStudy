package org.meghashroff.movierentals.controllers;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.meghashroff.movierentals.models.Movie;
import org.meghashroff.movierentals.models.RentalTransaction;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.services.MovieService;
import org.meghashroff.movierentals.services.RentalTransactionService;
import org.meghashroff.movierentals.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentalTransactionController {

	private MovieService movieService;
	private UserService userService;
	private RentalTransactionService rentalTransactionService;

	@Autowired
	public RentalTransactionController(MovieService movieService, UserService userService, RentalTransactionService rentalTransactionService) {
		this.movieService = movieService;
		this.userService = userService;
		this.rentalTransactionService = rentalTransactionService;
	}

	
	@GetMapping("/confirmPayment")
	public String showPaymentPage(@RequestParam("movieSel") Integer movieSel, Model model, HttpSession session) {
		model.addAttribute("movie", movieService.getMovieInformationById(movieSel));
		User user = (User) session.getAttribute("currentUser");
		if(user != null) {
			return "payment";
		}
		return "login_page";
	}
	
	
	@PostMapping("/payment")
	public String completeTransaction(@RequestParam("movieId") Integer movieId, HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		if(user != null) {
//			user = userService.findByUserId(user.getUserId());
			
			Movie movie = movieService.getMovieInformationById(movieId);
			Set<Movie> movieSet = new HashSet<>();
			movieSet.add(movie);
			
			RentalTransaction rental = new RentalTransaction();
			rental.setMovies(movieSet);
			rental.setPaymentDate(LocalDateTime.now());
			rental.setAmount(20.00);
			rental.setPaymentStatus("Paid");
			
//			Set<RentalTransaction> rentalSet = new HashSet<RentalTransaction>();
//			rentalSet.add(rental);
//			movie.setRentals(rentalSet); 
			
			rental = rentalTransactionService.saveTransaction(rental);
			user.getRentalTrans().add(rental);
			userService.save(user);
//			return "redirect:/";
			return "display_transaction_complete";
		}
		return "redirect:/login_page";
	}
	
}
