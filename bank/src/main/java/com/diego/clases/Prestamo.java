package com.diego.clases;

public class Prestamo {

    private int id;
    private int clienteId;
    private int empleadoId;
    private double monto;
    private double interes;
    private int cuotas;
    private String estado;


    public Prestamo(int clienteId, int empleadoId, double monto, double interes, int cuotas) {
        this.clienteId = clienteId;
        this.empleadoId = empleadoId;
        this.monto = monto;
        this.interes = interes;
        this.cuotas = cuotas;
        this.estado = "pendiente";
    }

    public Prestamo(int id, int clienteId, int empleadoId, double monto,
                    double interes, int cuotas, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.empleadoId = empleadoId;
        this.monto = monto;
        this.interes = interes;
        this.cuotas = cuotas;
        this.estado = estado;
    }

    public int getClienteId() { return clienteId; }
    public int getEmpleadoId() { return empleadoId; }
    public double getMonto() { return monto; }
    public double getInteres() { return interes; }
    public int getCuotas() { return cuotas; }
    public String getEstado() { return estado; }

    public double getMontoTotal() {
        return monto + (monto * interes / 100);
    }

    public double getCuotaMensual() {
        return getMontoTotal() / cuotas;
    }

    @Override
    public String toString() {
        return id + " | Cliente:" + clienteId + " | Empleado:" + empleadoId +
               " | Total:" + getMontoTotal() +
               " | Cuota:" + getCuotaMensual() +
               " | Estado:" + estado;
    }
}
