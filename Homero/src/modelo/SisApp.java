package modelo;


public class SisApp {    

    public int getId_sistemas() {
        return id_sistemas;
    }

    public void setId_sistemas(int id_sistemas) {
        this.id_sistemas = id_sistemas;
    }

    
    public String getNombre_sis() {
        return nombre_sis;
    }

    public void setNombre_sis(String nombre_sis) {
        this.nombre_sis = nombre_sis;
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

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }
    
      
    private int id_sistemas;
    private int id_bd;
    private String nombre_bd;    
    private String nombre_sis;
    private int id_lenguaje;    
    private int servidor_id;
    private int usuario_id;     
    private char activo;
    private String nom_servidor;
    private String nombre_us;
    private String apellido_paterno;
    private String apellido_materno;
    private String nombre_lenguaje;
    

    public String getNombre_bd() {
        return nombre_bd;
    }

    public void setNombre_bd(String nombre_bd) {
        this.nombre_bd = nombre_bd;
    }
    public int getId_bd() {
        return id_bd;
    }

    public void setId_bd(int id_bd) {
        this.id_bd = id_bd;
    }

    public int getId_lenguaje() {
        return id_lenguaje;
    }

    public void setId_lenguaje(int id_lenguaje) {
        this.id_lenguaje = id_lenguaje;
    }

    public String getNombre_lenguaje() {
        return nombre_lenguaje;
    }

    public void setNombre_lenguaje(String nombre_lenguaje) {
        this.nombre_lenguaje = nombre_lenguaje;
    }
    


    
}
