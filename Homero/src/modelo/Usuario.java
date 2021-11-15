package modelo;

public class Usuario {

    

    private int id_usuario;
    private String rut_us;
    private String dv_us;
    private String nombre_us;
    private String apaterno_us;
    private String amaterno_us;
    private String fnaciemiento_us;
    private String telefono_us;
    private String email_us;
    private String direccion;
    private String usuario;
    private String contrasena;
    private int perfil_id;

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    private String detalle;
    private char activo;
    
    
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getRut_us() {
        return rut_us;
    }

    public void setRut_us(String rut_us) {
        this.rut_us = rut_us;
    }

    public String getDv_us() {
        return dv_us;
    }

    public void setDv_us(String dv_us) {
        this.dv_us = dv_us;
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

    public String getAmaterno_us() {
        return amaterno_us;
    }

    public void setAmaterno_us(String amaterno_us) {
        this.amaterno_us = amaterno_us;
    }

    public String getFnaciemiento_us() {
        return fnaciemiento_us;
    }

    public void setFnaciemiento_us(String fnaciemiento_us) {
        this.fnaciemiento_us = fnaciemiento_us;
    }

    public String getTelefono_us() {
        return telefono_us;
    }

    public void setTelefono_us(String telefono_us) {
        this.telefono_us = telefono_us;
    }

    public String getEmail_us() {
        return email_us;
    }

    public void setEmail_us(String email_us) {
        this.email_us = email_us;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public int getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(int perfil_id) {
        this.perfil_id = perfil_id;
    }
    
    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }
    
    
    
    
}
