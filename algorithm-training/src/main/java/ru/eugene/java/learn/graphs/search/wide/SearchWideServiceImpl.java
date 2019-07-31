package ru.eugene.java.learn.graphs.search.wide;

import java.util.LinkedList;
import java.util.Queue;

public class SearchWideServiceImpl implements SearchWideService {
    private Queue<Vertex> queue = new LinkedList<>();

    /**
     * Простая реализация алгоритма поиска в ширину в графе,
     * применяется очередь для добавления в нее непроверенных вершин.
     * Алгортим не ведет список проверенных вершин, в случае двусторонней связи вершин,
     * произойдет бесконечный цикл.
     *
     * @param beginVertex Вершина от которой ведется поиск
     * @param finalVertex Вершину, которую нужно найти
     * @return true если удалось найти и false если не удалось найти
     */
    @Override
    public boolean searchWide(Vertex beginVertex, Vertex finalVertex) {
        queue.add(beginVertex);
        while (!queue.isEmpty()){
            Vertex current = queue.poll();
            if(current == null){
                continue;
            }
            for (Vertex neighbor : current.getNeighbors()){
                if(neighbor.equals(finalVertex)){
                    return true;
                } else {
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
