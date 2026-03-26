package ru.ksergey.ocp.ex03;

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

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }
}
