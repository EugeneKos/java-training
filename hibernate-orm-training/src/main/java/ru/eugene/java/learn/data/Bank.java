package ru.eugene.java.learn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bank",
        uniqueConstraints = @UniqueConstraint(name = "bank_name_uq", columnNames = "bank_name"))
public class Bank {
    @Id
    @SequenceGenerator(name = "bank_id_seq", sequenceName = "bank_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "bank_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "bank_name", nullable = false)
    private String name;

    @ManyToMany(targetEntity = Person.class, fetch = FetchType.LAZY)
    @JoinTable(name = "bank_person",
            joinColumns = @JoinColumn(name = "bank_id",
                    foreignKey = @ForeignKey(name = "bank_person_bank_fk")),
            inverseJoinColumns = @JoinColumn(name = "person_id",
                    foreignKey = @ForeignKey(name = "bank_person_person_fk")))
    private List<Person> persons;

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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id) &&
                Objects.equals(name, bank.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
