package ru.otus.services;

import ru.otus.api.services.*;
import ru.otus.domain.PriceInWordsConversionResult;
import ru.otus.domain.PriceCode;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class CommandHandlerImpl implements CommandHandler {

    private static final String EXIT_COMMAND = "exit";
    private static final String HISTORY_COMMAND = "history";
    private final IOService ioService;
    private final PriceInWordsRequestsHistoryHolder requestsHistoryHolder;
    private final PriceCodeParser priceCodeParser;
    private final PriceInWordsConverter priceInWordsConverter;

    public CommandHandlerImpl(IOService ioService,
                              PriceInWordsRequestsHistoryHolder requestsHistoryHolder,
                              PriceCodeParser priceCodeParser,
                              PriceInWordsConverter priceInWordsConverter) {
        this.ioService = ioService;
        this.requestsHistoryHolder = requestsHistoryHolder;
        this.priceCodeParser = priceCodeParser;
        this.priceInWordsConverter = priceInWordsConverter;
    }

    public boolean handleExitCommand(String command, String userName,
                                     AtomicBoolean executionFlag) {
        if (!command.equalsIgnoreCase(EXIT_COMMAND)) {
            return false;
        }
        executionFlag.getAndSet(false);
        ioService.outputStr("До свидания, %s", userName);
        return true;
    }

    public boolean handleRequestsHistoryCommand(String command) {
        if (!command.equalsIgnoreCase(HISTORY_COMMAND)) {
            return false;
        }
        ioService.outputStr("История запросов:");
        ioService.outputStr(requestsHistoryHolder.getRequestsList().stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n")));
        ioService.outputStr("");
        return true;
    }

    public void handlePriceCodeCommand(String priceCodeStr) {
        PriceCode priceCode;
        try {
            priceCode = priceCodeParser.parsePriceCode(priceCodeStr);
        } catch (IllegalArgumentException e) {
            ioService.outputException("Неверно введено число и/или код валюты!");
            return;
        }

        PriceInWordsConversionResult connectedCurrencyEnding = priceInWordsConverter.convertPriceCode(priceCode);
        ioService.outputStr("Вывод цены с валютой прописью: %s%n", connectedCurrencyEnding);
        requestsHistoryHolder.addPriceInWordsConversionResult(connectedCurrencyEnding);
    }
}
