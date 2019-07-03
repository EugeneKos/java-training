package ru.eugene.java.learn.data;

import javax.persistence.*;

@Entity
@Table(name = "car_service_link_auto",
        uniqueConstraints = {@UniqueConstraint(name = "car_service_automobile_uk",
                                                columnNames = {"automobile_id", "car_service_id"})})
public class CarServiceLinkAuto {
    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @ManyToOne(targetEntity = Automobile.class)
    @JoinColumn(name = "automobile_id", foreignKey = @ForeignKey(name = "link_automobile_fk"))
    private Automobile automobile;

    @ManyToOne(targetEntity = CarService.class)
    @JoinColumn(name = "car_service_id", foreignKey = @ForeignKey(name = "link_car_service_fk"))
    private CarService carService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}
