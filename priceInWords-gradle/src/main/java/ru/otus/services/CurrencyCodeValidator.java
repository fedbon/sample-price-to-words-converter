package ru.otus.services;

import ru.otus.api.services.Validator;
import ru.otus.domain.CurrencyEndingsInWords;

public class CurrencyCodeValidator implements Validator {
    @Override
    public boolean validate(String value) {
        for (CurrencyEndingsInWords currencyEndingsInWords : CurrencyEndingsInWords.values()) {
            if (currencyEndingsInWords.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String errorMessage() {
        return "Код валюты должен быть введен в формате RUB или USD!";
    }
}
