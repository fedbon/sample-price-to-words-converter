package ru.otus.api.services;

public interface ValidatorService {
    void isValidFormat(String[] arr);
    void isValidNumber(int number);
    void isValidCurrencyCode(String currencyCode);
}
