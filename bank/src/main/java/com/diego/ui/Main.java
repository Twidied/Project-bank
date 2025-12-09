package com.diego.ui;

import com.diego.dao.EmpleadoDAO;
import com.diego.model.Empleado;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmpleadoDAO dao = new EmpleadoDAO();

        System.out.println("=== Registrar empleado ===");
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // limpiar

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Documento: ");
        String doc = sc.nextLine();

        System.out.print("Rol: ");
        String rol = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Salario: ");
        double salario = sc.nextDouble();

        Empleado emp = new Empleado(id, nombre, doc, rol, correo, salario);

        dao.guardarEmpleado(emp);  // guarda en BD

        System.out.println("\n--- Listado ---");
        for (Empleado e : dao.listarEmpleados()) {
            System.out.println(e.getNombre() + " - " + e.getDocumento());
        }
    }
}
