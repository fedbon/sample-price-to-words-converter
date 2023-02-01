package ru.otus.services;


import ru.otus.api.services.IOService;

import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.err;

public class ConsoleIOService implements IOService {

    private final PrintStream out;
    private final Scanner in;

    public ConsoleIOService() {
        out = System.out;
        in = new Scanner(System.in);
    }

    @Override
    public void outputStr(String s) {
        out.println(s);
    }

    @Override
    public void outputStr(String template, Object ...args) {
        out.printf(template + "%n", args);
    }

    @Override
    public void outputException(String s) {
        err.println(s);
    }

    @Override
    public String readString() {
        return in.nextLine();
    }

    @Override
    public String readString(String prompt) {
        outputStr(prompt);
        return readString();
    }
}
