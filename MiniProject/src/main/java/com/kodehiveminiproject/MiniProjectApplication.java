package com.kodehiveminiproject;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kodehiveminiproject.model.Role;
import com.kodehiveminiproject.model.User;
import com.kodehiveminiproject.service.UserService;

@SpringBootApplication
public class MiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder();
	};
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new User(null, "Dark Muhammad Ihsan", "ihsan", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Rafi Soluchin", "rafi", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Wisnu Murti", "wisnu", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Raymond", "raymond", "1234", new ArrayList<>()));
		
			userService.addRoleToUser("rafi", "ROLE_USER");
			userService.addRoleToUser("wisnu", "ROLE_ADMIN");
			userService.addRoleToUser("wisnu", "ROLE_MANAGER");
			userService.addRoleToUser("ihsan", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("raymond", "ROLE_MANAGER");
			userService.addRoleToUser("ihsan", "ROLE_ADMIN");
		};
	}
}
