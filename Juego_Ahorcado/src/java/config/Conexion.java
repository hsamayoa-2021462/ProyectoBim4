package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/DB_Ahorcado?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "quintom";
    private static final String PASS = "admin"; 

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
