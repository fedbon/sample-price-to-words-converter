package ru.otus.domain;

public class CurrencyConnectionResult {
    private final PriceNumber priceNumber;
    private final Currency currency;

    public CurrencyConnectionResult(PriceNumber priceNumber, Currency currency) {
        this.priceNumber = priceNumber;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return priceNumber + " " + currency;
    }
}
