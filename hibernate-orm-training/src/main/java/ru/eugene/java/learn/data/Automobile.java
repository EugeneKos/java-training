package ru.eugene.java.learn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.Objects;

@Entity
@Table(
        name = "automobile",
        uniqueConstraints = @UniqueConstraint(name = "state_number_uq", columnNames = "state_number"))

public class Automobile {
    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "mark", nullable = false)
    private String mark;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "state_number", nullable = false)
    private String stateNumber;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "automobile_person_fk"))
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automobile that = (Automobile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(model, that.model) &&
                Objects.equals(stateNumber, that.stateNumber) &&
                Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, stateNumber, person);
    }
}
