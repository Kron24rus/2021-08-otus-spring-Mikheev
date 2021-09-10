package com.mikheev.homework.services;

public interface LocalizationService {

    String getLocalizedMessage(String messageCode);

    String getLocalizedMessage(String messageCode, Object[] arguments);
}
