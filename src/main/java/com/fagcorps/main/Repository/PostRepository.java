package com.fagcorps.main.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fagcorps.main.Domain.Post;
import com.fagcorps.main.dto.AuthorDto;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	@Query("{'title': { $regex : ?0, $options : 'i' }}")
	List<Post> SerachPosts(String text);
	
	List<Post> findByAuthor (AuthorDto author);
	List<Post> findBytitleContaining(String Text);
; 
}
