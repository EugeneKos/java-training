package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.converter.AutomobileConverter;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.dto.AutomobileDTO;
import ru.eugene.java.learn.exception.NotFoundException;
import ru.eugene.java.learn.exception.NotUniqueException;
import ru.eugene.java.learn.repository.AutomobileRepository;
import ru.eugene.java.learn.service.IAutomobileService;

@Service
public class AutomobileServiceImpl implements IAutomobileService {
    private AutomobileRepository automobileRepository;
    private AutomobileConverter automobileConverter;

    @Autowired
    public AutomobileServiceImpl(AutomobileRepository automobileRepository, AutomobileConverter automobileConverter) {
        this.automobileRepository = automobileRepository;
        this.automobileConverter = automobileConverter;
    }

    @Override
    public AutomobileDTO create(AutomobileDTO automobileDTO) {
        return update(automobileDTO);
    }

    @Override
    public AutomobileDTO update(AutomobileDTO automobileDTO) {
        if(automobileDTO == null){
            return null;
        }

        Automobile automobile = automobileConverter.convertToAutomobile(automobileDTO);

        assertExistById(automobile);
        assertUniqueByStateNumber(automobile);

        automobile = automobileRepository.saveAndFlush(automobile);
        return automobileConverter.convertToAutomobileDTO(automobile);
    }

    private void assertExistById(Automobile automobile){
        if(automobile.getId() == null){
            return;
        }
        automobileRepository.findById(automobile.getId()).orElseThrow(
                () -> new NotFoundException("Automobile with id " + automobile.getId() + " not found")
        );
    }

    private void assertUniqueByStateNumber(Automobile automobile){
        if(automobile.getStateNumber() == null){
            return;
        }

        Automobile foundedByStateNumber = automobileRepository.findByStateNumber(automobile.getStateNumber());

        if(foundedByStateNumber != null && !foundedByStateNumber.getId().equals(automobile.getId())){
            throw new NotUniqueException("Automobile with state number "
                    + automobile.getStateNumber() + " already exist");
        }
    }

    @Override
    @Transactional
    public AutomobileDTO getByStateNumber(String stateNumber) {
        Automobile foundedByStateNumber = automobileRepository.findByStateNumber(stateNumber);
        return automobileConverter.convertToAutomobileDTO(foundedByStateNumber);
    }
}
