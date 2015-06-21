package com.springTutorial.webServices;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ResponseEntity<Iterable<User>> findAll () {
		return new ResponseEntity<Iterable<User>>(userRepository.findAll(), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value="findUsersByFilter", method=RequestMethod.POST)
	public ResponseEntity<List<User>> findUsersByFilter (@RequestBody Map<String, Object> parameters) {
		
		String name = (String) parameters.get("name");
		String lastname = (String) parameters.get("lastname");
		String email = (String) parameters.get("email");
		
		Specifications<User> specification = Specifications.where(null);
		
		if (StringUtils.isNotBlank(name)) {
			specification = specification.and(User.isNameLike(name));
		}

		if (StringUtils.isNotBlank(lastname)) {
			specification = specification.and(User.isLastnameLike(lastname));
		}

		if (StringUtils.isNotBlank(email)) {
			specification = specification.and(User.isEmailLike(email));
		}
		
		List<User> usersList = userRepository.findAll(specification);
		
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
		
	}
	
}
