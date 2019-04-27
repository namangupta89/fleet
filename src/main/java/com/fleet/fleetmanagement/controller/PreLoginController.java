package com.fleet.fleetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.fleetmanagement.domain.Response;
import com.fleet.fleetmanagement.model.User;
import com.fleet.fleetmanagement.service.UserService;

@RestController
public class PreLoginController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value="/registration")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<Response> registration(@RequestBody User user){
		User dbUser = userService.save(user);
		if(dbUser!=null) {
			return new ResponseEntity<Response>(new Response("User is saved successfully"), HttpStatus.OK);
		}else {
			return null;
		}
	}
}
