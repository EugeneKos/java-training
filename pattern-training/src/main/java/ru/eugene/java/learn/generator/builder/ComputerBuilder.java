package ru.eugene.java.learn.generator.builder;

/**
 * Паттерн строитель нужен чтобы не плодить конструкторы целевого объекта,
 * если некоторые параметры могут быть по умолчанию.
 */
public class ComputerBuilder {
    private Computer computer;

    public ComputerBuilder(String motherboard) {
        this.computer = new Computer(motherboard);
    }

    public Computer getComputer() {
        return computer;
    }

    public ComputerBuilder setRam(int ram){
        computer.setRam(ram);
        return this;
    }

    public ComputerBuilder setRom(int rom){
        computer.setRom(rom);
        return this;
    }

    public ComputerBuilder setChipSet(String chipSet) {
        computer.setChipSet(chipSet);
        return this;
    }

    public ComputerBuilder setOc(String oc) {
        computer.setOc(oc);
        return this;
    }

    public ComputerBuilder setVideoAdapter(String videoAdapter) {
        computer.setVideoAdapter(videoAdapter);
        return this;
    }
}
