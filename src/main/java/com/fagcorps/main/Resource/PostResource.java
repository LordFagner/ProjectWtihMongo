package com.fagcorps.main.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fagcorps.main.Domain.Post;
import com.fagcorps.main.Resource.util.UrlDecoders;
import com.fagcorps.main.Services.PostService;

@RestController
@RequestMapping(value = "/Post")
public class PostResource {

	@Autowired
	PostService service;
	
	

@GetMapping(value = "/{id}")

public ResponseEntity<Post> FindById(@PathVariable String id){

	
	return ResponseEntity.ok().body(service.FindById(id)); 
	
}


@GetMapping
public ResponseEntity<List<Post>> FindAll(){
	
	return ResponseEntity.ok().body(service.findAll());

	
	
	
	
}


@GetMapping(value = "/Author/{id}")

public ResponseEntity<List<Post>> FindByAuthor(@PathVariable String id){

	
	return ResponseEntity.ok().body(service.findByAuthor(id)); 
	
}


@GetMapping(value = "/titleSearch")

public ResponseEntity<List<Post>> FindByTitle(@RequestParam(value = "text",defaultValue = "" ) String Text){
	String cod = UrlDecoders.DecodeParams(Text); 
	
	
	return ResponseEntity.ok().body(service.findByTitle(cod)); 
	
}





}
