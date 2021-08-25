package com.mikheev.homework.exceptions;

public class SurveyException extends RuntimeException {

    public SurveyException() {
    }

    public SurveyException(String message) {
        super(message);
    }

    public SurveyException(String message, Throwable cause) {
        super(message, cause);
    }
}
