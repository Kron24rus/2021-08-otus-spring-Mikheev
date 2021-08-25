package com.mikheev.homework.services.impl;

import com.mikheev.homework.services.IOService;
import com.mikheev.homework.services.SurveyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/test-context.xml")
public class SurveyServiceImplTest {

    @Autowired
    private IOService ioService;

    @Autowired
    @Qualifier("surveyService")
    private SurveyService surveyServiceCorrect;

    @Autowired
    @Qualifier("surveyServiceBroken")
    private SurveyService surveyServiceBroken;

    @BeforeEach
    void setUp() {
        Mockito.reset(ioService);
    }

    @Test
    void checkCorrectCsvResultParsing() {
        surveyServiceCorrect.run();
        verify(ioService, times(2)).write(anyString());
    }

    @Test
    void checkBrokenCsvResultParsing() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> surveyServiceBroken.run());
        verify(ioService, times(0)).write(anyString());
    }
}
