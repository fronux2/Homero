
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Login;
import modelo.LoginMVC;
import vista.VistaIndex;
import vista.VistaLogin;
import vista.VistaSala;
import vista.VistaServidor;
import vista.VistaUsuario;


public class CtrlServidor implements ActionListener{
    
  
    
    private Login l;
    private LoginMVC lmvc;
    private VistaLogin vl;
    private VistaSala vsal;
    private VistaServidor vser;
    private VistaIndex vin;
    private VistaUsuario vus;
    
      public CtrlServidor(Login l, LoginMVC lmvc, VistaLogin vl, VistaSala vsal, VistaServidor vser, VistaIndex vin, VistaUsuario vus){
        this.l = l;
        this.lmvc = lmvc;
        this.vl = vl;
        this.vsal = vsal;
        this.vser = vser;
        this.vin = vin;
        this.vus = vus;
        this.vin.btnUsuarios.addActionListener(this);
        this.vl.btnAceptar.addActionListener(this);
        this.vin.btnServidor.addActionListener(this);
        this.vin.btnSala.addActionListener(this);
        this.vus.btnVolver.addActionListener(this);
        this.vser.btnVolver.addActionListener(this);
        this.vsal.btnVolver.addActionListener(this);
}
    
    public void iniciar()
    {
        vl.setTitle("Login");
        vl.setLocationRelativeTo(null);
        vl.setVisible(true);   
    }
    
    public void volver(){
        vin.setTitle("Vista Index");
        vin.setLocationRelativeTo(null);  
        vin.setVisible(true);  
    }   
    

    @Override
    public void actionPerformed(ActionEvent e) {
                
        
        if(e.getSource() == vser.btnVolver){
                vser.setVisible(false);
                volver(); 
        }       
        
        
        
    }
    
}

