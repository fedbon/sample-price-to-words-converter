package ru.otus.domain;

public class RussianNumbersInWords {
    private static final String[] BELOW_TWENTY = {"ноль", "один", "два", "три", "четыре", "пять",
            "шесть", "семь", "восемь", "девять", "десять", "одиннадцать",
            "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
            "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] TENS = {"сто", "десять", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] HUNDREDS = {"тысяча", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static String word;

    public RussianNumbersInWords(String word) {
        RussianNumbersInWords.word = word;
    }

    public static String getNumbersInWords(int number) {
        if (number % 100 < 20 && number != 100) {
            word = BELOW_TWENTY[number % 100];
            number /= 100;
        } else {
            if (number == 100) {
                return (TENS[0]);
            }
            word = BELOW_TWENTY[number % 10];
            number /= 10;

            word = TENS[number % 10] + " " + word;
            number /= 10;
        }
        if (number == 0) return word;
        return HUNDREDS[number] + " " + word;
    }
}
