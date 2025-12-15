package com.diego.clases;

public class Cliente {

    private int id;
    private String nombre;
    private String documento;
    private String correo;
    private String telefono;

    public Cliente(String n, String d, String c, String t) {
        nombre = n;
        documento = d;
        correo = c;
        telefono = t;
    }

    public Cliente(int i, String n, String d, String c, String t) {
        id = i;
        nombre = n;
        documento = d;
        correo = c;
        telefono = t;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + documento + " | " + correo + " | " + telefono;
    }
}
