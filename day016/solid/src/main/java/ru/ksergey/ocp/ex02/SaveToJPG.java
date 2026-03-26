package ru.ksergey.ocp.ex02;

public class SaveToJPG implements Saveable {
    @Override
    public void save(String path, Image image) {
        String tempPath = path + ".jpg";
        // Реализация сохранения в JPG
    }
}
