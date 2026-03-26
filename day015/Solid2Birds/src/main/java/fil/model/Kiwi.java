package fil.model;

import fil.coordinates.Coordinates;

public class Kiwi extends Bird {

    public Kiwi(String name, Coordinates point){
        super(name, point);
    }

    @Override
    public void move(int time, Coordinates point) {
        Coordinates newPoint = new Coordinates(point.getX(), point.getY(), 0);
        super.move(time, newPoint);
    }
}
