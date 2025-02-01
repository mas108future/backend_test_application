package com.zinger.examback.model;

public class QuizResultResponse {

    private int totalQuestions;
    private int correctAnswers;
    private int score;

    public QuizResultResponse(int totalQuestions, int correctAnswers) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.score = (correctAnswers * 100) / totalQuestions;
    }

    // Getters
    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getScore() {
        return score;
    }
}
