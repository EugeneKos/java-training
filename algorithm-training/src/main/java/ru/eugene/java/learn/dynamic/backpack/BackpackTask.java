package ru.eugene.java.learn.dynamic.backpack;

import java.util.Set;

public interface BackpackTask {
    /**
     * Задача о рюкзаке. Суть задачи разместить в рюкзак, который ограничен по вместительности, вещи
     * и так чтобы суммарная стоимость всех вещей в рюкзаке была максимальной.
     *
     * @param allThing Множество вещей.
     * @param backpack Рюкзак.
     * @return Множество вещей в рюкзаке с максимальной стоимостью.
     */
    Set<Thing> findTheBestCombinationOfThings(Set<Thing> allThing, Backpack backpack);
}
