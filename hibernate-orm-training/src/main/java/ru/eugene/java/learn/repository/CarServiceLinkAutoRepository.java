package ru.eugene.java.learn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.CarService;
import ru.eugene.java.learn.data.CarServiceLinkAuto;

public interface CarServiceLinkAutoRepository extends CrudRepository<CarServiceLinkAuto, Long> {
    CarServiceLinkAuto findByAutomobileIdAndCarServiceId(Long automobileId, Long carServiceId);
    CarServiceLinkAuto findByAutomobileAndCarService(Automobile automobile, CarService carService);

    void deleteByAutomobileAndCarService(Automobile automobile, CarService carService);
    void deleteByAutomobileIdAndCarServiceId(Long automobileId, Long carServiceId);
}
