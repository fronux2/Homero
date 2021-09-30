package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
        String sql = "select * from SISAPP";
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
        String sql = "select * from sisapp where id_sistemas = ?";
        
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
}
