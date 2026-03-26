package fil.example.model;

public class Image extends Attach {
    private int width;
    private int height;

    public Image(String id, int width, int height) {
        super(id);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea(){
        return width * height;
    }
}
