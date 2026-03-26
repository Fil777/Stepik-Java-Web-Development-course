package ru.ksergey.ocp.ex02;

public class Image extends Attach {
    private ImageSize size;
    private Saveable saveOption;

    private Image(int width, int height, Saveable saveOption) {
        this.size = new ImageSize(width, height);
        this.saveOption = saveOption;
    }

    public static Image createImage(int width, int height, Saveable saveOption) {
        return new Image(width, height, saveOption);
    }

    public ImageSize getSize() {
        return new ImageSize(size.getWidth(), size.getHeight());
    }

    public void saveTo(String path) {
        saveOption.save(path, this);
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }
}
