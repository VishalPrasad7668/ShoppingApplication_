package com.niit.UserProductService.repository;

import com.niit.UserProductService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

    User findByUserId(int userId);
}
