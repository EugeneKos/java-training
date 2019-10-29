package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.dto.NodeDTO;

import java.util.Set;

public interface INodeService {
    NodeDTO addNode(NodeDTO dto);
    NodeDTO editNode(NodeDTO dto);

    Set<NodeDTO> saveAll(Set<NodeDTO> nodeDTOSet);

    Set<NodeDTO> getByIpAddress(String ipAddress);
    Set<NodeDTO> getByPort(String port);
}
