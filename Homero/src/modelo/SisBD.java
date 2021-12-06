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
    
    public int getServidor_id() {
        return servidor_id;
    }

    public void setServidor_id(int servidor_id) {
        this.servidor_id = servidor_id;
    }

    public int getLenguaje_id() {
        return lenguaje_id;
    }

    public void setLenguaje_id(int lenguaje_id) {
        this.lenguaje_id = lenguaje_id;
    }

    public String getAmaterno_us() {
        return amaterno_us;
    }

    public void setAmaterno_us(String amaterno_us) {
        this.amaterno_us = amaterno_us;
    }

    public String getNombre_leng() {
        return nombre_leng;
    }

    public void setNombre_leng(String nombre_leng) {
        this.nombre_leng = nombre_leng;
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
    private int lenguaje_id;
    private int servidor_id;
    private int usuario_id;
    private char activo;
    private String nom_servidor;
    private String nombre_us;
    private String apaterno_us;
    private String amaterno_us;
    private String nombre_leng;
    private String nombre_bd;

    public String getNombre_bd() {
        return nombre_bd;
    }

    public void setNombre_bd(String nombre_bd) {
        this.nombre_bd = nombre_bd;
    }

    public String getNom_servidor() {
        return nom_servidor;
    }

    public void setNom_servidor(String nom_servidor) {
        this.nom_servidor = nom_servidor;
    }

    public String getNombre_us() {
        return nombre_us;
    }

    public void setNombre_us(String nombre_us) {
        this.nombre_us = nombre_us;
    }    

    public String getApaterno_us() {
        return apaterno_us;
    }

    public void setApaterno_us(String apaterno_us) {
        this.apaterno_us = apaterno_us;
    }
    
}
