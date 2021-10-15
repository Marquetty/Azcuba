/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Lenovo
 *
 *  Comunicación con la BD
 */

public class Auth {

    /*
    * De MySQL 8.0.4+
    * cambiar driver com.mysql.jdbc.Driver -> com.mysql.cj.jdbc.Driver
    * */

    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "azcuba";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";

    private static Connection conn = null;

    public Connection conectarMySQL() {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Conectado BD --> AZCUBA");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void cerrar() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
   
    

}
