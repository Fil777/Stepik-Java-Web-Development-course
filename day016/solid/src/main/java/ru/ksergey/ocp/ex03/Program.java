package ru.ksergey.ocp.ex03;

public class Program {
    public static void main(String[] args) {
        Image image = Image.createImage(28, 9);
        ImageExtensions.saveToBMP(image, "image.bmp");
        ImageExtensions.saveToJPG(image, "image.jpg");
        ImageExtensions.saveToPNG(image, "image.png");
    }
}
