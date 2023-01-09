package ru.otus;

import ru.otus.api.services.*;
import ru.otus.services.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Enter amount and currency code: ");
//        Scanner scanner = new Scanner(System.in);
//        String userInput = scanner.nextLine();
//        String[] parameters = userInput.split(" ");
//        Integer amount = Integer.valueOf(parameters[0]);
//        String currencyCode = parameters[1];
//        Currency instance = Currency.valueOf(currencyCode);
//        String endingMessage = instance.getEndingMessage(amount);

    IOService ioService = new ConsoleIOService();

    UserService userService = new UserServiceImpl(ioService);

    PriceRequestsHistoryHolder historyHolder = new PriceRequestsHistoryHolderImpl();

    PriceNumberParser priceNumberParser = new PriceNumberParserImpl();
    CurrencyConnector currencyConnector = new CurrencyConnectorImpl();

    CommandHandler commandHandler = new CommandHandlerImpl(ioService, historyHolder, priceNumberParser, currencyConnector);

    ApplicationRunner applicationRunner = new ApplicationRunner(ioService, userService, commandHandler);
    applicationRunner.run();
    }
}
