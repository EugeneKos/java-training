package ru.eugene.java.learn.service;

public interface IBindAutomobileService {
    void bindAutomobile(Long personId, Long automobileId);
    void unbindAutomobile(Long automobileId);
}
