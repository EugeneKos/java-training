package ru.eugene.java.learn.converter;

import org.springframework.stereotype.Service;

import ru.eugene.java.learn.data.Node;
import ru.eugene.java.learn.data.dto.NodeDTO;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NodeConverter {
    public Node convertToNode(NodeDTO dto){
        Node entity = new Node();
        entity.setId(dto.getId());
        entity.setIpAddress(dto.getIpAddress());
        entity.setPort(dto.getPort());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public NodeDTO convertToNodeDTO(Node entity){
        NodeDTO dto = new NodeDTO();
        dto.setId(entity.getId());
        dto.setIpAddress(entity.getIpAddress());
        dto.setPort(entity.getPort());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public Set<Node> convertToNodeSet(Set<NodeDTO> dtoSet){
        return dtoSet.stream().map(this::convertToNode).collect(Collectors.toSet());
    }

    public Set<NodeDTO> convertToNodeDTOSet(Set<Node> entitySet){
        return entitySet.stream().map(this::convertToNodeDTO).collect(Collectors.toSet());
    }
}
