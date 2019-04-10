package com.company.DB;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DBHelper {
    public static final String COLUMN_ID = "_id";
    public static final String DEVICES_TABLE = "Devices";
    public static final String DEVICES_COLUMN_DEV_ID = "dev_id";
    public static final String DEVICES_COLUMN_NAME = "name";
    private Connection dbConnection;

    public DBHelper(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    /**
     * Devices table.
     * <p>
     * CREATE TABLE IF NOT EXISTS Devices(
     * _id INTEGER PRIMARY KEY AUTOINCREMENT,
     * dev_id TEXT,
     * name TEXT,
     * UNIQUE(dev_id)
     * )
     */
    public void createDevicesTableIfNotExist() {
        try {
            Statement statement = dbConnection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS " + DEVICES_TABLE +
                            " (" +
                            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            DEVICES_COLUMN_DEV_ID + " TEXT, " +
                            DEVICES_COLUMN_NAME + " TEXT, " +
                            "UNIQUE(" + DEVICES_COLUMN_DEV_ID + ")" +
                            ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDevicesTable() {
        try {
            Statement statement = dbConnection.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + DEVICES_TABLE + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
