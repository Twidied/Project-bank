package com.diego.menu;

import com.diego.datos.ClientesDATOS;
import com.diego.clases.Cliente;
import java.util.Scanner;

public class MenuClientes {

    public static void mostrar() {
        Scanner sc = new Scanner(System.in);
        ClientesDATOS d = new ClientesDATOS();
        int op;

        do {
            System.out.println("--- CLIENTES ---");
            System.out.println("1. Guardar");
            System.out.println("2. Listar");
            System.out.println("3. Volver");
            op = sc.nextInt(); sc.nextLine();

            if (op == 1) {
                System.out.print("Id: "); int id = sc.nextInt(); sc.nextLine();
                System.out.print("Nombre: "); String n = sc.nextLine();
                System.out.print("Doc: "); String doc = sc.nextLine();
                System.out.print("Correo: "); String c = sc.nextLine();
                System.out.print("Tel: "); String t = sc.nextLine();

                d.guardar(new Cliente(id,n,doc,c,t));
            }
            if (op == 2) d.listar().forEach(System.out::println);

        } while (op != 3);
    }
}
