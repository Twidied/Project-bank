package com.diego.menu;

import com.diego.datos.PagosDATOS;
import com.diego.clases.Pago;
import java.util.Scanner;

public class MenuPagos {

    public static void mostrar() {
        Scanner sc = new Scanner(System.in);
        PagosDATOS d = new PagosDATOS();
        int op;

        do {
            System.out.println("--- PAGOS ---");
            System.out.println("1. Guardar");
            System.out.println("2. Ver por préstamo");
            System.out.println("3. Ver todos");
            System.out.println("4. Volver");
            op = sc.nextInt(); sc.nextLine();

            if (op == 1) {
                System.out.print("Id: "); int id = sc.nextInt();
                System.out.print("Prestamo: "); int pr = sc.nextInt(); sc.nextLine();
                System.out.print("Fecha: "); String f = sc.nextLine();
                System.out.print("Monto: "); double m = sc.nextDouble();
                d.guardar(new Pago(id,pr,f,m));
            }
            if (op == 2) {
                System.out.print("Prestamo: "); int pr = sc.nextInt();
                d.porPrestamo(pr).forEach(System.out::println);
            }
            if (op == 3) d.todos().forEach(System.out::println);

        } while (op != 4);
    }
}
