package ru.eugene.java.learn.greedy.service.impl;

import ru.eugene.java.learn.greedy.model.Government;
import ru.eugene.java.learn.greedy.model.RadioStation;
import ru.eugene.java.learn.greedy.service.StationCoverageService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StationCoverageServiceGreedyImpl implements StationCoverageService {

    /**
     * Пример использования жадного алгоритма.
     *
     * @param states Множество штатов, которые должны быть покрыты.
     * @param stationCoverage Мапа радиостанция против множества штатов, которые она покрывает.
     * @return Множетсво радиостанций, которые покрывают все входящие штаты.
     */
    @Override
    public Set<RadioStation> getStations(Set<Government> states, Map<RadioStation, Set<Government>> stationCoverage) {
        Set<RadioStation> stations = new HashSet<>();
        while (!states.isEmpty()){
            RadioStation bestStation = null;
            Set<Government> statesCovered = new HashSet<>();
            for (Map.Entry<RadioStation, Set<Government>> entry : stationCoverage.entrySet()){
                Set<Government> intersection = new HashSet<>(states);
                intersection.retainAll(entry.getValue());
                if(intersection.size() > statesCovered.size()){
                    bestStation = entry.getKey();
                    statesCovered = intersection;
                }
            }
            states.removeAll(statesCovered);
            stations.add(bestStation);
        }
        return stations;
    }
}
