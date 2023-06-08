/*package Utilidades;

import java.util.Scanner;
public class EditorApp {
    private Utilidades.FileManager fileManager;
    private DatabaseManager databaseManager;

    public EditorApp() {
        fileManager = new FileManager();
        databaseManager = new DatabaseManager();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Editor de Texto Básico");
            System.out.println("1. Crear nuevo archivo");
            System.out.println("2. Abrir archivo existente");
            System.out.println("3. Guardar archivo");
            System.out.println("4. Editar archivo");
            System.out.println("5. Eliminar archivo");
            System.out.println("6. Listar archivos");
            System.out.println("7. Conectar a la base de datos");
            System.out.println("8. Desconectar de la base de datos");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    createNewFile(scanner);
                    break;
                case 2:
                    openExistingFile(scanner);
                    break;
                case 3:
                    saveFile(scanner);
                    break;
                case 4:
                    editFile(scanner);
                    break;
                case 5:
                    deleteFile(scanner);
                    break;
                case 6:
                    listFiles();
                    break;
                case 7:
                    connectToDatabase();
                    break;
                case 8:
                    disconnectFromDatabase();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    private void createNewFile(Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo archivo: ");
        String fileName = scanner.nextLine();
        fileManager.createNewFile(fileName);
    }

    private void openExistingFile(Scanner scanner) {
        System.out.print("Ingrese el nombre del archivo a abrir: ");
        String fileName = scanner.nextLine();
        fileManager.openFile(fileName);
    }

    private void saveFile(Scanner scanner) {
        System.out.print("Ingrese el nombre del archivo a guardar: ");
        String fileName = scanner.nextLine();
        fileManager.saveFile(fileName);
    }

    private void editFile(Scanner scanner) {
        System.out.print("Ingrese el nombre del archivo a editar: ");
        String fileName = scanner.nextLine();
        fileManager.editFile(fileName);
    }

    private void deleteFile(Scanner scanner) {
        System.out.print("Ingrese el nombre del archivo a eliminar: ");
        String fileName = scanner.nextLine();
        fileManager.deleteFile(fileName);
    }

    private void listFiles() {
        FileManager fileManager = new FileManager();
        fileManager.listFiles();
    }

    private void connectToDatabase() {
        databaseManager.connect();
    }

    private void disconnectFromDatabase() {
        databaseManager.disconnect();
    }

    public static void main(String[] args) {
        EditorApp editorApp = new EditorApp();
        editorApp.run();
    }
}*/