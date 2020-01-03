package ru.eugene.java.learn.service.impl;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.exception.PersonAlreadyExistException;
import ru.eugene.java.learn.service.PersonService;

import java.util.HashMap;
import java.util.Map;

public class PersonServiceImpl implements PersonService {
    private Map<String, Person> persons = new HashMap<>();

    @Override
    public Person create(String firstName, String lastName, String login, String password) throws PersonAlreadyExistException {
        Person person = getByLogin(login);
        if(person != null){
            throw new PersonAlreadyExistException("person with login: " + login + " already exist");
        }
        person = new Person(firstName, lastName, login, password);
        persons.put(login, person);
        return person;
    }

    @Override
    public Person getByLogin(String login) {
        return persons.get(login);
    }
}
