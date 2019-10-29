package ru.eugene.java.learn.converter;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ru.eugene.java.learn.data.Stand;
import ru.eugene.java.learn.data.dto.StandDTO;

@Service
public class StandConverter {
    private Mapper mapper;

    private NodeConverter nodeConverter;

    @Autowired
    public StandConverter(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setNodeConverter(NodeConverter nodeConverter) {
        this.nodeConverter = nodeConverter;
    }

    public Stand convertToStand(StandDTO dto){
        if(dto == null){
            return null;
        }
        return mapper.map(dto, Stand.class);
    }

    public StandDTO convertToStandDTO(Stand entity){
        if(entity == null){
            return null;
        }
        return mapper.map(entity, StandDTO.class);
    }

    public StandDTO convertToStandDTOTree(Stand entity){
        if(entity == null){
            return null;
        }

        StandDTO dto = convertToStandDTO(entity);

        if(!CollectionUtils.isEmpty(entity.getNodes())){
            dto.setNodeDTOSet(nodeConverter.convertToNodeDTOSet(entity.getNodes()));
        }

        return dto;
    }

    public Stand convertToStandTree(StandDTO dto){
        if(dto == null){
            return null;
        }

        Stand entity = convertToStand(dto);

        if(!CollectionUtils.isEmpty(dto.getNodeDTOSet())){
            entity.setNodes(nodeConverter.convertToNodeSet(dto.getNodeDTOSet()));
        }

        return entity;
    }
}
