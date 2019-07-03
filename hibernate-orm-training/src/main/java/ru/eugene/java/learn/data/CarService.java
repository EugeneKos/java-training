package ru.eugene.java.learn.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_service",
        uniqueConstraints = {@UniqueConstraint(name = "name_uk", columnNames = {"name"})},
        indexes = {@Index(name = "name_ix", columnList = "name")})
public class CarService {
    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "carService")
    private List<CarServiceLinkAuto> carServiceLinkAutos;

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

    public List<CarServiceLinkAuto> getCarServiceLinkAutos() {
        return carServiceLinkAutos;
    }

    public void setCarServiceLinkAutos(List<CarServiceLinkAuto> carServiceLinkAutos) {
        this.carServiceLinkAutos = carServiceLinkAutos;
    }
}
