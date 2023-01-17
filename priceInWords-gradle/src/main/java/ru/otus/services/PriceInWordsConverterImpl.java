package ru.otus.services;


import ru.otus.api.services.PriceInWordsConverter;
import ru.otus.domain.CurrencyEndingsInWords;
import ru.otus.domain.PriceInWordsConversionResult;
import ru.otus.domain.PriceCode;
import static ru.otus.domain.RussianNumbersInWords.getNumberInWords;

public class PriceInWordsConverterImpl implements PriceInWordsConverter {

    @Override
    public PriceInWordsConversionResult convertPriceCode(PriceCode priceCode) {
        int number = priceCode.number();
        int lastDigit = priceCode.getPriceNumberLastDigit(number);
        String currencyCode = priceCode.currencyCode();
        String numberInWords = getNumberInWords(number);
        CurrencyEndingsInWords instance = CurrencyEndingsInWords.valueOf(currencyCode);
        String currencyEnding = instance.getCurrencyEndingInWords(lastDigit);
        return new PriceInWordsConversionResult(numberInWords, currencyEnding);
    }
}
