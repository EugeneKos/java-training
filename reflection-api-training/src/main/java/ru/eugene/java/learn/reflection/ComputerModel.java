package ru.eugene.java.learn.reflection;

public class ComputerModel {
    private String fullName;
    private double frequency;
    private int memorySize;

    public ComputerModel(String fullName, double frequency, int memorySize) {
        this.fullName = fullName;
        this.frequency = frequency;
        this.memorySize = memorySize;
    }

    public void powerOn(){
        System.out.println("power on " + fullName);
    }

    private void overclock(){
        frequency = frequency + 2;
    }

    @Override
    public String toString() {
        return "ComputerModel{" +
                "fullName='" + fullName + '\'' +
                ", frequency=" + frequency +
                ", memorySize=" + memorySize +
                '}';
    }
}
