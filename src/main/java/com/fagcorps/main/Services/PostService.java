package com.fagcorps.main.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fagcorps.main.Domain.Post;
import com.fagcorps.main.Repository.PostRepository;
import com.fagcorps.main.Services.Exeption.ObjextNotFoundExpction;

@Service
public class PostService {

	@Autowired
	PostRepository Repository; 
	
	
	
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
	
	
	
	
	
	
	
}
