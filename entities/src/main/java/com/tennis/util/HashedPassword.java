package com.tennis.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class HashedPassword {

	public static String encodePassword(String originalPassword) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(originalPassword);
		return encodedPassword;
	}

	public static boolean isMatchPassword(String rawPassword,
			String encodedPassword) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(rawPassword, encodedPassword);
	}

	// public static void main(String[] args) {
	// String originalPassword = "admin123";
	// String encodedPassword = encodePassword(originalPassword);
	// System.out.println("Hashed Password : " + encodedPassword);
	// System.out.println(isMatchPassword(originalPassword, encodedPassword));
	// }
}
