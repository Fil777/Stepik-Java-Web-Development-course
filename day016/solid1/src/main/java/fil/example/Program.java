package fil.example;

import fil.example.dao.file.ImageExtensions;
import fil.example.model.Image;

public class Program {
    public static void main(String[] args) {

        Image image = new Image("image1", 50, 100);
        System.out.printf("Image: id = '%s', %d x %d = %d \n", image.getId(), image.getWidth(), image.getHeight(), image.getArea());
        String fType = "bmpx";
        if (ImageExtensions.saveImage(image.getId(), fType, image)){
            System.out.println(image.getId() + "." + fType + " saved");
        } else {
            System.out.println(image.getId() + "." + fType + " save failed");
        }
    }
}