package com.mikheev.homework.services.impl;

import com.mikheev.homework.exceptions.SurveyException;
import com.mikheev.homework.model.Answer;
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
    private static final int QUESTION_POSITION = 0;
    private static final int ANSWERS_POSITION = 1;
    private static final int CORRECT_ANSWER_POSITION = 2;
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
            loadSurvey(survey);
        } catch (SurveyException e) {
            LOGGER.error(e.getMessage(), e);
            ioService.write("Error occurred during running application.");
        }
        printSurvey(survey);
    }

    private void loadSurvey(List<Question> survey) {
        List<String[]> questionsFromCsv = csvReader.readAllLines(questionsPath);
        for (String[] questionValue : questionsFromCsv) {
            survey.add(parseQuestion(questionValue));
        }
    }

    private Question parseQuestion(String[] questionValue) {
        if (questionValue.length == 3) {
            Question question = new Question();
            question.setQuestion(questionValue[QUESTION_POSITION]);
            String correctAnswer = questionValue[CORRECT_ANSWER_POSITION];
            List<Answer> answers = parseAnswers(questionValue[ANSWERS_POSITION], correctAnswer);
            question.setAnswers(answers);
            return question;
        } else {
            ioService.write("Survey questions have wrong format.");
            throw new SecurityException("Survey questions have wrong format.");
        }
    }

    private List<Answer> parseAnswers(String answersString, String correctAnswer) {
        List<Answer> answers = new ArrayList<>();
        for (String answerValue : answersString.split("\\|")) {
            Answer answer = new Answer();
            answer.setAnswer(answerValue);
            answer.setCorrect(answerValue.equals(correctAnswer));
            answers.add(answer);
        }
        return answers;
    }

    private void printSurvey(List<Question> survey) {
        for (Question question : survey) {
            ioService.write(question.toString() + "\n");
        }
    }
}
