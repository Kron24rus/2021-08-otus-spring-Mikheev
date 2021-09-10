package com.mikheev.homework.model;

import com.mikheev.homework.utils.TextToAnswer;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class Question {

    @CsvBindByName(required = true)
    private String question;

    @CsvBindAndSplitByName(elementType = Answer.class, splitOn = "\\|", converter = TextToAnswer.class)
    private List<Answer> answers;

    @CsvBindByName(required = true)
    private String correctAnswer;
}
