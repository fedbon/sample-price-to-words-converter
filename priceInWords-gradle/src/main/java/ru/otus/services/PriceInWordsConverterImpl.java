package ru.otus.services;


import ru.otus.api.services.PriceInWordsConverter;
import ru.otus.domain.CurrencyEndingsInWords;
import ru.otus.domain.PriceInWordsConversionResult;
import ru.otus.domain.PriceCode;
import static ru.otus.domain.RussianNumbersInWords.getNumbersInWords;

public class PriceInWordsConverterImpl implements PriceInWordsConverter {

    @Override
    public PriceInWordsConversionResult convertPriceCode(PriceCode priceCode) {
        int number = priceCode.getNumber();
        int lastDigit = priceCode.getPriceNumberLastDigit(number);
        String currencyCode = priceCode.getCurrencyCode();
        String numberInWords = getNumbersInWords(number);
        CurrencyEndingsInWords instance = CurrencyEndingsInWords.valueOf(currencyCode);
        String currencyEnding = instance.getCurrencyEndingInWords(lastDigit);
        return new PriceInWordsConversionResult(numberInWords, currencyEnding);
    }
}
