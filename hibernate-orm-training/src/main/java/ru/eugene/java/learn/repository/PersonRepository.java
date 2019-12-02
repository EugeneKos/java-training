package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.eugene.java.learn.data.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.login = :login")
    Person findByLogin(@Param("login") String login);

    @Query("select p from Person p join fetch p.automobiles where p.login = :login")
    Person findByLoginWithAutomobile(@Param("login") String login);

    // Используем distinct поскольку для каждого автомобиля вернется свой Person
    @Query("select distinct p from Person p join fetch p.automobiles")
    List<Person> findAllWithAutomobile();
}
