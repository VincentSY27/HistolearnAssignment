package com.mobAppDev.assignment.histolearn;

import java.util.List;

// Getters for Quiz Questions
public class QuestionBean {


    private String type;
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;


    public String getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public List<String> getIncorrect_answers() {
        return incorrect_answers;
    }


}
