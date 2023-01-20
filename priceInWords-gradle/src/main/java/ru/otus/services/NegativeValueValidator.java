package ru.otus.services;

import ru.otus.api.services.Validator;
public class NegativeValueValidator implements Validator {
    @Override
    public boolean validate(int value) {
        return value >= 0;
    }
    @Override
    public String errorMessage() {
        return "Число не должно быть отрицательным!";
    }
}
