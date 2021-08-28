package org.meghashroff.movierentals.controllers;

import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
//		 Get current user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!principal.equals("anonymousUser"))
		{
			UserDetails userDetails = (UserDetails)principal;
			User user = null;
			try {
				user = userService.findByUsername(userDetails.getUsername());
			} catch (UserNotFoundException e) {
				System.out.println("User not found: " + e.getMessage());
			}
			System.out.println("User: "+user);
			if(user!=null)		
					model.addAttribute("currentUser", user);
		}
		return "home";
	}
	
}
