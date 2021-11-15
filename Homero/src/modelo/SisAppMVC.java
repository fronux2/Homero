package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;


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
    
    public ArrayList<SisApp> listar(){
        ArrayList listaProducto = new ArrayList();
        SisApp sisapp;
        String sql = "SELECT s.id_sistemas, s.software_bd, s.nombre_sis, s.lenguaje_sis,s.provedor_sistema, s.servidor_id_servidor, s.usuario_id_usuario,s.activo, sr.nom_servidor, u.nombre_us, u.apaterno_us FROM sisapp s JOIN servidor sr ON(s.servidor_id_servidor = sr.id_servidor)  JOIN usuario u ON(s.usuario_id_usuario = u.id_usuario)";
        Connection con = getConexion();
        
        try {            
            //PreparedStatement ps = con.prepareCall(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){                
                
                sisapp = new SisApp();
                sisapp.setId_sistemas(rs.getInt(1));
                sisapp.setSoftware_bd(rs.getString(2));
                sisapp.setNombre_sis(rs.getString(3));
                sisapp.setLenguaje_sis(rs.getString(4));
                sisapp.setProvedor_sistema(rs.getString(5));
                sisapp.setServidor_id(rs.getInt(6));
                sisapp.setUsuario_id(rs.getInt(7));                
                sisapp.setActivo(rs.getString(8).charAt(0));
                sisapp.setNom_servidor(rs.getString(9));
                sisapp.setNombre_us(rs.getString(10));
                sisapp.setApellido_us(rs.getString(11));
                listaProducto.add(sisapp);
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
    
    public boolean modificar(SisApp sisapp){
        PreparedStatement ps = null;
        Connection con = getConexion();        
        String sql = "UPDATE sisapp SET software_bd = ?, nombre_sis = ?, lenguaje_sis = ?, provedor_sistema = ?, servidor_id_servidor = ?, usuario_id_usuario = ?, activo = ? where id_sistemas = ? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sisapp.getSoftware_bd());
            ps.setString(2, sisapp.getNombre_sis());
            ps.setString(3, sisapp.getLenguaje_sis());
            ps.setString(4, sisapp.getProvedor_sistema());
            ps.setInt(5, sisapp.getServidor_id());            
            ps.setInt(6, sisapp.getUsuario_id());
            ps.setInt(7, sisapp.getActivo());
            ps.setInt(8, sisapp.getId_sistemas());
            
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
    
    
    public boolean buscar(SisApp sisapp){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT s.id_sistemas, s.software_bd, s.nombre_sis, s.lenguaje_sis,s.provedor_sistema, s.servidor_id_servidor, s.usuario_id_usuario,s.activo, sr.nom_servidor, u.nombre_us, u.apaterno_us FROM sisapp s JOIN servidor sr ON(s.servidor_id_servidor = sr.id_servidor)  JOIN usuario u ON(s.usuario_id_usuario = u.id_usuario) where id_sistemas = ?";
        
        try {
            ps = con.prepareStatement(sql); 
            ps.setInt(1, sisapp.getId_sistemas());
            
            rs = ps.executeQuery();
            
            if(rs.next()){               
                sisapp.setSoftware_bd(rs.getString("software_bd"));
                sisapp.setNombre_sis(rs.getString("nombre_sis"));
                sisapp.setLenguaje_sis(rs.getString("lenguaje_sis"));
                sisapp.setProvedor_sistema(rs.getString("provedor_sistema"));
                sisapp.setServidor_id(rs.getInt("servidor_id_servidor"));
                sisapp.setUsuario_id(rs.getInt("usuario_id_usuario"));    
                sisapp.setActivo(rs.getString("activo").charAt(0)); 
                sisapp.setNom_servidor(rs.getString("nom_servidor"));
                sisapp.setNombre_us(rs.getString("nombre_us"));
                sisapp.setApellido_us(rs.getString("apaterno_us"));
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
    
    public boolean Cargar_comboboxIdUsuario(JComboBox cbox_nombre){
        String sql= "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            //sql = "Select id_usuario from usuario";
            sql = "select id_usuario, nombre_us||' '||apaterno_us as nombre from usuario where perfiles_id_perfiles = 3";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_nombre.addItem("Seleccionar");
            while(rs.next()){
                cbox_nombre.addItem(rs.getString("id_usuario")+". "+rs.getString("nombre"));
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
    
    public boolean Cargar_comboboxServidorId(JComboBox cbox_nombre){
        String sql= "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            sql = "select id_servidor, nom_servidor from servidor";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_nombre.addItem("Seleccionar");
            while(rs.next()){
                cbox_nombre.addItem(rs.getString("id_servidor")+". "+rs.getString("nom_servidor"));
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
