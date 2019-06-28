package ru.eugene.java.learn.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_service",
        uniqueConstraints = {@UniqueConstraint(name = "name_uk", columnNames = {"name"})},
        indexes = {@Index(name = "name_ix", columnList = "name")})
public class CarService {
    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "car_service_automobile",
                joinColumns = @JoinColumn(name = "car_service_id", foreignKey = @ForeignKey(name = "car_service_id_fk")),
                inverseJoinColumns = @JoinColumn(name = "automobile_id", foreignKey = @ForeignKey(name = "automobile_id_fk")),
                uniqueConstraints =
                        {@UniqueConstraint(name = "car_service_id_automobile_id_uk", columnNames = {"car_service_id", "automobile_id"})},
                indexes = {@Index(name = "car_service_id_ix", columnList = "car_service_id"),
                            @Index(name = "automobile_id_ix", columnList = "automobile_id")})
    private List<Automobile> automobiles;

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

    public List<Automobile> getAutomobiles() {
        return automobiles;
    }

    public void setAutomobiles(List<Automobile> automobiles) {
        this.automobiles = automobiles;
    }
}
