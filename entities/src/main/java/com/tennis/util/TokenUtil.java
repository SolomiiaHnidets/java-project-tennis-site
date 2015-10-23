package com.tennis.util;

import java.util.UUID;

public class TokenUtil {
	public static String generateRandomToken() {
		return UUID.randomUUID().toString();
	}
}
