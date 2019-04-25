package com.fleet.fleetmanagement.service;

import java.util.List;

import com.fleet.fleetmanagement.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String name);


}
