CREATE DATABASE IF NOT EXISTS mi_aplicacion_db; -- Si no la creaste antes, hazlo aquí.
USE mi_aplicacion_db; -- ¡MUY IMPORTANTE! Selecciona tu base de datos para crear la tabla en ella

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
    contrasena_hash VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);