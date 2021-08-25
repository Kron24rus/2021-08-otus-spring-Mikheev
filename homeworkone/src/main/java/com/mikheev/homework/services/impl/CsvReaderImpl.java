package com.mikheev.homework.services.impl;

import com.mikheev.homework.services.CsvReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CsvReaderImpl implements CsvReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvReaderImpl.class);

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
            LOGGER.error("Error during reading csv file with file path: {}", csvFilePath);
        }
        return null;
    }
}
