package com.diego.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crediya_db",
                    "root",
                    "admin123"
            );
        } catch (SQLException e) {
            System.out.println("Error conexion: " + e.getMessage());
            return null;
        }
    }
}