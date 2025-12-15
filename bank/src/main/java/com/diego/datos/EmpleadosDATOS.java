package com.diego.datos;

import com.diego.clases.Empleado;
import com.diego.conexion.DBConnection;
import com.diego.conexion.FileManager;

import java.sql.*;
import java.util.*;

public class EmpleadosDATOS {

    public void guardar(Empleado e) {

        // BD
        try (Connection c = DBConnection.getConnection()) {
            String sql = "INSERT INTO empleados(nombre,documento,rol,correo,salario) VALUES(?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getDocumento());
            ps.setString(3, e.getRol());
            ps.setString(4, e.getCorreo());
            ps.setDouble(5, e.getSalario());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error BD empleados");
        }

        // TXT
        String texto =
                "Nombre: " + e.getNombre() + "\n" +
                "Documento: " + e.getDocumento() + "\n" +
                "Rol: " + e.getRol() + "\n" +
                "Correo: " + e.getCorreo() + "\n" +
                "Salario: " + e.getSalario() + "\n" +
                "----------------------\n";

        FileManager.guardar("empleados.txt", texto);
    }

    public List<Empleado> listar() {
        List<Empleado> l = new ArrayList<>();

        try (Connection c = DBConnection.getConnection()) {
            ResultSet rs = c.prepareStatement("SELECT * FROM empleados").executeQuery();
            while (rs.next()) {
                l.add(new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("documento"),
                        rs.getString("rol"),
                        rs.getString("correo"),
                        rs.getDouble("salario")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error listar empleados");
        }
        return l;
    }
}
