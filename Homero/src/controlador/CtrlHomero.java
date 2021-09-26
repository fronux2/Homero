package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Login;
import modelo.LoginMVC;
import modelo.Usuario;
import modelo.UsuarioMVC;
import vista.VistaIndex;
import vista.VistaListaUsuarios;
import vista.VistaLogin;
import vista.VistaServicio;
import vista.VistaSisApli;
import vista.VistaSisBD;
import vista.VistaUsuario;


public class CtrlHomero implements ActionListener{
    
  
    
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
    private VistaListaUsuarios vlus;
    TableRowSorter trs;
    
    
      public CtrlHomero(Login l, LoginMVC lmvc, VistaLogin vl, VistaIndex vin, VistaUsuario vus, VistaSisApli vsisapp, VistaSisBD vsisbd, VistaServicio vser, Usuario us, UsuarioMVC usmvc, VistaListaUsuarios vlus){
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
        this.vlus = vlus;
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
        this.vus.btnListar.addActionListener(this);
       
        
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
    
     public void LlenarTabla(JTable tabla){
        DefaultTableModel modeloT = new DefaultTableModel();
        tabla.setModel(modeloT);
        modeloT.addColumn("id");
        modeloT.addColumn("rut");
        modeloT.addColumn("dv");
        modeloT.addColumn("nombre");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Fecha Nacimiento");
        modeloT.addColumn("Telefono");
        modeloT.addColumn("Email");
        modeloT.addColumn("Direccion");
        modeloT.addColumn("Usuario");
        modeloT.addColumn("Contrasena");
        modeloT.addColumn("ID Perfil");
        
        Object[] columna = new Object[13];
        
        int numRegistros = usmvc.listar().size();
        
        for (int i=0; i<numRegistros; i++ ){
            columna[0] = usmvc.listar().get(i).getId_usuario();
            columna[1] = usmvc.listar().get(i).getRut_us();
            columna[2] = usmvc.listar().get(i).getDv_us();
            columna[3] = usmvc.listar().get(i).getNombre_us();
            columna[4] = usmvc.listar().get(i).getApaterno_us();
            columna[5] = usmvc.listar().get(i).getAmaterno_us();
            columna[6] = usmvc.listar().get(i).getFnaciemiento_us();
            columna[7] = usmvc.listar().get(i).getTelefono_us();
            columna[8] = usmvc.listar().get(i).getEmail_us();
            columna[9] = usmvc.listar().get(i).getDireccion();
            columna[10] = usmvc.listar().get(i).getUsuario();
            columna[11] = usmvc.listar().get(i).getContrasena();
            columna[12] = usmvc.listar().get(i).getPerfil_id();
            modeloT.addRow(columna);
        }
        
    }        

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
        
        if(e.getSource() == vus.btnListar){
            
            vus.setVisible(false);
            vlus.setTitle("Vista Lista Usuarios");
            vlus.setLocationRelativeTo(null);  
            vlus.setVisible(true);         
            LlenarTabla(vlus.jTablaUsuarios);
        }        
                
    }
    
}
