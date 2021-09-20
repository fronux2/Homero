/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author marku
 */
public class LoginMVC extends ConexionBD{
    public boolean login(Login l){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select * from login where usuario = ? and contrasena = ?";
        
        
        try {
            ps = con.prepareStatement(sql);             
            ps.setString(1, l.getUsuario());
            ps.setString(2, l.getContrasena());           
            rs = ps.executeQuery();
            
            if(rs.next()){                                
                return true;
            }return false;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }       
     }
}
