package ru.eugene.java.learn.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(name = "code_uk", columnNames = "code")})
public class Person {
    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "code", nullable = false)
    private String code;

    @OneToMany(mappedBy = "person")
    private List<Automobile> automobiles;

    @OneToOne(mappedBy = "person")
    private Passport passport;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "person_company_fk"))
    private Company company;

    @ManyToMany(targetEntity = Bank.class, mappedBy = "people")
    private List<Bank> banks;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Automobile> getAutomobiles() {
        return automobiles;
    }

    public void setAutomobiles(List<Automobile> automobiles) {
        this.automobiles = automobiles;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }
}
