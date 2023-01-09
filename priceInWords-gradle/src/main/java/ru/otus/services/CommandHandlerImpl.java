package ru.otus.services;

import ru.otus.api.services.*;
import ru.otus.domain.CurrencyConnectionResult;
import ru.otus.domain.PriceNumber;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class CommandHandlerImpl implements CommandHandler {

    private static final String EXIT_COMMAND = "exit";
    private static final String HISTORY_COMMAND = "history";
    private final IOService ioService;
    private final PriceRequestsHistoryHolder historyHolder;
    private final PriceNumberParser priceNumberParser;
    private final CurrencyConnector currencyConnector;

    public CommandHandlerImpl(IOService ioService,
                              PriceRequestsHistoryHolder historyHolder,
                              PriceNumberParser priceNumberParser,
                              CurrencyConnector currencyConnector) {
        this.ioService = ioService;
        this.historyHolder = historyHolder;
        this.priceNumberParser = priceNumberParser;
        this.currencyConnector = currencyConnector;
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

    public boolean handleHistoryCommand(String command) {
        if (!command.equalsIgnoreCase(HISTORY_COMMAND)) {
            return false;
        }
        ioService.outputStr("История запросов:");
        ioService.outputStr(historyHolder.getHistoryList().stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n")));
        ioService.outputStr("");
        return true;
    }

    public void handlePriceCommand(String priceStr) {
        PriceNumber priceNumber = priceNumberParser.parsePriceNumber(priceStr);
        if (priceNumber == null) {
            ioService.outputStr("Неверно введено денежное значение!");
            return;
        }

        CurrencyConnectionResult connectedCurrency = currencyConnector.connectCurrency(priceNumber);
        ioService.outputStr("Вывод цены с валютой прописью: %s%n", connectedCurrency);
        historyHolder.addPriceInWordsPrinterResult(connectedCurrency);
    }
}
