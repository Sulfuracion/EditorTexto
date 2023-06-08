package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;

    public void connect() {
        try {
            // Configurar los detalles de la conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/editor_texto";
            String username = "root";
            String password = "";

            // Establecer la conexión
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Conectado a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Desconectado de la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectarse de la base de datos: " + e.getMessage());
        }
    }

    public void createFile(File file) {
        try {
            // Preparar la consulta SQL
            String sql = "INSERT INTO archivos (nombre, contenido) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, file.getName());
            statement.setString(2, file.getContent());

            // Ejecutar la consulta
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Archivo creado en la base de datos: " + file.getName());
            } else {
                System.out.println("No se pudo crear el archivo en la base de datos");
            }

            // Cerrar el PreparedStatement
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al crear el archivo en la base de datos: " + e.getMessage());
        }
    }

    public void updateFile(File file) {
        try {
            // Preparar la consulta SQL
            String sql = "UPDATE archivos SET contenido = ? WHERE nombre = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, file.getContent());
            statement.setString(2, file.getName());

            // Ejecutar la consulta
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Archivo actualizado en la base de datos: " + file.getName());
            } else {
                System.out.println("No se pudo actualizar el archivo en la base de datos");
            }

            // Cerrar el PreparedStatement
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el archivo en la base de datos: " + e.getMessage());
        }
    }

    public void deleteFile(String fileName) {
        try {
            // Preparar la consulta SQL
            String sql = "DELETE FROM archivos WHERE nombre = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fileName);

            // Ejecutar la consulta
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Archivo eliminado de la base de datos: " + fileName);
            } else {
                System.out.println("No se pudo eliminar el archivo de la base de datos");
            }

            // Cerrar el PreparedStatement
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el archivo de la base de datos: " + e.getMessage());
        }
    }

    public File getFile(String fileName) {
        try {
            // Preparar la consulta SQL
            String sql = "SELECT contenido FROM archivos WHERE nombre = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fileName);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String contenido = resultSet.getString("contenido");
                System.out.println("Obteniendo archivo de la base de datos: " + fileName);
                return new File(fileName, contenido);
            } else {
                System.out.println("No se encontró el archivo en la base de datos");
            }

            // Cerrar el ResultSet y el PreparedStatement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el archivo de la base de datos: " + e.getMessage());
        }

        return null;
    }

    public List<File> getAllFiles() {
        List<File> files = new ArrayList<>();

        try {
            // Preparar la consulta SQL
            String sql = "SELECT nombre, contenido FROM archivos";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String contenido = resultSet.getString("contenido");
                files.add(new File(nombre, contenido));
            }

            System.out.println("Obteniendo todos los archivos de la base de datos");

            // Cerrar el ResultSet y el PreparedStatement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los archivos de la base de datos: " + e.getMessage());
        }

        return files;
    }
}
