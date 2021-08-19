package org.meghashroff.movierentals.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(MovieService movieService, UserService userService, RentalTransactionService rentalTransactionService) {
		this.userService = userService;
	}

	@GetMapping("/SignUp")
	public String showSignUpPage(Model model) {
		model.addAttribute("user", new User());
		return "sign_up";
	}
	
	@GetMapping("/LoginPage")
	public String showLoginPage(Model model) {
		return "login_page";
	}

	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult errors) {
		
		if (errors.hasErrors()) {
			System.out.println("errors: "+ errors);
			return "sign_up";
		}
		System.out.println(user.toString());
		User savedUser = userService.createUser(user);
		System.out.println(savedUser.toString());
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String searchUserByEmail(@RequestParam("username") String userEmail, @RequestParam("password") String password, HttpSession session) {
		User currentUser = userService.findByEmail(userEmail);
		
		if(currentUser != null) {
			System.out.println("User email: "+ currentUser.getEmail());
		System.out.println("User PAssword: " + currentUser.getPassword());
		System.out.println("Password: "+password);
		
		if(currentUser.getPassword().equals(password)) {
			session.setAttribute("currentUser", currentUser);
			return "redirect:/";
		}
		
		System.out.println(currentUser.toString());
		}
		return "login_page";
	}
	

	@GetMapping("/logout")
	public String logoutPage(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/changePassword")
	public String showChangePassword() {
		return "change_password";
	}
	
	@PostMapping("/updatePassword")
	public String showUpdatePassword(@RequestParam("email") String userEmail, @RequestParam("oldPassword") String password, @RequestParam("newPassword") String newPassword ) {
		//System.out.println("In showUpdatePassword");
		System.out.println("Username: "+userEmail);
		System.out.println("OldPassword "+password);
		System.out.println("NewPassword "+newPassword);
//		User user = userService.findByEmail(userEmail);
		User user = userService.findByUserEmailAndPassword(userEmail,password);
		System.out.println("Update user info for: "+user);
		
		user.setPassword(newPassword);
		userService.save(user);
		System.out.println("Updated user info  "+user.getPassword());
		
		return "login_page";
	}
	
	@GetMapping("/navToLoginPage")
	public String showBackToLoginPage() {
		return "login_page";
	}
}
