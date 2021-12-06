package modelo;


public class Servicio {

    public int getId_servicios() {
        return id_servicios;
    }

    public void setId_servicios(int id_servicios) {
        this.id_servicios = id_servicios;
    }

    public String getNombre_serv() {
        return nombre_serv;
    }

    public void setNombre_serv(String nombre_serv) {
        this.nombre_serv = nombre_serv;
    }

    public int getSisApp() {
        return SisApp;
    }

    public void setSisApp(int SisApp) {
        this.SisApp = SisApp;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }
    private int id_servicios;
    private String nombre_serv;
    private int tipo_serv_id;
    private int SisApp;
    private char activo;
    private String nombre_tipo;

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public String getNombre_sis() {
        return nombre_sis;
    }

    public int getTipo_serv_id() {
        return tipo_serv_id;
    }

    public void setTipo_serv_id(int tipo_serv_id) {
        this.tipo_serv_id = tipo_serv_id;
    }

    public void setNombre_sis(String nombre_sis) {
        this.nombre_sis = nombre_sis;
    }
    private String nombre_sis;
    
}
