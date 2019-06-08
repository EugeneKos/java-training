package ru.eugene.java.learn.structure.linker;

public class Square implements Graphic {
    private int x;
    private int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("Draw square in side x: " + x + " side y: " + y);
    }
}
