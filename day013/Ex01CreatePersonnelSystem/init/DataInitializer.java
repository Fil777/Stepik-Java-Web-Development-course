package init;

import java.util.Random;

import manager.DataManager;
import model.Instructor;
import model.Person;
import model.Staff;
import model.Student;

public class DataInitializer {
    private DataManager dataManager;
    private Random random;

    public DataInitializer(DataManager dataManager) {
        this.dataManager = dataManager;
        this.random = new Random();
    }

    public void populate(int count) {
        Person stuff = new Staff("Имя 1", 20, 10000);
        Person instructor = new Instructor("Имя 2", 20, "информатика");
        Person student = new Student("Имя 3", 14, "Школа №322");

        dataManager.addPerson(stuff, instructor, student);

        for (int i = 0; i < count - 3; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    dataManager.addPerson(
                            new Student(
                                    "Имя " + i,
                                    random.nextInt(7, 18),
                                    "Школа №" + random.nextInt(100, 1000)));
                    break;

                case 1:
                    dataManager.addPerson(
                            new Staff(
                                    "Имя " + i,
                                    random.nextInt(20, 65),
                                    random.nextInt(10, 100) * 1000));
                    break;

                default:
                    dataManager.addPerson(
                            new Instructor(
                                    "Имя " + i,
                                    random.nextInt(7, 18),
                                    "Предмет №" + random.nextInt(100, 1000)));
                    break;
            }
        }
    }
}
