package ru.ksergey.singleton;

public class DatabaseConnection {

    private static final DatabaseConnection INSTANCE = new DatabaseConnection();

    private String connectionString;

    private String username;
    private String url;
    private String port;

    private DatabaseConnection() {
    }

    public void initializeConnection(String username, String url, String port) {
        connectionString = String.format(
                "db//:%s:%s;username=%s",
                url, port, username

        );
        System.out.println("initializeConnection");
    }

    public static DatabaseConnection getInstance() {
        return INSTANCE;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void executeQuery(String sql) {
        System.out.println("Выполняется запрос: " + sql);
        System.out.println("Используется подключение: " + connectionString);
    }
}
