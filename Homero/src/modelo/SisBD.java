package modelo;


public class SisBD {

    public int getId_bd() {
        return id_bd;
    }

    public void setId_bd(int id_bd) {
        this.id_bd = id_bd;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getSoftware_bd() {
        return Software_bd;
    }

    public void setSoftware_bd(String Software_bd) {
        this.Software_bd = Software_bd;
    }

    public int getServidor_id() {
        return servidor_id;
    }

    public void setServidor_id(int servidor_id) {
        this.servidor_id = servidor_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }
    private int id_bd;
    private String usuario;
    private String contrasena;
    private String Software_bd;
    private int servidor_id;
    private int usuario_id;
    private char activo;
}
