package ru.eugene.java.learn.behaviour.visitor.var2;

public class ExporterImpl implements Exporter {
    @Override
    public void export(Shape shape) {
        shape.draw();
    }

    @Override
    public void export(Dot dot) {
        System.out.println("Export dot");
    }

    @Override
    public void export(Circle circle) {
        System.out.println("Export circle");
    }
}
