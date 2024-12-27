package com.fagcorps.main.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fagcorps.main.Domain.User;
import com.fagcorps.main.Repository.UserRepository;
import com.fagcorps.main.Services.UserServices;
@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		repository.saveAll(Arrays.asList(maria, alex, bob));

	}

}
