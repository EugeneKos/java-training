package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.CarService;
import ru.eugene.java.learn.data.Passport;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.AutomobileRepository;
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

    @Transactional
    @Override
    public void bindAutomobileToPerson(Long idAutomobile, Long idPerson) {
        Person person = personService.getById(idPerson);
        Automobile automobile = automobileService.getById(idAutomobile);
        automobile.setPerson(person);
        automobileRepository.save(automobile);
    }

    @Transactional
    @Override
    public void unbindAutomobileFromPerson(Long idAutomobile) {
        Automobile automobile = automobileService.getById(idAutomobile);
        automobile.setPerson(null);
        automobileRepository.save(automobile);
    }

    @Transactional
    @Override
    public void bindAutomobileToCarService(Long idAutomobile, Long idCarService) {
        Automobile automobile = automobileService.getById(idAutomobile);
        CarService carService = carServiceService.getById(idCarService);
        List<Automobile> automobiles = carService.getAutomobiles();
        automobiles.add(automobile);
        carService.setAutomobiles(automobiles);
        carServiceRepository.save(carService);
    }

    @Transactional
    @Override
    public void unbindAutomobileFromCarService(Long idAutomobile, Long idCarService) {
        Automobile automobile = automobileService.getById(idAutomobile);
        CarService carService = carServiceService.getById(idCarService);
        List<Automobile> automobiles = carService.getAutomobiles();
        automobiles.remove(automobile);
        carService.setAutomobiles(automobiles);
        carServiceRepository.save(carService);
    }

    @Override
    public void bindPassportToPerson(Long passportId, Long personId) {
        Person person = personService.getById(personId);
        Passport passport = passportService.getById(passportId);
        passport.setPerson(person);
        passportRepository.save(passport);
    }

    @Override
    public void unbindPassportFromPerson(Long idPassport) {
        Passport passport = passportService.getById(idPassport);
        passport.setPerson(null);
        passportRepository.save(passport);
    }
}
