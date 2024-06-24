package org.example.exercicesJDBC;

public class JDBCConfig {
    private final String BASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "root";
    private final String FULL_URL;

    public JDBCConfig(String schema) {
        FULL_URL = BASE_URL + "?currentSchema=" + schema;
    }

    public JDBCConfig() {
        FULL_URL = BASE_URL;
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getFULL_URL() {
        return FULL_URL;
    }
}
