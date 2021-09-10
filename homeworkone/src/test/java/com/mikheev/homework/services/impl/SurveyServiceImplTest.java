package com.mikheev.homework.services.impl;

import com.mikheev.homework.configuration.SurveyConfiguration;
import com.mikheev.homework.services.IOService;
import com.mikheev.homework.services.SurveyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class SurveyServiceImplTest {

    @MockBean
    private IOService ioService;

    @MockBean
    private SurveyConfiguration surveyConfiguration;

    @Autowired
    private SurveyService surveyServiceCorrect;

    @Test
    void checkCorrectCsvResultParsing() {
        when(surveyConfiguration.getDefaultQuestionsPath()).thenReturn("/test-csv/questions-correct.csv");
        surveyServiceCorrect.run();
        verify(ioService, atLeastOnce()).write(anyString());
        verify(ioService, atLeastOnce()).readFromConsole();
    }

    @Test
    void checkWrongCsvResultParsing() {
        when(surveyConfiguration.getDefaultQuestionsPath()).thenReturn("/test-csv/questions-broken.csv");
        surveyServiceCorrect.run();
        verify(ioService, times(1)).write("Error occurred during running application.");
        verify(ioService, never()).readFromConsole();
    }
}
