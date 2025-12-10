package com.diego.conexion;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void guardarLinea(String ruta, String linea) {
        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write(linea + "\n");
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo: " + e.getMessage());
        }
    }
}
