package ru.ksergey.isp;

public class Characteristic {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Characteristic set(String arg) {
        Characteristic characteristic = new Characteristic();
        characteristic.setValue(arg);
        return characteristic;
    }
}
