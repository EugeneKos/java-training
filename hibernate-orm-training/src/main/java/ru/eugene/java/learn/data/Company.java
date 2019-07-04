package ru.eugene.java.learn.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company",
        uniqueConstraints = {@UniqueConstraint(name = "company_name_uk", columnNames = "name")})
public class Company {
    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Person.class, mappedBy = "company")
    private List<Person> people;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
