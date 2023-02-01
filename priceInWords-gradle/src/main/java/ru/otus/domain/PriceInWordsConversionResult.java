package ru.otus.domain;

public class PriceInWordsConversionResult {
    private final String numberInWords;
    private final String currencyInWords;

    public PriceInWordsConversionResult(String numberInWords,
                                        String currencyInWords) {
        this.numberInWords = numberInWords;
        this.currencyInWords = currencyInWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceInWordsConversionResult that = (PriceInWordsConversionResult) o;
        return numberInWords.equals(that.numberInWords) &&
                currencyInWords.equals(that.currencyInWords);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numberInWords == null) ? 0 : numberInWords.hashCode());
        result = prime * result + ((currencyInWords == null) ? 0 : currencyInWords.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return numberInWords + " " + currencyInWords;
    }
}
