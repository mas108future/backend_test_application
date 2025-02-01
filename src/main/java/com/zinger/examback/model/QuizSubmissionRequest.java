package com.zinger.examback.model;

import java.util.List;
import java.util.Map;

public class QuizSubmissionRequest {

    private String quizId;
    private Map<String, List<String>> answers;

    public QuizSubmissionRequest() {
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public Map<String,List<String>> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String,List<String>> answers) {
        this.answers = answers;
    }
}
