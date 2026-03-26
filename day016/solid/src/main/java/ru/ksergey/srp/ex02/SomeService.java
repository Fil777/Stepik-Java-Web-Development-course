package ru.ksergey.srp.ex02;

public class SomeService {
    private String url;

    public SomeService(String url) {
        this.url = url;
    }

    public Image getImage() {
        return Image.createImage(100, 500);
    }
}
