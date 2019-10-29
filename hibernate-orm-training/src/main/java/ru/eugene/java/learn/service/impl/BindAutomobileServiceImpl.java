package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.exception.NotFoundException;
import ru.eugene.java.learn.repository.AutomobileRepository;
import ru.eugene.java.learn.repository.PersonRepository;
import ru.eugene.java.learn.service.IBindAutomobileService;

@Service
public class BindAutomobileServiceImpl implements IBindAutomobileService {
    private PersonRepository personRepository;
    private AutomobileRepository automobileRepository;

    @Autowired
    public BindAutomobileServiceImpl(PersonRepository personRepository, AutomobileRepository automobileRepository) {
        this.personRepository = personRepository;
        this.automobileRepository = automobileRepository;
    }

    @Override
    public void bindAutomobile(Long personId, Long automobileId) {
        Person person = getPersonById(personId);
        Automobile automobile = getAutomobile(automobileId);
        automobile.setPerson(person);
        automobileRepository.saveAndFlush(automobile);
    }

    @Override
    public void unbindAutomobile(Long automobileId) {
        Automobile automobile = getAutomobile(automobileId);
        automobile.setPerson(null);
        automobileRepository.saveAndFlush(automobile);
    }

    private Person getPersonById(Long id){
        return personRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Person with id " + id + " not found")
        );
    }

    private Automobile getAutomobile(Long id){
        return automobileRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Automobile with id " + id + " not found")
        );
    }
}
