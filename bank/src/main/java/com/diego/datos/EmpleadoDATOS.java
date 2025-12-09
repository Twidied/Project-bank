package com.diego.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diego.clases.Empleado;
import com.diego.conexion.DBConnection;

public class EmpleadoDATOS {

    // guardar empleado en la BD
    public void guardarEmpleado(Empleado e) {
        String sql = "INSERT INTO empleados (id, nombre, documento, rol, correo, salario) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getId());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getDocumento());
            ps.setString(4, e.getRol());
            ps.setString(5, e.getCorreo());
            ps.setDouble(6, e.getSalario());

            ps.executeUpdate();
            System.out.println("Empleado guardado correctamente.");

        } catch (SQLException ex) {
            System.out.println("Error al guardar: " + ex.getMessage());
        }
    }

    // listar empleados
    public ArrayList<Empleado> listarEmpleados() {
        ArrayList<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado e = new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("documento"),
                        rs.getString("rol"),
                        rs.getString("correo"),
                        rs.getDouble("salario")
                );

                lista.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }

        return lista;
    }
}
