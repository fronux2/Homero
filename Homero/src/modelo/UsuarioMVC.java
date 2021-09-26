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
        String sql = "select * from usuario where rut_us = ?";
        
        try {
            ps = con.prepareStatement(sql); 
            ps.setString(1, us.getRut_us());
            rs = ps.executeQuery();
            
            if(rs.next()){
                us.setRut_us(rs.getString("rut"));
                us.setDv_us(rs.getString("dv"));
                us.setNombre_us(rs.getString("nombre"));
                us.setApaterno_us(rs.getString("apaterno"));
                us.setAmaterno_us(rs.getString("amaterno"));
                us.setFnaciemiento_us(rs.getString("fnacimiento_us"));
                us.setTelefono_us(rs.getString("telefono"));
                us.setEmail_us(rs.getString("email"));
                us.setDireccion(rs.getString("direccion"));
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
        String sql = "select * from usuario";
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
}
