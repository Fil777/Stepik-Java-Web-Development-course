package utils;

public class IdGenerator {
    private static int counter = 100001;

    public static int generateId() {
        if (counter > 999999) {
            throw new RuntimeException("ID limit exceeded");
        }
        return counter++;
    }

    public static void setID(int newId) {
        if (newId > counter) {
            counter = newId;
        }
    }

    public static int getID() {
        return counter;
    }
}
