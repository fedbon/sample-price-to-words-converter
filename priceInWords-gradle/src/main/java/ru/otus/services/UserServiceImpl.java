package ru.otus.services;


import ru.otus.api.services.IOService;
import ru.otus.api.services.UserService;
import ru.otus.domain.User;

public class UserServiceImpl implements UserService {
    private final IOService ioService;

    public UserServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public User askUserName() {
        return new User(ioService.readString("Введите имя"));
    }

}
