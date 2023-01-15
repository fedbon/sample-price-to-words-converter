package ru.otus.domain;

public class PriceCode {
    private final int number;
    private final String currencyCode;

    public PriceCode(int number, String currencyCode) {
        this.number = number;
        this.currencyCode = currencyCode;
    }

    public int getNumber() {
        return number;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public int getPriceNumberLastDigit (int number) {
        if (number % 100 > 10 && number % 100 < 20) {
            return 5;
        } else {
            return number % 10;
        }
    }

    @Override
    public String toString() {
        return number + " " + currencyCode;
    }
}
