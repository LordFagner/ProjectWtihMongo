package com.fagcorps.main.Resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fagcorps.main.Domain.Post;
import com.fagcorps.main.Domain.User;
import com.fagcorps.main.Services.UserServices;
import com.fagcorps.main.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/Users")
public class UserResource {

	@Autowired
	UserServices service;

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {

		List<User> list = service.findAll();
		List<UserDto> ListDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(ListDto);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> FindById(@PathVariable String id) {
		UserDto dto = new UserDto(service.FindById(id));
		return ResponseEntity.ok().body(dto);

	}

	@PostMapping()
	public ResponseEntity<UserDto> postMethodName(@RequestBody User entity) {
		// TODO: process POST request
		UserDto dto = new UserDto(service.InsertUser(entity));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.id()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserDto> Delete(@PathVariable String id) {

		service.DeleteById(id);

		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDto> Update(@PathVariable String id, @RequestBody User entity) {
		// TODO: process PUT request
		UserDto user = new UserDto(service.Update(id, entity));

		return ResponseEntity.accepted().body(user);
	}
	@GetMapping(value = "/Post/{id}")
	public ResponseEntity<List<Post>> FindPosts(@PathVariable String id) {
	
		User user = service.FindById(id);
	
		return ResponseEntity.ok().body(user.getPost());

		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}