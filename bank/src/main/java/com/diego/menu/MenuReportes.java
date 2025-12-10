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
            System.out.println("1. Activos");
            System.out.println("2. Vencidos");
            System.out.println("3. Morosos");
            System.out.println("4. Volver");
            op = sc.nextInt();

            switch (op) {
                case 1 -> r.activos().forEach(System.out::println);
                case 2 -> r.vencidos().forEach(System.out::println);
                case 3 -> r.morosos().forEach(System.out::println);
            }
        } while (op != 4);
    }
}
