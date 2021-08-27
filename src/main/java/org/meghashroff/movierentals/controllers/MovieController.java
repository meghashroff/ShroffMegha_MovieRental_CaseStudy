package org.meghashroff.movierentals.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.Movie;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.services.MovieService;
import org.meghashroff.movierentals.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {


	private MovieService movieService;
	private UserService userService;
	
	@Autowired
	public MovieController(UserService userService,MovieService movieService) {
		this.movieService = movieService;
		this.userService = userService;
	}
	
	@GetMapping("/Movies")
	public String showMoviesPage(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!principal.equals("anonymousUser"))
		{
			UserDetails userDetails = (UserDetails)principal;
			User user= null;
			try {
				user = userService.findByUsername(userDetails.getUsername());
			} catch (UserNotFoundException e) {
				System.out.println("User not found" + e.getMessage());
			}
			if(user!=null)		
				model.addAttribute("currentUser", user);
		}
		model.addAttribute("movies", movieService.findAllMovies());
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
		model.addAttribute("movieInformation", movieService.findByMovieId(movieId));
		return "movie_info";
	}

	@GetMapping("/addMovie")
	public String showMovieSelectionPage(@RequestParam("movieToRent") int movieId, Model model, HttpSession session, HttpServletRequest request) {
		Set<Movie> movieSet = (Set<Movie>)session.getAttribute("selectedMovies");
		movieSet.add(movieService.findByMovieId(movieId));
		return "rented_movies_list";
	}
	

	@GetMapping("/addMovie/{movieId}")
	public String showMovieListPage(Model model, @PathVariable("movieId") int movieId) {
		model.addAttribute("movieInformation", movieService.findByMovieId(movieId));
		return "rented_movies_list";
	}
	
		
	@GetMapping("remove/{movieId}")
	public String removeFromList(@PathVariable("movieId") int movieId, HttpSession session) {
		Set<Movie> movieSet = (Set<Movie>)session.getAttribute("selectedMovies");
		movieSet.remove(movieService.findByMovieId(movieId));
		System.out.println("movieSet: "+movieSet);
		return "rented_movies_list";
	}

	@GetMapping("/navToMoviesPage")
	public String showBackToMovePage(Model model) {
		model.addAttribute("movies", movieService.findAllMovies());
		return "movies";
	}
	
	@PostMapping("selMovieList")
	public String showMoviesListSelectedForRent(@RequestParam String[] selectedMovies, HttpServletRequest request, HttpSession session) {
		Set<Movie> movieSet = new HashSet<Movie>();
		if(selectedMovies!=null){
			for(int i=0;i<selectedMovies.length;i++) {
				System.out.println(movieService.findByMovieId(Integer.parseInt(selectedMovies[i])));
			movieSet.add(movieService.findByMovieId(Integer.parseInt(selectedMovies[i])));
			}
		}
		session.setAttribute("selectedMovies", movieSet);
		return "rented_movies_list";
	}
	
}
