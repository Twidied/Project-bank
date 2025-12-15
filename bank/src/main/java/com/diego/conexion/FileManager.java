package com.diego.conexion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static final String CARPETA = "archivos";

    public static void guardar(String archivo, String contenido) {

        try {
            File dir = new File(CARPETA);
            if (!dir.exists()) {
                dir.mkdir();
            }

            FileWriter fw = new FileWriter(CARPETA + "/" + archivo, true);
            fw.write(contenido);
            fw.close();

        } catch (IOException e) {
            System.out.println("Error archivo: " + e.getMessage());
        }
    }
}
