-- Crear la base de datos
CREATE DATABASE editor_texto;

-- Usar la base de datos
USE editor_texto;

-- Crear la tabla 'archivos'
CREATE TABLE archivos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contenido TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
