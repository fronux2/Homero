
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;


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
    
    public boolean modificar(SisBD sisbd){
        PreparedStatement ps = null;
        Connection con = getConexion();        
        String sql = "UPDATE sisbd SET usuario = ?, contrasena = ?, software_bd = ?, servidor_id_servidor = ?, usuario_id_usuario = ?, activo = ? where id_bd = ? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sisbd.getUsuario());
            ps.setString(2, sisbd.getContrasena());
            ps.setString(3, sisbd.getSoftware_bd());
            ps.setInt(4, sisbd.getServidor_id());
            ps.setInt(5, sisbd.getUsuario_id());   
            ps.setInt(6, sisbd.getActivo());
            ps.setInt(7, sisbd.getId_bd());
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
    
    public boolean buscar(SisBD sisbd){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select * from sisbd where id_bd = ?";
        
        try {
            ps = con.prepareStatement(sql); 
            ps.setInt(1, sisbd.getId_bd());
            
            rs = ps.executeQuery();
            
            if(rs.next()){               
                sisbd.setUsuario(rs.getString("usuario"));
                sisbd.setContrasena(rs.getString("contrasena"));
                sisbd.setSoftware_bd(rs.getString("software_bd"));
                sisbd.setServidor_id(rs.getInt("servidor_id_servidor"));
                sisbd.setUsuario_id(rs.getInt("usuario_id_usuario"));
                sisbd.setActivo(rs.getString("activo").charAt(0));                
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
    
    public boolean Cargar_comboboxServidorId(JComboBox cbox_nombre){
        String sql= "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            sql = "Select id_servidor from servidor";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_nombre.addItem("Seleccionar");
            while(rs.next()){
                cbox_nombre.addItem(rs.getString("id_servidor"));
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
    
    public boolean Cargar_comboboxIdUsuario(JComboBox cbox_nombre){
        String sql= "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            sql = "Select id_usuario from usuario";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_nombre.addItem("Seleccionar");
            while(rs.next()){
                cbox_nombre.addItem(rs.getString("id_usuario"));
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
