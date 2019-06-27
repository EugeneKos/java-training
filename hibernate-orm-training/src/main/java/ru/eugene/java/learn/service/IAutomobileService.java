package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.Automobile;

public interface IAutomobileService {
    Automobile create(String mark, String model, String stateNumber);
}
