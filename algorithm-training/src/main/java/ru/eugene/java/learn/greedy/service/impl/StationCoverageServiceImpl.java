package ru.eugene.java.learn.greedy.service.impl;

import ru.eugene.java.learn.greedy.service.StationCoverageService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StationCoverageServiceImpl implements StationCoverageService {
    @Override
    public <T, E> Set<T> getStations(Set<E> states, Map<T, Set<E>> stationCoverage) {
        Set<T> stations = new HashSet<>();
        while (!states.isEmpty()){
            T bestStation = null;
            Set<E> statesCovered = new HashSet<>();
            for (Map.Entry<T, Set<E>> entry : stationCoverage.entrySet()){
                Set<E> intersection = new HashSet<>(states);
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
