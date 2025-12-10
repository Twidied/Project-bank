package com.diego.datos;

import com.diego.conexion.DBConnection;
import com.diego.conexion.FileManager;
import com.diego.clases.Pago;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagosDATOS {

    public void guardar(Pago p) {
        try {
            DBConnection.getConnection().createStatement().executeUpdate(
                "INSERT INTO pagos VALUES ("+
                        p.getId()+","+p.getPrestamoId()+",'"+p.getFechaPago()+"',"+p.getMonto()+")"
            );
        } catch (Exception e) {}
        FileManager.guardarLinea("archivos/pagos.txt", p.getId()+"|"+p.getMonto());
        System.out.println("Guardado");
    }

    public List<Pago> listar(String sql) {
        List<Pago> lista = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
            while (rs.next()) lista.add(new Pago(
                    rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDouble(4)
            ));
        } catch (Exception e) {}
        return lista;
    }

    public List<Pago> porPrestamo(int id) { return listar("SELECT * FROM pagos WHERE prestamo_id="+id); }
    public List<Pago> todos() { return listar("SELECT * FROM pagos"); }
}
