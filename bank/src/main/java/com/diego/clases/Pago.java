package com.diego.clases;

public class Pago {

    private int id;
    private int prestamoId;
    private double monto;

    // registrar pago
    public Pago(int prestamoId, double monto) {
        this.prestamoId = prestamoId;
        this.monto = monto;
    }

    // listar pagos
    public Pago(int id, int prestamoId, double monto) {
        this.id = id;
        this.prestamoId = prestamoId;
        this.monto = monto;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return id + " | Prestamo:" + prestamoId + " | Monto:" + monto;
    }
}
