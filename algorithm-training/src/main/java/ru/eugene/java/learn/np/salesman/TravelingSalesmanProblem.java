package ru.eugene.java.learn.np.salesman;

import java.util.Set;

public interface TravelingSalesmanProblem {
    /**
     * Задача о коммивояжере.
     *
     * @param roadways Множество маршрутов от города до города
     * @return Минимальное время посещения всех городов.
     */
    int findTimeShortestRoadway(Set<Roadway> roadways);
}
