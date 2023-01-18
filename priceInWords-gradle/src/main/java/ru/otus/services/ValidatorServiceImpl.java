package ru.otus.services;

import ru.otus.api.services.IOService;
import ru.otus.api.services.ValidatorService;

public class ValidatorServiceImpl implements ValidatorService {
    private final IOService ioService;
    public ValidatorServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }
    @Override
    public void isValidFormat(String[] arr) {
        if (arr.length != 2) {
            ioService.outputException("Неверный формат ввода!");
            throw new IllegalArgumentException();
        }
    }
    @Override
    public void isValidNumber(int number) {
        if (number < 0) {
            ioService.outputException("Число не должно быть отрицательным!");
            throw new IllegalArgumentException();
        } else if (number > 999) {
            ioService.outputException("Число должно быть меньше 999!");
            throw new IllegalArgumentException();
        }
    }
    @Override
    public void isValidCurrencyCode(String currencyCode) {
        if (!currencyCode.equals("RUB") && !currencyCode.equals("USD")) {
            ioService.outputException("Код валюты должен быть введен в формате RUB или USD!");
            throw new IllegalArgumentException();
        }
    }
}
