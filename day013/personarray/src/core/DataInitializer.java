package core;

public class DataInitializer {
    private static int counter = 100001;
    public static int generateID(){
        if (counter > 999999) {
            throw new RuntimeException("ID limit exceeded");
        }
        return counter++;
    }
}
