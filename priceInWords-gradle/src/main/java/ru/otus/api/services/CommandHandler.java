package ru.otus.api.services;

import java.util.concurrent.atomic.AtomicBoolean;

public interface CommandHandler {

    boolean handleExitCommand(String command, String userName,
                              AtomicBoolean executionFlag);

    boolean handleRequestsHistoryCommand(String command);

    void handlePriceCodeCommand(String priceCodeStr);
}
