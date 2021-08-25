package com.mikheev.homework.services.impl;

import com.mikheev.homework.exceptions.SurveyException;
import com.mikheev.homework.services.CsvReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CsvReaderImpl implements CsvReader {

    public CsvReaderImpl() {
    }

    @Override
    public List<String[]> readAllLines(String csvFilePath) {
        try {
            Resource resource = new ClassPathResource(csvFilePath);
            InputStream csvResourceStream = resource.getInputStream();
            CSVReader csvReader = new CSVReader(new InputStreamReader(csvResourceStream));
            List<String[]> result = csvReader.readAll();
            csvReader.close();
            return result;
        } catch (IOException | CsvException e) {
            throw new SurveyException("Error during reading csv file with file path: " + csvFilePath, e);
        }
    }
}
