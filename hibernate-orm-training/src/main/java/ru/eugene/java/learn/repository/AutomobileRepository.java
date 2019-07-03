package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.eugene.java.learn.data.Automobile;

import java.util.Optional;

public interface AutomobileRepository extends CrudRepository<Automobile, Long> {
    //@Query("select a from Automobile a join fetch a.person")
    Optional<Automobile> getById(Long id);
    Automobile findByStateNumber(String stateNumber);

    /*@Query("select a from Automobile a join fetch a.carServices")
    Optional<Automobile> getById(Long id, boolean withCarServices);*/
}
