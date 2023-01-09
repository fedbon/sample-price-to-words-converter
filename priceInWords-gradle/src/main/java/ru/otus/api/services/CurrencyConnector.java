package ru.otus.api.services;

import ru.otus.domain.CurrencyConnectionResult;
import ru.otus.domain.PriceNumber;

public interface CurrencyConnector {
    CurrencyConnectionResult connectCurrency(PriceNumber priceNumber);
}
