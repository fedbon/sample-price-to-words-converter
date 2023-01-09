package ru.otus.api.services;

import ru.otus.domain.PriceNumber;

public interface PriceNumberParser {
    PriceNumber parsePriceNumber(String priceString);
}
