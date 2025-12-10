package com.diego.datos;

import com.diego.conexion.DBConnection;
import com.diego.conexion.FileManager;
import com.diego.clases.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDATOS {

    private static final String RUTA = "archivos/clientes.txt";

    public void guardar(Cliente c) {
        try {
            Connection con = DBConnection.getConnection();
            con.createStatement().executeUpdate(
                "INSERT INTO clientes VALUES (" +
                        c.getId() + ",'" + c.getNombre() + "','" + c.getDocumento() + "','" +
                        c.getCorreo() + "','" + c.getTelefono() + "')"
            );
        } catch (Exception ex) { System.out.println("Error BD"); }

        FileManager.guardarLinea(RUTA, c.getId()+"|"+c.getNombre());
        System.out.println("Guardado");
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getConnection().createStatement().executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)
                ));
            }
        } catch (Exception e) {}
        return lista;
    }
}
