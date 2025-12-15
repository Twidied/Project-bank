package com.diego.menu;

import com.diego.clases.Prestamo;
import com.diego.datos.PrestamosDATOS;

import java.util.Scanner;

public class MenuPrestamos {

    public static void mostrar() {

        Scanner sc = new Scanner(System.in);
        PrestamosDATOS datos = new PrestamosDATOS();
        int op;

        do {
            System.out.println("--- PRESTAMOS ---");
            System.out.println("1. Crear prestamo");
            System.out.println("2. Listar prestamos");
            System.out.println("3. Marcar como pagado");
            System.out.println("4. Volver");
            op = sc.nextInt();

            if (op == 1) {
                System.out.print("ID Cliente: ");
                int c = sc.nextInt();
                System.out.print("ID Empleado: ");
                int e = sc.nextInt();
                System.out.print("Monto: ");
                double m = sc.nextDouble();
                System.out.print("Interes (%): ");
                double i = sc.nextDouble();
                System.out.print("Cuotas: ");
                int q = sc.nextInt();

                Prestamo p = new Prestamo(c, e, m, i, q);
                datos.guardar(p);
            }

            if (op == 2) {
                datos.listar().forEach(System.out::println);
            }

            if (op == 3) {
                System.out.print("ID del prestamo: ");
                int id = sc.nextInt();
                datos.marcarPagado(id);
            }

        } while (op != 4);
    }
}
