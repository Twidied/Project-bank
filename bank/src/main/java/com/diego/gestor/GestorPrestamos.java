package com.diego.gestor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.diego.clases.Pago;
import com.diego.clases.Prestamo;
import com.diego.clases.prestamo;
import com.diego.conexion.DBConnection;
import com.diego.datos.PrestamosDATOS;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

public class GestorPrestamos {

    public List<Prestamo> cargarPrestamos() throws SQLException {
        List<Prestamo> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            PreparableStatement ps = (PreparableStatement) con.prepareStatement(
                "SELECT * FROM prestamos");
            ResultSet rs = ps.executeQuery();
    
            while (rs.next()) {
                    Prestamo p = new Prestamo(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("empleado_id"),
                        rs.getDouble("monto"),
                        rs.getDouble("Interes"),
                        rs.getInt("cuotas"),
                        rs.getString("estado")
                );
                lista.add(p);
        }
    } catch (Exception e) {
        System.out.println("Errorrrrr al cargar prestamos:" + e.getMessage());
    }
    return lista;
}

//vencidos
    public List<Prestamo> filtrarPrestamosVencidos(List<Prestamo> lista) {
        try {
            return.lista.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase("Vencido"))
                .collect(Collectors.toList());
        
        } catch (Exception e) {
            System.out.println("ERRORRRRR al filtrar prestamos Vencidos");
            return new ArrayList<>();
        }
    }
//activos
    public List<Prestamo> filtrarPrestamosActivos(List<Prestamo> lista) {
        try {
            return.lista.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase("Pendiente"))
                .collect(Collectors.toList());
        
        } catch (Exception e) {
            System.out.println("ERRORRRRR al filtrar prestamos activos");
            return new ArrayList<>();
        }
    }

    public void mostrarResumen(List<Prestamo> lista) {
        try {
            long activos = filtrarPrestamosActivos(lista).size();
            long vencidos = filtrarPrestamosVencidos(lista).size();
            
            double montoTotal = lista.stream()
                .mapToDouble(Prestamo = getmonto)
                .sum();

            System.out.println("----- Prestamo ----");
            System.out.println("Prestamos activos");

//falta


        }
    }


