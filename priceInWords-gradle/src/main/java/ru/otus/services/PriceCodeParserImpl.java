package ru.otus.services;

import ru.otus.api.services.PriceCodeParser;
import ru.otus.api.services.Validator;
import ru.otus.domain.PriceCode;

import java.util.List;

public class PriceCodeParserImpl implements PriceCodeParser {

    @Override
    public PriceCode parsePriceCode(String priceCodeString, List<Validator> validators) {

        String[] arr = priceCodeString.split(" ");

        if (arr.length != 2) {
            throw new IllegalArgumentException("Неверный формат ввода!");
        }

        int number = Integer.parseInt(arr[0]);
        String currencyCode = arr[1];

        for (Validator validator: validators) {
            if (!validator.validate(number) || !validator.validate(currencyCode)) {
                throw new IllegalArgumentException(validator.errorMessage());
            }
        }
        return new PriceCode(number, currencyCode);
    }
}
