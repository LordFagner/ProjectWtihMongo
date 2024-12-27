package com.fagcorps.main.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fagcorps.main.Domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
