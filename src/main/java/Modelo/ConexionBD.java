package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
   
    private static Connection cn = null;
    
    public static void main(String[] args) {
                
    }
        
    //Obtención de la conexión en la base de datos    
    public static Connection getConexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver"); //Driver de MySQL
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?ssl=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","n0m3l0"); //Inicializacion de la cadena de conexion
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
        return cn;
    }
    
    //Método para cerrar la conexión en la base de datos
    public static void closeConexion() {
        try{
            if (cn != null) {
                cn.close();
            }
        } catch(SQLException e){
            System.out.println("Error al cerrar la conexion a la base de datos");
            e.printStackTrace();
        } 
    }
    
}