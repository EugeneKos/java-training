package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.eugene.java.learn.data.Person;

import java.util.List;
import java.util.Set;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.code = :code")
    Person findByCode(@Param("code") String code);

    @Query("select p from Person p left join fetch p.automobiles where p.code = :code")
    Person findByCodeWithAutomobiles(@Param("code") String code);

    @Query("select distinct p from Person p left join fetch p.automobiles")
    Set<Person> findAllWithAutomobiles();

    @Query("select distinct p from Person p left join fetch p.automobiles pa " +
            "where pa.id in :automobileIdList")
    Set<Person> findAllByAutomobileIdList(@Param("automobileIdList") List<Long> automobileIdList);
}
