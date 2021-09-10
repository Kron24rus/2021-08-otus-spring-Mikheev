package com.mikheev.homework.services.impl;

import com.mikheev.homework.configuration.SurveyConfiguration;
import com.mikheev.homework.exceptions.SurveyException;
import com.mikheev.homework.model.Question;
import com.mikheev.homework.model.UserSurvey;
import com.mikheev.homework.services.CsvReader;
import com.mikheev.homework.services.IOService;
import com.mikheev.homework.services.LocalizationService;
import com.mikheev.homework.services.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Service
@PropertySource("classpath:application.yaml")
public class SurveyServiceImpl implements SurveyService {

    private static final String REQUEST_USER_FIRSTNAME = "request.user.firstname";
    private static final String REQUEST_USER_LASTNAME = "request.user.lastname";
    private static final String REQUEST_USER_ANSWER = "request.user.answer";
    private static final String SURVEY_RESULT = "survey.result";
    private static final String RESULT_PASSED = "result.passed";
    private static final String RESULT_FAILED = "result.failed";
    private static final String RESULT_SHOW_ANSWER = "result.show.answer";

    private final CsvReader csvReader;
    private final IOService ioService;
    private final SurveyConfiguration surveyConfiguration;
    private final LocalizationService localizationService;

    @Override
    public void run() {
        List<Question> surveyQuestions;
        try {
            surveyQuestions = loadSurveyQuestions();
            UserSurvey userSurvey = createUserSurvey();
            runSurvey(surveyQuestions, userSurvey);
            printSurveyResult(userSurvey);
        } catch (SurveyException e) {
            log.error(e.getMessage(), e);
            ioService.write("Error occurred during running application.");
        }
    }

    private List<Question> loadSurveyQuestions() {
        return csvReader.loadCsvToSurvey(surveyConfiguration.getDefaultQuestionsPath(),
                surveyConfiguration.getLocalizedQuestionsPaths());
    }

    private UserSurvey createUserSurvey() {
        ioService.write(localizationService.getLocalizedMessage(REQUEST_USER_FIRSTNAME) + " ");
        String userFirstName = ioService.readFromConsole();
        ioService.write(localizationService.getLocalizedMessage(REQUEST_USER_LASTNAME) + " ");
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
        questionString.append(localizationService.getLocalizedMessage(REQUEST_USER_ANSWER)).append(" ");
        ioService.write(questionString.toString());
    }

    private void printSurveyResult(UserSurvey userSurvey) {
        ioService.write(localizationService.getLocalizedMessage(SURVEY_RESULT,
                new Object[]{userSurvey.getUserFirstName(), userSurvey.getUserLastName(), userSurvey.getResult(),
                localizationService.getLocalizedMessage(
                        (userSurvey.getResult() >= surveyConfiguration.getRequiredAnswers()
                                ? RESULT_PASSED : RESULT_FAILED))}) + "\n");

        for (Map.Entry<Question, String> answer : userSurvey.getUserAnswers().entrySet()) {
            Question question = answer.getKey();
            String userAnswer = answer.getValue();
            ioService.write(localizationService.getLocalizedMessage(RESULT_SHOW_ANSWER,
                    new Object[] {question.getQuestion(), question.getCorrectAnswer(), userAnswer}) + "\n");
        }
    }
}
