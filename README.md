# Price To Words Converter

## Description
The Price To Words Converter app is a command-line tool designed to convert numerical prices into their equivalent written form in Russian. It supports conversion for two currencies: Russian Rubles (RUB) and United States Dollars (USD).

## Features
- Converts numerical prices into their equivalent written form in Russian, using appropriate currency endings.
- Accepts input in the format of `<number> <currency code>` (e.g., `118 RUB`, `54 USD`).
- Supports two currencies: RUB and USD.
- Handles validation of input to ensure correctness.
- Provides a history feature to view previously converted prices.
- Allows users to exit the application gracefully.

## Components

### 1. `CurrencyEndingsInWords`
- Enum defining the different currency endings in words for RUB and USD.

### 2. `PriceCode`
- Record representing a price code consisting of a numerical value and a currency code.

### 3. `PriceInWordsConversionResult`
- Class representing the result of converting a price into words, including both the numerical part and the currency in words.

### 4. `RussianNumbersInWords`
- Utility class for converting numerical values into their written form in Russian.

### 5. `User`
- Record representing a user.

### 6. `CommandHandler`
- Implementation for handling user commands.

### 7. `ConsoleIOService`
- Implementation for handling input/output operations through the console.

### 8. `Controller`
- Main controller class orchestrating the application flow.

### 9. `Validators`
- Various validator classes to validate input data, including `MaxValueValidator`, `NegativeValueValidator`, `CurrencyCodeValidator`, and `StringToNumberValidator`.

### 10. `PriceCodeParserImpl`
- Implementation for parsing and validating price codes.

### 11. `PriceInWordsConverterImpl`
- Implementation for converting price codes into words.

### 12. `PriceInWordsRequestsHistoryHolderImpl`
- Implementation for storing and retrieving conversion history.

## Usage
1. Run the application.
2. Enter a numerical price followed by a space and the currency code (e.g., `118 RUB`, `54 USD`).
3. View the converted price in words.
4. Optionally, view the conversion history by entering the `history` command.
5. To exit the application, enter the `exit` command.

## How to Run
1. Compile all Java files.
2. Run the `Controller` class.

## Contributors
- Fedor Bondarev
