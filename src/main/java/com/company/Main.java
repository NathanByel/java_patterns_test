package com.company;

import com.company.DB.DBConnector;
import com.company.DB.DBHelper;
import com.company.DB.DeviceMapper;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DeviceManager deviceManager = DeviceManager.getInstance();

        DBHelper dbHelper = new DBHelper(DBConnector.getConnection());
        dbHelper.createDevicesTableIfNotExist();

        // Test
        try {
            DeviceMapper deviceMapper = new DeviceMapper(DBConnector.getConnection());

            Device device = deviceMapper.findByDevID("1");

            device = new Device("1");
            device.setName("test");
            deviceMapper.insert(device);

            device = deviceMapper.findByDevID("1");

            deviceMapper.delete(device);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnector.close();
        }

/*
        deviceManager.addDevice("1");
        deviceManager.addDevice("2");

        try {
            deviceManager.sendCommandToDevice("2", "open");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            deviceManager.sendCommandToDevice("10", "open");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            deviceManager.sendCommandToDevice("1", "close");
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        //result = deviceManager.sendCommandSequenceToDevice("2", "close", "block");
        //System.out.println(result);
    }
}
