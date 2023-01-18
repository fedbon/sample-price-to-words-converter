package ru.otus;

import ru.otus.api.services.*;
import ru.otus.services.*;

public class App {
    public static void main(String[] args) {

    IOService ioService = new ConsoleIOService();

    UserService userService = new UserServiceImpl(ioService);

    PriceInWordsRequestsHistoryHolder historyHolder = new PriceInWordsRequestsHistoryHolderImpl();
    ValidatorService validatorService = new ValidatorServiceImpl(ioService);
    PriceCodeParser priceCodeParser = new PriceCodeParserImpl();
    PriceInWordsConverter priceInWordsConverter = new PriceInWordsConverterImpl();

    CommandHandler commandHandler = new CommandHandlerImpl(ioService, historyHolder,
            priceCodeParser, priceInWordsConverter, validatorService);

    Controller controller = new Controller(ioService, userService, commandHandler);
    controller.run();
    }
}
