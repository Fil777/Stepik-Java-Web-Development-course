package ru.ksergey.ocp.ex01;

public class Program {
    public static void main(String[] args) {
        Image image = Image.createImage(28, 9);
        image.saveToBMP("image.bmp");
        image.saveToJPG("image.jpg");
        image.saveToPNG("image.png");
    }
}
