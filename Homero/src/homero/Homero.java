package homero;

import controlador.CtrlLogin;
import modelo.Login;
import modelo.LoginMVC;
import vista.VistaIndex;
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
        VistaSala vsal = new VistaSala();        
        VistaIndex vin = new VistaIndex();
        VistaUsuario vus = new VistaUsuario();
        VistaSisApli vsisapp = new VistaSisApli();
        VistaSisBD vsisbd = new VistaSisBD();
        VistaServicio vser = new VistaServicio();
        
        
        CtrlLogin ctrl = new CtrlLogin(l, lmvc, vl, vin, vus, vsisapp, vsisbd, vser);
        ctrl.iniciar();
    }
    
}
