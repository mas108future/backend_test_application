package com.zinger.examback.repo;

import com.zinger.examback.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepo extends MongoRepository<Quiz, String> {
}
