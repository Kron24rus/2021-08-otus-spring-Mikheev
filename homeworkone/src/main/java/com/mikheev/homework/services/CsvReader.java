package com.mikheev.homework.services;

import com.mikheev.homework.model.Question;

import java.util.List;

public interface CsvReader {

    List<Question> loadCsvToSurvey(String defaultQuestionsPath, List<String> localizedQuestionsPaths);
}
