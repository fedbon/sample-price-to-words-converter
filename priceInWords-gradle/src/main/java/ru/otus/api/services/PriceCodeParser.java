package ru.otus.api.services;

import ru.otus.domain.PriceCode;

import java.util.List;

public interface PriceCodeParser {
    PriceCode parsePriceCode(String priceCodeString, List<Validator> validators);
}
