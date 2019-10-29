package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ru.eugene.java.learn.converter.NodeConverter;
import ru.eugene.java.learn.converter.StandConverter;
import ru.eugene.java.learn.data.Node;
import ru.eugene.java.learn.data.Stand;
import ru.eugene.java.learn.data.dto.NodeDTO;
import ru.eugene.java.learn.data.dto.StandDTO;
import ru.eugene.java.learn.exception.NotFoundException;
import ru.eugene.java.learn.exception.NotUniqueException;
import ru.eugene.java.learn.repository.StandRepository;
import ru.eugene.java.learn.service.INodeService;
import ru.eugene.java.learn.service.IStandService;

import java.util.Set;

@Service
public class StandServiceImpl implements IStandService {
    private StandRepository standRepository;
    private StandConverter standConverter;

    private INodeService nodeService;
    private NodeConverter nodeConverter;

    @Autowired
    public StandServiceImpl(StandRepository standRepository, StandConverter standConverter) {
        this.standRepository = standRepository;
        this.standConverter = standConverter;
    }

    @Autowired
    public void setNodeService(INodeService nodeService) {
        this.nodeService = nodeService;
    }

    @Autowired
    public void setNodeConverter(NodeConverter nodeConverter) {
        this.nodeConverter = nodeConverter;
    }

    @Override
    //@Transactional
    public StandDTO editStand(StandDTO dto) {
        if(dto == null){
            return null;
        }

        Stand stand = standConverter.convertToStand(dto);

        assertExistById(stand);
        assertUniqueByName(stand);

        stand = fillLinksAndSave(stand, dto);

        return standConverter.convertToStandDTOTree(stand);
    }

    private void assertExistById(Stand stand){
        if(stand.getId() == null){
            return;
        }
        standRepository.findById(stand.getId()).orElseThrow(
                () -> new NotFoundException("Stand with id " + stand.getId() + " not found")
        );
    }

    private void assertUniqueByName(Stand stand){
        if(stand.getName() == null){
            return;
        }

        Stand foundedByName = standRepository.findByName(stand.getName());

        if(foundedByName != null && !foundedByName.getId().equals(stand.getId())){
            throw new NotUniqueException("Stand with name " + stand.getName() + " already exist");
        }
    }

    private Stand fillLinksAndSave(Stand stand, StandDTO dto){
        fillNodes(stand, dto);
        return standRepository.saveAndFlush(stand);
    }

    private void fillNodes(Stand stand, StandDTO dto){
        if(CollectionUtils.isEmpty(dto.getNodeDTOSet())){
            return;
        }

        // Работает когда каскад отключен
        Set<NodeDTO> savedNodeDTOSet = nodeService.saveAll(dto.getNodeDTOSet());
        Set<Node> savedNodes = nodeConverter.convertToNodeSet(savedNodeDTOSet);

        stand.setNodes(savedNodes);

        // Работает при cascade.PERSIST
        //stand.setNodes(nodeConverter.convertToNodeSet(dto.getNodeDTOSet()));
    }

    @Override
    public StandDTO getStandByName(String name) {
        if(name == null){
            return null;
        }

        Stand foundedByName = standRepository.findByName(name);
        return standConverter.convertToStandDTOTree(foundedByName);
    }
}
