package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

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
    
    public boolean modificar(Servicio ser){
        PreparedStatement ps = null;
        Connection con = getConexion();        
        String sql = "UPDATE servicio SET nombre_serv = ?, tipo_serv = ?, sisapp_id_sistemas = ?, activo = ? where id_servicios = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ser.getNombre_serv());
            ps.setString(2, ser.getTipo_serv());
            ps.setInt(3, ser.getSisApp());
            ps.setInt(4, ser.getActivo());
            ps.setInt(5, ser.getId_servicios());
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
    
    public boolean buscar(Servicio ser){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select * from servicio where id_servicios = ?";
        
        try {
            ps = con.prepareStatement(sql); 
            ps.setInt(1, ser.getId_servicios());
            
            rs = ps.executeQuery();
            
            if(rs.next()){      
                ser.setNombre_serv(rs.getString("nombre_serv"));
                ser.setTipo_serv(rs.getString("tipo_serv"));
                ser.setSisApp(rs.getInt("sisapp_id_sistemas"));
                ser.setActivo(rs.getString("activo").charAt(0));                
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
    
    public boolean Cargar_combobox(JComboBox cbox_nombre){
        String sql= "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            sql = "Select id_sistemas from sisapp ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_nombre.addItem("Seleccionar");
            while(rs.next()){
                cbox_nombre.addItem(rs.getString("id_sistemas"));
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
