package ru.otus.services;

import ru.otus.api.services.Validator;

public class StringToNumberValidator implements Validator {
    @Override
    public boolean validate(String[] array) {
        String value = array[0];
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    @Override
    public String errorMessage() {
        return "Введено не число!";
    }
}
