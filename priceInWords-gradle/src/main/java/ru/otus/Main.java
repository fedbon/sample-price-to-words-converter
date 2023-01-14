package ru.otus;

import ru.otus.api.services.*;
import ru.otus.services.*;

public class Main {
    public static void main(String[] args) {

    IOService ioService = new ConsoleIOService();

    UserService userService = new UserServiceImpl(ioService);

    PriceInWordsRequestsHistoryHolder historyHolder = new PriceInWordsRequestsHistoryHolderImpl();

    PriceCodeParser priceCodeParser = new PriceCodeParserImpl();
    PriceInWordsConverter priceInWordsConverter = new PriceInWordsConverterImpl();

    CommandHandler commandHandler = new CommandHandlerImpl(ioService, historyHolder, priceCodeParser, priceInWordsConverter);

    ApplicationRunner applicationRunner = new ApplicationRunner(ioService, userService, commandHandler);
    applicationRunner.run();
    }
}
