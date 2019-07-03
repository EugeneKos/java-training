package ru.eugene.java.learn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eugene.java.learn.data.CarService;

import java.util.Optional;

public interface CarServiceRepository extends CrudRepository<CarService, Long> {
    Optional<CarService> getById(Long id);
    CarService findByName(String name);
}
