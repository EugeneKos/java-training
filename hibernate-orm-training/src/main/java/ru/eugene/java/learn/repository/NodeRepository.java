package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.eugene.java.learn.data.Node;

public interface NodeRepository extends JpaRepository<Node, Long> {
}
