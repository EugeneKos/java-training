package ru.eugene.java.learn.data.dto;

import java.util.List;

public class PersonTreeDTO extends PersonDTO {
    private List<AutomobileDTO> automobileDTOList;

    public List<AutomobileDTO> getAutomobileDTOList() {
        return automobileDTOList;
    }

    public void setAutomobileDTOList(List<AutomobileDTO> automobileDTOList) {
        this.automobileDTOList = automobileDTOList;
    }
}
