package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.eugene.java.learn.data.Stand;

import java.util.List;
import java.util.Set;

public interface StandRepository extends JpaRepository<Stand, Long> {
    @Query("select s from Stand s left join s.nodes where s.name = :name")
    Stand findByName(@Param("name") String name);

    @Query("select s from Stand s left join s.nodes where s.name = :name")
    List<Stand> findAllByName(@Param("name") String name);

    @Query("select s from Stand s left join s.nodes where s.description = :description")
    Set<Stand> findAllByDescription(@Param("description") String description);
}
