package com.mikheev.homework.services;

import java.util.List;

public interface CsvReader {

    List<String[]> readAllLines(String csvFilePath);
}
