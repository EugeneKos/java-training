package ru.eugene.java.learn.structure.linker;

public class Circle implements Graphic {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Draw circle radius in: " + radius);
    }
}
