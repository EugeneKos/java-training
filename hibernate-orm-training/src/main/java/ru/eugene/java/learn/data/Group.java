package ru.eugene.java.learn.data;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "my_group", uniqueConstraints = @UniqueConstraint(name = "group_name_uq", columnNames = "name"))
public class Group {
    @Id
    @SequenceGenerator(name = "group_id_seq", sequenceName = "group_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_id_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    //@Fetch(FetchMode.JOIN)
    @OneToMany
    @JoinColumn(name = "parent_group_id", foreignKey = @ForeignKey(name = "parent_group_fk"))
    private Set<Group> childrenGroups;

    public Group() {
    }

    public Group(String name) {
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

    public Set<Group> getChildrenGroups() {
        return childrenGroups;
    }

    public void setChildrenGroups(Set<Group> childrenGroups) {
        this.childrenGroups = childrenGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) &&
                Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", childrenGroups=" + childrenGroups +
                '}';
    }
}
