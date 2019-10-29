package ru.eugene.java.learn.data.dto;

import java.util.Objects;
import java.util.Set;

public class StandDTO {
    private Long id;
    private String name;
    private String description;

    private Set<NodeDTO> nodeDTOSet;

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

    public Set<NodeDTO> getNodeDTOSet() {
        return nodeDTOSet;
    }

    public void setNodeDTOSet(Set<NodeDTO> nodeDTOSet) {
        this.nodeDTOSet = nodeDTOSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandDTO standDTO = (StandDTO) o;
        return Objects.equals(id, standDTO.id) &&
                Objects.equals(name, standDTO.name) &&
                Objects.equals(description, standDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
