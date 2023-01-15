package ru.otus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceCodeParserImplTest {
    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("5 RUB", "рублей"),
                Arguments.of(21, "рубль"),
                Arguments.of(1, "рубль"),
                Arguments.of(2, "рубля")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void parsePriceCode(String priceCodeString, String expected) {
        assertEquals(priceCodeString, expected);
    }
}
