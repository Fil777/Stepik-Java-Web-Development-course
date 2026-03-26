package ru.ksergey.ocp.ex02;

public class SaveToPNG implements Saveable {
    @Override
    public void save(String path, Image image) {
        String tempPath = path + ".png";
        // Реализация сохранения в PNG
    }
}
