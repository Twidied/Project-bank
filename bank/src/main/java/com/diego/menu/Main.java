package com.diego.menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("--- MENU ---");
            System.out.println("1. Empleados");
            System.out.println("2. Clientes");
            System.out.println("3. Prestamos");
            System.out.println("4. Pagos");
            System.out.println("5. Reportes");
            System.out.println("6. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> MenuEmpleados.mostrar();
                case 2 -> MenuClientes.mostrar();
                case 3 -> MenuPrestamos.mostrar();
                case 4 -> MenuPagos.mostrar();
                case 5 -> MenuReportes.mostrar();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
