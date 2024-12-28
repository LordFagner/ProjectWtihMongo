package com.fagcorps.main.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fagcorps.main.Domain.Post;
import com.fagcorps.main.Domain.User;
import com.fagcorps.main.Repository.PostRepository;
import com.fagcorps.main.Repository.UserRepository;
import com.fagcorps.main.dto.AuthorDto;
import com.fagcorps.main.dto.CommentsDto;

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

		
		maria.getPost().addAll(Arrays.asList(post1,post2)); 
		bob	.getPost().addAll(Arrays.asList(post3,post5)); 
		alex.getPost().add(post4); 		
		
		repository.saveAll(Arrays.asList(maria, alex, bob));

		CommentsDto comment = new CommentsDto(new AuthorDto(maria), "vamos amanhã!!!");

		CommentsDto comment1 = new CommentsDto(new AuthorDto(maria), "ok Vamos sim!!");
		
		CommentsDto comment2 = new CommentsDto(new AuthorDto(bob), "não vai dar não !!");
		CommentsDto comment3 = new CommentsDto(new AuthorDto(alex), "vejo vocês lá !");
		CommentsDto comment4 = new CommentsDto(new AuthorDto(maria), "Vamos sair amanhã!");
		

		post1.getComments().addAll(Arrays.asList(comment,comment1,comment2));
		post2.getComments().addAll(Arrays.asList(comment4,comment3));
		repositoryPost.saveAll(Arrays.asList(post1,post2,post3,post4,post5)); 

		
		

		
	}

}
