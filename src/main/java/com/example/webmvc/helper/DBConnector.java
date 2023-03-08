package com.example.webmvc.helper;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
@Component
public class DBConnector {
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_crud",
                    "root", "daraudi1");
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        return connection;
    }
}
