package init;

import java.util.Random;

import manager.DataManager;
import model.Instructor;
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
        int currentId = 1000;
        // Person stuff = new Staff(currentId, "Имя 1", 20, 10000);
        // Person instructor = new Instructor(++currentId, "Имя 2", 20, "информатика");
        // Person student = new Student(++currentId, "Имя 3", 14, "Школа №322");

        // dataManager.addPerson(stuff, instructor, student);

        for (int i = 0; i < count; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    dataManager.addPerson(
                            new Student(
                                    ++currentId,
                                    "Имя " + i,
                                    random.nextInt(7, 18),
                                    "Школа №" + random.nextInt(100, 1000)));
                    break;

                case 1:
                    dataManager.addPerson(
                            new Staff(
                                    ++currentId,
                                    "Имя " + i,
                                    random.nextInt(20, 65),
                                    random.nextInt(10, 100) * 1000));
                    break;

                default:
                    dataManager.addPerson(
                            new Instructor(
                                    ++currentId,
                                    "Имя " + i,
                                    random.nextInt(7, 18),
                                    "Предмет №" + random.nextInt(100, 1000)));
                    break;
            }
        }
    }
}
