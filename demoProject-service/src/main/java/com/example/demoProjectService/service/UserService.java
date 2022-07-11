package com.example.demoProjectService.service;

import org.springframework.stereotype.Service;

import com.example.demoProjectService.model.User;
import com.example.demoProjectService.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}
}
