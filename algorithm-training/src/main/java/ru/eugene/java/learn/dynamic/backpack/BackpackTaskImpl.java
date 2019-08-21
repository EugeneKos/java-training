package ru.eugene.java.learn.dynamic.backpack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class BackpackTaskImpl implements BackpackTask {
    /**
     * Задача о рюкзаке. Суть задачи разместить в рюкзак, который ограничен по вместительности, вещи
     * и так чтобы суммарная стоимость всех вещей в рюкзаке была максимальной.
     *
     * Задача реализована с помощью алгоритма "динамическое программирование".
     * Для решения данной задачи необходима матрица (таблица).
     *
     * Формула следующая:
     * 1. a(i,w) = c(i) + a(i-1,w-m(i))
     * 2. a(i,w) = a(i-1,w)
     * 3. max(1 str, 2 str)
     *
     * 1 строчка означает что мы хотим взять текущий предмет.
     * Поэтому для текущего предмета и вместительности сумки смотрим его стоимость ( c(i) )
     * плюс то что уже лежит в нашем рюкзаке и обязательно проверяем а можел ли вообще вместиться новая вещь,
     * для этого ( w-m(i) )
     *
     * 2 строчка означает, что мы не кладем предмет в сумку и оставляем стоимость такую какая и была для предыдущего
     * предмета, но с новым парметром вместительности.
     *
     * 3. Далее мы берем максимум от первого и второго выражения
     * (если в первом выражении вес предмета не больше оставшейся вместительности рюкзака)
     *
     * @param allThing Множество вещей.
     * @param backpack Рюкзак.
     * @return Множество вещей в рюкзаке с максимальной стоимостью.
     */
    @Override
    public Set<Thing> findTheBestCombinationOfThings(Set<Thing> allThing, Backpack backpack) {
        List<Thing> allThingList = new ArrayList<>(allThing);
        allThingList.add(0, null);
        Map<Cell, CellValue> matrix = initMatrix(backpack.getCapacity(), allThingList.size());
        for (int i = 1; i < allThingList.size(); i++) {
            for (int j = 1; j <= backpack.getCapacity(); j++) {
                Thing current = allThingList.get(i);
                if(j - current.getWeight() >= 0){
                    CellValue prevCellValue = matrix.get(new Cell(j - current.getWeight(), i - 1));

                    Set<Thing> newThingsSet = new HashSet<>(prevCellValue.getThings());
                    newThingsSet.add(current);

                    CellValue firstCellValue = new CellValue(current.getCoast() + prevCellValue.getValue(), newThingsSet);
                    CellValue secondCellValue = matrix.get(new Cell(j, i - 1));

                    CellValue newCellValue = max(firstCellValue, secondCellValue);
                    matrix.put(new Cell(j, i), newCellValue);
                } else {
                    matrix.put(new Cell(j, i), matrix.get(new Cell(j, i - 1)));
                }
            }
        }
        return matrix.get(new Cell(backpack.getCapacity(), allThingList.size() - 1)).getThings();
    }

    private CellValue max(CellValue first, CellValue second){
        int max = Math.max(first.getValue(), second.getValue());
        if(max == first.getValue()){
            return first;
        }
        return second;
    }

    private Map<Cell, CellValue> initMatrix(int backpackCapacity, int numAllThing){
        Map<Cell, CellValue> matrix = new HashMap<>();
        for (int i = 0; i <= backpackCapacity; i++) {
            matrix.put(new Cell(i, 0), new CellValue(0, new HashSet<>()));
        }
        for (int i = 0; i < numAllThing; i++) {
            matrix.put(new Cell(0, i), new CellValue(0, new HashSet<>()));
        }
        return matrix;
    }

    private class Cell{
        private int backpackCapacity;
        private int thingCoast;

        Cell(int backpackCapacity, int thingCoast) {
            this.backpackCapacity = backpackCapacity;
            this.thingCoast = thingCoast;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return backpackCapacity == cell.backpackCapacity &&
                    thingCoast == cell.thingCoast;
        }

        @Override
        public int hashCode() {
            return Objects.hash(backpackCapacity, thingCoast);
        }
    }

    private class CellValue {
        private int value;

        private Set<Thing> things;

        CellValue(int value, Set<Thing> things) {
            this.value = value;
            this.things = things;
        }

        int getValue() {
            return value;
        }

        Set<Thing> getThings() {
            return things;
        }
    }
}
