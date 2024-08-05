/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class proyectodb {

    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl"; // Cambia según tu configuración
    private static final String JDBC_USER = "PROYECTODB";
    private static final String JDBC_PASSWORD = "Bilbo0711";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Cargar el controlador JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establecer la conexión
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos!");
            } else {
                System.out.println("Fallo al conectar a la base de datos!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
    
    
