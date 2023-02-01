package ru.otus.domain;

public record PriceCode(int number, String currencyCode) {

    public int getPriceNumberLastDigit(int number) {
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
