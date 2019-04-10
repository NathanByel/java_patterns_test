package com.company.DB;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection dbConnection;
    private static final String DB_PATH = "db.db";

    public static Connection getConnection() {
        if (dbConnection == null) {
            try {
                //Class.forName("org.sqlite.JDBC");
                dbConnection = DriverManager.getConnection(JDBC.PREFIX + DB_PATH);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dbConnection;
    }

    public static void close() {
        if (dbConnection != null) {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
