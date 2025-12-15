package com.diego.menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("========================================");
            System.out.println("        SISTEMA CREDIYA - BANCO          ");
            System.out.println("========================================");
            System.out.println(" 1. Módulo Empleados");
            System.out.println(" 2. Módulo Clientes");
            System.out.println(" 3. Módulo Préstamos");
            System.out.println(" 4. Módulo Pagos");
            System.out.println(" 5. Módulo Reportes");
            System.out.println(" 6. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> MenuEmpleados.mostrar();
                case 2 -> MenuClientes.mostrar();
                case 3 -> MenuPrestamos.mostrar();
                case 4 -> MenuPagos.mostrar();
                case 5 -> MenuReportes.mostrar();
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 6);
    }
}
