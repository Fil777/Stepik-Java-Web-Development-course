package ru.ksergey.lsp.ex01;

public class Coordinates {
    public int latitude;
    public int longitude;

    public Coordinates(int x, int y) {
        latitude = x;
        longitude = y;
    }

    @Override
    public String toString() {
        return String.format("Широта: %d  Долгота: %d", latitude, longitude);
    }
}
