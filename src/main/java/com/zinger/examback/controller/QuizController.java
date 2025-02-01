package com.zinger.examback.controller;

import com.zinger.examback.model.Quiz;
import com.zinger.examback.model.QuizResultResponse;
import com.zinger.examback.model.QuizSubmissionRequest;
import com.zinger.examback.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable String id) {
        return quizService.getQuizById(id);
    }

    @PostMapping("/submit")
    public ResponseEntity<QuizResultResponse> submitQuiz(@RequestBody QuizSubmissionRequest submission) {
        QuizResultResponse result = quizService.submitQuiz(submission);
        return ResponseEntity.ok(result);
    }
}
