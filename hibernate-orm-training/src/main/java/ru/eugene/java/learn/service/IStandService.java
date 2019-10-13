package ru.eugene.java.learn.service;

import ru.eugene.java.learn.data.dto.StandDTO;

public interface IStandService {
    StandDTO editStand(StandDTO dto);

    StandDTO getStandByName(String name);
}
