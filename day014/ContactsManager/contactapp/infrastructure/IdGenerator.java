package contactapp.infrastructure;

public class IdGenerator {
    private static int id;

    static {
        id = 1;
    }

    public static int getId() {
        return id;
    }
}
