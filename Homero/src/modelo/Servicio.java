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

    public String getTipo_serv() {
        return tipo_serv;
    }

    public void setTipo_serv(String tipo_serv) {
        this.tipo_serv = tipo_serv;
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
    private String tipo_serv;
    private int SisApp;
    private char activo;

    public String getNombre_sis() {
        return nombre_sis;
    }

    public void setNombre_sis(String nombre_sis) {
        this.nombre_sis = nombre_sis;
    }
    private String nombre_sis;
    
}
