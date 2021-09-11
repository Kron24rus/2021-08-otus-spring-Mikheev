package com.mikheev.homework.services.impl;

import com.mikheev.homework.exceptions.SurveyException;
import com.mikheev.homework.model.Question;
import com.mikheev.homework.services.CsvReader;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

@Service
public class CsvReaderImpl implements CsvReader {

    @Override
    public List<Question> loadCsvToSurvey(String defaultQuestionsPath, List<String> localizedQuestionsPaths) {
        String csvFilePath = getCSVPathForUserLocale(defaultQuestionsPath, localizedQuestionsPaths);
        Resource resource = new ClassPathResource(csvFilePath);
        try (InputStream csvResourceStream = resource.getInputStream();
             CSVReader csvReader = new CSVReader(new InputStreamReader(csvResourceStream))) {
            return new CsvToBeanBuilder<Question>(csvReader).withType(Question.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            throw new SurveyException("Error during reading csv file with file path: " + csvFilePath, e);
        }
    }

    private String getCSVPathForUserLocale(String defaultQuestionsPath, List<String> localizedQuestionsPaths) {
        Locale userLocale = LocaleContextHolder.getLocale();
        String userLocaleLanguage = userLocale.getLanguage();
        String questionPathWithoutExtension = defaultQuestionsPath.substring(0, defaultQuestionsPath.length() - 4);

        for (String questionsPath : localizedQuestionsPaths) {
            String localeExtension = questionsPath.replace(questionPathWithoutExtension, "").replace(".csv", "");
            if (localeExtension.contains(userLocaleLanguage)) {
                return questionsPath;
            }
        }

        return defaultQuestionsPath;
    }
}
