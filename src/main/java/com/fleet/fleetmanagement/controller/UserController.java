package com.fleet.fleetmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.fleetmanagement.model.User;
import com.fleet.fleetmanagement.service.UserService;

@RestController
public class UserController {
	
	@Autowired private UserService userService;

	@GetMapping(value="/users")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity< List<User> > getAllUsers(){
		
		List<User> users = userService.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getuser")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<User>  getUser(Principal principal){
		
		User user = userService.getUserByEmail(principal.getName());
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}

}
