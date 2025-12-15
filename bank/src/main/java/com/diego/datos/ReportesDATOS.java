package com.diego.datos;

import com.diego.clases.Cliente;
import com.diego.clases.Prestamo;
import com.diego.conexion.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class ReportesDATOS {

    public List<Prestamo> prestamosActivos() {
        return obtenerPrestamos()
                .stream()
                .filter(p -> p.getEstado().equalsIgnoreCase("pendiente"))
                .collect(Collectors.toList());
    }

    public List<Prestamo> prestamosVencidos() {
        return obtenerPrestamos()
                .stream()
                .filter(p -> p.getEstado().equalsIgnoreCase("vencido"))
                .collect(Collectors.toList());
    }

    public List<Cliente> clientesMorosos() {

        List<Cliente> clientes = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT DISTINCT c.* FROM clientes c " +
                "JOIN prestamos p ON c.id = p.cliente_id " +
                "WHERE p.estado = 'vencido'"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                clientes.add(new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("documento"),
                    rs.getString("correo"),
                    rs.getString("telefono")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error clientes morosos");
        }

        return clientes;
    }

    private List<Prestamo> obtenerPrestamos() {

        List<Prestamo> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM prestamos");
            ResultSet rs = ps.executeQuery();

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
            System.out.println("Error reportes");
        }

        return lista;
    }
}