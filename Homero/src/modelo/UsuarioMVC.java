/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;



public class UsuarioMVC extends ConexionBD{
    
    public boolean registrar(Usuario us){
        
        CallableStatement ps = null;
        Connection con = getConexion();                 
        String sql = "{call sp_agregar_usuario(?,?,?,?,?,?,?,?,?,?,?,?,?)}";  
        try {
            ps = con.prepareCall(sql);
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
            ps.setInt(13, 1);
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
    
    
    public boolean modificar(Usuario us){
        PreparedStatement ps = null;
        Connection con = getConexion();        
        String sql = "UPDATE usuario SET rut_us = ?, dv_us = ?, nombre_us = ?, apaterno_us = ?, amaterno_us = ?,f_nac_us = to_date(?, 'dd/mm/yyyy'), telefono_us = ?, email_us = ?, direccion = ?, usuario = ?, contrasena = ?, perfiles_id_perfiles = ?, activo = ? where rut_us = ? and dv_us = ?";
        
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
            ps.setInt(13, us.getActivo());
            ps.setString(14, us.getRut_us());
            ps.setString(15, us.getDv_us());
            
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
    
    public boolean eliminar(Usuario us){
        PreparedStatement ps = null;
        Connection con = getConexion();        
        String sql = "DELETE FROM usuario WHERE rut_us=? ";
        
        try {
            ps = con.prepareStatement(sql);            
            ps.setString(1, us.getRut_us());
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
    
    public boolean buscar(Usuario us){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        //String sql = "select * from usuario where rut_us = ? and dv_us = ?";
        String sql = "SELECT u.id_usuario, u.rut_us, u.dv_us, u.nombre_us, u.apaterno_us, u.amaterno_us, u.f_nac_us, u.telefono_us, u.email_us, u.direccion, u.usuario, u.contrasena, u.perfiles_id_perfiles, p.detalle, u.activo FROM usuario u JOIN perfiles p ON(perfiles_id_perfiles = id_perfiles) where rut_us = ? and dv_us = ?";
        
        try {
            ps = con.prepareStatement(sql); 
            ps.setString(1, us.getRut_us());
            ps.setString(2, us.getDv_us());
            rs = ps.executeQuery();
            
            if(rs.next()){               
                               
                us.setRut_us(rs.getString("rut_us"));
                us.setDv_us(rs.getString("dv_us"));
                us.setNombre_us(rs.getString("nombre_us"));
                us.setApaterno_us(rs.getString("apaterno_us"));
                us.setAmaterno_us(rs.getString("amaterno_us"));
                us.setFnaciemiento_us(rs.getString("f_nac_us"));
                us.setTelefono_us(rs.getString("telefono_us"));
                us.setEmail_us(rs.getString("email_us"));
                us.setDireccion(rs.getString("direccion"));
                us.setUsuario(rs.getString("usuario"));
                us.setContrasena(rs.getString("contrasena"));
                us.setPerfil_id(rs.getInt("perfiles_id_perfiles"));
                us.setDetalle(rs.getString("detalle"));
                us.setActivo(rs.getString("activo").charAt(0));
                return true;
            }else{return false;}
            
        } catch (Exception e) {
        }finally{
            try {
                con.close();
                System.out.println("Conexion cerrada");
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        
        return false;
     }
    
    public boolean buscarRut(Usuario us){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select rut_us from usuario where rut_us = ?";
        
        try {
            ps = con.prepareStatement(sql); 
            ps.setString(1, us.getRut_us());           
            rs = ps.executeQuery();
            
            if(rs.next()){    
                us.setRut_us(rs.getString("rut_us"));
                return true;
            }else{return false;}
            
        } catch (Exception e) {
        }finally{
            try {
                con.close();
                System.out.println("Conexion cerrada");
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        
        return false;
     }
    
    
    public boolean buscarLogin(Usuario us){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select * from usuario where usuario = ? and contrasena = ?";
        
        try {
            ps = con.prepareStatement(sql); 
            ps.setString(1, us.getUsuario());    
            ps.setString(2, us.getContrasena());
            rs = ps.executeQuery();
            
            if(rs.next()){                    
                us.setUsuario(rs.getString("usuario"));
                us.setContrasena(rs.getString("contrasena"));
                us.setPerfil_id(rs.getInt("perfiles_id_perfiles"));
                us.setNombre_us(rs.getString("nombre_us"));
                us.setApaterno_us(rs.getString("apaterno_us"));
                return true;
            }else{return false;}
            
        } catch (Exception e) {
        }finally{
            try {
                con.close();
                System.out.println("Conexion cerrada");
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        
        return false;
     }
    
    
    public ArrayList<Usuario> listar(){
        ArrayList listaProducto = new ArrayList();
        Usuario us;
        String sql = "SELECT u.id_usuario, u.rut_us, u.dv_us, u.nombre_us, u.apaterno_us, u.amaterno_us, u.f_nac_us, u.telefono_us, u.email_us, u.direccion, u.usuario, u.contrasena, u.perfiles_id_perfiles, p.detalle, u.activo FROM usuario u JOIN perfiles p ON(perfiles_id_perfiles = id_perfiles)";
        Connection con = getConexion();
        
        try {            
            //PreparedStatement ps = con.prepareCall(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){                
                
                us = new Usuario();
                us.setId_usuario(rs.getInt(1));
                us.setRut_us(rs.getString(2));
                us.setDv_us(rs.getString(3));
                us.setNombre_us(rs.getString(4));
                us.setApaterno_us(rs.getString(5));
                us.setAmaterno_us(rs.getString(6));
                us.setFnaciemiento_us(rs.getString(7));
                us.setTelefono_us(rs.getString(8));
                us.setEmail_us(rs.getString(9));
                us.setDireccion(rs.getString(10));
                us.setUsuario(rs.getString(11));
                us.setContrasena(rs.getString(12));
                us.setPerfil_id(rs.getInt(13));
                us.setDetalle(rs.getString(14));
                us.setActivo(rs.getString(15).charAt(0));
                listaProducto.add(us);
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
    
    public boolean Cargar_combobox(JComboBox cbox_nombre){
        String sql= "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            sql = "Select id_perfiles, detalle from perfiles ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_nombre.addItem("Seleccionar");
            while(rs.next()){
                cbox_nombre.addItem(rs.getString("id_perfiles")+". "+rs.getString("detalle"));
            }
        } catch (SQLException e) {
        }finally{
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return true;
    }
    
    
    
}
