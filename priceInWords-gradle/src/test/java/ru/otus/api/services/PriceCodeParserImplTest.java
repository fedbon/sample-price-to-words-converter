package ru.otus.api.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.domain.PriceCode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("PriceCodeParserImpl должен ")
class PriceCodeParserImplTest {

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("12 + RUB",
                        new PriceCode(12, "рублей")),
                Arguments.of(" ", " ")
        );
    }

    @BeforeEach
    public void setUp() {

    }

    @DisplayName(" ")
    @ParameterizedTest
    @MethodSource("generateData")
    void parsePriceCode(String priceCodeString, String expected) {
        assertEquals(priceCodeString, expected);
    }
}
