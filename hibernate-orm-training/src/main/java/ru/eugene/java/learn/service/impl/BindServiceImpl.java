package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eugene.java.learn.data.*;
import ru.eugene.java.learn.repository.AutomobileRepository;
import ru.eugene.java.learn.repository.CarServiceLinkAutoRepository;
import ru.eugene.java.learn.repository.CarServiceRepository;
import ru.eugene.java.learn.repository.PassportRepository;
import ru.eugene.java.learn.service.*;

import java.util.List;

@Service
public class BindServiceImpl implements IBindService {
    private IPersonService personService;
    private IAutomobileService automobileService;
    private ICarServiceService carServiceService;
    private IPassportService passportService;

    private AutomobileRepository automobileRepository;
    private CarServiceRepository carServiceRepository;
    private PassportRepository passportRepository;
    private CarServiceLinkAutoRepository carServiceLinkAutoRepository;

    @Autowired
    public BindServiceImpl(IPersonService personService,
                           IAutomobileService automobileService,
                           ICarServiceService carServiceService,
                           IPassportService passportService) {

        this.personService = personService;
        this.automobileService = automobileService;
        this.carServiceService = carServiceService;
        this.passportService = passportService;
    }

    @Autowired
    public void setAutomobileRepository(AutomobileRepository automobileRepository) {
        this.automobileRepository = automobileRepository;
    }

    @Autowired
    public void setCarServiceRepository(CarServiceRepository carServiceRepository) {
        this.carServiceRepository = carServiceRepository;
    }

    @Autowired
    public void setPassportRepository(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Autowired
    public void setCarServiceLinkAutoRepository(CarServiceLinkAutoRepository carServiceLinkAutoRepository) {
        this.carServiceLinkAutoRepository = carServiceLinkAutoRepository;
    }

    @Transactional
    @Override
    public void bindAutomobileToPerson(String stateNumberAuto, String personCode) {
        Person person = personService.getByCode(personCode);
        Automobile automobile = automobileService.getByStateNumber(stateNumberAuto);
        automobile.setPerson(person);
        automobileRepository.save(automobile);
    }

    @Transactional
    @Override
    public void unbindAutomobileFromPerson(String stateNumberAuto) {
        Automobile automobile = automobileService.getByStateNumber(stateNumberAuto);
        automobile.setPerson(null);
        automobileRepository.save(automobile);
    }

    @Transactional
    @Override
    public void bindAutomobileToCarService(String stateNumberAuto, String carServiceName) {
        Automobile automobile = automobileService.getByStateNumber(stateNumberAuto);
        CarService carService = carServiceService.getByName(carServiceName);
        CarServiceLinkAuto carServiceLinkAuto = new CarServiceLinkAuto();
        carServiceLinkAuto.setAutomobile(automobile);
        carServiceLinkAuto.setCarService(carService);
        carServiceLinkAutoRepository.save(carServiceLinkAuto);
    }

    @Transactional
    @Override
    public void unbindAutomobileFromCarService(String stateNumberAuto, String carServiceName) {
        Automobile automobile = automobileService.getByStateNumber(stateNumberAuto);
        CarService carService = carServiceService.getByName(carServiceName);
        carServiceLinkAutoRepository.deleteByAutomobileAndCarService(automobile, carService);
    }

    @Override
    public void bindPassportToPerson(String passportUIN, String personCode) {
        Person person = personService.getByCode(personCode);
        Passport passport = passportService.getByUIN(passportUIN);
        passport.setPerson(person);
        passportRepository.save(passport);
    }

    @Override
    public void unbindPassportFromPerson(String passportUIN) {
        Passport passport = passportService.getByUIN(passportUIN);
        passport.setPerson(null);
        passportRepository.save(passport);
    }
}
