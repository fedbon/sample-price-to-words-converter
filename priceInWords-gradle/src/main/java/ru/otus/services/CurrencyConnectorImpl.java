package ru.otus.services;


import ru.otus.api.services.CurrencyConnector;
import ru.otus.domain.Currency;
import ru.otus.domain.CurrencyConnectionResult;
import ru.otus.domain.PriceNumber;

public class CurrencyConnectorImpl implements CurrencyConnector {

    @Override
    public CurrencyConnectionResult CurrencyConnectionResult(PriceNumber priceNumber, Currency currency) {
        int connectionResult = 0;
        return new CurrencyConnectionResult(priceNumber);
    }
}
