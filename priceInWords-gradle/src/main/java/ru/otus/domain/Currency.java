package ru.otus.domain;

public enum Currency {
    RUB(new String[]{"рубль", "рубля", "рублей"}),
    USD(new String[]{"доллар", "доллара", "долларов"});

    private final String[] endings;

    Currency(String[] endings) {
        this.endings = endings;
    }

    public String[] getEnding() {
        return endings;
    }
}
