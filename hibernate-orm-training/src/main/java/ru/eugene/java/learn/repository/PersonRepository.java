package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.eugene.java.learn.data.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
