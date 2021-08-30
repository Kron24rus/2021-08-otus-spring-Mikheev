package com.mikheev.homework;

import com.mikheev.homework.services.SurveyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        SurveyService surveyService = context.getBean(SurveyService.class);
        surveyService.run();
    }
}
