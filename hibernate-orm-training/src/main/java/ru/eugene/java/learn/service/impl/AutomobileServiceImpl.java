package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.repository.AutomobileRepository;
import ru.eugene.java.learn.service.IAutomobileService;

@Service
public class AutomobileServiceImpl implements IAutomobileService {
    private AutomobileRepository automobileRepository;

    @Autowired
    public AutomobileServiceImpl(AutomobileRepository automobileRepository) {
        this.automobileRepository = automobileRepository;
    }

    @Override
    @Transactional
    public Automobile getByStateNumber(String stateNumber) {
        return automobileRepository.findByStateNumber(stateNumber);
    }
}
