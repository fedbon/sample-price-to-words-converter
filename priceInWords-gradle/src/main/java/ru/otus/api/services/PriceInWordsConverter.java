package ru.otus.api.services;

import ru.otus.domain.PriceInWordsConversionResult;
import ru.otus.domain.PriceCode;

public interface PriceInWordsConverter {
    PriceInWordsConversionResult convertPriceCode(PriceCode priceCode);
}
