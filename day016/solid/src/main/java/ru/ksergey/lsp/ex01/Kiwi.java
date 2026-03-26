package ru.ksergey.lsp.ex01;

public class Kiwi extends Bird {
    public Kiwi() {
        position = new Coordinates(30, 10);
    }

    @Override
    public void fly() {
        System.out.println("Я не умею летать");
    }

    public void run() {
        mark(position.latitude, position.longitude);
        speed = 1;

        switch (rand.nextInt(4)) {
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
}
