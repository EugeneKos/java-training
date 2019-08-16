package ru.eugene.java.learn.greedy.service.impl;

import ru.eugene.java.learn.greedy.model.Government;
import ru.eugene.java.learn.greedy.model.RadioStation;
import ru.eugene.java.learn.greedy.service.ExponentialSetService;
import ru.eugene.java.learn.greedy.service.StationCoverageService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StationCoverageServiceNPFullImpl implements StationCoverageService {
    private ExponentialSetService<RadioStation> exponentialSetService;

    public StationCoverageServiceNPFullImpl(ExponentialSetService<RadioStation> exponentialSetService) {
        this.exponentialSetService = exponentialSetService;
    }

    /**
     * Пример использования алгоритма решения в лоб.
     * Сначала получаем список всех возможных комбинаций станций, а затем выделяем подмножество,
     * которое удовлетворяет условиям:
     *      1. Набор станций покрывает все штаты.
     *      2. Количество станций в наборе должно быть минимальным.
     *
     * @param states Множество штатов, которые должны быть покрыты.
     * @param stationCoverage Мапа радиостанция против множества штатов, которые она покрывает.
     * @return Множетсво радиостанций, которые покрывают все входящие штаты.
     */
    @Override
    public Set<RadioStation> getStations(Set<Government> states, Map<RadioStation, Set<Government>> stationCoverage) {
        Set<RadioStation> radioStations = null;
        int minNumRadioStations = Integer.MAX_VALUE;
        Set<Set<RadioStation>> allSubsets = exponentialSetService.getAllSubsets(stationCoverage.keySet());
        for (Set<RadioStation> radioStationsSubset : allSubsets){
            if(isAllCoverage(states, stationCoverage, radioStationsSubset)){
                int subsetSize = radioStationsSubset.size();
                if(subsetSize < minNumRadioStations){
                    radioStations = radioStationsSubset;
                    minNumRadioStations = subsetSize;
                }
            }
        }
        return radioStations;
    }

    private boolean isAllCoverage(Set<Government> states,
                                  Map<RadioStation, Set<Government>> stationCoverage,
                                  Set<RadioStation> radioStationsSubset){

        Set<Government> needCoverage = new HashSet<>(states);
        for (RadioStation radioStation : radioStationsSubset){
            needCoverage.removeAll(stationCoverage.get(radioStation));
        }
        return needCoverage.isEmpty();
    }
}
