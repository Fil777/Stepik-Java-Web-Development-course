package fil.model;

import fil.coordinates.Coordinates;
import fil.coordinates.CalculatingDistance;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Bird {
    private HashMap<Integer, Coordinates> wayPoints;
    private String name;
    private int currentTime;
    private Coordinates currentPoint;

    public Bird(String name, Coordinates point) {
        this.name = name;
        wayPoints = new HashMap<Integer, Coordinates>();
        currentTime = 0;
        move(currentTime, point);
    }

    public Coordinates getCoordinates() {
        return currentPoint;
    }

    public int getTimer(){
        return currentTime;
    }

    public void mark() {
        wayPoints.put(currentTime, currentPoint);
    }

    public void move(int time, Coordinates point) throws UnsupportedOperationException {
        if (time < currentTime) {
            throw new UnsupportedOperationException("Time can not go backwards!");
        }
        currentTime = time;
        currentPoint = new Coordinates(point.getX(), point.getY(), point.getZ());
        mark();
    }

    public double distanceCovered(){
        return CalculatingDistance.distanceTotal(List.copyOf(wayPoints.values()));
    }

    @Override
    public String toString() {
        return name + " время: " + currentTime + ", координаты: " + currentPoint.toString();
    }
}
