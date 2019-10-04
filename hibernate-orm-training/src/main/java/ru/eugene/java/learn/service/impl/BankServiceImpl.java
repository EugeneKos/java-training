package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eugene.java.learn.data.Bank;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.BankRepository;
import ru.eugene.java.learn.service.IBankService;
import ru.eugene.java.learn.service.IPersonService;

import java.util.List;

@Service
public class BankServiceImpl implements IBankService {
    private BankRepository bankRepository;

    private IPersonService personService;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository, IPersonService personService) {
        this.bankRepository = bankRepository;
        this.personService = personService;
    }

    @Override
    @Transactional
    public Bank create(String name) {
        Bank existBank = bankRepository.findByName(name);
        if(existBank != null){
            throw new RuntimeException("bank with name: " + name + " already exist");
        }
        Bank bank = new Bank();
        bank.setName(name);
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    @Transactional
    public Bank getByName(String name) {
        return bankRepository.findByName(name);
    }

    @Override
    @Transactional
    public void addPersonToBank(String bankName, Person person) {
        Bank bank = bankRepository.findByName(bankName);
        if(bank == null){
            throw new RuntimeException("bank with name: " + bankName + " not found");
        }
        List<Person> bankPersons = bank.getPersons();
        bankPersons.add(person);
        bank.setPersons(bankPersons);
        bankRepository.saveAndFlush(bank);
    }

    @Override
    @Transactional
    public void removePersonFromBank(String bankName, String personCode) {
        Bank bank = bankRepository.findByName(bankName);
        if(bank == null){
            throw new RuntimeException("bank with name: " + bankName + " not found");
        }

        Person person = personService.getByCode(personCode);
        if(person == null){
            throw new RuntimeException("person with code: " + personCode + " not found");
        }

        List<Person> persons = bank.getPersons();
        if(persons.remove(person)){
            bank.setPersons(persons);
            bankRepository.saveAndFlush(bank);
        }
    }
}
