package ru.Aidar.SQL.JDBC.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToBd {
    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Гринатом";
    static final String DB_USER = "postgres";
    static final String DB_PASS = "A140220";
    static final String DB_DRIVER = "org.postgresql.Driver";

    public static java.sql.Connection getDBConnection() {
        java.sql.Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public static void main(String[] argv) {
        System.out.println("Testing ConnectionToBd to PostgreSQL JDBC");
        java.sql.Connection connection = getDBConnection();
        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make ConnectionToBd to database");
        }
    }
}
