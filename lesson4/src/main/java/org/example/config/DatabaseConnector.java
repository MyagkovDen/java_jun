package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static final String DB_URL = "jdbc:postgresql://localhost:5431/SchoolDB";
    public static final String DB_USERNAME = "school";
    public static final String DB_PASSWORD = "s123";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}
