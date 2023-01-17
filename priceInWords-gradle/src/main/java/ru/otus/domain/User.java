package ru.otus.domain;

public record User(String fullName) {

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
