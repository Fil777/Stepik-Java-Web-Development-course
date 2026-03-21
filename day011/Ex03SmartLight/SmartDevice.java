package Ex03SmartLight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SmartDevice {
    private String id;
    private String name;
    private boolean isOn;
    private int brightness;
    private String color;
    private ArrayList<String> supportedColors;
    private LocalDateTime lastInteraction;
    private ArrayList<String> activityLog;
    private Timer timer;

    public SmartDevice(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.isOn = false;
        this.brightness = 0;
        this.color = "white";
        this.supportedColors = new ArrayList<>(
                List.of("white", "red", "green", "blue", "yellow"));
        this.lastInteraction = LocalDateTime.now();
        this.activityLog = new ArrayList<>();
        this.timer = new Timer();
    }

    private void updateLastInteraction() {
        this.lastInteraction = LocalDateTime.now();
    }

    private void logActivity(String activity) {
        String logEntry = LocalDateTime.now() + ": " + activity;
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("activity.log", true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            logActivity("Ошибка при записи в файл лога: " + e.getMessage());
        }
    }

    public void turnOn() {
        isOn = true;
        logActivity("Устройство включено");
        updateLastInteraction();
    }

    public void turnOff() {
        isOn = false;
        brightness = 0;
        logActivity("Устройство выключено");
        updateLastInteraction();
    }

    public void setBrightness(int brightness) {
        this.brightness = Math.max(0, Math.min(100, brightness));
        logActivity("Яркость установлена на " + this.brightness);
        updateLastInteraction();
    }

    public void setColor(String color) {
        if (supportedColors.contains(color.toLowerCase())) {
            this.color = color.toLowerCase();
            logActivity("Цвет изменен на " + this.color);
            updateLastInteraction();
        }
    }

    public void addSupportedColor(String color) {
        supportedColors.add(color.toLowerCase());
        logActivity("Добавлен новый поддерживаемый цвет: " + color);
    }

    public ArrayList<String> getSupportedColors() {
        return new ArrayList<>(supportedColors);
    }

    public LocalDateTime getLastInteraction() {
        return lastInteraction;
    }

    public ArrayList<String> getActivityLog() {
        return new ArrayList<>(activityLog);
    }

    public void setTimer(int minutes) {
        timer.set(minutes);
        logActivity("Установлен таймер на " + minutes + " минут");
    }

    public void cancelTimer() {
        timer.cancel();
        logActivity("Таймер отменен");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getStatus() {
        return isOn ? "Включено, яркость: " + brightness + ", цвет: " + color : "Выключено";
    }
}
