package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.repository.AutomobileRepository;
import ru.eugene.java.learn.service.IAutomobileService;

@Service
public class AutomobileService implements IAutomobileService {
    private AutomobileRepository automobileRepository;

    @Autowired
    public AutomobileService(AutomobileRepository automobileRepository) {
        this.automobileRepository = automobileRepository;
    }

    @Override
    public Automobile create(String mark, String model, String stateNumber) {
        Automobile automobile = new Automobile();
        automobile.setMark(mark);
        automobile.setModel(model);
        automobile.setStateNumber(stateNumber);
        return automobileRepository.save(automobile);
    }
}
