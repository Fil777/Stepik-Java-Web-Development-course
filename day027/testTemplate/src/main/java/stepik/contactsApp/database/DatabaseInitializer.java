package stepik.contactsApp.database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private void createTables() {
        CreateDatabaseObjects.createTables(this.jdbcTemplate);
    }

    public void init() {
        createTables();
    }
}
