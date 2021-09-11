package com.mikheev.homework.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

@ToString
@Getter
@RequiredArgsConstructor
public class UserSurvey {

    private final String userFirstName;
    private final String userLastName;
    private final Map<Question, String> userAnswers = new LinkedHashMap<>();
    private int result = 0;

    public void addUserAnswer(Question question, String answer) {
        userAnswers.put(question, answer);
        if (question.getCorrectAnswer().equals(answer)) {
            result++;
        }
    }

    public void clearResults() {
        userAnswers.clear();
        result = 0;
    }
}
