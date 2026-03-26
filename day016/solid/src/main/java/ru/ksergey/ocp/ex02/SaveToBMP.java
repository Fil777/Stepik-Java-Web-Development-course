package ru.ksergey.ocp.ex02;

public class SaveToBMP implements Saveable {
    @Override
    public void save(String path, Image image) {
        String tempPath = path + ".bmp";
        // Реализация сохранения в BMP
    }
}
