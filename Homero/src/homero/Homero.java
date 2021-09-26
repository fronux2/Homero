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
        
        
        
        CtrlHomero ctrl = new CtrlHomero(l, lmvc, vl, vin, vus, vsisapp, vsisbd, vser, us, usmvc, vlus);
        ctrl.iniciar();
    }
    
}
