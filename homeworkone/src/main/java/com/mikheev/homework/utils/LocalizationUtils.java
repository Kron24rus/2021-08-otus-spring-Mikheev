package com.mikheev.homework.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public final class LocalizationUtils {

    public static String getLocalizedMessage(MessageSource messageSource, String messageCode) {
        return messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
    }

    public static String getLocalizedMessage(MessageSource messageSource, String messageCode, Object[] arguments) {
        return messageSource.getMessage(messageCode, arguments, LocaleContextHolder.getLocale());
    }

    public static String getLocalizedMessage(MessageSource messageSource, String messageCode, Locale locale) {
        return messageSource.getMessage(messageCode, null, locale);
    }

    public static String getLocalizedMessage(MessageSource messageSource, String messageCode, Object[] arguments,
                                             Locale locale) {
        return messageSource.getMessage(messageCode, arguments, locale);
    }
}
