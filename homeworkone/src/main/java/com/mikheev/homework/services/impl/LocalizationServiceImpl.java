package com.mikheev.homework.services.impl;

import com.mikheev.homework.services.LocalizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@RequiredArgsConstructor
@Service
public class LocalizationServiceImpl implements LocalizationService {

    private final MessageSource messageSource;
    private final Locale applicationLocale = LocaleContextHolder.getLocale();

    @Override
    public String getLocalizedMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null, applicationLocale);
    }

    @Override
    public String getLocalizedMessage(String messageCode, Object[] arguments) {
        return messageSource.getMessage(messageCode, arguments, applicationLocale);
    }
}
