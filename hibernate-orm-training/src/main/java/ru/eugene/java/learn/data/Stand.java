package ru.eugene.java.learn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stand", uniqueConstraints = @UniqueConstraint(name = "stand_name_uq", columnNames = "name"))
public class Stand {
    @Id
    @SequenceGenerator(name = "stand_id_seq", sequenceName = "stand_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stand_id_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(targetEntity = Node.class, fetch = FetchType.EAGER)
    @JoinTable(name = "stand_node",
            joinColumns = @JoinColumn(name = "stand_id"),
            inverseJoinColumns = @JoinColumn(name = "node_id")
    )
    private Set<Node> nodes;

    public Stand() {
    }

    public Stand(String name) {
        this.name = name;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stand stand = (Stand) o;
        return Objects.equals(id, stand.id) &&
                Objects.equals(name, stand.name) &&
                Objects.equals(description, stand.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
