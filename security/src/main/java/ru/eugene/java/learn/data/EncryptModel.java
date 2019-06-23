package ru.eugene.java.learn.data;

public class EncryptModel<T> {
    private String name;
    private byte[] encryptData;
    private Class<T> clazz;

    public EncryptModel(String name, byte[] encryptData, Class<T> clazz) {
        this.name = name;
        this.encryptData = encryptData;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public byte[] getEncryptData() {
        return encryptData;
    }

    public Class<T> getClazz() {
        return clazz;
    }
}
