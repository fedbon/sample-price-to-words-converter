package ru.otus.api.services;

public interface IOService {

    void outputStr(String s);

    void outputStr(String template, Object ...args);

    String readString();

    String readString(String prompt);
}
