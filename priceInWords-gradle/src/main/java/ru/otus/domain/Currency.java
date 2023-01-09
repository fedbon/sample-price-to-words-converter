package ru.otus.domain;

public enum Currency {
    RUB(new String[]{"рубль", "рубля", "рублей"}),
    USD(new String[]{"доллар", "доллара", "долларов"});

    private final String[] endings;

    Currency(String[] endings) {
        this.endings = endings;
    }

    public String getEnding(int amount) {
        if(amount == 1) {
            return endings[0];
        } else if(amount <=4 && amount >= 2) {
            return endings[1];
        } else {
            return endings[2];
        }
    }
}
