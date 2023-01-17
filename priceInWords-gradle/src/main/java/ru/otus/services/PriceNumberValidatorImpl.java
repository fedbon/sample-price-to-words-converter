package ru.otus.services;

import ru.otus.api.services.PriceNumberValidator;

public class PriceNumberValidatorImpl implements PriceNumberValidator {
    @Override
    public void isValidNumber(int number) {
        if(number < 0 || number > 999){
            throw new IllegalArgumentException("Число должно быть в диапазоне между 0 и 999!");
        }
    }
}
