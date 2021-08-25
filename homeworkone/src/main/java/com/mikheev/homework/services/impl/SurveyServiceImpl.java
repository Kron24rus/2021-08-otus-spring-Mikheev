package com.mikheev.homework.services.impl;

import com.mikheev.homework.model.Answer;
import com.mikheev.homework.model.Question;
import com.mikheev.homework.services.CsvReader;
import com.mikheev.homework.services.IOService;
import com.mikheev.homework.services.SurveyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SurveyServiceImpl implements SurveyService {

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
        loadSurvey(survey);
        printSurvey(survey);
    }

    private void loadSurvey(List<Question> survey) {
        List<String[]> questionsFromCsv = csvReader.readAllLines(questionsPath);
        if (Objects.nonNull(questionsFromCsv)) {
            for (String[] questionValue : questionsFromCsv) {
                Question question = new Question();
                question.setQuestion(questionValue[QUESTION_POSITION]);
                String correctAnswer = questionValue[CORRECT_ANSWER_POSITION];
                List<Answer> answers = new ArrayList<>();
                for (String answerValue : questionValue[ANSWERS_POSITION].split("\\|")) {
                    Answer answer = new Answer();
                    answer.setAnswer(answerValue);
                    answer.setCorrect(answerValue.equals(correctAnswer));
                    answers.add(answer);
                }
                question.setAnswers(answers);
                survey.add(question);
            }
        } else {
            ioService.write("Survey is empty or error occurred during parsing, check input file.");
        }
    }

    private void printSurvey(List<Question> survey) {
        for (Question question : survey) {
            ioService.write(question.toString() + "\n");
        }
    }
}
