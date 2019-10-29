package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.dto.AutomobileDTO;

public interface IAutomobileService {
    AutomobileDTO create(AutomobileDTO automobileDTO);
    AutomobileDTO update(AutomobileDTO automobileDTO);
    AutomobileDTO getByStateNumber(String stateNumber);
}
