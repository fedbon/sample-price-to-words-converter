package ru.otus.services;

import ru.otus.api.services.PriceCurrencyCodeValidator;

public class PriceCurrencyCodeValidatorImpl implements PriceCurrencyCodeValidator {
    @Override
    public void isValidCurrencyCode(String currencyCode) {
        if (!currencyCode.equals("RUB") && !currencyCode.equals("USD")) {
            throw new IllegalArgumentException("Код валюты должен быть RUB или USD!");
        }
    }
}
