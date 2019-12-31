package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.eugene.java.learn.data.Automobile;

public interface AutomobileRepository extends JpaRepository<Automobile, Long> {
}
