package com.example.demoProjectService.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demoProjectService.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);
}
