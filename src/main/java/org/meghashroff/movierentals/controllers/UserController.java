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
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) {
			return "sign_up";
		}
		
		User userExists = userService.findByEmail(user.getEmail());
		if (userExists == null) {
		User savedUser = userService.createUser(user);
		System.out.println(savedUser.toString());
		return "redirect:/LoginPage";
		}
		else {
			bindingResult.rejectValue("email", "error.user",
                    "There is already a user registered with the user name provided");
			return "sign_up";
		}
	}
	
	@PostMapping("/login")
	public String searchUserByEmail(@RequestParam("username") String userEmail, @RequestParam("password") String password, 
			HttpSession session) {

//		if (bindingResult.hasErrors()) {
//			return "login_page";
//		}
	
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
		System.out.println("Username: "+userEmail);
		System.out.println("OldPassword "+password);
		System.out.println("NewPassword "+newPassword);
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
	
	@GetMapping("/accountInfo")
	public String showUserAccountInfo() {
		System.out.println("In show user account method");
		return "user_account";
	}
	
	@GetMapping("/deleteAccount")
	public String deleteUserAccount(HttpSession session) {
		System.out.println("In delete user account method");
		User user = (User)session.getAttribute("currentUser");
		User delUser  = userService.findByUserId(user.getUserId());
		userService.deleteUserAccountById(delUser.getUserId());
		session.removeAttribute("currentUser");
		return "redirect:/";
	}
}
