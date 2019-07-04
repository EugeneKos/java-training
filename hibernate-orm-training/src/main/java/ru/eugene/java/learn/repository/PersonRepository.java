package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.eugene.java.learn.data.Person;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> getById(Long id);
    Person findByCode(String code);

    @Query("select p from Person p join fetch p.banks where p.code = :code")
    Person findByCodeFetchBanks(@Param("code") String code);
}
