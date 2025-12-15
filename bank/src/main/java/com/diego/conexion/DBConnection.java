package com.diego.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3309/crediya_db",
                "root",
                "admin123"
            );
        } catch (Exception e) {
            System.out.println("Error conexion BD: " + e.getMessage());
            return null;
        }
    }
}
