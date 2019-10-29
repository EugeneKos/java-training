package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.eugene.java.learn.data.Stand;

public interface StandRepository extends JpaRepository<Stand, Long> {
    @Query("select s from Stand s where s.name = :name")
    Stand findByName(@Param("name") String name);
}
