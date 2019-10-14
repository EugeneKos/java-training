package ru.eugene.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.eugene.java.learn.data.Node;

import java.util.Set;

public interface NodeRepository extends JpaRepository<Node, Long> {
    @Query("select n from Node n where n.ipAddress = :ipAddress and n.port = :port")
    Node findByIpAddressAndPort(@Param("ipAddress") String ipAddress, @Param("port") String port);

    @Query("select n from Node n where n.ipAddress = :ipAddress")
    Set<Node> findByIpAddress(@Param("ipAddress") String ipAddress);

    @Query("select n from Node n where n.port = :port")
    Set<Node> findByPort(@Param("port") String port);
}
