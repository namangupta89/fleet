package com.fleet.fleetmanagement.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fleet.fleetmanagement.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmailIgnoreCase(String username);


}
