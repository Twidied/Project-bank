package com.diego.menu;

import com.diego.datos.ReportesDATOS;
import java.util.Scanner;

public class MenuReportes {

    public static void mostrar() {

        Scanner sc = new Scanner(System.in);
        ReportesDATOS r = new ReportesDATOS();
        int op;

        do {
            System.out.println("--- REPORTES ---");
            System.out.println("1. Prestamos activos");
            System.out.println("2. Prestamos vencidos");
            System.out.println("3. Clientes morosos");
            System.out.println("4. Volver");
            op = sc.nextInt();

            switch (op) {
                case 1 -> r.prestamosActivos().forEach(System.out::println);
                case 2 -> r.prestamosVencidos().forEach(System.out::println);
                case 3 -> r.clientesMorosos().forEach(System.out::println);
            }

        } while (op != 4);
    }
}
