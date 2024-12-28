package com.fagcorps.main.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fagcorps.main.Domain.Post;
import com.fagcorps.main.Domain.User;
import com.fagcorps.main.Repository.PostRepository;
import com.fagcorps.main.Repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	UserRepository repository;
	@Autowired
	PostRepository repositoryPost;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		repository.deleteAll();
		repositoryPost.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		repository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, Instant.parse("2024-12-27T12:00:00Z"), "Hello World", "This is my first post!",maria);
		Post post2 = new Post(null, Instant.parse("2024-12-26T15:30:00Z"), "Java Tips", "Learn about the Serializable interface in Java.",maria);
		Post post3 = new Post(null, Instant.parse("2024-12-25T10:15:00Z"), "Holiday Greetings", "Wishing everyone a happy holiday season!",bob);
		Post post4 = new Post(null, Instant.now(), "Tech Trends 2025", "Exploring the most anticipated technologies of 2025.",alex);
		Post post5 = new Post(null, Instant.parse("2024-12-20T08:45:00Z"), "Code Snippets", "Here are some useful Java snippets for everyday programming.",bob);

		
		repositoryPost.saveAll(Arrays.asList(post1,post2,post3,post4,post5)); 

		
	}

}
