package ru.otus.api.services;

public interface Validator {
    default boolean validate (String value){
        return true;
    }
    default boolean validate (int value){
        return true;
    }
    default boolean validate (String[] array){
        return true;
    }
    String errorMessage();
}

