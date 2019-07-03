package ru.eugene.java.learn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.CarService;
import ru.eugene.java.learn.data.CarServiceLinkAuto;

import java.util.List;

public interface CarServiceLinkAutoRepository extends CrudRepository<CarServiceLinkAuto, Long> {
    CarServiceLinkAuto findByAutomobileIdAndCarServiceId(Long automobileId, Long carServiceId);
    CarServiceLinkAuto findByAutomobileAndCarService(Automobile automobile, CarService carService);

    void deleteByAutomobileAndCarService(Automobile automobile, CarService carService);
    void deleteByAutomobileIdAndCarServiceId(Long automobileId, Long carServiceId);

    List<CarServiceLinkAuto> findAllByCarService(CarService carService);
}
