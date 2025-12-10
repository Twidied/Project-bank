package com.diego.datos;

import com.diego.conexion.DBConnection;
import com.diego.conexion.FileManager;
import com.diego.clases.Prestamo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDATOS {

    public void guardar(Prestamo p) {
        try {
            DBConnection.getConnection().createStatement().executeUpdate(
                "INSERT INTO prestamos VALUES (" +
                        p.getId()+","+p.getClienteId()+","+p.getEmpleadoId()+","+
                        p.getMonto()+","+p.getInteres()+","+p.getCuotas()+",'"+
                        p.getFechaInicio()+"','"+p.getEstado()+"')"
            );
        } catch (Exception e) { System.out.println("Error BD"); }

        FileManager.guardarLinea("archivos/prestamos.txt", p.getId()+"|"+p.getMonto());
        System.out.println("Guardado");
    }

    public List<Prestamo> listar(String c) { // c = condición
        List<Prestamo> lista = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(c);
            while (rs.next()) lista.add(new Prestamo(
                    rs.getInt(1),rs.getInt(2),rs.getInt(3),
                    rs.getDouble(4),rs.getDouble(5),rs.getInt(6),
                    rs.getString(7),rs.getString(8)
            ));
        } catch (Exception e) {}
        return lista;
    }

    public List<Prestamo> activos() { return listar("SELECT * FROM prestamos WHERE estado='pendiente' AND DATE_ADD(fecha_inicio, INTERVAL cuotas MONTH)>=CURDATE()"); }

    public List<Prestamo> vencidos() { return listar("SELECT * FROM prestamos WHERE estado='pendiente' AND DATE_ADD(fecha_inicio, INTERVAL cuotas MONTH)<CURDATE()"); }
}
