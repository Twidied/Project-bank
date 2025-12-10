package com.diego.menu;

import com.diego.datos.EmpleadosDATOS;
import com.diego.clases.Empleado;
import java.util.Scanner;

public class MenuEmpleados {

    public static void mostrar() {
        Scanner sc = new Scanner(System.in);
        EmpleadosDATOS d = new EmpleadosDATOS();
        int op;

        do {
            System.out.println("--- EMPLEADOS ---");
            System.out.println("1. Guardar");
            System.out.println("2. Listar");
            System.out.println("3. Volver");
            op = sc.nextInt(); sc.nextLine();

            if (op == 1) {
                System.out.print("Id: "); int id = sc.nextInt(); sc.nextLine();
                System.out.print("Nombre: "); String n = sc.nextLine();
                System.out.print("Doc: "); String doc = sc.nextLine();
                System.out.print("Rol: "); String rol = sc.nextLine();
                System.out.print("Correo: "); String c = sc.nextLine();
                System.out.print("Salario: "); double s = sc.nextDouble();

                d.guardar(new Empleado(id,n,doc,rol,c,s));
            }
            if (op == 2) d.listar().forEach(System.out::println);

        } while (op != 3);
    }
}
