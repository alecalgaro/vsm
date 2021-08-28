package Clases;

/**
 * @author Calgaro Alejandro
 */

import java.sql.*;

/*
Ésta clase es para conectarse con la base de datos
Por ahora se va a usar una base de datos local con mysql y xampp, más adelante se podría usar una base de datos remota para usar el software en más de una computadora
*/

public class Conexion {
    //Conexión local.
    public static Connection conectar(){
        try {   //La base de datos que cree se llama "vsm"
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/vsm?serverTimezone=UTC", "root", "");
                                                                                    //?serverTimezone=UTC es por la zona horaria, sino provoca un error.
            return cn;                                 
        } catch (SQLException e) {  //La excepción que queremos capturar es un "SQLException"
            System.out.println("Error en la conexión local" + e);
        }
         return (null);
    }
}
