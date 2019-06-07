package ru.eugene.java.learn.structure.bridge;

/**
 * Паттерн мост используется когда классы разрастаются в двух плоскостях,
 * например есть различные устройства и есть различные пульты управления,
 * чтобы не делать для каждого устройства свой пульт, мы определяем интерфейс пульта и
 * в реализации передаем интерфейс устройства, если мы добавим новое устройство, то все реализации пультов будут
 * к нему применимы или же добавим новый пульт, для всех устройств он будет применим
 */
public class BasicRemote implements Remote {
    private Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        if(device.isEnable()){
            device.off();
        } else {
            device.on();
        }
    }
}
