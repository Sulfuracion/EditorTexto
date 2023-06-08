package Utilidades;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class FileManager {
    public FileManager() {
        // Configurar los detalles de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/editor_texto";
        String username = "root";
        String password = "";

        try {
            // Establecer la conexión
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
    }
    public void createNewFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("Se ha creado un nuevo archivo: " + fileName);
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void openFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
                System.out.println("Archivo abierto: " + fileName);
            } catch (IOException e) {
                System.out.println("Error al abrir el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    public void saveFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            System.out.println("Archivo guardado: " + fileName);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void editFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese el nuevo contenido del archivo:");
                String content = scanner.nextLine();

                FileWriter writer = new FileWriter(file);
                writer.write(content);
                writer.close();

                System.out.println("Archivo editado: " + fileName);
            } catch (IOException e) {
                System.out.println("Error al editar el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Archivo eliminado: " + fileName);
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    public void listFiles(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files.length > 0) {
                System.out.println("Archivos en el directorio " + directoryPath + ":");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("El directorio no existe.");
        }
    }

    public void listFiles() {
    }

    public void saveFile(String fileName) {
    }
}
