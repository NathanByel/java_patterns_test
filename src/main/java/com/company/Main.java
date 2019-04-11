package com.company;

import com.company.DB.DBConnector;
import com.company.DB.DBHelper;
import com.company.DB.DeviceMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
//@ComponentScan({"com.company.domain"})
//@EntityScan("com.company.domain")
//@EnableJpaRepositories("com.company.repositories")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

       /* DeviceManager deviceManager = DeviceManager.getInstance();

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
        }*/
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
