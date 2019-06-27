package ru.eugene.java.learn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eugene.java.learn.data.Automobile;

public interface AutomobileRepository extends CrudRepository<Automobile, Long> {
}
