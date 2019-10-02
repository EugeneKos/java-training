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
@Table(name = "passport",
        uniqueConstraints = {@UniqueConstraint(name = "person_id_uq", columnNames = "person_id"),
                            @UniqueConstraint(name = "number_uq", columnNames = "number"),
                            @UniqueConstraint(name = "passport_code_uq", columnNames = "code")})
public class Passport {
    @Id
    @SequenceGenerator(name = "passport_id_seq", sequenceName = "passport_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "passport_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "code")
    private String code;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "passport_person_fk"))
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id) &&
                Objects.equals(number, passport.number) &&
                Objects.equals(code, passport.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, code);
    }
}
