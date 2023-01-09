package ru.otus.services;

import ru.otus.api.services.CommandHandler;
import ru.otus.api.services.IOService;
import ru.otus.api.services.UserService;
import ru.otus.domain.User;

import java.util.concurrent.atomic.AtomicBoolean;

public class ApplicationRunner {

    private final IOService ioService;
    private final UserService userService;
    private final CommandHandler commandHandler;

    public ApplicationRunner(IOService ioService,
                             UserService userService,
                             CommandHandler commandHandler) {
        this.ioService = ioService;
        this.userService = userService;
        this.commandHandler = commandHandler;
    }

    public void run() {
        AtomicBoolean executionFlag = new AtomicBoolean(true);

        User user = userService.askUserName();
        while (executionFlag.get()) {
            String commandOrPrice = showPromptAndReadCommand();

            if (!commandHandler.handleExitCommand(commandOrPrice, user.getFullName(),
                    executionFlag)) {
                if (!commandHandler.handleHistoryCommand(commandOrPrice)) {
                    commandHandler.handlePriceCommand(commandOrPrice);
                }
            }
        }
    }

    private String showPromptAndReadCommand() {
        ioService.outputStr("Введите число + код валюты/history/exit");
        return ioService.readString("Число и код валюты должны быть отделены пробелом (Например, 8 RUB или 5 USD)");
    }
}
