package ru.ksergey.ocp.ex01;

public class Image extends Attach {
    private ImageSize size;

    private Image(int width, int height) {
        this.size = new ImageSize(width, height);
    }

    public static Image createImage(int width, int height) {
        return new Image(width, height);
    }

    public ImageSize getSize() {
        return new ImageSize(size.getWidth(), size.getHeight());
    }

    public void saveToBMP(String path) {
        // Реализация сохранения в BMP
    }

    public void saveToJPG(String path) {
        // Реализация сохранения в JPG
    }

    public void saveToPNG(String path) {
        // Реализация сохранения в PNG
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }
}
