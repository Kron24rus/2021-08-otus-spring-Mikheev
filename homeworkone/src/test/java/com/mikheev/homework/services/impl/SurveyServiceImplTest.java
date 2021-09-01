package com.mikheev.homework.services.impl;

import com.mikheev.homework.services.IOService;
import com.mikheev.homework.services.SurveyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class SurveyServiceImplTest {

    @MockBean
    private IOService ioService;

    @Autowired
    private SurveyService surveyServiceCorrect;

//    @BeforeEach
//    void setUp() {
//        Mockito.reset(ioService);
//    }
//
    @Test
    void checkCorrectCsvResultParsing() {
        surveyServiceCorrect.run();
        verify(ioService, atLeastOnce()).write(anyString());
    }
}
