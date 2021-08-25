package com.mikheev.homework.services.impl;

import com.mikheev.homework.exceptions.SurveyException;
import com.mikheev.homework.model.Question;
import com.mikheev.homework.services.CsvReader;
import com.mikheev.homework.services.IOService;
import com.mikheev.homework.services.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SurveyServiceImpl implements SurveyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyServiceImpl.class);
    private CsvReader csvReader;
    private IOService ioService;
    private String questionsPath;

    public SurveyServiceImpl(CsvReader csvReader, IOService ioService, String questionsPath) {
        this.csvReader = csvReader;
        this.ioService = ioService;
        this.questionsPath = questionsPath;
    }

    @Override
    public void run() {
        List<Question> survey = new ArrayList<>();
        try {
            survey = loadSurvey();
        } catch (SurveyException e) {
            LOGGER.error(e.getMessage(), e);
            ioService.write("Error occurred during running application.");
        }
        printSurvey(survey);
    }

    private List<Question> loadSurvey() {
        return csvReader.loadCsvToSurvey(questionsPath);
    }

    private void printSurvey(List<Question> survey) {
        for (Question question : survey) {
            ioService.write(question.toString() + "\n");
        }
    }
}
