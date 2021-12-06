
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
        String sql = "{call sp_agregar_sisbd(?,?,?,?,?,?,?)}";   
        
        try {
            ps = con.prepareCall(sql);            
            ps.setString(1, sisbd.getUsuario());
            ps.setString(2, sisbd.getContrasena());
            ps.setInt(3, sisbd.getLenguaje_id());
            ps.setInt(4, sisbd.getServidor_id());
            ps.setInt(5, sisbd.getUsuario_id());  
            ps.setString(6, sisbd.getNombre_bd());
            ps.setInt(7, 1);
            System.out.println("us:"+sisbd.getUsuario()+"cont:"+sisbd.getContrasena()+"leng:"+sisbd.getLenguaje_id()+"serv:"+sisbd.getServidor_id()+"idus:"+sisbd.getUsuario_id()+"namebd:"+sisbd.getNombre_bd());
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
        String sql = "SELECT s.id_bd,s.usuario, s.contrasena, s.lenguajes_id_lenguajes, l.nombre, s.servidor_id_servidor,\n" +
                     "       s.usuario_id_usuario, s.activo, sr.nom_servidor, u.nombre_us, u.apaterno_us, u.amaterno_us, s.nombre_bd\n" +
                     "       FROM sisbd s JOIN servidor sr ON(s.servidor_id_servidor = sr.id_servidor)\n" +
                     "                    JOIN usuario u ON(s.usuario_id_usuario = u.id_usuario)\n" +
                     "                    JOIN lenguajes l ON (s.lenguajes_id_lenguajes = l.id_lenguajes)";
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
                sisbd.setLenguaje_id(rs.getInt(4));
                sisbd.setNombre_leng(rs.getString(5));
                sisbd.setServidor_id(rs.getInt(6));
                sisbd.setUsuario_id(rs.getInt(7));                                
                sisbd.setActivo(rs.getString(8).charAt(0));
                sisbd.setNom_servidor(rs.getString(9));
                sisbd.setNombre_us(rs.getString(10));
                sisbd.setApaterno_us(rs.getString(11));
                sisbd.setAmaterno_us(rs.getString(12));
                sisbd.setNombre_bd(rs.getString(13));
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
        String sql =  "UPDATE sisbd \n" +
                      "SET usuario = ?, contrasena = ?, lenguajes_id_lenguajes = ?, servidor_id_servidor = ?,\n" +
                      "usuario_id_usuario = ?, activo = ?, nombre_bd = ? where id_bd = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sisbd.getUsuario());
            ps.setString(2, sisbd.getContrasena());
            ps.setInt(3, sisbd.getLenguaje_id());
            ps.setInt(4, sisbd.getServidor_id());
            ps.setInt(5, sisbd.getUsuario_id());   
            ps.setInt(6, sisbd.getActivo());
            ps.setString(7, sisbd.getNombre_bd());
            ps.setInt(8, sisbd.getId_bd());
            System.out.println(sisbd.getUsuario()+sisbd.getContrasena()+"leng"+sisbd.getLenguaje_id()+"serv"+sisbd.getServidor_id()+"us"+sisbd.getUsuario_id()+"act"+sisbd.getActivo()+"name"+sisbd.getNombre_bd());
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
        String sql = "SELECT s.id_bd,s.usuario, s.contrasena, s.lenguajes_id_lenguajes, l.nombre, s.servidor_id_servidor,\n" +
                     "       s.usuario_id_usuario, s.activo, sr.nom_servidor, u.nombre_us, u.apaterno_us, u.amaterno_us, s.nombre_bd\n" +
                     "       FROM sisbd s JOIN servidor sr ON(s.servidor_id_servidor = sr.id_servidor)\n" +
                     "                    JOIN usuario u ON(s.usuario_id_usuario = u.id_usuario)\n" +
                     "                    JOIN lenguajes l ON(s.lenguajes_id_lenguajes = l.id_lenguajes)\n" +
                     "                    WHERE id_bd = ?";
        
        try {
            ps = con.prepareStatement(sql); 
            ps.setInt(1, sisbd.getId_bd());
            
            rs = ps.executeQuery();
            
            if(rs.next()){               
                sisbd.setUsuario(rs.getString("usuario"));
                sisbd.setContrasena(rs.getString("contrasena"));
                sisbd.setLenguaje_id(rs.getInt("lenguajes_id_lenguajes"));
                sisbd.setNombre_leng(rs.getString("nombre"));
                sisbd.setServidor_id(rs.getInt("servidor_id_servidor"));
                sisbd.setUsuario_id(rs.getInt("usuario_id_usuario"));
                sisbd.setActivo(rs.getString("activo").charAt(0));  
                sisbd.setNom_servidor(rs.getString("nom_servidor"));
                sisbd.setNombre_us(rs.getString("nombre_us"));
                sisbd.setApaterno_us(rs.getString("apaterno_us"));
                sisbd.setAmaterno_us(rs.getString("amaterno_us"));
                sisbd.setNombre_bd(rs.getString("nombre_bd"));
                sisbd.setId_bd(rs.getInt("id_bd"));
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
            sql = "Select id_servidor, nom_servidor from servidor";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_nombre.addItem("Seleccionar");
            while(rs.next()){
                cbox_nombre.addItem(rs.getString("id_servidor")+"   . "+rs.getString("nom_servidor"));
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
            sql = "select id_usuario, nombre_us||' '||apaterno_us||' '||amaterno_us as nombre from usuario where perfiles_id_perfiles = 3";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_nombre.addItem("Seleccionar");
            while(rs.next()){
                cbox_nombre.addItem(rs.getString("id_usuario")+"   . "+rs.getString("nombre"));
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
    
    public boolean Cargar_comboboxLenguaje(JComboBox cbox_lenguaje){
        String sql= "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            sql = "select id_lenguajes, nombre from lenguajes";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_lenguaje.addItem("Seleccionar");
            while(rs.next()){
                cbox_lenguaje.addItem(rs.getString("id_lenguajes")+"   . "+rs.getString("nombre"));
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
