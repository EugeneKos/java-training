package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.eugene.java.learn.data.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findByName(String name);

    @Query("select c from Company c join fetch c.people where c.name = :name")
    Company findByNameFetchPeople(@Param("name") String name);
}
