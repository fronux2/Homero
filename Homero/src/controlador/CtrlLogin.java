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
import modelo.Usuario;
import modelo.UsuarioMVC;
import vista.VistaIndex;
import vista.VistaLogin;
import vista.VistaServicio;
import vista.VistaSisApli;
import vista.VistaSisBD;
import vista.VistaUsuario;

/**
 *
 * @author marku
 */
public class CtrlLogin implements ActionListener{
    
  
    
    private Login l;
    private LoginMVC lmvc;
    private VistaLogin vl;    
    private VistaIndex vin;
    private VistaUsuario vus;
    private VistaSisApli vsisapp;
    private VistaSisBD vsisbd;
    private VistaServicio vser;
    private UsuarioMVC usmvc;
    private Usuario us;
    
    
      public CtrlLogin(Login l, LoginMVC lmvc, VistaLogin vl, VistaIndex vin, VistaUsuario vus, VistaSisApli vsisapp, VistaSisBD vsisbd, VistaServicio vser, Usuario us, UsuarioMVC usmvc){
        this.l = l;
        this.lmvc = lmvc;
        this.vl = vl;       
        this.vin = vin;
        this.vus = vus;
        this.vsisapp = vsisapp;
        this.vsisbd = vsisbd;
        this.vser = vser;   
        this.us = us;
        this.usmvc = usmvc;
        this.vin.btnUsuarios.addActionListener(this);
        this.vin.btnSisApp.addActionListener(this);
        this.vin.btnSisBD.addActionListener(this);
        this.vin.btnServicio.addActionListener(this);
        this.vl.btnAceptar.addActionListener(this);        
        this.vus.btnVolver.addActionListener(this);
        this.vsisapp.btnVolver.addActionListener(this);
        this.vsisbd.btnVolver2.addActionListener(this);
        this.vser.btnVolver.addActionListener(this);
        this.vus.btnGuardar.addActionListener(this);
       
        
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
    
     public void limpiarUsuario(){
        vus.txtRut.setText(null);        
        vus.txtNombre.setText(null);
        vus.txtApaterno.setText(null);
        vus.txtAmaterno.setText(null);
        vus.txtFnacimiento.setText(null);
        vus.txtTelefono.setText(null);
        vus.txtEmail.setText(null);
        vus.txtDireccion.setText(null);
        vus.txtUsuario.setText(null);
        vus.txtContrasena.setText(null);
        vus.txtIdPerfil.setText(null);
        
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
        
        if(e.getSource() == vin.btnSisApp){
                vin.setVisible(false);
                vsisapp.setTitle("Vista Sistema Aplicaciones");
                vsisapp.setLocationRelativeTo(null);  
                vsisapp.setVisible(true);  
        }
        
        if(e.getSource() == vin.btnSisBD){
                vin.setVisible(false);
                vsisbd.setTitle("Vista Sistema Base de Datos");
                vsisbd.setLocationRelativeTo(null);  
                vsisbd.setVisible(true);  
        }
        if(e.getSource() == vin.btnServicio){
                vin.setVisible(false);
                vsisbd.setTitle("Vista Sistema Base de Datos");
                vsisbd.setLocationRelativeTo(null);  
                vsisbd.setVisible(true);  
        }
        
        
        
        
        
        
         
        //Acciones Vista Usuario
        if(e.getSource() == vus.btnVolver){
                vus.setVisible(false);
                volver();  
        }
        //Acciones Vista Sistema Aplicaciones sisapp
        if(e.getSource() == vsisapp.btnVolver){
                vsisapp.setVisible(false);
                volver();  
        }   
        
        if(e.getSource() == vsisbd.btnVolver2){
                vsisbd.setVisible(false);
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
        
        //Vista Gestion Usuarios
        if(e.getSource() == vus.btnGuardar){            
            us.setRut_us(vus.txtRut.getText());
            us.setDv_us(vus.txtDv.getText());
            us.setNombre_us(vus.txtNombre.getText());
            us.setApaterno_us(vus.txtApaterno.getText());
            us.setAmaterno_us(vus.txtAmaterno.getText());
            us.setFnaciemiento_us(vus.txtFnacimiento.getText());
            us.setTelefono_us(vus.txtTelefono.getText());
            us.setEmail_us(vus.txtEmail.getText());
            us.setDireccion(vus.txtDireccion.getText());
            us.setUsuario(vus.txtUsuario.getText());
            us.setContrasena(vus.txtContrasena.getText());
            us.setPerfil_id(Integer.parseInt(vus.txtIdPerfil.getText()));           
                    
            
            if(usmvc.registrar(us))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiarUsuario();
            } else 
            {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                //limpiarUsuario();
            }          
        }
        
    }
    
}
