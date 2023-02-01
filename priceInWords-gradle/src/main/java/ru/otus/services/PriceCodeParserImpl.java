package ru.otus.services;

import ru.otus.api.services.PriceCodeParser;
import ru.otus.api.services.Validator;
import ru.otus.domain.PriceCode;

import java.util.List;

public class PriceCodeParserImpl implements PriceCodeParser {

    @Override
    public PriceCode parsePriceCode(String priceCodeString, List<Validator> validators) {

        String[] priceCodeArray = priceCodeString.split(" ");

        if (priceCodeArray.length != 2) {
            throw new IllegalArgumentException("Некорректный формат ввода!");
        }

        for (Validator validator: validators) {
            if (!validator.validate(priceCodeArray)) {
                throw new IllegalArgumentException(validator.errorMessage());
            }
        }

        int number = Integer.parseInt(priceCodeArray[0]);
        String currencyCode = priceCodeArray[1];

        for (Validator validator: validators) {
            if (!validator.validate(number) || !validator.validate(currencyCode)) {
                throw new IllegalArgumentException(validator.errorMessage());
            }
        }
        return new PriceCode(number, currencyCode);
    }
}
