package com.mikheev.homework.services.impl;

import com.mikheev.homework.Main;
import com.mikheev.homework.services.IOService;
import com.mikheev.homework.services.SurveyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Main.class, TestConfig.class})
public class SurveyServiceImplTest {

    @Autowired
    private IOService ioService;

    @Autowired
    private SurveyService surveyServiceCorrect;

    @BeforeEach
    void setUp() {
        Mockito.reset(ioService);
    }

    @Test
    void checkCorrectCsvResultParsing() {
        surveyServiceCorrect.run();
        verify(ioService, atLeastOnce()).write(anyString());
    }
}
