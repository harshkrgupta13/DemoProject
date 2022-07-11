package com.example.demoProjectService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProjectService.model.AuthenticationStatus;
import com.example.demoProjectService.model.User;
import com.example.demoProjectService.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		System.out.println(user);
		return userService.saveUser(user);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationStatus> authenticated(@RequestBody User user) {
		String actualPassword = null;
		String password = user.getPassword();
		System.out.println(password);
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticated(false);
		User actualUser = userService.getUser(user.getUsername());
		System.out.println(actualUser);
		if (actualUser != null) {
			actualPassword = actualUser.getPassword();
			if (actualPassword.equals(password)) {
				status.setUser(actualUser);
			}
		}
		status.setAuthenticated(password.equals(actualPassword));
		System.out.println(status);
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);
	}
}
