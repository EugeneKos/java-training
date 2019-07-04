package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.eugene.java.learn.data.Bank;

public interface BankRepository extends CrudRepository<Bank, Long> {
    Bank findByName(String name);

    @Query("select b from Bank b join fetch b.people where b.name = :name")
    Bank findByNameFetchPeople(@Param("name") String name);
}
