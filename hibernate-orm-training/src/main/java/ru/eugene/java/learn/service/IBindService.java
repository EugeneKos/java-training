package ru.eugene.java.learn.service;

public interface IBindService {
    void bindAutomobileToPerson(Long idAutomobile, Long idPerson);
    void unbindAutomobileFromPerson(Long idAutomobile);

    void bindAutomobileToCarService(Long idAutomobile, Long idCarService);
    void unbindAutomobileFromCarService(Long idAutomobile, Long idCarService);

    void bindPassportToPerson(Long passportId, Long personId);
    void unbindPassportFromPerson(Long idPassport);
}
