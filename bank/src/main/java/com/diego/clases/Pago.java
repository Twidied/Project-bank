package com.diego.clases;

public class Pago {

    private int id;
    private int prestamoId;
    private String fechaPago;
    private double monto;

    public Pago() {
    }

    public Pago(int id, int prestamoId, String fechaPago, double monto) {
        this.id = id;
        this.prestamoId = prestamoId;
        this.fechaPago = fechaPago;
        this.monto = monto;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPrestamoId() { return prestamoId; }
    public void setPrestamoId(int prestamoId) { this.prestamoId = prestamoId; }

    public String getFechaPago() { return fechaPago; }
    public void setFechaPago(String fechaPago) { this.fechaPago = fechaPago; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
}
