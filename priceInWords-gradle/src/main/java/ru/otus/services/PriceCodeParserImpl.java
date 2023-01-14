package ru.otus.services;

import ru.otus.api.services.PriceCodeParser;
import ru.otus.domain.PriceCode;

public class PriceCodeParserImpl implements PriceCodeParser {

    @Override
    public PriceCode parsePriceCode(String priceCodeString) {
        String[] arr = priceCodeString.split(" ");
        try {
            if (arr.length != 2) {
                throw new IllegalArgumentException();
            }
            int amount = Integer.parseInt(arr[0]);

            if (amount < 0 || amount > 999) {
                throw new IllegalArgumentException();
            }

            String currencyCode = String.valueOf(arr[1]);

            if (!currencyCode.equals("RUB") && !currencyCode.equals("USD")) {
                throw new IllegalArgumentException();
            }
            return new PriceCode(amount, currencyCode);
        } catch (IllegalArgumentException ignored) {
        }
        return null;
    }
}
