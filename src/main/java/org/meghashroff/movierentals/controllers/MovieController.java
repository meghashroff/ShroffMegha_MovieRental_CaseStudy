package org.meghashroff.movierentals.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.meghashroff.movierentals.models.Movie;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.services.MovieService;
import org.meghashroff.movierentals.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	/*
	 * This method shows the movies page where the user can select the genre.
	 * 
	 * */
	@GetMapping("/Movies")
	public String showMoviesPage(Model model) {
		User user = userService.getCurrentUserInSession();
		if(user!=null)		
			model.addAttribute("currentUser", user);
		return "movies";
	}
	
	
	/*
	 * This method retrieves the information for the selected movie based on the movieID.
	 * Takes the movieId as a parameter
	 * */
	@GetMapping("/MovieInfo/{movieId}")
	public String showMovieInfoPage(Model model, @PathVariable("movieId") int movieId) {
		model.addAttribute("movieInformation", movieService.findByMovieId(movieId));
		return "movie_info";
	}

	/*
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
	*/
	
	/*
	 * This method removes the selected movie from the selection of movies 
	 * */	
	@GetMapping("/selMovieList/remove/{movieId}")
	public String removeFromList(@PathVariable("movieId") int movieId, HttpSession session) {
		Set<Movie> movieSet = (Set<Movie>)session.getAttribute("selectedMovies");
		movieSet.remove(movieService.findByMovieId(movieId));
		return "rented_movies_list";
	}

	
	/*
	 * This method gets the list of movies selected from the movie list
	 * 
	 * */
	@PostMapping("/selMovieList")
	public String showMoviesListSelectedForRent(@RequestParam String[] selectedMovies, HttpServletRequest request, HttpSession session) {
		Set<Movie> movieSet = new HashSet<Movie>();
		if(selectedMovies!=null){
			for(int i=0;i<selectedMovies.length;i++) {
				movieSet.add(movieService.findByMovieId(Integer.parseInt(selectedMovies[i])));
			}
		}
		session.setAttribute("selectedMovies", movieSet);
		return "rented_movies_list";
	}

	/*
	 * This method gets the list of movies for the selected genre
	 * 
	 * */
	@PostMapping("/selGenre")
	public String showMovieListByGenre(@RequestParam("movieGenre") String movieGenre, Model model) {
		User user = userService.getCurrentUserInSession();
		if(user!=null)		
				model.addAttribute("currentUser", user);
		if(movieGenre.equals("All"))
			model.addAttribute("movies", movieService.findAllMovies());
		else
			model.addAttribute("movies", movieService.findByMovieGenre(movieGenre));
		return "movies";
		
	}
}
