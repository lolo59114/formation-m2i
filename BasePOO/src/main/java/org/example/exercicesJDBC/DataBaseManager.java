package org.example.exercicesJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private final String BASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "root";
    private final String FULL_URL;

    public DataBaseManager(String schema) {
        FULL_URL = BASE_URL + "?currentSchema=" + schema;
    }

    public DataBaseManager() {
        FULL_URL = BASE_URL;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(FULL_URL, USER, PASSWORD);
    }
}
