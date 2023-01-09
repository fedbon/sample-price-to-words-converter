package ru.otus.services;

import ru.otus.api.services.PriceNumberParser;
import ru.otus.domain.PriceNumber;

public class PriceNumberParserImpl implements PriceNumberParser {

    @Override
    public PriceNumber parsePriceNumber(String priceString) {
        String[] arr = priceString.split(" ");
        try {
            if (arr.length != 1) {
                throw new IllegalArgumentException();
            }
            long amount = Integer.parseInt(arr[0]);

            return new PriceNumber(amount);
        } catch (IllegalArgumentException ignored) {
        }
        return null;
    }
}
