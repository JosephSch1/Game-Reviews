package com.coderscampus.gamereviews;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class GamereviewsApplicationTests {

	@Test
	void encrypt_password() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPass = passwordEncoder.encode("password123");
		System.out.println(encodedPass);
	}

}
