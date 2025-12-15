package com.diego.clases;

public class Empleado {
    private int id;
    private String nombre, documento, rol, correo;
    private double salario;

    public Empleado(String n, String d, String r, String c, double s) {
        nombre = n; documento = d; rol = r; correo = c; salario = s;
    }

    public Empleado(int i, String n, String d, String r, String c, double s) {
        id = i; nombre = n; documento = d; rol = r; correo = c; salario = s;
    }

    public String getNombre(){return nombre;}
    public String getDocumento(){return documento;}
    public String getRol(){return rol;}
    public String getCorreo(){return correo;}
    public double getSalario(){return salario;}

    public String toString() {
        return id+" | "+nombre+" | "+documento+" | "+rol+" | "+correo+" | "+salario;
    }
}
