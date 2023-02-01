package ru.otus.services;

import ru.otus.api.services.Validator;

public class MaxValueValidator implements Validator {
    @Override
    public boolean validate(int value) {
        return value <= 999;
    }
    @Override
    public String errorMessage() {
        return "Число должно быть меньше 1000!";
    }
}
