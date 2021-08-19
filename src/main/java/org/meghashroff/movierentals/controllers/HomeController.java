package org.meghashroff.movierentals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
public class HomeController {

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
}
