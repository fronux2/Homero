package homero;

import controlador.CtrlLogin;
import modelo.Login;
import modelo.LoginMVC;
import vista.VistaIndex;
import vista.VistaLogin;
import vista.VistaSala;
import vista.VistaServidor;
import vista.VistaUsuario;

public class Homero {

    public static void main(String[] args) {
        Login l = new Login();
        LoginMVC lmvc = new LoginMVC();
        VistaLogin vl = new VistaLogin();
        VistaSala vsal = new VistaSala();
        VistaServidor vser = new VistaServidor();
        VistaIndex vin = new VistaIndex();
        VistaUsuario vus = new VistaUsuario();
        
        
        
        
        CtrlLogin ctrl = new CtrlLogin(l, lmvc, vl, vsal, vser, vin, vus);
        ctrl.iniciar();
    }
    
}
