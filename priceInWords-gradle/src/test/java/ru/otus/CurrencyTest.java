package ru.otus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.domain.Currency;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyTest {
    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(5, "рублей"),
                Arguments.of(21, "рубль"),
                Arguments.of(1, "рубль"),
                Arguments.of(2, "рубля")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void testCurrencyEndingsRUB(int input, String expected) {
        assertEquals(expected, Currency.RUB.getEnding());
    }
}
