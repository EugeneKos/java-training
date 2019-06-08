package ru.eugene.java.learn.structure.linker;

public class Frame {
    private CompoundGraphic compoundGraphic;

    public void show(){
        compoundGraphic = new CompoundGraphic();
        compoundGraphic.addComponent(new Circle(5));
        compoundGraphic.addComponent(new Circle(3));
        compoundGraphic.addComponent(new Circle(12));
        compoundGraphic.addComponent(new Square(2, 4));
        compoundGraphic.addComponent(new Square(6, 9));
        CompoundGraphic compoundGraphic2 = new CompoundGraphic();
        compoundGraphic2.addComponent(new Circle(77));
        compoundGraphic.addComponent(compoundGraphic2);
        compoundGraphic.draw();
    }
}
