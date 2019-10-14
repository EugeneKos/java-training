package ru.eugene.java.learn.converter;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.eugene.java.learn.data.Node;
import ru.eugene.java.learn.data.dto.NodeDTO;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NodeConverter {
    private Mapper mapper;

    @Autowired
    public NodeConverter(Mapper mapper) {
        this.mapper = mapper;
    }

    public Node convertToNode(NodeDTO dto){
        if(dto == null){
            return null;
        }
        return mapper.map(dto, Node.class);
    }

    public NodeDTO convertToNodeDTO(Node entity){
        if(entity == null){
            return null;
        }
        return mapper.map(entity, NodeDTO.class);
    }

    public Set<Node> convertToNodeSet(Set<NodeDTO> dtoSet){
        return dtoSet.stream()
                .filter(Objects::nonNull)
                .map(this::convertToNode)
                .collect(Collectors.toSet());
    }

    public Set<NodeDTO> convertToNodeDTOSet(Set<Node> entitySet){
        return entitySet.stream()
                .filter(Objects::nonNull)
                .map(this::convertToNodeDTO)
                .collect(Collectors.toSet());
    }
}
