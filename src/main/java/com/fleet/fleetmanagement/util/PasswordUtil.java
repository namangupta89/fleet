package com.fleet.fleetmanagement.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	public static String getPassword(String password) {
		// TODO Auto-generated method stub
		return bCryptPasswordEncoder.encode(password);
	}

}
