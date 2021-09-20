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
import java.util.ArrayList;
import javax.swing.JComboBox;
import static modelo.Conexion.getConexion;

/**
 *
 * @author marku
 */
public class UsuarioMVC {
    
    public boolean registrar(Usuario us){
        PreparedStatement ps = null;
        Connection con = getConexion();        
        String sql = "INSERT INTO USUARIO (id_usuario, rut_us, dv_us, nombre_us, apaterno_us, amaterno_us, fnacimiento_us, telefono_us, email_us, direccion) "
                + "VALUES(SEQUENCE_ID.NEXTVAL,?,?,?,?)";        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getRut_us());
            ps.setString(2, us.getDv_us());
            ps.setString(2, us.getNombre_us());
            ps.setString(2, us.getApaterno_us());
            ps.setString(2, us.getAmaterno_us());
            ps.setString(2, us.getFnaciemiento_us());
            ps.setString(2, us.getTelefono_us());
            ps.setString(2, us.getEmail_us());
            ps.setString(2, us.getDireccion());
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
        String sql = "UPDATE usuario SET rut_us=? , dv_us=?, nombre_us=?, apaterno_us=?, amaterno_us=?, fnacimiento_us=?, telefono_us=?, email_us=?, direccion WHERE rut_us=? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getRut_us());
            ps.setString(2, us.getDv_us());
            ps.setString(3, us.getNombre_us());
            ps.setString(4, us.getApaterno_us());
            ps.setString(5, us.getAmaterno_us());
            ps.setString(5, us.getFnaciemiento_us());
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
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                us = new Usuario();
                us.setRut_us(rs.getString(1));
                us.setDv_us(rs.getString(2));
                us.setNombre_us(rs.getString(3));
                us.setApaterno_us(rs.getString(4));
                us.setAmaterno_us(rs.getString(5));
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
