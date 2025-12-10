package com.diego.datos;

import com.diego.conexion.DBConnection;
import com.diego.conexion.FileManager;
import com.diego.clases.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDATOS {

    private static final String RUTA = "archivos/empleados.txt";

    public void guardar(Empleado e) {
        try {
            Connection con = DBConnection.getConnection();
            con.createStatement().executeUpdate(
                "INSERT INTO empleados VALUES (" +
                        e.getId() + ",'" + e.getNombre() + "','" + e.getDocumento() + "','" +
                        e.getRol() + "','" + e.getCorreo() + "'," + e.getSalario() + ")"
            );
        } catch (Exception ex) {
            System.out.println("Error BD");
        }

        FileManager.guardarLinea(RUTA, e.getId()+"|"+e.getNombre());
        System.out.println("Guardado");
    }

    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM empleados");
            while (rs.next()) {
                lista.add(new Empleado(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6)
                ));
            }
        } catch (Exception e) { System.out.println("Error listando"); }
        return lista;
    }
}
