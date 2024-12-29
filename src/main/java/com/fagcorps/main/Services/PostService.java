package com.fagcorps.main.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fagcorps.main.Domain.Post;
import com.fagcorps.main.Repository.PostRepository;
import com.fagcorps.main.Services.Exeption.ObjextNotFoundExpction;
import com.fagcorps.main.dto.AuthorDto;

@Service
public class PostService {

	@Autowired
	PostRepository Repository; 
	@Autowired
	UserServices service;
	
	
	
	public Post FindById(String id) {
		
		Optional<Post> post =  Repository.findById(id); 
		
		
		if(post.isEmpty()) {
			
			 throw new ObjextNotFoundExpction(id); 
			
		}else {
			
			return post.get();
			
		}
		
		
	}



	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return Repository.findAll();
	}
	
	public List<Post> findByAuthor( String id) {
		// TODO Auto-generated method stub
		return Repository.findByAuthor(new AuthorDto(service.FindById(id)));
	}
	
	public List<Post> findByTitle(String text){
		
		return Repository.SerachPosts(text);
		
	}
	
	
	
}
