package com.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventosApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}
}
