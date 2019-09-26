package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.eugene.java.learn.data.Automobile;

public interface AutomobileRepository extends JpaRepository<Automobile, Long> {
    @Query("select a from Automobile a where a.stateNumber = :stateNumber")
    Automobile findByStateNumber(@Param("stateNumber") String stateNumber);
}
