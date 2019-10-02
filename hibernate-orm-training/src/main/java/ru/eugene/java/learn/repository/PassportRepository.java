package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.eugene.java.learn.data.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {
    @Query("select p from Passport p where p.number = :number")
    Passport findByNumber(@Param("number") String number);
}
