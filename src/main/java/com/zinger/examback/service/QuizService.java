package com.zinger.examback.service;

import com.zinger.examback.model.Question;
import com.zinger.examback.model.Quiz;
import com.zinger.examback.model.QuizResultResponse;
import com.zinger.examback.model.QuizSubmissionRequest;
import com.zinger.examback.repo.QuizRepo;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepo quizRepository;

    public QuizService(QuizRepo quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        for (Question question : quiz.getQuestions()) {
            if (question.getId() == null || question.getId().isEmpty()) {
                question.setId(new ObjectId().toString());
            }
        }
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(String id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    public QuizResultResponse submitQuiz(QuizSubmissionRequest submission) {
        Quiz quiz = quizRepository.findById(submission.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        int correctCount = 0;
        int totalQuestions = quiz.getQuestions().size();

        for (Question question : quiz.getQuestions()) {
            List<String> submittedAnswers = submission.getAnswers().get(question.getId());

            if (question.isMultipleChoice()) {
                if (submittedAnswers != null &&
                        submittedAnswers.size() == question.getCorrectAnswers().size() &&
                        question.getCorrectAnswers().containsAll(submittedAnswers)) {
                    correctCount++;
                }
            } else {
                if (submittedAnswers != null &&
                        question.getCorrectAnswers().contains(submittedAnswers.get(0))) {
                    correctCount++;
                }
            }
        }

        return new QuizResultResponse(totalQuestions, correctCount);
    }

}

