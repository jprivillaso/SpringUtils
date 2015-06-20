package com.springTutorial.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springTutorial.entities.User;
import com.springTutorial.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class UserServiceImpl extends BaseRestService implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<User>> findAll () {
		return new ResponseEntity<Iterable<User>>(userRepository.findAll(), HttpStatus.OK);
	}
	
}
