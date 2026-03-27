package fil;

import fil.coordinates.Coordinates;
import fil.model.Bird;
import fil.model.Kiwi;

public class BirdsProgram {
    public static void main(String[] args) {

        Bird falcon = new Bird("Сокол", new Coordinates(0,0,0));
        falcon.move(30, new Coordinates(400,400,400));
        System.out.println(falcon);
        System.out.printf("Преодолено расстояние: %.2f, потрачено времени: %d\n", falcon.distanceCovered(),falcon.getTimer());
        falcon.move(70, new Coordinates(400,400,0));
        System.out.printf("Преодолено расстояние: %.2f, потрачено времени: %d\n", falcon.distanceCovered(),falcon.getTimer());
        System.out.println(falcon);

        Kiwi kiwi = new Kiwi("Киви", new Coordinates(0,0,0));
        kiwi.move(60, new Coordinates(400,400,400));
        System.out.println(kiwi);
        System.out.printf("Преодолено расстояние: %.2f, потрачено времени: %d\n", kiwi.distanceCovered(),kiwi.getTimer());
        kiwi.move(120, new Coordinates(400,400,-400));
        System.out.printf("Преодолено расстояние: %.2f, потрачено времени: %d\n", kiwi.distanceCovered(),kiwi.getTimer());
        System.out.println(kiwi);

    }
}