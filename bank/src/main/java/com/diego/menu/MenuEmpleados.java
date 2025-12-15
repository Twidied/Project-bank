package com.diego.menu;

import com.diego.clases.Empleado;
import com.diego.datos.EmpleadosDATOS;
import java.util.Scanner;

public class MenuEmpleados {

    public static void mostrar() {
        Scanner sc = new Scanner(System.in);
        EmpleadosDATOS d = new EmpleadosDATOS();
        int op;

        do {
            System.out.println("--- EMPLEADOS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Volver");
            op = sc.nextInt(); sc.nextLine();

            if (op == 1) {
                System.out.print("Nombre: "); String n = sc.nextLine();
                System.out.print("Documento: "); String doc = sc.nextLine();
                System.out.print("Rol: "); String r = sc.nextLine();
                System.out.print("Correo: "); String c = sc.nextLine();
                System.out.print("Salario: "); double s = sc.nextDouble();
                d.guardar(new Empleado(n, doc, r, c, s));
            }

            if (op == 2) d.listar().forEach(System.out::println);

        } while (op != 3);
    }
}
