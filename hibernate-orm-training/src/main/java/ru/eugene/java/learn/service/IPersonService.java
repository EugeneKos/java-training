package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Person;

import java.util.Set;

public interface IPersonService {
    Set<Person> getAllWithAutomobiles();
}
