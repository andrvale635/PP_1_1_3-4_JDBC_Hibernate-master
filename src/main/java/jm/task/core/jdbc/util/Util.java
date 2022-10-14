package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/newlesson1";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static Connection connection;

    public Util() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
