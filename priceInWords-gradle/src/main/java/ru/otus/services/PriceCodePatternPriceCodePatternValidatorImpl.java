package ru.otus.services;

import ru.otus.api.services.PriceCodePatternValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceCodePatternPriceCodePatternValidatorImpl implements PriceCodePatternValidator {
    private static final String CODE_EXPRESSION_PATTERN = "^[\\d-]+\\S[RUBSD]+$";
    private static final Pattern codeExpressionPattern = Pattern.compile(CODE_EXPRESSION_PATTERN);

    @Override
    public boolean isValidCodeExpressionPattern(String priceCodeString) {
        Matcher matcher = codeExpressionPattern.matcher(priceCodeString);
        if(matcher.matches()){
            return true;
        } else {
            throw new IllegalArgumentException("Некорректный формат ввода числа и/или кода валюты!");
        }
    }
}
