package ru.eugene.java.learn.greedy.service;

import ru.eugene.java.learn.greedy.model.Government;
import ru.eugene.java.learn.greedy.model.RadioStation;

import java.util.Map;
import java.util.Set;

public interface StationCoverageService {

    /**
     * Необходимо написать метод получения радиостанций которые покрывают все входящие штаты.
     *
     * @param states Множество штатов, которые должны быть покрыты.
     * @param stationCoverage Мапа радиостанция против множества штатов, которые она покрывает.
     * @return Множетсво радиостанций, которые покрывают все входящие штаты.
     */
    Set<RadioStation> getStations(Set<Government> states, Map<RadioStation, Set<Government>> stationCoverage);
}
