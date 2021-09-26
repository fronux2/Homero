package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SisAppMVC extends ConexionBD{
    public boolean registrar(SisApp sis){
        CallableStatement ps = null;
        Connection con = getConexion();                 
        String sql = "{call sp_agregar_sisapp(?,?,?,?,?,?,?)}";   
        
        try {
            ps = con.prepareCall(sql);            
            ps.setString(1, sis.getSoftware_bd());
            ps.setString(2, sis.getNombre_sis());
            ps.setString(3, sis.getLenguaje_sis());
            ps.setString(4, sis.getProvedor_sistema());
            ps.setInt(5, sis.getServidor_id());
            ps.setInt(6, sis.getUsuario_id());
            ps.setInt(7, 1);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }   
    }      
}
