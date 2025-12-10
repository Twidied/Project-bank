package com.diego.datos;

import com.diego.conexion.DBConnection;
import com.diego.clases.Prestamo;
import com.diego.clases.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportesDATOS {

    public List<Prestamo> activos() {
        return consultar("SELECT * FROM prestamos WHERE estado='pendiente' AND DATE_ADD(fecha_inicio, INTERVAL cuotas MONTH)>=CURDATE()");
    }

    public List<Prestamo> vencidos() {
        return consultar("SELECT * FROM prestamos WHERE estado='pendiente' AND DATE_ADD(fecha_inicio, INTERVAL cuotas MONTH)<CURDATE()");
    }

    public List<Cliente> morosos() {
        List<Cliente> lista = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(
                "SELECT DISTINCT c.* FROM clientes c JOIN prestamos p ON c.id=p.cliente_id WHERE p.estado='pendiente' AND DATE_ADD(p.fecha_inicio, INTERVAL p.cuotas MONTH)<CURDATE()"
            );
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)
                ));
            }
        } catch (Exception e) {}
        return lista;
    }

    private List<Prestamo> consultar(String sql) {
        List<Prestamo> lista = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                lista.add(new Prestamo(
                        rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4),
                        rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getString(8)
                ));
            }
        } catch (Exception e) {}
        return lista;
    }
}
