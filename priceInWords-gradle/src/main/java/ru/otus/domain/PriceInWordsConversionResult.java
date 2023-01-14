package ru.otus.domain;

public class PriceInWordsConversionResult {
    private final String numberInWords;
    private final String currencyInWords;

    public PriceInWordsConversionResult(String numberInWords, String currencyInWords) {
        this.numberInWords = numberInWords;
        this.currencyInWords = currencyInWords;
    }

    @Override
    public String toString() {
        return numberInWords + " " + currencyInWords;
    }
}
