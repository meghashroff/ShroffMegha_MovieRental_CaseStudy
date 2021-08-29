package org.meghashroff.movierentals.controllers;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
public class HomeController {

private UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	/*
	 * This method shows the home page of the application
	 * 
	 * */
	@GetMapping("/")
	public String showHomePage(Model model) {
		User user = userService.getCurrentUserInSession();
		if(user!=null)		
			model.addAttribute("currentUser", user);
		return "home";
	}
}
