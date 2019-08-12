package ru.eugene.java.learn.greedy.service;

import java.util.Map;
import java.util.Set;

public interface StationCoverageService {

    /**
     * Пример жадного алгоритма.
     * Необходимо написать метод получения радиостанций которые покрывают все входящие штаты.
     *
     * @param states Множество штатов, которые должны быть покрыты.
     * @param stationCoverage Мапа радиостанция против множества штатов, которые она покрывает.
     * @return Множетсво радиостанций, которые покрывают все входящие штаты.
     */
    <T, E> Set<T> getStations(Set<E> states, Map<T, Set<E>> stationCoverage);
}
