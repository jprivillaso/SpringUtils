package com.springTutorial.webServices;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.springTutorial.entities.User;

public interface UserService {

	ResponseEntity<Iterable<User>> findAll();

	ResponseEntity<List<User>> findUsersByFilter(Map<String, Object> parameters);

}
