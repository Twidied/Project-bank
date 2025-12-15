package com.diego.datos;

import com.diego.clases.Pago;
import com.diego.conexion.DBConnection;
import com.diego.conexion.FileManager;

import java.sql.*;
import java.util.*;

public class PagosDATOS {

    public void guardar(Pago p) {

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO pagos(prestamo_id, monto) VALUES (?,?)");
            ps.setInt(1, p.getPrestamoId());
            ps.setDouble(2, p.getMonto());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error BD pagos");
        }

        String texto =
                "Prestamo ID: " + p.getPrestamoId() + "\n" +
                "Monto: " + p.getMonto() + "\n" +
                "----------------------\n";

        FileManager.guardar("pagos.txt", texto);
    }

    public List<Pago> listarPorPrestamo(int id) {
        List<Pago> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM pagos WHERE prestamo_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Pago(
                        rs.getInt("id"),
                        rs.getInt("prestamo_id"),
                        rs.getDouble("monto")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error listar pagos");
        }

        return lista;
    }
}
