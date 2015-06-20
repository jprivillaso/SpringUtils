package com.springTutorial.webServices;

import org.springframework.http.ResponseEntity;

import com.springTutorial.entities.User;

public interface UserService {

	ResponseEntity<Iterable<User>> findAll();

}
