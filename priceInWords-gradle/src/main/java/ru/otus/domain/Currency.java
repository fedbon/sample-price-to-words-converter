package ru.otus.domain;

public enum Currency {
    RUB(new String[]{"рубль", "рубля", "рублей"}),
    USD(new String[]{"доллар", "доллара", "долларов"});

    private final String[] endings;

    Currency(String[] endings) {
        this.endings = endings;
    }

    public String getEnding(long lastNumber) {
        if(lastNumber == 1) {
            return endings[0];
        } else if(lastNumber >= 2 && lastNumber <= 4) {
            return endings[1];
        } else {
            return endings[2];
        }
    }
}
