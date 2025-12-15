package com.diego.menu;

import com.diego.clases.Cliente;
import com.diego.datos.ClientesDATOS;

import java.util.Scanner;

public class MenuClientes {

    public static void mostrar() {

        Scanner sc = new Scanner(System.in);
        ClientesDATOS datos = new ClientesDATOS();
        int op;

        do {
            System.out.println("--- CLIENTES ---");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. Volver");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Documento: ");
                String documento = sc.nextLine();

                System.out.print("Correo: ");
                String correo = sc.nextLine();

                System.out.print("Telefono: ");
                String telefono = sc.nextLine();

                Cliente c = new Cliente(nombre, documento, correo, telefono);
                datos.guardar(c);
            }

            if (op == 2) {
                datos.listar().forEach(System.out::println);
            }

        } while (op != 3);
    }
}
