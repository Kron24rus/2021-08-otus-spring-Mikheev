package com.mikheev.homework;

import com.mikheev.homework.services.SurveyService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        SurveyService surveyService = context.getBean(SurveyService.class);
        surveyService.run();
    }
}
