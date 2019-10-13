package ru.eugene.java.learn.util;

import ru.eugene.java.learn.data.dto.NodeDTO;
import ru.eugene.java.learn.data.dto.StandDTO;

public final class DTOUtils {
    private DTOUtils(){}

    public static NodeDTO createNodeDTO(String ipAddress, String port, String description){
        NodeDTO dto = new NodeDTO();
        dto.setIpAddress(ipAddress);
        dto.setPort(port);
        dto.setDescription(description);
        return dto;
    }

    public static StandDTO createStandDTO(String name, String description){
        StandDTO standDTO = new StandDTO();
        standDTO.setName(name);
        standDTO.setDescription(description);
        return standDTO;
    }
}
