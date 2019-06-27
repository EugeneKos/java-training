package ru.eugene.java.learn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eugene.java.learn.data.CarService;

public interface CarServiceRepository extends CrudRepository<CarService, Long> {
}
