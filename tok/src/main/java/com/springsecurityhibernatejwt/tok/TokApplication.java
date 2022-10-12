package com.springsecurityhibernatejwt.tok;

import com.springsecurityhibernatejwt.tok.user.User;
import com.springsecurityhibernatejwt.tok.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TokApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TokApplication.class, args);
	}
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args)throws  Exception{
		//Khi ct chay
		//insert vao CSDL 1 user
		User user = new User();
		user.setUsername("Vnfite");
		user.setPassword(passwordEncoder.encode("@vnfite"));
		userRepository.save(user);
		System.out.println(user);
	}
}
