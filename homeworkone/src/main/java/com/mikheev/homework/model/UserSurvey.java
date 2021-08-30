package com.mikheev.homework.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserSurvey {

    private String userFirstName;
    private String userLastName;
    private Map<Question, String> userAnswers = new LinkedHashMap<>();
    private int result = 0;

    public UserSurvey(String userFirstName, String userLastName) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void addUserAnswer(Question question, String answer) {
        userAnswers.put(question, answer);
        if (question.getCorrectAnswer().equals(answer)) {
            result++;
        }
    }

    public Map<Question, String> getUserAnswers() {
        return userAnswers;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "UserSurvey{" +
                "userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userAnswers=" + userAnswers +
                ", result=" + result +
                '}';
    }
}
