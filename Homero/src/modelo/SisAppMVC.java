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
        String sql = "{call sp_agregar_sisapp(?,?,?,?,?,?)}";   
        
        try {
            ps = con.prepareCall(sql);            
            ps.setInt(1, sis.getId_bd());            
            ps.setString(2, sis.getNombre_sis());
            ps.setInt(3, sis.getId_lenguaje());            
            ps.setInt(4, sis.getServidor_id());
            ps.setInt(5, sis.getUsuario_id());
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
    
    public ArrayList<SisApp> listar(){
        ArrayList listaProducto = new ArrayList();
        SisApp sisapp;
        String sql = "SELECT sa.id_sistemas, sa.sisbd_id_bd, sa.nombre_sis, sa.lenguajes_id_lenguajes,\n" +
                     "le.nombre, sa.servidor_id_servidor, se.nom_servidor, sa.usuario_id_usuario, us.nombre_us,\n" +
                     "us.apaterno_us, us.amaterno_us, sa.activo\n" +
                     "                            FROM sisapp sa JOIN sisbd sb ON(sa.sisbd_id_bd = sb.id_bd)\n" +
                     "                                           JOIN lenguajes le ON(sa.lenguajes_id_lenguajes = le.id_lenguajes)\n" +
                     "                                           JOIN servidor se ON(sa.servidor_id_servidor = se.id_servidor)\n" +
                     "                                           JOIN usuario us ON (sa.usuario_id_usuario = us.id_usuario)\n" +
                     "                                           WHERE us.perfiles_id_perfiles = 3";
        Connection con = getConexion();
        
        try {            
            //PreparedStatement ps = con.prepareCall(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){                
                
                sisapp = new SisApp();
                sisapp.setId_sistemas(rs.getInt(1));
                sisapp.setId_bd(rs.getInt(2));
                sisapp.setNombre_sis(rs.getString(3));
                sisapp.setId_lenguaje(rs.getInt(4));
                sisapp.setNombre_lenguaje(rs.getString(5));
                sisapp.setServidor_id(rs.getInt(6));                    
                sisapp.setNom_servidor(rs.getString(7));
                sisapp.setUsuario_id(rs.getInt(8));          
                sisapp.setNombre_us(rs.getString(9));
                sisapp.setApellido_paterno(rs.getString(10));
                sisapp.setApellido_materno(rs.getString(11));
                sisapp.setActivo(rs.getString(12).charAt(0));
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
        String sql = "UPDATE sisapp SET sisbd_id_bd = ?, nombre_sis = ?, lenguajes_id_lenguajes = ?,\n" +
                     "                  servidor_id_servidor = ?, usuario_id_usuario = ?, activo = ?\n" +
                     "                  where id_sistemas = ? \n" +
                     "        ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sisapp.getId_bd());
            ps.setString(2, sisapp.getNombre_sis());
            ps.setInt(3, sisapp.getId_lenguaje());            
            ps.setInt(4, sisapp.getServidor_id());            
            ps.setInt(5, sisapp.getUsuario_id());
            ps.setInt(6, sisapp.getActivo());
            ps.setInt(7, sisapp.getId_sistemas());
            
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
        String sql = "SELECT sa.id_sistemas, sa.sisbd_id_bd, sa.nombre_sis, sa.lenguajes_id_lenguajes,\n" +
                     "le.nombre, sa.servidor_id_servidor, se.nom_servidor, sa.usuario_id_usuario, us.nombre_us,\n" +
                     "us.apaterno_us, us.amaterno_us, sa.activo\n" +
                     "                            FROM sisapp sa JOIN sisbd sb ON(sa.sisbd_id_bd = sb.id_bd)\n" +
                     "                                           JOIN lenguajes le ON(sa.lenguajes_id_lenguajes = le.id_lenguajes)\n" +
                     "                                           JOIN servidor se ON(sa.servidor_id_servidor = se.id_servidor)\n" +
                     "                                           JOIN usuario us ON (sa.usuario_id_usuario = us.id_usuario)\n" +
                     "                            WHERE id_sistemas = ?\n" +
                     "                                           ";
        try {
            ps = con.prepareStatement(sql); 
            ps.setInt(1, sisapp.getId_sistemas());
            
            rs = ps.executeQuery();
            
            if(rs.next()){               
                sisapp.setId_bd(rs.getInt("sisbd_id_bd"));
                sisapp.setNombre_sis(rs.getString("nombre_sis"));
                sisapp.setId_lenguaje(rs.getInt("lenguajes_id_lenguajes"));
                sisapp.setNombre_lenguaje(rs.getString("nombre"));
                sisapp.setServidor_id(rs.getInt("servidor_id_servidor"));
                sisapp.setNom_servidor(rs.getString("nom_servidor"));
                sisapp.setUsuario_id(rs.getInt("usuario_id_usuario"));
                sisapp.setNombre_us(rs.getString("nombre_us"));
                sisapp.setApellido_paterno(rs.getString("apaterno_us"));
                sisapp.setApellido_materno(rs.getString("amaterno_us"));
                sisapp.setActivo(rs.getString("activo").charAt(0)); 
                
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
    
    public boolean Cargar_comboboxBD(JComboBox cbox_BD){
        String sql= "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            sql = "select id_bd from sisbd";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            cbox_BD.addItem("Seleccionar");
            while(rs.next()){
                cbox_BD.addItem(rs.getString("id_bd")+"   . "+"name");
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
