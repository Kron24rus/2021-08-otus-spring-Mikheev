package com.mikheev.homework.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "survey")
public class SurveyConfiguration {

    private String defaultQuestionsPath;

    private List<String> localizedQuestionsPaths;

    private int requiredAnswers;

    public String getDefaultQuestionsPath() {
        return defaultQuestionsPath;
    }

    public void setDefaultQuestionsPath(String defaultQuestionsPath) {
        this.defaultQuestionsPath = defaultQuestionsPath;
    }

    public List<String> getLocalizedQuestionsPaths() {
        return localizedQuestionsPaths;
    }

    public void setLocalizedQuestionsPaths(List<String> localizedQuestionsPaths) {
        this.localizedQuestionsPaths = localizedQuestionsPaths;
    }

    public int getRequiredAnswers() {
        return requiredAnswers;
    }

    public void setRequiredAnswers(int requiredAnswers) {
        this.requiredAnswers = requiredAnswers;
    }
}
