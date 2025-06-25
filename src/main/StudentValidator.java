package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentValidator {

    public static Student validarDatos() {
        String nombre = null;
        String correo = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("student.env"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("STUDENT_NAME=")) {
                    nombre = linea.substring("STUDENT_NAME=".length()).trim();
                } else if (linea.startsWith("STUDENT_EMAIL=")) {
                    correo = linea.substring("STUDENT_EMAIL=".length()).trim();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo student.env", e);
        }

        if (nombre == null || correo == null || nombre.isEmpty() || correo.isEmpty()) {
            throw new IllegalStateException("❌ Debes completar STUDENT_NAME y STUDENT_EMAIL en student.env");
        }

        return new Student(nombre, correo);
    }

    public record Student(String nombre, String correo) {}
}
