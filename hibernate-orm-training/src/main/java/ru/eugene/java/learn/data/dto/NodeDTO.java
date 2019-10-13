package ru.eugene.java.learn.data.dto;

import java.util.Objects;

public class NodeDTO {
    private Long id;
    private String ipAddress;
    private String port;
    private String description;

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
        NodeDTO nodeDTO = (NodeDTO) o;
        return Objects.equals(id, nodeDTO.id) &&
                Objects.equals(ipAddress, nodeDTO.ipAddress) &&
                Objects.equals(port, nodeDTO.port) &&
                Objects.equals(description, nodeDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ipAddress, port, description);
    }
}
