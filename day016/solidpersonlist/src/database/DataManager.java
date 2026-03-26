package database;

import core.DataInitializer;
import model.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class DataManager {

    //private static Path path = Paths.get("c:\\temp\\persons.bin");
    private static Path path = Paths.get("persons.bin");

    public static void saveData(Person[] people) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));

        try {
            oos.writeInt((int) people.length);
        } catch (IOException exc) {
            throw exc;
        };

        for (Person person : people) {
            try {
                if (person instanceof Staff) {
                    oos.writeByte(1);
                } else if (person instanceof Instructor) {
                    oos.writeByte(2);
                } else if (person instanceof Student) {
                    oos.writeByte(3);
                } else {
                    oos.writeByte(0);
                }
                oos.writeObject(person);
            }
            catch (IOException exc) {
                throw exc;
            }
        }
        oos.close();
    }

    public static Person[] readData() throws Exception {
        final Logger logger = Logger.getLogger(Class.class.getName());
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
        int nPersons = 0;
        int maxId = 0;

        try {
            nPersons = ois.readInt();
        } catch (IOException exc) {
            throw exc;
        }

        Person[] people = new EmptyPerson[nPersons];
        for (int i = 0; i < nPersons; i++ ) {
            try {
                byte objType = ois.readByte();
                if (objType == 1) {
                    people[i] = (Staff) ois.readObject();
                } else if (objType == 2) {
                    people[i] = (Instructor) ois.readObject();
                } else if (objType == 3) {
                    people[i] = (Student) ois.readObject();
                } else {
                    people[i] = (EmptyPerson) ois.readObject();
                }
            } catch (IOException exc) {
                throw exc;
            }
            if (maxId < people[i].getId()){
                maxId = people[i].getId();
            }
            logger.info(people[i].toString());
        }
        ois.close();
        DataInitializer.setID(maxId+1);
        return people;
    }

}
