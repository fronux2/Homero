
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SisBDMVC extends ConexionBD{
    public boolean registrar(SisBD sisbd){
        CallableStatement ps = null;
        Connection con = getConexion();                 
        String sql = "{call sp_agregar_sisbd(?,?,?,?,?,?)}";   
        
        try {
            ps = con.prepareCall(sql);            
            ps.setString(1, sisbd.getUsuario());
            ps.setString(2, sisbd.getContrasena());
            ps.setString(3, sisbd.getSoftware_bd());
            ps.setInt(4, sisbd.getServidor_id());
            ps.setInt(5, sisbd.getUsuario_id());            
            ps.setInt(6, 1);
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
    
    public ArrayList<SisBD> listar(){
        ArrayList listaProducto = new ArrayList();
        SisBD sisbd;
        String sql = "select * from SISBD";
        Connection con = getConexion();
        
        try {            
            //PreparedStatement ps = con.prepareCall(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){                
                
                sisbd = new SisBD();
                sisbd.setId_bd(rs.getInt(1));
                sisbd.setUsuario(rs.getString(2));
                sisbd.setContrasena(rs.getString(3));
                sisbd.setSoftware_bd(rs.getString(4));
                sisbd.setServidor_id(rs.getInt(5));
                sisbd.setUsuario_id(rs.getInt(6));                                
                sisbd.setActivo(rs.getString(7).charAt(0));
                listaProducto.add(sisbd);
            }
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }        
        }
        return listaProducto;
    }  
    
    public boolean modificar(Usuario us){
        PreparedStatement ps = null;
        Connection con = getConexion();        
        String sql = "UPDATE usuario SET rut_us = ?, dv_us = ?, nombre_us = ?, apaterno_us = ?, amaterno_us = ?,f_nac_us = to_date(?, 'dd/mm/yyyy'), telefono_us = ?, email_us = ?, direccion = ?, usuario = ?, contrasena = ?, perfiles_id_perfiles = ? where rut_us = ? and dv_us = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getRut_us());
            ps.setString(2, us.getDv_us());
            ps.setString(3, us.getNombre_us());
            ps.setString(4, us.getApaterno_us());
            ps.setString(5, us.getAmaterno_us());
            ps.setString(6, us.getFnaciemiento_us());
            ps.setString(7, us.getTelefono_us());
            ps.setString(8, us.getEmail_us());
            ps.setString(9, us.getDireccion());
            ps.setString(10, us.getUsuario());
            ps.setString(11, us.getContrasena());
            ps.setInt(12, us.getPerfil_id());
            ps.setString(13, us.getRut_us());
            ps.setString(14, us.getDv_us());
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
