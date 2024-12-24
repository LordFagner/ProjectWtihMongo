package com.fagcorps.main.Resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fagcorps.main.Domain.User;

@RestController
@RequestMapping(value = "/Users")
public class UserResource {
	@GetMapping
public ResponseEntity<List<User>> findAll(){
	User u1 = new User("1", "fanger.klop@gmail.com", "fagner1");
	User u2 = new User("2", "fagner.compras1.0.0", "fagner2");
	
	List<User> list = Arrays.asList(u1,u2);
	
	return list; 


}
}