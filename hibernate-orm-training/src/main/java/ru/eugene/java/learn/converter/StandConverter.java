package ru.eugene.java.learn.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ru.eugene.java.learn.data.Stand;
import ru.eugene.java.learn.data.dto.StandDTO;

@Service
public class StandConverter {
    private NodeConverter nodeConverter;

    @Autowired
    public StandConverter(NodeConverter nodeConverter) {
        this.nodeConverter = nodeConverter;
    }

    public Stand convertToStand(StandDTO dto){
        Stand entity = new Stand();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public StandDTO convertToStandDTO(Stand entity){
        StandDTO dto = new StandDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public StandDTO convertToStandDTOTree(Stand entity){
        StandDTO dto = convertToStandDTO(entity);

        if(!CollectionUtils.isEmpty(entity.getNodes())){
            dto.setNodeDTOSet(nodeConverter.convertToNodeDTOSet(entity.getNodes()));
        }

        return dto;
    }

    public Stand convertToStandTree(StandDTO dto){
        Stand entity = convertToStand(dto);

        if(!CollectionUtils.isEmpty(dto.getNodeDTOSet())){
            entity.setNodes(nodeConverter.convertToNodeSet(dto.getNodeDTOSet()));
        }

        return entity;
    }
}
