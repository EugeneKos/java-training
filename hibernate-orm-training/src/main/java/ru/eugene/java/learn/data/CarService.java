package ru.eugene.java.learn.data;

import javax.persistence.*;

@Entity
@Table(name = "car_service")
public class CarService {
    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
