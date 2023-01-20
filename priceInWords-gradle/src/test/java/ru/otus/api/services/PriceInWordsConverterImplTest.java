package ru.otus.api.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.domain.PriceCode;
import ru.otus.domain.PriceInWordsConversionResult;
import ru.otus.services.PriceInWordsConverterImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Сервис PriceInWordsConverterImpl должен: ")
class PriceInWordsConverterImplTest {
    private PriceInWordsConverter priceInWordsConverter;

    private static Stream<Arguments> priceCodeAndPriceInWordsConversionResultProvider() {
        return Stream.of(
                Arguments.of(new PriceCode(12, "RUB"),
                        new PriceInWordsConversionResult("двенадцать", "рублей")),
                Arguments.of(new PriceCode(0, "RUB"),
                        new PriceInWordsConversionResult("ноль", "рублей")),
                Arguments.of(new PriceCode(1, "RUB"),
                        new PriceInWordsConversionResult("один", "рубль")),
                Arguments.of(new PriceCode(2, "RUB"),
                        new PriceInWordsConversionResult("два", "рубля")),
                Arguments.of(new PriceCode(20, "RUB"),
                        new PriceInWordsConversionResult("двадцать", "рублей")),
                Arguments.of(new PriceCode(99, "USD"),
                        new PriceInWordsConversionResult("девяносто девять", "долларов")),
                Arguments.of(new PriceCode(100, "USD"),
                        new PriceInWordsConversionResult("сто", "долларов")),
                Arguments.of(new PriceCode(111, "USD"),
                        new PriceInWordsConversionResult("сто одиннадцать", "долларов")),
                Arguments.of(new PriceCode(200, "USD"),
                        new PriceInWordsConversionResult("двести", "долларов")),
                Arguments.of(new PriceCode(250, "USD"),
                        new PriceInWordsConversionResult("двести пятьдесят", "долларов")),
                Arguments.of(new PriceCode(301, "RUB"),
                        new PriceInWordsConversionResult("триста один", "рубль")),
                Arguments.of(new PriceCode(999, "RUB"),
                        new PriceInWordsConversionResult("девятьсот девяносто девять", "рублей"))
        );
    }

    @BeforeEach
    public void setUp() {
        priceInWordsConverter = new PriceInWordsConverterImpl();
    }

    @DisplayName("проверить корректность работы метода convertPriceCode")
    @ParameterizedTest
    @MethodSource("priceCodeAndPriceInWordsConversionResultProvider")
    void shouldConvertPriceCodeCorrectly(PriceCode priceCodeParsed,
                                         PriceInWordsConversionResult priceInWordsConversionResultExpected) {
        PriceInWordsConversionResult convertedPriceCode = priceInWordsConverter.convertPriceCode(priceCodeParsed);
        assertEquals(convertedPriceCode, priceInWordsConversionResultExpected);
    }
}
