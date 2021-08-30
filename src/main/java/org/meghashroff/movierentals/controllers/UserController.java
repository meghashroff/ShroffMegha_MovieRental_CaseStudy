package org.meghashroff.movierentals.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.meghashroff.movierentals.exceptions.UserAlreadyExists;
import org.meghashroff.movierentals.exceptions.UserNotFoundException;
import org.meghashroff.movierentals.models.User;
import org.meghashroff.movierentals.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User savedUser = userService.createUser(user);
			System.out.println("User saved");
			return "redirect:/login";

		} catch (UserAlreadyExists uae) {
			bindingResult.rejectValue("username", "error.user",
                    uae.getMessage());
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
		User user = userService.findByUsername(username);
		//System.out.println("User: "+user);
		try {
			if (user!=null) {
		    	if (passwordEncoder.matches(password, user.getPassword())) {
					user.setPassword(passwordEncoder.encode(newPassword));
					userService.updateUser(user);
					System.out.println("User information updated");
					return "login_page";
		    	} else {
			    	System.out.println("Incorrect password");
			    	return "change_password";
			    }
			}
			else { 
				throw new UserNotFoundException();
			}
		}
		catch(UserNotFoundException e){
			System.out.println(e.getMessage());
			return "change_password";
		}
	} 
			
	@GetMapping("/navToLoginPage")
	public String showBackToLoginPage() {
		return "login_page";
	}
	
	@GetMapping("/accountInfo")
	public String showUserAccountInfo(Model model) {
		User user = userService.getCurrentUserInSession();
		model.addAttribute("currentUser", user);
		return "user_account";
	}
	
	@GetMapping("/deleteAccount")
	public String deleteUserAccount(HttpSession session) {
		User user = userService.getCurrentUserInSession();
		userService.deleteUserAccountById(user.getUserId());
		session.removeAttribute("currentUser");
		return "redirect:/";
	}
}
