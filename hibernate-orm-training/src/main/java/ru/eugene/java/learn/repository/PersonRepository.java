package ru.eugene.java.learn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eugene.java.learn.data.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
