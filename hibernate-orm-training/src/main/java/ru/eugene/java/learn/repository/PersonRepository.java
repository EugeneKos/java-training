package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.eugene.java.learn.data.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.login = :login")
    Person findByLogin(@Param("login") String login);
}
