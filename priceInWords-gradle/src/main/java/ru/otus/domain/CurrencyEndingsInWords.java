package ru.otus.domain;

public enum CurrencyEndingsInWords {
    RUB(new String[]{"рубль", "рубля", "рублей"}),
    USD(new String[]{"доллар", "доллара", "долларов"});

    private final String[] endings;

    CurrencyEndingsInWords(String[] endings) {
        this.endings = endings;
    }

    public String getCurrencyEndingInWords(int lastDigit) {
        if(lastDigit == 1) {
            return endings[0];
        } else if(lastDigit >= 2 && lastDigit <= 4) {
            return endings[1];
        } else {
            return endings[2];
        }
    }
}
