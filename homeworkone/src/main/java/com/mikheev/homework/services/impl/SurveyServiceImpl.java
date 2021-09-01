package com.mikheev.homework.services.impl;

import com.mikheev.homework.configuration.SurveyConfiguration;
import com.mikheev.homework.exceptions.SurveyException;
import com.mikheev.homework.model.Question;
import com.mikheev.homework.model.UserSurvey;
import com.mikheev.homework.services.CsvReader;
import com.mikheev.homework.services.IOService;
import com.mikheev.homework.services.SurveyService;
import com.mikheev.homework.utils.LocalizationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@PropertySource("classpath:application.yaml")
public class SurveyServiceImpl implements SurveyService {

    public static final String REQUEST_USER_FIRSTNAME = "request.user.firstname";
    public static final String REQUEST_USER_LASTNAME = "request.user.lastname";
    public static final String REQUEST_USER_ANSWER = "request.user.answer";
    public static final String SURVEY_RESULT = "survey.result";
    public static final String RESULT_PASSED = "result.passed";
    public static final String RESULT_FAILED = "result.failed";
    public static final String RESULT_SHOW_ANSWER = "result.show.answer";

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyServiceImpl.class);
    private CsvReader csvReader;
    private IOService ioService;
    private MessageSource messageSource;
    private SurveyConfiguration surveyConfiguration;

    public SurveyServiceImpl(CsvReader csvReader,
                             IOService ioService,
                             MessageSource messageSource,
                             SurveyConfiguration surveyConfiguration) {
        this.csvReader = csvReader;
        this.ioService = ioService;
        this.messageSource = messageSource;
        this.surveyConfiguration = surveyConfiguration;
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
        return csvReader.loadCsvToSurvey(surveyConfiguration.getDefaultQuestionsPath(),
                surveyConfiguration.getLocalizedQuestionsPaths());
    }

    private UserSurvey createUserSurvey() {
        ioService.write(LocalizationUtils.getLocalizedMessage(messageSource, REQUEST_USER_FIRSTNAME, Locale.US) + " ");
        String userFirstName = ioService.readFromConsole();
        ioService.write(LocalizationUtils.getLocalizedMessage(messageSource, REQUEST_USER_LASTNAME, Locale.UK) + " ");
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
        questionString.append(LocalizationUtils.getLocalizedMessage(messageSource, REQUEST_USER_ANSWER)).append(" ");
        ioService.write(questionString.toString());
    }

    private void printSurveyResult(UserSurvey userSurvey) {
        ioService.write(LocalizationUtils.getLocalizedMessage(messageSource, SURVEY_RESULT,
                new Object[]{userSurvey.getUserFirstName(), userSurvey.getUserLastName(), userSurvey.getResult(),
                LocalizationUtils.getLocalizedMessage(messageSource,
                        (userSurvey.getResult() >= surveyConfiguration.getRequiredAnswers()
                                ? RESULT_PASSED : RESULT_FAILED))}) + "\n");

        for (Map.Entry<Question, String> answer : userSurvey.getUserAnswers().entrySet()) {
            Question question = answer.getKey();
            String userAnswer = answer.getValue();
            ioService.write(LocalizationUtils.getLocalizedMessage(messageSource, RESULT_SHOW_ANSWER,
                    new Object[] {question.getQuestion(), question.getCorrectAnswer(), userAnswer}) + "\n");
        }
    }
}
