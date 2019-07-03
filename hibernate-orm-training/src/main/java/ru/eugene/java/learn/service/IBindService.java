package ru.eugene.java.learn.service;

public interface IBindService {
    void bindAutomobileToPerson(String stateNumberAuto, String personCode);
    void unbindAutomobileFromPerson(String stateNumberAuto);

    void bindAutomobileToCarService(String stateNumberAuto, String carServiceName);
    void unbindAutomobileFromCarService(String stateNumberAuto, String carServiceName);

    void bindPassportToPerson(String passportUIN, String personCode);
    void unbindPassportFromPerson(String passportUIN);
}
