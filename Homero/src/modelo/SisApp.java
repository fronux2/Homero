package modelo;


public class SisApp {    

    public int getId_sistemas() {
        return id_sistemas;
    }

    public void setId_sistemas(int id_sistemas) {
        this.id_sistemas = id_sistemas;
    }

    public String getSoftware_bd() {
        return software_bd;
    }

    public void setSoftware_bd(String software_bd) {
        this.software_bd = software_bd;
    }

    public String getNombre_sis() {
        return nombre_sis;
    }

    public void setNombre_sis(String nombre_sis) {
        this.nombre_sis = nombre_sis;
    }

    public String getLenguaje_sis() {
        return lenguaje_sis;
    }

    public void setLenguaje_sis(String lenguaje_sis) {
        this.lenguaje_sis = lenguaje_sis;
    }

    public String getProvedor_sistema() {
        return provedor_sistema;
    }

    public void setProvedor_sistema(String provedor_sistema) {
        this.provedor_sistema = provedor_sistema;
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
    
    private int id_sistemas;
    private String software_bd;
    private String nombre_sis;
    private String lenguaje_sis;
    private String provedor_sistema;
    private int servidor_id;
    private int usuario_id;     
    private char activo;
}
