package ru.otus.api.services;

import ru.otus.domain.PriceCode;

public interface PriceCodeParser {
    PriceCode parsePriceCode(String priceCodeString,
                             ValidatorService validatorService);
}
