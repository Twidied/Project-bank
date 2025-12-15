package com.diego.menu;

import com.diego.clases.Pago;
import com.diego.datos.PagosDATOS;

import java.util.Scanner;

public class MenuPagos {

    public static void mostrar() {

        Scanner sc = new Scanner(System.in);
        PagosDATOS datos = new PagosDATOS();
        int op;

        do {
            System.out.println("--- PAGOS ---");
            System.out.println("1. Registrar pago");
            System.out.println("2. Ver pagos por prestamo");
            System.out.println("3. Volver");
            op = sc.nextInt();

            if (op == 1) {
                System.out.print("ID Prestamo: ");
                int id = sc.nextInt();
                System.out.print("Monto a pagar: ");
                double m = sc.nextDouble();

                datos.guardar(new Pago(id, m));
            }

            if (op == 2) {
                System.out.print("ID Prestamo: ");
                int id = sc.nextInt();
                datos.listarPorPrestamo(id)
                     .forEach(System.out::println);
            }

        } while (op != 3);
    }
}