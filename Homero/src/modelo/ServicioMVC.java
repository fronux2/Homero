package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicioMVC extends ConexionBD{
    public boolean registrar(Servicio serv){
        CallableStatement ps = null;
        Connection con = getConexion();                 
        String sql = "{call sp_agregar_servicio(?,?,?,?)}";   
        
        try {
            ps = con.prepareCall(sql);            
            ps.setString(1, serv.getNombre_serv());
            ps.setString(2, serv.getTipo_serv());
            ps.setInt(3, serv.getSisApp());            
            ps.setInt(4, 1);
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
    
    public ArrayList<Servicio> listar(){
        ArrayList listaProducto = new ArrayList();
        Servicio ser;
        String sql = "select * from servicio";
        Connection con = getConexion();
        
        try {            
            //PreparedStatement ps = con.prepareCall(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){                
                
                ser = new Servicio();
                ser.setId_servicios(rs.getInt(1));
                ser.setNombre_serv(rs.getString(2));
                ser.setTipo_serv(rs.getString(3));
                ser.setSisApp(rs.getInt(4));
                ser.setActivo(rs.getString(5).charAt(0));
                
                
                listaProducto.add(ser);
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
