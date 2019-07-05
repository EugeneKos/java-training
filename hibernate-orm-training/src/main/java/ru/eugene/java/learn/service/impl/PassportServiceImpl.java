package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eugene.java.learn.data.Passport;
import ru.eugene.java.learn.exception.NotFoundException;
import ru.eugene.java.learn.repository.PassportRepository;
import ru.eugene.java.learn.service.IPassportService;

@Service
public class PassportServiceImpl implements IPassportService {
    private PassportRepository passportRepository;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Transactional
    @Override
    public Passport create(String uin) {
        Passport passport = new Passport();
        passport.setUin(uin);
        return passportRepository.save(passport);
    }

    @Override
    public Passport getById(Long id) {
        return passportRepository.getById(id)
                .orElseThrow(() -> new NotFoundException("passport by id: " + id + " not found"));
    }

    @Override
    public Passport getByUIN(String uin) {
        return passportRepository.findByUin(uin);
    }

    @Transactional
    @Override
    public void deleteByUin(String uin) {
        passportRepository.deleteByUin(uin);
    }
}
