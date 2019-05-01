package com.fleet.fleetmanagement.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.fleet.fleetmanagement.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.fleet.fleetmanagement.model.User;
import com.fleet.fleetmanagement.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }

    @GetMapping(value = "/getuser/{email}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        User user = userService.getUserByEmail(email);

        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> deleteUser(@PathVariable String id) {
        String[] ids = id.split("\\,");

        if (ids.length > 0) {
            Arrays.stream(ids).forEach(d -> {
                userService.deleteUser(Long.parseLong(d));
            });
            return new ResponseEntity<Response>(new Response("User has deleted successfully"), HttpStatus.OK);

        } else {
            return null;
        }

    }

    @PutMapping(value = "/update")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> updateUser(@RequestBody User user) {
        boolean isExist = userService.isExists(user.getId());
        if (isExist) {
            User dbUser = userService.save(user);
            if (dbUser != null) {
                return new ResponseEntity<Response>(new Response("User has updated successfully"), HttpStatus.OK);
            }
        } else {
            return null;
        }
        return null;

    }


}
