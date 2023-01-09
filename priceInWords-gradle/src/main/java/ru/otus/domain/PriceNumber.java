package ru.otus.domain;

public class PriceNumber {
    private final long amount;

    public PriceNumber(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return amount + " ";
    }
}
