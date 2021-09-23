/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author marku
 */
public class CtrlLogin implements ActionListener{
    
  
    
    private Login l;
    private LoginMVC lmvc;
    private VistaLogin vl;
    private VistaSala vsal;
    private VistaServidor vser;
    private VistaIndex vin;
    private VistaUsuario vus;
    
      public CtrlLogin(Login l, LoginMVC lmvc, VistaLogin vl, VistaSala vsal, VistaServidor vser, VistaIndex vin, VistaUsuario vus){
        this.l = l;
        this.lmvc = lmvc;
        this.vl = vl;
        this.vsal = vsal;
        this.vser = vser;
        this.vin = vin;
        this.vus = vus;
        this.vin.btnUsuarios.addActionListener(this);
        this.vl.btnAceptar.addActionListener(this);        
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
    
    /*public void iniciarb()
    {       
        vsal.setTitle("Productos");
        vsal.setLocationRelativeTo(null);          
        vsal.setVisible(true);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        //Acciones Vista Index
        
        if(e.getSource() == vin.btnUsuarios){
                vin.setVisible(false);
                vus.setTitle("Vista Usuario");
                vus.setLocationRelativeTo(null);  
                vus.setVisible(true);  
        }
         
        //Acciones Vista Usuario
        if(e.getSource() == vus.btnVolver){
                vus.setVisible(false);
                volver();  
        }
        //Acciones Vista Servidor
        if(e.getSource() == vser.btnVolver){
                vser.setVisible(false);
                volver(); 
        }
        //Acciones Vista Sala
        if(e.getSource() == vsal.btnVolver){
                vsal.setVisible(false);
                volver(); 
        }
        
        //Acciones Vista Login
        if(e.getSource() == vl.btnAceptar){
            l.setUsuario(vl.txtUsuario.getText());
            l.setContrasena(vl.txtContrasena.getText());            
            if(lmvc.login(l))
            {             
                vl.setVisible(false);
                vin.setTitle("Index");
                vin.setLocationRelativeTo(null);  
                vin.setVisible(true);            
            }else{JOptionPane.showMessageDialog(null, "No se encontro registro");}
        }
        
    }
    
}
