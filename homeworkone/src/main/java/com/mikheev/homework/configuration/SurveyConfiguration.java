package com.mikheev.homework.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "survey")
public class SurveyConfiguration {

    private String defaultQuestionsPath;

    private List<String> localizedQuestionsPaths;

    private int requiredAnswers;
}
