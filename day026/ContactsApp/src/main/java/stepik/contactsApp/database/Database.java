package stepik.contactsApp.database;

import java.sql.*;
import java.util.logging.*;

public class Database {
    private Connection connection;
    // Имя драйвера СУБД postgres
    private final String driverName = "org.postgresql.Driver";
    //URL к базе состоит из протокола:подпротокола://[хоста]:[прта_СУБД]/[БД] и других_сведений
    private final String url = "jdbc:postgresql://localhost:5432/stepik";
    //Имя пользователя БДо
    private final String dbName = "postgres";
    //Пароль
    private final String schemaPassword = "postgres";
    // Схема
    private final String schemaName = "contacts";
    // Автозавершение транзакции
    private boolean autoCommit = false;
    //
    private boolean active = false;

    public Database() {
        try {
            //Загружаем драйвер
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
        }

        this.active = false;
    }

    public void open(String dbName, String password, String schemaName, boolean autoCommit) {
        if (!this.active) {
            try {
                //Создаём соединение
                this.connection = DriverManager.getConnection(url, dbName, password);
                this.connection.setSchema(schemaName);
                this.connection.setAutoCommit(autoCommit);

                this.active = true;

            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public void open() {
        open(this.dbName, this.schemaPassword, this.schemaName, this.autoCommit);
    }

    public Connection getConnect() {
        return this.connection;
    }

    public boolean isActive(){
        return this.active;
    }

    public void checkConnection() {
        if (this.active) {
            try {
                this.active = connection.isValid(5);
            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public void commit() {
        boolean myAutoCommit;
        if (this.connection != null && this.active) {
            try {
                myAutoCommit = this.connection.getAutoCommit();
                if (!myAutoCommit) {
                    this.connection.commit();
                }
            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public void close() {
        if (this.connection != null && this.active) {
            try {
                connection.close();
                this.active = false;
            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public boolean tableExists(String tableName){
        if (this.active) {
            try (Statement statement = this.connection.createStatement()) {
                ResultSet result = statement.executeQuery(
                "SELECT to_regclass('"+ schemaName + "." + tableName + "') IS NOT NULL AS table_exists");
                if (result.next()) {
                    return result.getBoolean(1);
                }
            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
