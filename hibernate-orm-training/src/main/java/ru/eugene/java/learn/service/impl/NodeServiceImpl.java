package ru.eugene.java.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.eugene.java.learn.converter.NodeConverter;
import ru.eugene.java.learn.data.Node;
import ru.eugene.java.learn.data.dto.NodeDTO;
import ru.eugene.java.learn.exception.NotFoundException;
import ru.eugene.java.learn.exception.NotUniqueException;
import ru.eugene.java.learn.repository.NodeRepository;
import ru.eugene.java.learn.service.INodeService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NodeServiceImpl implements INodeService {
    private NodeRepository nodeRepository;
    private NodeConverter nodeConverter;

    @Autowired
    public NodeServiceImpl(NodeRepository nodeRepository, NodeConverter nodeConverter) {
        this.nodeRepository = nodeRepository;
        this.nodeConverter = nodeConverter;
    }

    @Override
    //@Transactional
    public NodeDTO addNode(NodeDTO dto) {
        return editNode(dto);
    }

    @Override
    //@Transactional
    public NodeDTO editNode(NodeDTO dto) {
        if(dto == null){
            return null;
        }

        Node node = nodeConverter.convertToNode(dto);

        assertExistById(node);
        assertUniqueByIpAddressAndPort(node);

        node = nodeRepository.saveAndFlush(node);
        return nodeConverter.convertToNodeDTO(node);
    }

    private void assertExistById(Node node){
        if(node.getId() == null){
            return;
        }
        nodeRepository.findById(node.getId()).orElseThrow(
                () -> new NotFoundException("Node with id " + node.getId() + " not found")
        );
    }

    private void assertUniqueByIpAddressAndPort(Node node){
        if(node.getIpAddress() == null || node.getPort() == null){
            return;
        }

        Node foundedByIpAddressAndPort = nodeRepository.findByIpAddressAndPort(node.getIpAddress(), node.getPort());

        if(foundedByIpAddressAndPort != null && !foundedByIpAddressAndPort.getId().equals(node.getId())){
            throw new NotUniqueException("Node this ip address " + node.getIpAddress()
                    + " and port " + node.getPort() + " already exist");
        }
    }

    @Override
    //@Transactional
    public Set<NodeDTO> saveAll(Set<NodeDTO> nodeDTOSet) {
        return nodeDTOSet.stream().map(this::editNode).collect(Collectors.toSet());
    }

    @Override
    public Set<NodeDTO> getByIpAddress(String ipAddress) {
        Set<Node> foundedByIpAddress = nodeRepository.findByIpAddress(ipAddress);
        return nodeConverter.convertToNodeDTOSet(foundedByIpAddress);
    }

    @Override
    public Set<NodeDTO> getByPort(String port) {
        Set<Node> foundedByPort = nodeRepository.findByPort(port);
        return nodeConverter.convertToNodeDTOSet(foundedByPort);
    }
}
