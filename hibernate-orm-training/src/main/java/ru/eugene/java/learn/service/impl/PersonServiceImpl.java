package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.PersonRepository;
import ru.eugene.java.learn.service.IPersonService;

import java.util.Set;

@Service
public class PersonServiceImpl implements IPersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @Transactional
    public Person getByCode(String code) {
        return personRepository.findByCode(code);
    }

    @Override
    @Transactional
    public Set<Person> getAllWithAutomobiles() {
        return personRepository.findAllWithAutomobiles();
    }
}
