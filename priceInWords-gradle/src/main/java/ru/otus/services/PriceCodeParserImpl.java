package ru.otus.services;

import ru.otus.api.services.PriceCodeParser;
import ru.otus.api.services.ValidatorService;
import ru.otus.domain.PriceCode;

public class PriceCodeParserImpl implements PriceCodeParser {

    @Override
    public PriceCode parsePriceCode(String priceCodeString,
                                    ValidatorService validatorService) {

        String[] arr = priceCodeString.split(" ");
        validatorService.isValidFormat(arr);

        int number = Integer.parseInt(arr[0]);
        validatorService.isValidNumber(number);

        String currencyCode = String.valueOf(arr[1]);
        validatorService.isValidCurrencyCode(currencyCode);

        return new PriceCode(number, currencyCode);
    }
}
