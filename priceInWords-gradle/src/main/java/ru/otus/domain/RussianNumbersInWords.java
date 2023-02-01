package ru.otus.domain;

public class RussianNumbersInWords {
    private static final String[] BELOW_TWENTY = {"ноль", "один", "два", "три",
            "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",
            "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] TENS = {"", "десять", "двадцать", "тридцать",
            "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят",
            "девяносто"};
    private static final String[] HUNDREDS = {"", "сто", "двести", "триста",
            "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    private RussianNumbersInWords() {
    }

    public static String getNumberInWords(int number) {
        String word;
        if (number % 100 == 0 && number >= 100 && number < 1000) {
            number /= 100;
            return HUNDREDS[number];
        } else if (number % 100 < 20) {
            word = BELOW_TWENTY[number % 100];
            number /= 100;
        } else if (number % 10 == 0 && number > 100 && number < 1000) {
            number /= 10;
            word = TENS[number % 10];
            number /= 10;
            return HUNDREDS[number] + " " + word;
        } else if (number % 10 == 0 && number > 0 && number < 100 ) {
            number /= 10;
            return TENS[number];
        } else {
            word = BELOW_TWENTY[number % 10];
            number /= 10;

            word = TENS[number % 10] + " " + word;
            number /= 10;
        }
        if (number == 0) return word;
        return HUNDREDS[number] + " " + word;
    }
}
