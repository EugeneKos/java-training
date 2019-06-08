package ru.eugene.java.learn.structure.linker;

import java.util.ArrayList;
import java.util.List;

/**
 * Паттерн компоновщик применяется в случае древовидной структуры.
 * Накрываем общим интерфейсом и в классе храним набор таких же объектов интерфейсов.
 * Также интерфейс реализуют простые объекты называемые листьями в структуре дерева.
 */
public class CompoundGraphic implements Graphic {
    private List<Graphic> components = new ArrayList<>();

    public void addComponent(Graphic graphic){
        components.add(graphic);
    }

    public void removeComponent(Graphic graphic){
        components.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic component : components){
            component.draw();
        }
    }
}
