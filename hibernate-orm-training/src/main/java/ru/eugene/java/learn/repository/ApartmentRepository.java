package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.eugene.java.learn.data.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
