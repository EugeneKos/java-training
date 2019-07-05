package ru.eugene.java.learn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eugene.java.learn.data.Passport;

import java.util.Optional;

public interface PassportRepository extends CrudRepository<Passport, Long> {
    Optional<Passport> getById(Long id);
    Passport findByUin(String uin);
    void deleteByUin(String uin);
}
