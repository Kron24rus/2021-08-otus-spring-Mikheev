package com.mikheev.homework.shell;

import com.mikheev.homework.services.SurveyService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class SurveyServiceCommands {

    private final SurveyService surveyService;

    public SurveyServiceCommands(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @ShellMethod(value = "Run survey", key = {"run"})
    public void runSurvey() {
        surveyService.run();
    }

    @ShellMethod(value = "Create Survey For User", key = {"create"})
    public void createUserSurvey() {
        surveyService.createUserSurvey();
    }

    @ShellMethod(value = "Print survey results", key = {"printres"})
    public void printSurveyResults() {
        surveyService.printSurveyResults();
    }
}
