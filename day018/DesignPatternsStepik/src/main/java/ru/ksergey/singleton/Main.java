package ru.ksergey.singleton;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnect1 = DatabaseConnection.getInstance();

        dbConnect1.initializeConnection(
                "root",
                "localhost",
                "13306");

        System.out.println(dbConnect1.getConnectionString());

        String sql = "SELECT * FROM users;";
        dbConnect1.executeQuery(sql);

        DatabaseConnection dbConnect2 = DatabaseConnection.getInstance();
        System.out.println(dbConnect2.getConnectionString());

        sql = "SELECT * FROM products;";
        dbConnect2.executeQuery(sql);

        System.out.println(dbConnect1 == dbConnect2);
    }
}
