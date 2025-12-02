package sistemas.operativos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionBD {

    // Información de la base de datos
    private static final String URL = "jdbc:mysql://localhost:80/bd_sop";
    private static final String USUARIO = "root"; // Usuario por defecto de XAMPP para MySQL
    private static final String CONTRASENA = ""; // Contraseña por defecto de XAMPP para MySQL (vacía)

    public static void main(String[] args) {
        // Datos que quieres insertar
        String nombre = "Juan Pérez";
        String email = "juan.perez@example.com";

        // Llama al método para insertar los datos
        insertarUsuario(nombre, email);
    }

    /**
     * Este método se encarga de establecer la conexión a la base de datos
     * y de insertar un nuevo usuario.
     * @param nombre El nombre del usuario a insertar.
     * @param email El email del usuario a insertar.
     */
    public static void insertarUsuario(String nombre, String email) {
        Connection conexion = null; // Objeto para la conexión a la base de datos
        PreparedStatement ps = null; // Objeto para ejecutar sentencias SQL preparadas

        try {
            // 1. Cargar el controlador JDBC (No es estrictamente necesario en versiones modernas de Java,
            // pero es una buena práctica para asegurar que el controlador esté disponible)
            // Class.forName("com.mysql.cj.jdbc.Driver"); // Para MySQL Connector/J 8.x en adelante
            // Class.forName("com.mysql.jdbc.Driver"); // Para versiones antiguas de MySQL Connector/J

            // 2. Establecer la conexión a la base de datos
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a la base de datos.");

            // 3. Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
            ps = conexion.prepareStatement(sql);

            // 4. Asignar los valores a los parámetros de la sentencia preparada
            ps.setString(1, nombre); // El primer '?' se reemplaza por el valor de 'nombre'
            ps.setString(2, email);  // El segundo '?' se reemplaza por el valor de 'email'

            // 5. Ejecutar la sentencia de inserción
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Datos insertados correctamente en la tabla usuarios.");
            } else {
                System.out.println("No se pudieron insertar los datos.");
            }

        } catch (SQLException e) {
            // Manejo de excepciones en caso de error de SQL
            System.err.println("Error de SQL al conectar o insertar datos: " + e.getMessage());
            e.printStackTrace(); // Imprime el rastro completo de la excepción para depuración
        } finally {
            // 6. Cerrar los recursos (PreparedStatement y Connection)
            // Esto es crucial para liberar los recursos de la base de datos
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexión a la base de datos cerrada.");
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}