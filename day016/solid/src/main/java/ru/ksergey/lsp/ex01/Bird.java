package ru.ksergey.lsp.ex01;

import java.util.Random;

public class Bird {
    protected static Random rand = new Random();
    public Coordinates position;
    protected int speed, spacing;
    protected String m;

    public Bird() {
        position = new Coordinates(10, 10);
        this.m = "B";
    }

    protected void mark(int x, int y) {
        System.out.printf("(%d, %d) %s%n", x, y, m);
    }

    public void fly() {
        mark(position.latitude, position.longitude);
        speed = 1;

        switch (rand.nextInt(2)) {
            case 0:
                position.latitude += speed;
                break;
            default:
                position.longitude += speed;
                break;
        }

        spacing++;
        mark(position.latitude, position.longitude);
    }

    public void stopFly() {
        speed = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpacing() {
        return spacing;
    }
}
