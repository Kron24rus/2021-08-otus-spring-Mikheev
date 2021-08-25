package com.mikheev.homework.utils;

import com.mikheev.homework.model.Answer;
import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class TextToAnswer extends AbstractCsvConverter {

    @Override
    public Object convertToRead(String answerValue) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        Answer answer = new Answer();
        answer.setAnswer(answerValue);
        return answer;
    }
}
