package ru.eugene.java.learn.generator.builder;

public class Computer {
    private String motherboard;
    private int ram;
    private int rom;
    private String chipSet;
    private String oc;
    private String videoAdapter;

    public Computer(String motherboard) {
        this.motherboard = motherboard;
        this.ram = 4;
        this.rom = 500;
        this.chipSet = "intel core i3";
        this.oc = "linux";
        this.videoAdapter = "Radeon";
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public String getChipSet() {
        return chipSet;
    }

    public void setChipSet(String chipSet) {
        this.chipSet = chipSet;
    }

    public String getOc() {
        return oc;
    }

    public void setOc(String oc) {
        this.oc = oc;
    }

    public String getVideoAdapter() {
        return videoAdapter;
    }

    public void setVideoAdapter(String videoAdapter) {
        this.videoAdapter = videoAdapter;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "motherboard='" + motherboard + '\'' +
                ", ram=" + ram +
                ", rom=" + rom +
                ", chipSet='" + chipSet + '\'' +
                ", oc='" + oc + '\'' +
                ", videoAdapter='" + videoAdapter + '\'' +
                '}';
    }
}
