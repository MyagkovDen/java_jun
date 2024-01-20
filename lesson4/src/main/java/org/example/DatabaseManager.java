package org.example;

import org.example.config.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    public static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS SchoolDB";
    DatabaseConnector databaseConnector;

    public DatabaseManager(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public void createDatabase() {
        try (Connection connection = databaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(CREATE_DATABASE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable() {
        try (Connection connection = databaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            String createTableCourses = """
                    CREATE TABLE IF NOT EXISTS courses
                    (
                       id SERIAL PRIMARY KEY,
                       title varchar(100) NOT NULL,
                       duration int NOT NULL
                       );
                             """;
            statement.execute(createTableCourses);
            System.out.println("Table Courses successfully created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
