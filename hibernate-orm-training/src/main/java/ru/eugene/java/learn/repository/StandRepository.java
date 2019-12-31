package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.eugene.java.learn.data.Stand;

public interface StandRepository extends JpaRepository<Stand, Long> {
}
