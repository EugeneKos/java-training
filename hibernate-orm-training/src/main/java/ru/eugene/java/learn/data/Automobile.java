package ru.eugene.java.learn.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "automobile",
        uniqueConstraints = {@UniqueConstraint(name = "state_number_uk", columnNames = "state_number")},
        indexes = {@Index(name = "state_number_ix", columnList = "state_number")})

public class Automobile {
    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "mark")
    private String mark;

    @Column(name = "model")
    private String model;

    @Column(name = "state_number")
    private String stateNumber;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "automobile_person_fk"))
    private Person person;

    @ManyToMany(mappedBy = "automobiles", fetch = FetchType.EAGER)
    private List<CarService> carServices;

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

    public List<CarService> getCarServices() {
        return carServices;
    }

    public void setCarServices(List<CarService> carServices) {
        this.carServices = carServices;
    }
}
