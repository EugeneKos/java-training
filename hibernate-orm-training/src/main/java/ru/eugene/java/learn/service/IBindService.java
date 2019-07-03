package ru.eugene.java.learn.service;

public interface IBindService {
    void bindAutomobileToPerson(String stateNumberAuto, String personCode);
    void unbindAutomobileFromPerson(String stateNumberAuto);

    void bindAutomobileToCarService(Long idAutomobile, Long idCarService);
    void unbindAutomobileFromCarService(Long idAutomobile, Long idCarService);

    void bindPassportToPerson(String passportUIN, String personCode);
    void unbindPassportFromPerson(String passportUIN);
}
