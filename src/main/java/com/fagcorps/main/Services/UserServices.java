package com.fagcorps.main.Services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fagcorps.main.Domain.User;
import com.fagcorps.main.Repository.UserRepository;
import com.fagcorps.main.Services.Exeption.IvalidInsertUser;
import com.fagcorps.main.Services.Exeption.ObjextNotFoundExpction;

@Service
public class UserServices {
	@Autowired
	UserRepository repository;
	
	
	public List<User> findAll(){
		
		return repository.findAll();		
		
	}
	

	public User FindById(String id) {
		try {
		Optional<User> user = repository.findById(id); 
		return user.get();
				
		}catch (NoSuchElementException e) {

			throw new ObjextNotFoundExpction(id); 
			// TODO: handle exception
		}
		
		
	}
	
	public User InsertUser(User user) {
		if(user != null) {
		repository.insert(user);
		
		return user;
		
		} else {
			
			throw new IvalidInsertUser();
		}
		
	}


	public void DeleteById(String id) {
		// TODO Auto-generated method stub
		
		repository.deleteById(id);
		
		
	}
	
	
}
