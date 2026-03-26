package ru.ksergey.ocp.ex02;

public class Program {
    public static void main(String[] args) {
        Image[] pictures = new Image[]{
                Image.createImage(28, 9, new SaveToBMP()),
                Image.createImage(19, 90, new SaveToJPG()),
                Image.createImage(15, 6, new SaveToPNG()),
        };

        for (Image pic : pictures) {
            pic.saveTo("filename_" + System.currentTimeMillis());
        }
    }
}
