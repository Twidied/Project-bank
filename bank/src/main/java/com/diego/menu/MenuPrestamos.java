package com.diego.menu;

import com.diego.datos.PrestamosDATOS;
import com.diego.clases.Prestamo;
import java.util.Scanner;

public class MenuPrestamos {

    public static void mostrar() {
        Scanner sc = new Scanner(System.in);
        PrestamosDATOS d = new PrestamosDATOS();
        int op;

        do {
            System.out.println("--- PRESTAMOS ---");
            System.out.println("1. Guardar");
            System.out.println("2. Activos");
            System.out.println("3. Vencidos");
            System.out.println("4. Volver");
            op = sc.nextInt(); sc.nextLine();

            if (op == 1) {
                System.out.print("Id: "); int id = sc.nextInt();
                System.out.print("Cliente: "); int c = sc.nextInt();
                System.out.print("Empleado: "); int e = sc.nextInt();
                System.out.print("Monto: "); double m = sc.nextDouble();
                System.out.print("Int: "); double i = sc.nextDouble();
                System.out.print("Cuotas: "); int cu = sc.nextInt(); sc.nextLine();
                System.out.print("Fecha: "); String f = sc.nextLine();
                d.guardar(new Prestamo(id,c,e,m,i,cu,f,"pendiente"));
            }
            if (op == 2) d.activos().forEach(System.out::println);
            if (op == 3) d.vencidos().forEach(System.out::println);

        } while (op != 4);
    }
}
