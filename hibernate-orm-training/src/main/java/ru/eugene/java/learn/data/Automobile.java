package ru.eugene.java.learn.data;

import javax.persistence.*;

@Entity
@Table(name = "automobile")
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
}
