package com.company.DB;

import com.company.Device;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DeviceMapper {
    private Map<String, Device> identityMap = new HashMap<>();
    private PreparedStatement selectStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement deleteStatement;

    public DeviceMapper(Connection dbConnection) throws SQLException {
        selectStatement = dbConnection.prepareStatement(
                "SELECT " +
                        DBHelper.DEVICES_COLUMN_DEV_ID + ", " +
                        DBHelper.DEVICES_COLUMN_NAME +
                        " FROM " + DBHelper.DEVICES_TABLE +
                        " WHERE " + DBHelper.DEVICES_COLUMN_DEV_ID + " = ?");

        insertStatement = dbConnection.prepareStatement(
                "INSERT INTO " + DBHelper.DEVICES_TABLE +
                        " (" + DBHelper.DEVICES_COLUMN_DEV_ID + ", " + DBHelper.DEVICES_COLUMN_NAME + ") VALUES (?, ?); ");

        updateStatement = dbConnection.prepareStatement(
                "UPDATE " + DBHelper.DEVICES_TABLE +
                        " SET " + DBHelper.DEVICES_COLUMN_NAME + " = ? " +
                        " WHERE " + DBHelper.DEVICES_COLUMN_DEV_ID + " = ?");

        deleteStatement = dbConnection.prepareStatement(
                "DELETE FROM " + DBHelper.DEVICES_TABLE +
                        " WHERE " + DBHelper.DEVICES_COLUMN_DEV_ID + " = ?");
    }

    public Device findByDevID(String devID) throws SQLException {
        if (identityMap.containsKey(devID)) {
            return identityMap.get(devID);
        }

        selectStatement.setString(1, devID);

        try (ResultSet resultSet = selectStatement.executeQuery()) {
            while (resultSet.next()) {
                int devIdColumn = resultSet.findColumn(DBHelper.DEVICES_COLUMN_DEV_ID);
                int nameColumn = resultSet.findColumn(DBHelper.DEVICES_COLUMN_NAME);

                Device device = new Device(resultSet.getString(devIdColumn));
                device.setName(resultSet.getString(nameColumn));
                identityMap.put(devID, device);
                return device;
            }
        }
        return null;
    }

    public void insert(Device device) throws SQLException {
        insertStatement.setString(1, device.getDevID());
        insertStatement.setString(2, device.getName());
        insertStatement.execute();
    }

    public void update(Device device) throws SQLException {
        identityMap.remove(device.getDevID());
        updateStatement.setString(1, device.getName());
        updateStatement.setString(2, device.getDevID());
        updateStatement.execute();
    }

    public void delete(Device device) throws SQLException {
        identityMap.remove(device.getDevID());
        deleteStatement.setString(1, device.getDevID());
        deleteStatement.execute();
    }
}
