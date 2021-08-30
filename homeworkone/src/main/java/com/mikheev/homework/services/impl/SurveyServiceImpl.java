package com.mikheev.homework.services.impl;

import com.mikheev.homework.exceptions.SurveyException;
import com.mikheev.homework.model.Question;
import com.mikheev.homework.model.UserSurvey;
import com.mikheev.homework.services.CsvReader;
import com.mikheev.homework.services.IOService;
import com.mikheev.homework.services.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@PropertySource("classpath:application.properties")
public class SurveyServiceImpl implements SurveyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyServiceImpl.class);
    private CsvReader csvReader;
    private IOService ioService;
    private String questionsPath;
    private int requiredAnswers;

    @Autowired
    public SurveyServiceImpl(CsvReader csvReader, IOService ioService,
                             @Value("${survey.questions.path}") String questionsPath,
                             @Value("${survey.required.answers:2}") int requiredAnswers) {
        this.csvReader = csvReader;
        this.ioService = ioService;
        this.questionsPath = questionsPath;
        this.requiredAnswers = requiredAnswers;
    }

    @Override
    public void run() {
        List<Question> surveyQuestions;
        try {
            surveyQuestions = loadSurveyQuestions();
            UserSurvey userSurvey = createUserSurvey();
            runSurvey(surveyQuestions, userSurvey);
            printSurveyResult(userSurvey);
        } catch (SurveyException e) {
            LOGGER.error(e.getMessage(), e);
            ioService.write("Error occurred during running application.");
        }
    }

    private List<Question> loadSurveyQuestions() {
        return csvReader.loadCsvToSurvey(questionsPath);
    }

    private UserSurvey createUserSurvey() {
        ioService.write("Enter your first name: ");
        String userFirstName = ioService.readFromConsole();
        ioService.write("Enter your last name: ");
        String userLastName = ioService.readFromConsole();
        return new UserSurvey(userFirstName, userLastName);
    }

    private void runSurvey(List<Question> surveyQuestions, UserSurvey userSurvey) {
        for (Question question : surveyQuestions) {
            printQuestion(question);
            String userAnswer = ioService.readFromConsole();
            userSurvey.addUserAnswer(question, userAnswer);
        }
    }

    private void printQuestion(Question question) {
        StringBuilder questionString = new StringBuilder();
        questionString.append(question.getQuestion()).append("\n");
        question.getAnswers().forEach(answer -> questionString.append(answer.getAnswer()).append("\n"));
        questionString.append("Your answer: ");
        ioService.write(questionString.toString());
    }

    private void printSurveyResult(UserSurvey userSurvey) {
        ioService.write(userSurvey.getUserFirstName() + " " + userSurvey.getUserLastName()
                + " completed test with " + userSurvey.getResult() + " correct answers. Test result: "
                + (userSurvey.getResult() >= requiredAnswers ? "passed." : "failed.") + "\n");
        for (Map.Entry<Question, String> answer : userSurvey.getUserAnswers().entrySet()) {
            Question question = answer.getKey();
            String userAnswer = answer.getValue();
            ioService.write("Question: " + question.getQuestion()
                    + " | Correct answer: " + question.getCorrectAnswer()
                    + " | User Answer: " + userAnswer + "\n");
        }
    }
}
