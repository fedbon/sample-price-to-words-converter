package ru.otus.api.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InOrder;
import ru.otus.domain.PriceCode;
import ru.otus.domain.PriceInWordsConversionResult;
import ru.otus.services.PriceInWordsConverterImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("PriceInWordsConverterImpl должен ")
class PriceInWordsConverterImplTest {

    private InOrder inOrder;
    private PriceCode priceCode;
    private PriceInWordsConversionResult priceInWordsConversionResult;

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(" ", " "),
                Arguments.of(" ", " ")
        );
    }

    @BeforeEach
    public void setUp() {
        priceCode = mock(PriceCode.class);
        priceInWordsConversionResult = new PriceInWordsConversionResult(priceCode);
        inOrder = inOrder(priceCode);
    }

    @DisplayName(" ")
    @ParameterizedTest
    @MethodSource("generateData")
    void parsePriceCode(String priceCodeString, String expected) {
        assertEquals(priceCodeString, expected);
    }
}
