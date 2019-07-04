package ru.eugene.java.learn.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank",
        uniqueConstraints = {@UniqueConstraint(name = "bank_name_uk", columnNames = "name")})
public class Bank {
    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(targetEntity = Person.class)
    @JoinTable(name = "bank_person",
            joinColumns = @JoinColumn(name = "bank_id",
                    foreignKey = @ForeignKey(name = "bank_person_bank_fk")),
            inverseJoinColumns = @JoinColumn(name = "person_id"),
                    foreignKey = @ForeignKey(name = "bank_person_person_fk"))
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
