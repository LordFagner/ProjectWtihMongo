package com.fagcorps.main.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fagcorps.main.Domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
