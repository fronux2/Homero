package homero;

import controlador.CtrlHomero;
import modelo.Login;
import modelo.LoginMVC;
import modelo.Usuario;
import modelo.UsuarioMVC;
import vista.VistaIndex;
import vista.VistaListaUsuarios;
import vista.VistaLogin;
import vista.VistaSala;
import vista.VistaServicio;
import vista.VistaSisApli;
import vista.VistaSisBD;
import vista.VistaUsuario;
import vista.*;
import modelo.*;

public class Homero {

    public static void main(String[] args) {
        Login l = new Login();
        LoginMVC lmvc = new LoginMVC();
        VistaLogin vl = new VistaLogin();               
        VistaIndex vin = new VistaIndex();
        VistaUsuario vus = new VistaUsuario();
        VistaSisApli vsisapp = new VistaSisApli();
        VistaSisBD vsisbd = new VistaSisBD();
        VistaServicio vser = new VistaServicio();
        Usuario us = new Usuario();
        UsuarioMVC usmvc = new UsuarioMVC();
        VistaListaUsuarios vlus = new VistaListaUsuarios();
        SisApp sisapp = new SisApp();
        SisAppMVC sisappmvc = new SisAppMVC();
        SisBD sisbd = new SisBD();
        SisBDMVC sisbdmvc = new SisBDMVC();
        Servicio ser = new Servicio();
        ServicioMVC sermvc = new ServicioMVC();
        VistaListaServicio vlser = new VistaListaServicio();
        VistaListaSisApp vlsisapp = new VistaListaSisApp();
        VistaListaSisBD vlsisbd = new VistaListaSisBD();
        
        
        
        CtrlHomero ctrl = new CtrlHomero(l, lmvc, vl, vin, vus, vsisapp, vsisbd, vser, us, usmvc, vlus, sisapp,sisappmvc, sisbd, sisbdmvc, ser, sermvc, vlser, vlsisapp, vlsisbd);
        ctrl.iniciar();
        
        
    }
    
}
