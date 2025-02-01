package com.zinger.examback.repo;

import com.zinger.examback.test.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    // You can define custom query methods here
    User findByEmail(String email);
}
