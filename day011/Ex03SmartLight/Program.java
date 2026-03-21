package Ex03SmartLight;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        SmartDevice device = new SmartDevice("Умная лампа");

        System.out.println("Начальное состояние: " + device.getStatus());

        device.turnOn();
        System.out.println("После включения: " + device.getStatus());

        device.setBrightness(75);
        System.out.println("После установки яркости: " + device.getStatus());

        device.setColor("blue");
        System.out.println("После изменения цвета: " + device.getStatus());

        device.setColor("purple");
        System.out.println("После попытки установить неподдерживаемый цвет: " + device.getStatus());

        device.addSupportedColor("purple");
        device.setColor("purple");
        System.out.println("После добавления и установки нового цвета: " + device.getStatus());

        device.setTimer(5);
        System.out.println("Таймер установлен на 5 минут");

        device.turnOff();
        System.out.println("После выключения: " + device.getStatus());

        System.out.println("\nЖурнал активности:");
        ArrayList<String> activityLog = device.getActivityLog();
        for (String entry : activityLog) {
            System.out.println(entry);
        }

        System.out.println("\nПоддерживаемые цвета:");
        ArrayList<String> supportedColors = device.getSupportedColors();
        for (String color : supportedColors) {
            System.out.println(color);
        }

        System.out.println("\nПоследнее взаимодействие: " + device.getLastInteraction());
    }
}
