package ru.eugene.java.learn.data;

import javax.persistence.*;

@Entity
@Table(name = "passport",
        uniqueConstraints = {@UniqueConstraint(name = "uin_uk", columnNames = {"uin"}),
                            @UniqueConstraint(name = "person_id_uk", columnNames = "person_id")})
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "uin")
    private String uin;

    @OneToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "passport_person_fk"))
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
