package org.meghashroff.movierentals.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserController(UserService userService, 
			 PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/SignUp")
	public String showSignUpPage(Model model) {
		model.addAttribute("user", new User());
		return "sign_up";
	}
	
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		return "login_page";
	}

	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) {
			return "sign_up";
		}
		
		User userExists = null;
		try {
			userExists = userService.findByUsername(user.getUsername());
		} catch (UserNotFoundException e) {
			System.out.println("User not found" + e.getMessage());
		}
		if (userExists == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User savedUser = userService.createOrUpdateUser(user);
			System.out.println(savedUser.toString());
			return "redirect:/login";
		}
		else {
			bindingResult.rejectValue("username", "error.user",
                    "There is already a user registered with the user name provided");
			return "sign_up";
		}
	}
//	
//	@PostMapping("/login")
//	public String searchUserByEmail(@RequestParam("username") String userEmail, @RequestParam("password") String password, 
//			HttpSession session) {
//
////		if (bindingResult.hasErrors()) {
////			return "login_page";
////		}
//	
//		User currentUser = userService.findByEmail(userEmail);
//		
//		if(currentUser != null) {
//			System.out.println("User email: "+ currentUser.getEmail());
//		System.out.println("User PAssword: " + currentUser.getPassword());
//		System.out.println("Password: "+password);
//		
//		if(currentUser.getPassword().equals(password)) {
//			session.setAttribute("currentUser", currentUser);
//			return "redirect:/";
//		}
//		
//		System.out.println(currentUser.toString());
//		}
//		return "login_page";
//	}
//	

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
	public String showUpdatePassword(@RequestParam("username") String username, 
			@RequestParam("oldPassword") String password, @RequestParam("newPassword") String newPassword ) {
		
		
		System.out.println("Username: "+username);
		System.out.println("OldPassword "+password);
		System.out.println("NewPassword "+newPassword);
//		User user = userService.findByUserEmailAndPassword(userEmail,password);
//		User user = userService.findByEmail(userEmail);
		User user = null;
		try {
			user = userService.findByUsername(username);
		    if (passwordEncoder.matches(password, user.getPassword())) {
				user.setPassword(passwordEncoder.encode(newPassword));
	
	//			user.setPassword(newPassword);
				userService.createOrUpdateUser(user);
				System.out.println("Updated user info  "+user.getPassword());
		    } else {
		    	System.out.println("Old password is incorrect: "+user);
		    	return "change_password";
			    
		    }
		} catch (UserNotFoundException e) {
			System.out.println("User not found" + e.getMessage());
			return "change_password";
		    
		} 
		return "login_page";	
		
	}
	
	@GetMapping("/navToLoginPage")
	public String showBackToLoginPage() {
		return "login_page";
	}
	
	@GetMapping("/accountInfo")
	public String showUserAccountInfo(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails)principal;
		User user = null;
		try {
			user = userService.findByUsername(userDetails.getUsername());
		} catch (UserNotFoundException e) {
			System.out.println("User not found" + e.getMessage());
		}
		model.addAttribute("currentUser", user);
		System.out.println("In show user account method");
		
		return "user_account";
	}
	
	@GetMapping("/deleteAccount")
	public String deleteUserAccount(HttpSession session) {
		System.out.println("In delete user account method");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails)principal;
		User user = null;
		try {
			user = userService.findByUsername(userDetails.getUsername());
		} catch (UserNotFoundException e) {
			System.out.println("User not found" + e.getMessage());
		}
//User delUser  = userService.findByUserId(user.getUserId());
		userService.deleteUserAccountById(user.getUserId());
		session.removeAttribute("currentUser");
		return "redirect:/";
	}
}
