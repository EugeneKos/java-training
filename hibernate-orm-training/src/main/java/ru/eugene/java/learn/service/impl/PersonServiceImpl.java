package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.PersonRepository;
import ru.eugene.java.learn.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    @Override
    public Person create(String name, String surname) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        return personRepository.save(person);
    }
}
