package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Person;

import java.util.Set;

public interface IPersonService {
    Person getByCode(String code);

    Set<Person> getAllWithAutomobiles();
}
