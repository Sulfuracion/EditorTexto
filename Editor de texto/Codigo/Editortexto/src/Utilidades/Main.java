package Utilidades;

import Utilidades.FileManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();

        int opcion = 0;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del archivo a crear:");
                    String nombreCrear = scanner.nextLine();
                    fileManager.createNewFile(nombreCrear);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del archivo a abrir:");
                    String nombreAbrir = scanner.nextLine();
                    fileManager.openFile(nombreAbrir);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del archivo a guardar:");
                    String nombreGuardar = scanner.nextLine();
                    fileManager.saveFile(nombreGuardar);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del archivo a editar:");
                    String nombreEditar = scanner.nextLine();
                    fileManager.editFile(nombreEditar);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del archivo a eliminar:");
                    String nombreEliminar = scanner.nextLine();
                    fileManager.deleteFile(nombreEliminar);
                    break;
                case 6:
                    fileManager.listFiles();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("---- Menú ----");
        System.out.println("1. Crear un archivo");
        System.out.println("2. Abrir un archivo");
        System.out.println("3. Guardar un archivo");
        System.out.println("4. Editar un archivo");
        System.out.println("5. Eliminar un archivo");
        System.out.println("6. Listar archivos");
        System.out.println("7. Salir");
        System.out.println("Ingrese el número de la opción deseada:");
    }
}
