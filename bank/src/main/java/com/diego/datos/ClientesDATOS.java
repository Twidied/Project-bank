package com.diego.datos;

import com.diego.clases.Cliente;
import com.diego.conexion.DBConnection;
import com.diego.conexion.FileManager;

import java.sql.*;
import java.util.*;

public class ClientesDATOS {

    public void guardar(Cliente c) {

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO clientes(nombre, documento, correo, telefono) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDocumento());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error BD clientes");
        }

        String texto =
                "Nombre: " + c.getNombre() + "\n" +
                "Documento: " + c.getDocumento() + "\n" +
                "Correo: " + c.getCorreo() + "\n" +
                "Telefono: " + c.getTelefono() + "\n" +
                "----------------------\n";

        FileManager.guardar("clientes.txt", texto);
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.prepareStatement("SELECT * FROM clientes").executeQuery();
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("documento"),
                        rs.getString("correo"),
                        rs.getString("telefono")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error listar clientes");
        }

        return lista;
    }
}
