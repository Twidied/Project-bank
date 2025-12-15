package com.diego.datos;

import com.diego.clases.Prestamo;
import com.diego.conexion.DBConnection;
import com.diego.conexion.FileManager;

import java.sql.*;
import java.util.*;

public class PrestamosDATOS {

    public void guardar(Prestamo p) {

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO prestamos(cliente_id, empleado_id, monto, interes, cuotas, estado) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getClienteId());
            ps.setInt(2, p.getEmpleadoId());
            ps.setDouble(3, p.getMonto());
            ps.setDouble(4, p.getInteres());
            ps.setInt(5, p.getCuotas());
            ps.setString(6, p.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error BD prestamos");
        }

        String texto =
                "Cliente ID: " + p.getClienteId() + "\n" +
                "Empleado ID: " + p.getEmpleadoId() + "\n" +
                "Monto Total: " + p.getMontoTotal() + "\n" +
                "Cuota Mensual: " + p.getCuotaMensual() + "\n" +
                "Estado: " + p.getEstado() + "\n" +
                "----------------------\n";

        FileManager.guardar("prestamos.txt", texto);
    }

    public List<Prestamo> listar() {
        List<Prestamo> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.prepareStatement("SELECT * FROM prestamos").executeQuery();
            while (rs.next()) {
                lista.add(new Prestamo(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("empleado_id"),
                        rs.getDouble("monto"),
                        rs.getDouble("interes"),
                        rs.getInt("cuotas"),
                        rs.getString("estado")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error listar prestamos");
        }

        return lista;
    }

    public void marcarPagado(int id) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE prestamos SET estado='pagado' WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error actualizar estado");
        }
    }
}
