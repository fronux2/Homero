package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {
    Connection con = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String nombre = "homero4";
        String contrasena = "homero4";
        public Connection getConexion(){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(url, nombre, contrasena);
                con.setAutoCommit(false);
                if(con != null){
                    System.out.println("Conexion correcta");                   
                }
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null,"Error de Conexion"+ e.getMessage());
            }
            return con;
        }        
}
