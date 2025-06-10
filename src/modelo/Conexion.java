package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//crea la conexion con la base de datos
public class Conexion {
    private static Connection conexion;

    public static Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalcoches", "root", "root");
        }
        return conexion;
    }
}
