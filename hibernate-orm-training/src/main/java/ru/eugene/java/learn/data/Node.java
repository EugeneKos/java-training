package ru.eugene.java.learn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.Objects;

@Entity
@Table(name = "node",
        uniqueConstraints = @UniqueConstraint(name = "ip_address_port_uq",
                columnNames = {"ip_address", "port"})
)
public class Node {
    @Id
    @SequenceGenerator(name = "node_id_seq", sequenceName = "node_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "node_id_seq")
    private Long id;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "port")
    private String port;

    @Column(name = "description")
    private String description;

    public Node() {
    }

    public Node(String ipAddress, String port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(id, node.id) &&
                Objects.equals(ipAddress, node.ipAddress) &&
                Objects.equals(port, node.port) &&
                Objects.equals(description, node.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ipAddress, port, description);
    }
}