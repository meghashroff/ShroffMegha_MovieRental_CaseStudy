package org.meghashroff.movierentals.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.meghashroff.movierentals.models.Movie;
import org.meghashroff.movierentals.models.RentalTransaction;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.services.MovieService;
import org.meghashroff.movierentals.services.RentalTransactionService;
import org.meghashroff.movierentals.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {


	private MovieService movieService;
	private UserService userService;
	private RentalTransactionService rentalTransactionService;

	@Autowired
	public MovieController(MovieService movieService, UserService userService, RentalTransactionService rentalTransactionService) {
		this.movieService = movieService;
		this.userService = userService;
		this.rentalTransactionService = rentalTransactionService;
	}
	
	@GetMapping("/Movies")
	public String showMoviesPage(Model model) {
		model.addAttribute("movies", movieService.getAllMovies());
		return "movies";
	}
	
////	@ModelAttribute("movies")
////	public Iterable<Movie> getAllMovies(Model model) {
////		return movieService.getAllMovies();
////	}
////	
	
	
//	@GetMapping("/MovieInfo/{movieName}")
//	public String showMovieInfoPage(Model model, @PathVariable("movieName") String movieName) {
//		model.addAttribute("movieInformation", movieService.getMovieInformation(movieName));
//		return "MovieInfo";
//	}
	
	@GetMapping("/MovieInfo/{movieId}")
	public String showMovieInfoPage(Model model, @PathVariable("movieId") int movieId) {
		model.addAttribute("movieInformation", movieService.getMovieInformationById(movieId));
		return "movie_info";
	}

	@GetMapping("/addMovie")
	public String showMovieSelectionPage(@RequestParam("movieToRent") int movieId, Model model, HttpSession session) {
		model.addAttribute("movieInformation", movieService.getMovieInformationById(movieId));
		List<Movie> selMovieList = new ArrayList<Movie>();
		selMovieList.add(movieService.getMovieInformationById(movieId));
//		session.setAttribute("selMovieList", selMovieList);
		return "rented_movies_list";
	}
	

	@GetMapping("/addMovie/{movieId}")
	public String showMovieListPage(Model model, @PathVariable("movieId") int movieId) {
		model.addAttribute("movieInformation", movieService.getMovieInformationById(movieId));
		return "rented_movies_list";
	}
	
		
	@GetMapping("remove/{movieId}")
	public String removeFromList(@PathVariable("movieId") int movieId, HttpSession session) {
//		List<Movie> movieList = (List)session.getAttribute("selMovieList");
//		System.out.println(movieList.size());
//		for(int i = 0; i <moieList.size(); i++) {
//			if(movieList.get(i).getMovieId()==movieId) {
//				movieList.remove(movieId);
//				break;
//			}
//		}
	return "rented_movies_list";
//		return null;
	}

	@GetMapping("/navToMoviesPage")
	public String showBackToMovePage(Model model) {
		model.addAttribute("movies", movieService.getAllMovies());
		return "movies";
	}
	
	@GetMapping("selMovieList")
	public String showMoviesListSelectedForRent() {
		return "rented_movies_list";
	}
}
