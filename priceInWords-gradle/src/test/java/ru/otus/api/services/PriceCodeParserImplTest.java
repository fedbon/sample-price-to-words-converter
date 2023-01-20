package ru.otus.api.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.domain.PriceCode;
import ru.otus.services.CurrencyCodeValidator;
import ru.otus.services.MaxValueValidator;
import ru.otus.services.NegativeValueValidator;
import ru.otus.services.PriceCodeParserImpl;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Сервис PriceCodeParserImpl должен: ")
class PriceCodeParserImplTest {
    private PriceCodeParser priceCodeParser;

    private static Stream<Arguments> priceCodeStringAndPriceCodeProvider() {
        return Stream.of(
                Arguments.of("12 RUB", new PriceCode(12, "RUB")),
                Arguments.of("0 USD", new PriceCode(0, "USD")),
                Arguments.of("100 RUB", new PriceCode(100, "RUB")),
                Arguments.of("999 USD", new PriceCode(999, "USD")));
    }

    @BeforeEach
    public void setUp() {
        priceCodeParser = new PriceCodeParserImpl();
    }

    @DisplayName("проверить корректность работы метода parsePriceCode")
    @ParameterizedTest
    @MethodSource("priceCodeStringAndPriceCodeProvider")
    void shouldParsePriceCodeCorrectly(String priceCodeString, PriceCode priceCodeExpected) {
        PriceCode priceCodeParsed = priceCodeParser.parsePriceCode(priceCodeString,
                Arrays.asList(new MaxValueValidator(), new NegativeValueValidator(), new CurrencyCodeValidator()));
        assertEquals(priceCodeParsed, priceCodeExpected);
    }
}
