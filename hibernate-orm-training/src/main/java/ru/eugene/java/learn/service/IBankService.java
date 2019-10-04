package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Bank;
import ru.eugene.java.learn.data.Person;

public interface IBankService {
    Bank create(String name);

    Bank getByName(String name);

    void addPersonToBank(String bankName, Person person);
    void removePersonFromBank(String bankName, String personCode);
}
