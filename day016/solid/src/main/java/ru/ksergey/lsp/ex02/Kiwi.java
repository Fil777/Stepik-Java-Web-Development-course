package ru.ksergey.lsp.ex02;

import java.util.Random;

public class Kiwi extends Bird {
    public Kiwi() {
        position = new Coordinates(30, 10);
        this.m = "K";
    }

    private void run() {
        mark(position.latitude, position.longitude);
        speed = 1;
        switch (new Random().nextInt(4)) {
            case 0:
                position.latitude += speed;
                break;
            case 1:
                position.latitude -= speed;
                break;
            case 2:
                position.longitude += speed;
                break;
            default:
                position.longitude -= speed;
                break;
        }
        spacing++;
        mark(position.latitude, position.longitude);
    }

    @Override
    public void move() {
        this.run();
    }
}
