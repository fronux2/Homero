package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import static java.lang.Integer.parseInt;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import vista.*;
import modelo.*;

//codificacion contraseña
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

public class CtrlHomero implements ActionListener {

    private VistaLogin vl;
    private VistaIndex vin;
    private VistaUsuario vus;
    private VistaSisApli vsisapp;
    private VistaSisBD vsisbd;
    private VistaServicio vser;
    private UsuarioMVC usmvc;
    private Usuario us;
    private VistaListaUsuarios vlus;
    private SisApp sisapp;
    private SisAppMVC sisappmvc;
    private SisBD sisbd;
    private SisBDMVC sisbdmvc;
    TableRowSorter trs;
    private Servicio ser;
    private ServicioMVC sermvc;
    private VistaListaServicio vlser;
    private VistaListaSisApp vlsisapp;
    private VistaListaSisBD vlsisbd;

    public CtrlHomero(VistaLogin vl, VistaIndex vin, VistaUsuario vus, VistaSisApli vsisapp, VistaSisBD vsisbd, VistaServicio vser, Usuario us, UsuarioMVC usmvc, VistaListaUsuarios vlus, SisApp sisapp, SisAppMVC sisappmvc, SisBD sisbd, SisBDMVC sisbdmvc, Servicio ser, ServicioMVC sermvc, VistaListaServicio vlser, VistaListaSisApp vlsisapp, VistaListaSisBD vlsisbd) {
        this.vl = vl;
        this.vin = vin;
        this.vus = vus;
        this.vsisapp = vsisapp;
        this.vsisbd = vsisbd;
        this.sisbdmvc = sisbdmvc;
        this.sisbd = sisbd;
        this.vser = vser;
        this.us = us;
        this.usmvc = usmvc;
        this.vlus = vlus;
        this.sisapp = sisapp;
        this.sisappmvc = sisappmvc;
        this.ser = ser;
        this.sermvc = sermvc;
        this.vlser = vlser;
        this.vlsisapp = vlsisapp;
        this.vlsisbd = vlsisbd;
        this.vsisapp.btnListar.addActionListener(this);
        this.vsisbd.btnListar.addActionListener(this);
        this.vin.btnUsuarios.addActionListener(this);
        this.vin.btnSisApp.addActionListener(this);
        this.vin.btnSisBD.addActionListener(this);
        this.vin.btnServicio.addActionListener(this);
        this.vl.btnAceptar.addActionListener(this);
        this.vus.btnVolver.addActionListener(this);
        this.vsisapp.btnVolver.addActionListener(this);
        this.vsisbd.btnVolver2.addActionListener(this);
        this.vser.btnVolver.addActionListener(this);
        this.vlus.btnVolver.addActionListener(this);
        this.vus.btnGuardar.addActionListener(this);
        this.vus.btnListar.addActionListener(this);
        this.vus.btnBuscar.addActionListener(this);
        this.vus.btnModificar.addActionListener(this);
        this.vsisapp.btnGuardar.addActionListener(this);
        this.vsisapp.btnListar.addActionListener(this);
        this.vsisapp.btnModificar.addActionListener(this);
        this.vsisbd.btnGuardar.addActionListener(this);
        this.vser.btnGuardar.addActionListener(this);
        this.vser.btnListar.addActionListener(this);
        this.vser.btnModificar.addActionListener(this);
        this.vser.btnBuscar.addActionListener(this);
        this.vlsisapp.btnVolver.addActionListener(this);
        this.vlser.btnVolver.addActionListener(this);
        this.vlsisbd.btnVolver.addActionListener(this);
        this.vsisapp.btnBuscar.addActionListener(this);
        this.vsisbd.btnBuscar.addActionListener(this);
        this.vsisbd.btnModificar.addActionListener(this);
        this.vlus.Seleccionar.addActionListener(this);
        this.vlsisapp.Seleccionar.addActionListener(this);
        this.vlsisbd.Seleccionar.addActionListener(this);
        this.vlser.Seleccionar.addActionListener(this);
        this.vin.Salir.addActionListener(this);
        this.vlser.modificar.addActionListener(this);
        this.vlser.actualizar.addActionListener(this);
        this.vus.cbox_region.addActionListener(this);
        this.vus.cbox_comuna.addActionListener(this);
        this.vus.txtContrasenaVieja.addActionListener(this);

    }

    public void iniciar() {
        vl.setResizable(false);
        vin.setResizable(false);
        vlsisapp.setResizable(false);
        vlsisbd.setResizable(false);
        vlus.setResizable(false);
        vlser.setResizable(false);
        vus.setResizable(false);
        vser.setResizable(false);
        vsisapp.setResizable(false);
        vsisbd.setResizable(false);

        vser.btnGuardar.setBackground(new Color(0, 123, 255));
        vser.btnListar.setBackground(new Color(0, 123, 255));
        vser.btnModificar.setBackground(new Color(0, 123, 255));
        vser.btnVolver.setBackground(new Color(0, 123, 255));
        vser.btnBuscar.setBackground(new Color(0, 123, 255));
        JTextField t = new JTextField();
        vsisapp.btnGuardar.setBackground(new Color(0, 123, 255));
        vsisapp.btnListar.setBackground(new Color(0, 123, 255));
        vsisapp.btnModificar.setBackground(new Color(0, 123, 255));
        vsisapp.btnVolver.setBackground(new Color(0, 123, 255));
        vsisapp.btnBuscar.setBackground(new Color(0, 123, 255));
        vus.btnGuardar.setBackground(new Color(0, 123, 255));
        vus.btnListar.setBackground(new Color(0, 123, 255));
        vus.btnModificar.setBackground(new Color(0, 123, 255));
        vus.btnVolver.setBackground(new Color(0, 123, 255));
        vus.btnBuscar.setBackground(new Color(0, 123, 255));
        vsisbd.btnGuardar.setBackground(new Color(0, 123, 255));
        vsisbd.btnListar.setBackground(new Color(0, 123, 255));
        vsisbd.btnModificar.setBackground(new Color(0, 123, 255));
        vsisbd.btnVolver2.setBackground(new Color(0, 123, 255));
        vsisbd.btnBuscar.setBackground(new Color(0, 123, 255));
        vl.txtUsuario.setHorizontalAlignment(JTextField.CENTER);
        vl.txtContrasena.setHorizontalAlignment(JTextField.CENTER);
        vl.jPanel1.setBackground(new Color(25, 25, 25));
        vl.getContentPane().setBackground(new Color(0, 0, 0));
        vl.txtUsuario.setBorder(new LineBorder(new Color(52, 152, 219)));
        vl.txtContrasena.setBorder(new LineBorder(new Color(52, 152, 219)));
        vl.btnAceptar.setBorder(new LineBorder(new Color(45, 196, 110)));
        vl.btnAceptar.setBackground(new Color(25, 25, 25));            
        vl.setTitle("Login");
        vl.setLocationRelativeTo(null);
        vl.setVisible(true);
        LlenarTablaSisBD(vlsisbd.jTablaBD);
        LlenarTabla(vlus.jTablaUsuarios);
        LlenarTablaSer(vlser.jTablaServicio);
        LlenarTablaSisApp(vlsisapp.jTablaSisApp);
        vus.txtContrasenaVieja.setVisible(false);
        vus.lvieja.setVisible(false);

    }

    public void volver() {
        vin.setTitle("Vista Index");
        vin.setLocationRelativeTo(null);
        vin.setVisible(true);
    }

    public void limpiarUsuario() {
        vus.txtRut.setText(null);
        vus.txtNombre.setText(null);
        vus.txtApaterno.setText(null);
        vus.txtAmaterno.setText(null);
        vus.txtDv.setText(null);
        vus.jdFecha.setDate(null);
        //vus.txtFnacimiento.setText(null);
        vus.txtTelefono.setText(null);
        vus.txtEmail.setText(null);
        vus.txtDireccion.setText(null);
        vus.txtUsuario.setText(null);
        vus.txtContrasena.setText(null);
        //vus.txtIdPerfil.setText(null);
        vus.cbox_perfiles.removeAllItems();
        
        
        vus.txtActivo.setText(null);
    }

    
    public void limpiarServicio() {
        vser.cbox_idSistemaApp.removeAllItems();
        vser.txtNombre.setText(null);
        vser.cbox_tipo_serv.removeAllItems();
        vser.txtAplicacion.setText(null);
        vser.txtBuscar.setText(null);
    }

    public void limpiarSisApp() {
        vsisapp.txtActivo.setText(null);
        vsisapp.txtBuscar.setText(null);
        vsisapp.cbox_idEncargado.removeAllItems();
        vsisapp.cbox_idServidor.removeAllItems();
        vsisapp.cbox_idlenguaje.removeAllItems();        
        vsisapp.txtNSis.setText(null);
        vsisapp.cbox_idBD.removeAllItems();        
        
    }

    public void limpiarBD() {
        vsisapp.txtActivo.setText(null);
        vsisbd.txtUsuario.setText(null);
        vsisbd.txtContrasena.setText(null);
        //vsisbd.txtSBD.setText(null);
        vsisbd.txtActivo.setText(null);
        vsisbd.cbox_idEncargado.removeAllItems();
        vsisbd.cbox_idServidor.removeAllItems();
        vsisbd.txtBuscar.setText(null);
    }

    //llenar columnas jtable Listar Usuarios
    public void LlenarTabla(JTable tabla) {
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
        modeloT.addColumn("Región");
        modeloT.addColumn("Comuna");
        modeloT.addColumn("Direccion");
        modeloT.addColumn("Usuario");
        modeloT.addColumn("Contrasena");
        modeloT.addColumn("ID Perfil");
        modeloT.addColumn("Activo");
        Object[] columna = new Object[16];

        int numRegistros = usmvc.listar().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = usmvc.listar().get(i).getId_usuario();
            columna[1] = usmvc.listar().get(i).getRut_us();
            columna[2] = usmvc.listar().get(i).getDv_us();
            columna[3] = usmvc.listar().get(i).getNombre_us();
            columna[4] = usmvc.listar().get(i).getApaterno_us();
            columna[5] = usmvc.listar().get(i).getAmaterno_us();
            columna[6] = usmvc.listar().get(i).getFnaciemiento_us();
            columna[7] = usmvc.listar().get(i).getTelefono_us();
            columna[8] = usmvc.listar().get(i).getEmail_us();
            columna[9] = usmvc.listar().get(i).getId_region()+"   . "+ usmvc.listar().get(i).getRegion();
            columna[10] = usmvc.listar().get(i).getId_comuna()+"   . "+usmvc.listar().get(i).getComuna();
            columna[11] = usmvc.listar().get(i).getDireccion();
            columna[12] = usmvc.listar().get(i).getUsuario();
            columna[13] = usmvc.listar().get(i).getContrasena();
            columna[14] = usmvc.listar().get(i).getPerfil_id() + "   . " + usmvc.listar().get(i).getDetalle();
            columna[15] = usmvc.listar().get(i).getActivo();
            modeloT.addRow(columna);
        }

    }

    public void LlenarTablaSer(JTable tabla) {
        DefaultTableModel modeloT = new DefaultTableModel();        

        tabla.setModel(modeloT);
        modeloT.addColumn("id servicios");
        modeloT.addColumn("nombre servicio");
        modeloT.addColumn("tipo servicio");
        modeloT.addColumn("id sisapp");
        modeloT.addColumn("activo");
        Object[] columna = new Object[5];

        int numRegistros = sermvc.listar().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = sermvc.listar().get(i).getId_servicios();
            columna[1] = sermvc.listar().get(i).getNombre_serv();
            columna[2] = sermvc.listar().get(i).getTipo_serv_id()+ "   . " + sermvc.listar().get(i).getNombre_tipo();
            columna[3] = sermvc.listar().get(i).getSisApp() + "   . " + sermvc.listar().get(i).getNombre_sis();
            columna[4] = sermvc.listar().get(i).getActivo(); 
            //columna[4] = dr;

            modeloT.addRow(columna);
        }

    }

    public void LlenarTablaSisApp(JTable tabla) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tabla.setModel(modeloT);
        modeloT.addColumn("id Sistema");
        modeloT.addColumn("Software BD");
        modeloT.addColumn("Nombre Sistema");
        modeloT.addColumn("Lenguaje Sistema");
        modeloT.addColumn("Servidor");
        modeloT.addColumn("Usuario");
        modeloT.addColumn("Activo");
        Object[] columna = new Object[7];

        int numRegistros = sisappmvc.listar().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = sisappmvc.listar().get(i).getId_sistemas();
            columna[1] = sisappmvc.listar().get(i).getId_bd()+"   . "+"name";
            columna[2] = sisappmvc.listar().get(i).getNombre_sis();
            columna[3] = sisappmvc.listar().get(i).getId_lenguaje() +"   . "+ sisappmvc.listar().get(i).getNombre_lenguaje();            
            columna[4] = sisappmvc.listar().get(i).getServidor_id() + "   . " + sisappmvc.listar().get(i).getNom_servidor();
            columna[5] = sisappmvc.listar().get(i).getUsuario_id() + "   . " + sisappmvc.listar().get(i).getNombre_us() + " " + sisappmvc.listar().get(i).getApellido_paterno()+ " " + sisappmvc.listar().get(i).getApellido_materno();
            columna[6] = sisappmvc.listar().get(i).getActivo();
            modeloT.addRow(columna);
        }
    }

    public void LlenarTablaSisBD(JTable tabla) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tabla.setModel(modeloT);
        modeloT.addColumn("ID BD");
        modeloT.addColumn("Usuario");
        modeloT.addColumn("Contrasena");
        modeloT.addColumn("Software BD");
        modeloT.addColumn("ID Servidor");
        modeloT.addColumn("ID Usuario");
        modeloT.addColumn("Nombre BD");
        modeloT.addColumn("Activo");
        Object[] columna = new Object[8];

        int numRegistros = sisbdmvc.listar().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = sisbdmvc.listar().get(i).getId_bd();
            columna[1] = sisbdmvc.listar().get(i).getUsuario();
            columna[2] = sisbdmvc.listar().get(i).getContrasena();
            columna[3] = sisbdmvc.listar().get(i).getLenguaje_id()+ "   . " + sisbdmvc.listar().get(i).getNombre_leng();
            columna[4] = sisbdmvc.listar().get(i).getServidor_id() + "   . " + sisbdmvc.listar().get(i).getNom_servidor();
            columna[5] = sisbdmvc.listar().get(i).getUsuario_id() + "   . " + sisbdmvc.listar().get(i).getNombre_us() + " " + sisbdmvc.listar().get(i).getApaterno_us()+ " " + sisbdmvc.listar().get(i).getAmaterno_us();;
            columna[6] = sisbdmvc.listar().get(i).getNombre_bd();
            columna[7] = sisbdmvc.listar().get(i).getActivo();
            modeloT.addRow(columna);
        }
    }

    //funcion que verifica que el email este bien escrito
    protected static boolean esEmailCorrecto(String email) {

        boolean valido = false;

        Pattern patronEmail = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");

        Matcher mEmail = patronEmail.matcher(email.toLowerCase());
        if (mEmail.matches()) {
            valido = true;
        }
        return valido;
    }

    //funcion que verifica el rut sea correcto y despues lo igualamos con el dv
    public static String dv(String rut) {
        Integer M = 0, S = 1, T = Integer.parseInt(rut);
        for (; T != 0; T = (int) Math.floor(T /= 10)) {
            S = (S + T % 10 * (9 - M++ % 6)) % 11;
        }
        return (S > 0) ? String.valueOf(S - 1) : "k";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Acciones Vista Index

        if (e.getSource() == vin.btnUsuarios) {
            vin.setVisible(false);
            vus.setTitle("Vista Usuario");
            vus.setLocationRelativeTo(null);
            vus.setVisible(true);
            usmvc.Cargar_combobox(vus.cbox_perfiles);
            usmvc.Cargar_combobox_region(vus.cbox_region);
            usmvc.Cargar_combobox_comuna(vus.cbox_comuna);            
            vus.txtFecha.setVisible(false);
            vus.lfecha.setVisible(false);
            vus.txtPerfil.setVisible(false);
            vus.lperfil.setVisible(false);
            vus.txtActivo.setVisible(false);
            vus.lactivo.setVisible(false);
            vus.btnModificar.setVisible(false);
            vus.btnGuardar.setVisible(true);

            String a = "01/01/1975";
            Date w = new Date(Date.parse(a));
            String b = "01/01/2021";
            Date z = new Date(Date.parse(b));

            String de = LocalDate.now().toString();
            vus.jdFecha.setSelectableDateRange(w, z);
            System.out.println(de);
            System.out.println(w);
            System.out.println(z);

        }

        if (e.getSource() == vin.btnSisApp) {
            vsisapp.btnGuardar.setVisible(true);
            vin.setVisible(false);
            vsisapp.txtid.setVisible(false);
            vsisapp.setTitle("Vista Sistema Aplicaciones");
            vsisapp.setLocationRelativeTo(null);
            vsisapp.setVisible(true);
            vsisapp.txtActivo.setVisible(false);
            vsisapp.btnModificar.setVisible(false);
            sisappmvc.Cargar_comboboxServidorId(vsisapp.cbox_idServidor);
            sisappmvc.Cargar_comboboxIdUsuario(vsisapp.cbox_idEncargado);
            sisappmvc.Cargar_comboboxBD(vsisapp.cbox_idBD);
            sisappmvc.Cargar_comboboxLenguaje(vsisapp.cbox_idlenguaje);
            vsisapp.txtActivo.setVisible(false);
            
            
        }
        
               
        if (e.getSource() == vin.btnSisBD) {
            vsisbd.lencargado.setVisible(false);
            vsisbd.lservidor.setVisible(false);
            vsisbd.txtEncargado.setVisible(false);
            vsisbd.txtServidor.setVisible(false);
            vsisbd.lactivo.setVisible(false);
            vsisbd.txtActivo.setVisible(false);
            vsisbd.btnModificar.setVisible(false);
            vsisbd.btnGuardar.setVisible(true);
            vin.setVisible(false);
            vsisbd.setTitle("Vista Sistema Base de Datos");
            vsisbd.setLocationRelativeTo(null);
            vsisbd.setVisible(true);
            vsisbd.txtid.setVisible(false);
            sisbdmvc.Cargar_comboboxServidorId(vsisbd.cbox_idServidor);
            sisbdmvc.Cargar_comboboxIdUsuario(vsisbd.cbox_idEncargado);
            sisbdmvc.Cargar_comboboxLenguaje(vsisbd.cbox_lenguaje);
        }
        if (e.getSource() == vin.btnServicio) {
            vser.lactivo.setVisible(false);
            vser.laplicacion.setVisible(false);
            vser.txtAplicacion.setVisible(false);
            vser.txtActivo.setVisible(false);
            vser.txtAplicacion.setVisible(false);
            vser.btnModificar.setVisible(false);
            vin.setVisible(false);
            vser.txtid.setVisible(false);
            vser.setTitle("Vista Servicio");
            vser.setLocationRelativeTo(null);
            vser.setVisible(true);
            sermvc.Cargar_combobox(vser.cbox_idSistemaApp);
            sermvc.Cargar_combobox_servicio(vser.cbox_tipo_serv);

        }
        //ACCIONES BOTON VOLVER 
        //Acciones Vista Usuario
        if (e.getSource() == vus.btnVolver) {
            limpiarUsuario();
            vus.setVisible(false);
            volver();
        }
        //Acciones Vista Sistema Aplicaciones sisapp
        if (e.getSource() == vsisapp.btnVolver) {
            limpiarSisApp();
            vsisapp.setVisible(false);
            volver();
        }

        if (e.getSource() == vsisbd.btnVolver2) {
            limpiarBD();
            vsisbd.setVisible(false);
            volver();
        }
        //Acciones Vista Usuario
        if (e.getSource() == vlus.btnVolver) {
            vlus.setVisible(false);
            volver();
            limpiarUsuario();

        }
        //Acciones Vista Servicio
        if (e.getSource() == vser.btnVolver) {
            vser.setVisible(false);
            volver();
            limpiarServicio();

        }

        if (e.getSource() == vlsisapp.btnVolver) {
            vlsisapp.setVisible(false);
            volver();
            limpiarServicio();

        }
        if (e.getSource() == vlser.btnVolver) {
            vlser.setVisible(false);
            volver();
            limpiarServicio();

        }
        if (e.getSource() == vlsisbd.btnVolver) {
            vlsisbd.setVisible(false);
            volver();
            limpiarServicio();

        }
        //ACCION BOTON ACEPTAR EN LOGIN
        if (e.getSource() == vl.btnAceptar) {

            us.setUsuario(vl.txtUsuario.getText());
            String cadenaEncriptada = DigestUtils.md5Hex(vl.txtContrasena.getText()); 
            us.setContrasena(cadenaEncriptada);

            if (usmvc.buscarLogin(us)) {
                vin.nombre.setText("Bienvenido: " + String.valueOf(us.getNombre_us()) + " " + String.valueOf(us.getApaterno_us()));
                vin.getContentPane().setBackground(new Color(213, 204, 249));
                vser.getContentPane().setBackground(new Color(213, 204, 249));
                vsisapp.getContentPane().setBackground(new Color(213, 204, 249));
                vsisbd.getContentPane().setBackground(new Color(213, 204, 249));
                vus.getContentPane().setBackground(new Color(213, 204, 249));
                vlser.getContentPane().setBackground(new Color(213, 204, 249));
                vlus.getContentPane().setBackground(new Color(213, 204, 249));
                vlsisbd.getContentPane().setBackground(new Color(213, 204, 249));
                vlsisapp.getContentPane().setBackground(new Color(213, 204, 249));
                vin.jPanel1.setBackground(new Color(51, 57, 63));
                vin.jLabel1.setBackground(new Color(0, 123, 255));
                if (us.getPerfil_id() == 1 || us.getPerfil_id() == 3) {
                    vl.setVisible(false);
                    vin.setTitle("Index");
                    vin.setLocationRelativeTo(null);
                    vin.setVisible(true);
                    vin.btnServicio.setVisible(true);
                    vin.btnSisApp.setVisible(true);
                    vin.btnSisBD.setVisible(true);
                    vin.btnUsuarios.setVisible(true);
                    if (us.getPerfil_id() == 3) {
                        vin.btnUsuarios.setVisible(false);
                        vin.jusuarios.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales Incorrectas.");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Credenciales Incorrectas.");
            }
        }

        if (e.getSource() == vin.Salir) {

            vin.setVisible(false);
            vl.setTitle("Vista Login");
            vl.setLocationRelativeTo(null);
            vl.setVisible(true);
            vl.txtUsuario.setText(null);
            vl.txtContrasena.setText(null);

        }
        //ACCION BOTONES GUARDAR

        if (e.getSource() == vsisapp.btnGuardar) {

            if (vsisapp.cbox_idBD.getSelectedIndex() == 0 || vsisapp.txtNSis.getText() == null || vsisapp.cbox_idlenguaje.getSelectedIndex() == 0 || vsisapp.cbox_idServidor.getSelectedIndex() == 0 || vsisapp.cbox_idEncargado.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Debes LLenar Todos los Campos");
            } else {       
                String cbox_bd = (String) vsisapp.cbox_idBD.getSelectedItem(); 
                String idbd = cbox_bd.substring(0, 3); 
                int parseIdbd = parseInt(idbd.replaceAll("\\s", "")); 
                sisapp.setId_bd(parseIdbd);    
                
                sisapp.setNombre_sis(vsisapp.txtNSis.getText());                
                String cbox_lenguaje = (String) vsisapp.cbox_idlenguaje.getSelectedItem();                
                String idlenguaje = cbox_lenguaje.substring(0, 3);
                int parseIdlenguaje = parseInt(idlenguaje.replaceAll("\\s", "")); 
                sisapp.setId_lenguaje(parseIdlenguaje);   
                
                String cbox_serv = (String) vsisapp.cbox_idServidor.getSelectedItem();                
                String idserv = cbox_serv.substring(0, 3);
                int parseIdserv = parseInt(idserv.replaceAll("\\s", "")); 
                sisapp.setServidor_id(parseIdserv);
                
                String cbox_enc = (String) vsisapp.cbox_idEncargado.getSelectedItem();                
                String idenc = cbox_enc.substring(0, 3);
                int parseIdenc = parseInt(idenc.replaceAll("\\s", "")); 
                sisapp.setUsuario_id(parseIdenc);
                
                if (sisappmvc.registrar(sisapp)) {
                    limpiarSisApp();
                    sisappmvc.Cargar_comboboxServidorId(vsisapp.cbox_idServidor);
                    sisappmvc.Cargar_comboboxIdUsuario(vsisapp.cbox_idEncargado);
                    LlenarTablaSisApp(vlsisapp.jTablaSisApp);
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }
            }

        }

        
        if (e.getSource() == vsisbd.btnGuardar) {

            if (vsisbd.txtUsuario.getText() == null || vsisbd.txtContrasena.getText() == null || vsisbd.cbox_idServidor.getSelectedIndex() == 0  || vsisbd.cbox_idServidor.getSelectedIndex() == 0 || vsisbd.cbox_idEncargado.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Debes de LLenar todos los Campos");
            } else {
                
                sisbd.setUsuario(vsisbd.txtUsuario.getText());
                sisbd.setContrasena(vsisbd.txtContrasena.getText());
                
                String cbox_lenguaje = (String) vsisbd.cbox_lenguaje.getSelectedItem();                
                String idlenguaje = cbox_lenguaje.substring(0, 3);
                int parseIdlenguaje = parseInt(idlenguaje.replaceAll("\\s", "")); 
                sisbd.setLenguaje_id(parseIdlenguaje);                
                                
                String cbox_serv = (String) vsisbd.cbox_idServidor.getSelectedItem();                
                String idserv = cbox_serv.substring(0, 3);
                int parseIdserv = parseInt(idserv.replaceAll("\\s", "")); 
                sisbd.setServidor_id(parseIdserv);
                
                String cbox_enc = (String) vsisbd.cbox_idEncargado.getSelectedItem();                
                String idenc = cbox_enc.substring(0, 3);
                int parseIdenc = parseInt(idenc.replaceAll("\\s", "")); 
                sisbd.setUsuario_id(parseIdenc);
                
                sisbd.setNombre_bd(vsisbd.txtNombreBD.getText());

                if (sisbdmvc.registrar(sisbd)) {
                    limpiarBD();
                    sisbdmvc.Cargar_comboboxServidorId(vsisbd.cbox_idServidor);
                    sisbdmvc.Cargar_comboboxIdUsuario(vsisbd.cbox_idEncargado);
                    LlenarTablaSisBD(vlsisbd.jTablaBD);
                    JOptionPane.showMessageDialog(null, "Registro Guardado");

                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                    //limpiarUsuario();
                }
            }

        }

        
        if (e.getSource() == vus.btnGuardar) {

            if (vus.txtRut.getText() == null || vus.txtDv.getText() == null || vus.txtDv.getText() == null || vus.txtNombre.getText() == null || vus.txtApaterno.getText() == null || vus.txtAmaterno.getText() == null || vus.jdFecha.getDate() == null || vus.txtTelefono.getText() == null || vus.txtEmail.getText() == null || vus.txtDireccion.getText() == null || vus.txtUsuario.getText() == null || vus.txtContrasena.getText() == null || vus.cbox_perfiles.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Debes de llenar Todos los Campos");
            } else {
                us.setRut_us(vus.txtRut.getText());
                us.setDv_us(vus.txtDv.getText());
                us.setNombre_us(vus.txtNombre.getText());
                us.setApaterno_us(vus.txtApaterno.getText());
                us.setAmaterno_us(vus.txtAmaterno.getText());
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                us.setFnaciemiento_us(formatoFecha.format(vus.jdFecha.getDate()));
                us.setTelefono_us(vus.txtTelefono.getText());
                us.setEmail_us(vus.txtEmail.getText());
                us.setDireccion(vus.txtDireccion.getText());
                us.setUsuario(vus.txtUsuario.getText());               
                
                String cadenaEncriptada = DigestUtils.md5Hex(vus.txtContrasena.getText());   
                us.setContrasena(cadenaEncriptada);
                String cbox_sistema = (String) vus.cbox_perfiles.getSelectedItem();                
                String idperfil = cbox_sistema.substring(0, 3);
                int parseIdperfil = parseInt(idperfil.replaceAll("\\s", ""));  
                us.setPerfil_id(parseIdperfil);
                
                String cbox_region = (String) vus.cbox_region.getSelectedItem();                
                String idregion = cbox_region.substring(0, 3);
                int parseIdreg = parseInt(idregion.replaceAll("\\s", ""));  
                us.setId_region(parseIdreg);
                
                String cbox_comuna = (String) vus.cbox_comuna.getSelectedItem();                
                String idcomuna = cbox_comuna.substring(0, 3);
                int parseIdcomuna = parseInt(idcomuna.replaceAll("\\s", ""));  
                us.setId_comuna(parseIdcomuna);
                
                String a = dv(vus.txtRut.getText());
                String b = vus.txtDv.getText();
                System.out.println(vus.jdFecha.getDate());
                if (formatoFecha.format(vus.jdFecha.getDate()) == null) {
                    JOptionPane.showMessageDialog(null, "Fecha incorrecta");
                }

                if (!usmvc.buscarRut(us)) {
                    if (a == null ? b == null : a.equals(b)) {
                        if (esEmailCorrecto(vus.txtEmail.getText()) == true) {

                            if (usmvc.registrar(us)) {
                                limpiarUsuario();
                                usmvc.Cargar_combobox(vus.cbox_perfiles);
                                LlenarTabla(vlus.jTablaUsuarios);
                                JOptionPane.showMessageDialog(null, "Registro Guardado");

                            } else {
                                JOptionPane.showMessageDialog(null, "Error al guardar");
                                //limpiarUsuario();
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "email incorrecto");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "RUT INCORRECTO");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El rut seleccionado ya esta registrado");
                }
            }

        }

        
        if (e.getSource() == vser.btnGuardar) {
            if (vser.txtNombre.getText() == null || vser.cbox_tipo_serv.getSelectedIndex() == 0 || vser.cbox_idSistemaApp.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Debes de llenar Todos los Campos");
            } else {
                ser.setNombre_serv(vser.txtNombre.getText());
                
                String cbox_tipo_serv = (String) vser.cbox_tipo_serv.getSelectedItem();                
                String idtiposerv = cbox_tipo_serv.substring(0, 3);
                int parseIdtiposerv = parseInt(idtiposerv.replaceAll("\\s", ""));  
                ser.setTipo_serv_id(parseIdtiposerv);                
                               
                String cbox_sistema = (String) vser.cbox_idSistemaApp.getSelectedItem();                
                String idapp = cbox_sistema.substring(0, 3);
                int parseIdserv = parseInt(idapp.replaceAll("\\s", ""));
                ser.setSisApp(parseIdserv);
                
                if (sermvc.registrar(ser)) {
                    limpiarServicio();
                    sermvc.Cargar_combobox(vser.cbox_idSistemaApp);
                    LlenarTablaSer(vlser.jTablaServicio);
                    JOptionPane.showMessageDialog(null, "Registro Guardado");

                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                    //limpiarUsuario();
                }
            }

        }

        
        //ACCION DE BOTON LISTAR
        if (e.getSource() == vus.btnListar) {

            vus.setVisible(false);
            vlus.setTitle("Vista Lista Usuarios");
            vlus.setLocationRelativeTo(null);
            vlus.setVisible(true);
            limpiarUsuario();
        }

        if (e.getSource() == vser.btnListar) {

            vser.setVisible(false);
            vlser.setTitle("Vista Lista Servicio");
            vlser.setLocationRelativeTo(null);
            vlser.setVisible(true);
            limpiarServicio();
        }

        if (e.getSource() == vsisapp.btnListar) {

            vsisapp.setVisible(false);
            vlsisapp.setTitle("Vista Lista Sistema Aplicacion");
            vlsisapp.setLocationRelativeTo(null);
            vlsisapp.setVisible(true);

            limpiarSisApp();
        }

        if (e.getSource() == vsisbd.btnListar) {

            vsisbd.setVisible(false);
            vlsisbd.setTitle("Vista Lista Sistema Base de Dato");
            vlsisbd.setLocationRelativeTo(null);
            vlsisbd.setVisible(true);
            limpiarBD();
        }

        
        //ACCION DE BOTONES MODIFICAR
        if (e.getSource() == vus.btnModificar) {

            us.setRut_us(vus.txtRut.getText());
            us.setDv_us(vus.txtDv.getText());
            us.setNombre_us(vus.txtNombre.getText());
            us.setApaterno_us(vus.txtApaterno.getText());
            us.setAmaterno_us(vus.txtAmaterno.getText());
            if (vus.jdFecha.getDate() == null) {
                us.setFnaciemiento_us(vus.txtFecha.getText());
            }
            if (vus.jdFecha.getDate() != null) {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                us.setFnaciemiento_us(formatoFecha.format(vus.jdFecha.getDate()));
            }
            us.setTelefono_us(vus.txtTelefono.getText());
            us.setEmail_us(vus.txtEmail.getText());
            
            String cbox_region = (String) vus.cbox_region.getSelectedItem();               
            String idregion = cbox_region.substring(0, 3);
            int parseIdregion = parseInt(idregion.replaceAll("\\s", ""));  
            us.setId_region(parseIdregion);
            
            String cbox_comuna = (String) vus.cbox_comuna.getSelectedItem();               
            String idcomuna = cbox_comuna.substring(0, 3);
            int parseIdcomuna = parseInt(idcomuna.replaceAll("\\s", ""));  
            us.setId_comuna(parseIdcomuna);
            
            us.setDireccion(vus.txtDireccion.getText());
            us.setUsuario(vus.txtUsuario.getText());
            String contrasena = vus.txtContrasena.getText();
            String contrasenavieja = vus.txtContrasenaVieja.getText();   
            String contrasenaa = contrasena;
            String contrasenaviejaa = contrasenavieja;
            System.out.println("actual: "+contrasena);
            System.out.println("vieja:"+contrasenavieja);
            
            
            
            if(contrasenaa.equals(contrasenaviejaa) ){
                us.setContrasena(vus.txtContrasenaVieja.getText());
            }
            else
            {
               
                us.setContrasena(DigestUtils.md5Hex(vus.txtContrasena.getText()));                
            }
                      
            
            us.setActivo((char) Integer.parseInt(vus.txtActivo.getText()));            
            if (vus.cbox_perfiles.getSelectedIndex() == 0) {
                us.setPerfil_id(Integer.parseInt(vus.txtPerfil.getText()));
            } else {
                String cbox_perfil = (String) vus.cbox_perfiles.getSelectedItem();               
                String idperfil = cbox_perfil.substring(0, 3);
                int parseIdperfil = parseInt(idperfil.replaceAll("\\s", ""));  
                us.setPerfil_id(parseIdperfil);
            }
            if (usmvc.modificar(us)) {
                limpiarUsuario();
                vus.txtFecha.setVisible(false);
                vus.lfecha.setVisible(false);
                vus.txtPerfil.setVisible(false);
                vus.lperfil.setVisible(false);
                vus.lactivo.setVisible(false);
                vus.txtActivo.setVisible(false);
                usmvc.Cargar_combobox(vus.cbox_perfiles);
                LlenarTabla(vlus.jTablaUsuarios);
                vus.btnModificar.setVisible(false);
                vus.btnGuardar.setVisible(true);
                vus.cbox_region.removeAllItems();
                vus.cbox_comuna.removeAllItems();
                usmvc.Cargar_combobox_region(vus.cbox_region);
                usmvc.Cargar_combobox_comuna(vus.cbox_comuna);
                JOptionPane.showMessageDialog(null, "Registro Modificado");

            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");

            }
        }

        if (e.getSource() == vsisapp.btnModificar) {

            vsisapp.txtActivo.setVisible(false);
            vsisapp.setVisible(false);
            vsisapp.setTitle("Vista Sistema Aplicacion");
            vsisapp.setLocationRelativeTo(null);
            vsisapp.setVisible(true);

            vsisapp.txtActivo.setVisible(true);
            
            vsisapp.lactivo.setVisible(true);
            
                       
            
            
            String cbox_idbd = (String) vsisapp.cbox_idBD.getSelectedItem();               
            String idbd = cbox_idbd.substring(0, 3);
            int parseIdbd = parseInt(idbd.replaceAll("\\s", ""));  
            sisapp.setId_bd(parseIdbd);
            
            sisapp.setNombre_sis(vsisapp.txtNSis.getText()); 
            
            String cbox_idlenguaje = (String) vsisapp.cbox_idlenguaje.getSelectedItem();               
            String idlenguaje = cbox_idlenguaje.substring(0, 3);
            int parseIdlenguaje = parseInt(idlenguaje.replaceAll("\\s", ""));  
            sisapp.setId_lenguaje(parseIdlenguaje);
            
            String cbox_idservidor = (String) vsisapp.cbox_idServidor.getSelectedItem();               
            String idservidor = cbox_idservidor.substring(0, 3);
            int parseIdservidor = parseInt(idservidor.replaceAll("\\s", ""));  
            sisapp.setServidor_id(parseIdservidor);
            
            String cbox_idusuario = (String) vsisapp.cbox_idEncargado.getSelectedItem();               
            String idusuario = cbox_idusuario.substring(0, 3);
            int parseIdusuario = parseInt(idusuario.replaceAll("\\s", ""));  
            sisapp.setUsuario_id(parseIdusuario);
            
            sisapp.setId_sistemas(Integer.parseInt(vsisapp.txtidsis.getText())); 
            
            sisapp.setActivo((char) Integer.parseInt(vsisapp.txtActivo.getText()));
            System.out.println("activo?: "+sisapp.getActivo());
            if (sisappmvc.modificar(sisapp)) {
                limpiarSisApp();
                vsisapp.lactivo.setVisible(false);
                vsisapp.txtActivo.setVisible(false);
                vsisapp.btnModificar.setVisible(false);
                vsisapp.btnGuardar.setVisible(true);
                sisappmvc.Cargar_comboboxServidorId(vsisapp.cbox_idServidor);
                sisappmvc.Cargar_comboboxIdUsuario(vsisapp.cbox_idEncargado);
                LlenarTablaSisApp(vlsisapp.jTablaSisApp);
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar sistema app");
                limpiarSisApp();

            }
        }

        if (e.getSource() == vsisbd.btnModificar) {
            vsisbd.txtActivo.setVisible(false);
            vsisbd.setVisible(false);
            vsisbd.setTitle("Vista Sistema BD");
            vsisbd.setLocationRelativeTo(null);
            vsisbd.setVisible(true);

            sisbd.setUsuario(vsisbd.txtUsuario.getText());
            sisbd.setContrasena(vsisbd.txtContrasena.getText());
            
            String cbox_lenguaje = (String) vsisbd.cbox_lenguaje.getSelectedItem();
            String idlenguaje = cbox_lenguaje.substring(0, 3);
            int parseIdlenguaje = parseInt(idlenguaje.replaceAll("\\s", ""));
            sisbd.setLenguaje_id(parseIdlenguaje);   
            System.out.println("leng"+parseIdlenguaje);
            
            
            String cbox_servidor= (String) vsisbd.cbox_idServidor.getSelectedItem();               
            String idservidor = cbox_servidor.substring(0, 3);
            int parseIdservidor = parseInt(idservidor.replaceAll("\\s", ""));  
            sisbd.setServidor_id(parseIdservidor);
            System.out.println("serv"+parseIdservidor);
            
            String cbox_encargado= (String) vsisbd.cbox_idEncargado.getSelectedItem();               
            String idencargado = cbox_encargado.substring(0, 3);
            int parseIdencargado = parseInt(idencargado.replaceAll("\\s", ""));  
            sisbd.setUsuario_id(parseIdencargado);
            
            System.out.println("user "+parseIdencargado);
            sisbd.setActivo((char) Integer.parseInt(vsisbd.txtActivo.getText()));
            System.out.println("activo?: "+sisbd.getActivo());
            sisbd.setNombre_bd(vsisbd.txtNombreBD.getText());
            sisbd.setId_bd(Integer.parseInt(vsisbd.txtid.getText()));
            
            if (sisbdmvc.modificar(sisbd)) {
                limpiarBD();
                vsisbd.lencargado.setVisible(false);
                vsisbd.lservidor.setVisible(false);
                vsisbd.txtEncargado.setVisible(false);
                vsisbd.txtServidor.setVisible(false);
                vsisbd.lactivo.setVisible(false);
                vsisbd.txtActivo.setVisible(false);
                sisbdmvc.Cargar_comboboxServidorId(vsisbd.cbox_idServidor);
                sisbdmvc.Cargar_comboboxIdUsuario(vsisbd.cbox_idEncargado);
                vsisbd.btnModificar.setVisible(false);
                vsisbd.btnGuardar.setVisible(true);
                LlenarTablaSisBD(vlsisbd.jTablaBD);
                JOptionPane.showMessageDialog(null, "Registro Modificado");

            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");

            }
        }

        if (e.getSource() == vser.btnModificar) {

            vser.txtAplicacion.setVisible(false);
            vser.setVisible(false);
            vser.setTitle("Vista Servicio");
            vser.setLocationRelativeTo(null);
            vser.setVisible(true);
            vser.lactivo.setVisible(false);
            vser.txtActivo.setVisible(false);
            vser.laplicacion.setVisible(false);            
            ser.setId_servicios(Integer.parseInt(vser.txtid.getText())); 
            ser.setNombre_serv(vser.txtNombre.getText());
            String cbox_tipo_serv = (String) vser.cbox_tipo_serv.getSelectedItem();                
            String idtiposerv = cbox_tipo_serv.substring(0, 3);
            int parseIdtiposerv = parseInt(idtiposerv.replaceAll("\\s", ""));  
            ser.setTipo_serv_id(parseIdtiposerv);            
            
            String cbox_id_app = (String) vser.cbox_idSistemaApp.getSelectedItem();                
            String idapp = cbox_id_app.substring(0, 3);
            int parseIdapp = parseInt(idapp.replaceAll("\\s", ""));  
            ser.setSisApp(parseIdapp);                 
            
            ser.setActivo((char) Integer.parseInt(vser.txtActivo.getText()));

            if (sermvc.modificar(ser)) {
                limpiarServicio();
                sermvc.Cargar_combobox(vser.cbox_idSistemaApp);
                LlenarTablaSer(vlser.jTablaServicio);
                vser.btnGuardar.setVisible(true);
                vser.btnModificar.setVisible(false);
                JOptionPane.showMessageDialog(null, "Registro Modificado");

            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");

            }
        }

        if (e.getSource() == vus.btnBuscar) {
            us.setRut_us(vus.txtRut.getText());
            us.setDv_us(vus.txtDv.getText());
            vus.txtFecha.setVisible(true);
            vus.lfecha.setVisible(false);
            vus.txtFecha.setVisible(false);
            vus.txtPerfil.setVisible(true);
            vus.lactivo.setVisible(true);
            vus.txtActivo.setVisible(true);
            vus.lperfil.setVisible(false);
            vus.txtFecha.setEnabled(false);
            vus.txtPerfil.setVisible(false);
            vus.btnGuardar.setVisible(false);
            vus.btnModificar.setVisible(true);
            if (usmvc.buscar(us)) {
                vus.txtRut.setText(String.valueOf(us.getRut_us()));
                vus.txtDv.setText(String.valueOf(us.getDv_us()));
                vus.txtNombre.setText(String.valueOf(us.getNombre_us()));
                vus.txtApaterno.setText(String.valueOf(us.getApaterno_us()));
                vus.txtAmaterno.setText(String.valueOf(us.getAmaterno_us()));

                String fechaa = us.getFnaciemiento_us().substring(0, 10);
                vus.jdFecha.setDate(Date.valueOf(fechaa));
                vus.txtTelefono.setText(String.valueOf(us.getTelefono_us()));
                vus.txtEmail.setText(String.valueOf(us.getEmail_us()));
                vus.txtDireccion.setText(String.valueOf(us.getDireccion()));
                vus.txtUsuario.setText(String.valueOf(us.getUsuario()));
                
                vus.txtContrasena.setText(us.getContrasena());
                String perfill = (String.valueOf(us.getPerfil_id()) + ". " + String.valueOf(us.getDetalle()));
                vus.cbox_perfiles.setSelectedItem(perfill);
                vus.txtActivo.setText(String.valueOf(us.getActivo()));
                System.out.println("Activo ?: " + us.getActivo());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro usuario");
            }
        }

        if (e.getSource() == vsisapp.btnBuscar) {

            vsisapp.btnModificar.setVisible(true);
            vsisapp.lactivo.setVisible(true);
            vsisapp.txtActivo.setVisible(true);
            vsisapp.setVisible(false);
            vsisapp.setTitle("Vista Sistema Aplicacion");
            vsisapp.setLocationRelativeTo(null);
            vsisapp.setVisible(true);
            //vsisapp.txtid.setVisible(true);
            vsisapp.btnGuardar.setVisible(false);
            sisapp.setId_sistemas(Integer.parseInt(vsisapp.txtBuscar.getText()));
            if (sisappmvc.buscar(sisapp)) {
                
                
                String bdd = (String.valueOf(sisapp.getId_bd())+"   . "+"name");
                vsisapp.cbox_idBD.setSelectedItem(bdd);
                  
                vsisapp.txtNSis.setText(String.valueOf(sisapp.getNombre_sis()));
                
                String lenguajee = (String.valueOf(sisapp.getId_lenguaje()) + "   . " + String.valueOf(sisapp.getNombre_lenguaje()));
                vsisapp.cbox_idlenguaje.setSelectedItem(lenguajee);
                
                vsisapp.txtid.setText(String.valueOf(sisapp.getId_sistemas()));
                String servidorr = (String.valueOf(sisapp.getServidor_id()) + "   . " + String.valueOf(sisapp.getNom_servidor()));
                vsisapp.cbox_idServidor.setSelectedItem(servidorr);
                
                String encargadoo = (String.valueOf(sisapp.getUsuario_id()) + "   . " + String.valueOf(sisapp.getNombre_us()) + " " + String.valueOf(sisapp.getApellido_paterno())+ " " + String.valueOf(sisapp.getApellido_materno()));
                vsisapp.cbox_idEncargado.setSelectedItem(encargadoo);
                vsisapp.txtActivo.setText(String.valueOf(sisapp.getActivo()));
                vsisapp.txtidsis.setText(String.valueOf(sisapp.getId_sistemas()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro Sistema Aplicacion");
            }
        }

        if (e.getSource() == vsisbd.btnBuscar) {
            vsisbd.lencargado.setVisible(false);
            vsisbd.lservidor.setVisible(false);
            vsisbd.txtEncargado.setVisible(false);
            vsisbd.txtServidor.setVisible(false);
            vsisbd.lactivo.setVisible(true);
            vsisbd.txtActivo.setVisible(true);

            vsisbd.txtActivo.setVisible(true);
            vsisbd.setVisible(false);
            vsisbd.setTitle("Vista Sistema BD");
            vsisbd.setLocationRelativeTo(null);
            vsisbd.btnModificar.setVisible(true);
            vsisbd.btnGuardar.setVisible(false);
            vsisbd.setVisible(true);
            sisbd.setId_bd(Integer.parseInt(vsisbd.txtBuscar.getText()));
            if (sisbdmvc.buscar(sisbd)) {

                vsisbd.txtUsuario.setText(String.valueOf(sisbd.getUsuario()));
                vsisbd.txtContrasena.setText(String.valueOf(sisbd.getContrasena()));        
                String lenguajee = (String.valueOf(sisbd.getLenguaje_id()) + "   . " + String.valueOf(sisbd.getNombre_leng()));
                vsisbd.cbox_lenguaje.setSelectedItem(lenguajee);
                
                vsisbd.txtServidor.setText(String.valueOf(sisbd.getServidor_id()));
                vsisbd.txtEncargado.setText(String.valueOf(sisbd.getServidor_id()));
                vsisbd.txtActivo.setText(String.valueOf(sisbd.getActivo()));

                vsisbd.txtid.setText(String.valueOf(sisbd.getId_bd()));
                String servidorr = (String.valueOf(sisbd.getServidor_id()) + "   . " + String.valueOf(sisbd.getNom_servidor()));
                vsisbd.cbox_idServidor.setSelectedItem(servidorr);
                vsisbd.txtEncargado.setText(String.valueOf(sisbd.getUsuario_id()));
                String encargadoo = (String.valueOf(sisbd.getUsuario_id()) + "   . " + String.valueOf(sisbd.getNombre_us())+ " " + String.valueOf(sisbd.getApaterno_us())+ " " + String.valueOf(sisbd.getAmaterno_us()));
                vsisbd.cbox_idEncargado.setSelectedItem(encargadoo);
                vsisbd.txtNombreBD.setText(String.valueOf(sisbd.getNombre_bd()));
            } else {String servidorr = (String.valueOf(sisbd.getServidor_id()) + "   . " + String.valueOf(sisbd.getNom_servidor()));
                vsisbd.cbox_idServidor.setSelectedItem(servidorr);
                JOptionPane.showMessageDialog(null, "No se encontro registro BD");
            }

        }

        if (e.getSource() == vser.btnBuscar) {

            vser.lactivo.setVisible(true);
            vser.laplicacion.setVisible(false);
            vser.txtAplicacion.setVisible(false);
            vser.txtActivo.setVisible(true);
            vser.btnGuardar.setVisible(false);
            vser.btnModificar.setVisible(true);
            vser.setVisible(false);
            vser.setTitle("Vista Sistema Servicio");
            vser.setLocationRelativeTo(null);
            vser.setVisible(true);
            ser.setId_servicios(Integer.parseInt(vser.txtBuscar.getText()));
            System.out.println("id:"+ser.getId_servicios());
            if (sermvc.buscar(ser)) {
                vser.txtNombre.setText(String.valueOf(ser.getNombre_serv()));                
                String tipo_servicio = (String.valueOf(ser.getTipo_serv_id()) + "   . " + String.valueOf(ser.getNombre_tipo()));
                vser.cbox_tipo_serv.setSelectedItem(tipo_servicio);
                vser.txtAplicacion.setText(String.valueOf(ser.getSisApp()));
                vser.txtActivo.setText(String.valueOf(ser.getActivo()));
                vser.txtid.setText(String.valueOf(ser.getId_servicios()));

                String sistemaa = (String.valueOf(ser.getSisApp()) + "   . " + String.valueOf(ser.getNombre_sis()));
                vser.cbox_idSistemaApp.setSelectedItem(sistemaa);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro Servicio");
            }

        }

        if (e.getSource() == vlus.Seleccionar) {

            DefaultTableModel tm = (DefaultTableModel) vlus.jTablaUsuarios.getModel();
            String rut = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 1));
            String dv = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 2));
            String nombre = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 3));
            String apaterno = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 4));
            String amaterno = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 5));
            String nacimiento = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 6)).substring(0, 10);
            String telefono = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 7));
            String email = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 8));
            String region = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 9));
            String comuna = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 10));
            String direccion = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 11));
            String usuario = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 12));
            String contrasena = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 13));
            String perfil = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 14));
            String activo = String.valueOf(tm.getValueAt(vlus.jTablaUsuarios.getSelectedRow(), 15));
            
                    
            
            
            vus.btnModificar.setVisible(true);
            vlus.setVisible(false);
            vus.setVisible(true);
            vus.btnGuardar.setVisible(false);
            vus.jdFecha.setDate(Date.valueOf(nacimiento));
            vus.txtRut.setText(rut);
            vus.txtDv.setText(dv);
            vus.txtNombre.setText(nombre);
            vus.txtApaterno.setText(apaterno);
            vus.txtAmaterno.setText(amaterno);
            vus.txtFecha.setText(nacimiento);
            vus.txtTelefono.setText(telefono);
            vus.txtEmail.setText(email);
            vus.cbox_region.setSelectedItem(region);
            vus.cbox_comuna.setSelectedItem(comuna);
                
            vus.txtDireccion.setText(direccion);
            vus.txtUsuario.setText(usuario);
            vus.txtContrasena.setText(contrasena);
            vus.txtContrasenaVieja.setText(contrasena);
            vus.txtPerfil.setText(perfil);
            vus.txtActivo.setText(activo);
            usmvc.Cargar_combobox(vus.cbox_perfiles);
            vus.cbox_perfiles.setSelectedItem(perfil);
            
        }

        if (e.getSource() == vlsisapp.Seleccionar) {

            DefaultTableModel tsis = (DefaultTableModel) vlsisapp.jTablaSisApp.getModel();
            String id_sistemas = String.valueOf(tsis.getValueAt(vlsisapp.jTablaSisApp.getSelectedRow(), 0));
            String software_bd = String.valueOf(tsis.getValueAt(vlsisapp.jTablaSisApp.getSelectedRow(), 1));
            String nombre_sis = String.valueOf(tsis.getValueAt(vlsisapp.jTablaSisApp.getSelectedRow(), 2));
            String lenguaje_sis = String.valueOf(tsis.getValueAt(vlsisapp.jTablaSisApp.getSelectedRow(), 3));            
            String servidor_id_servidor = String.valueOf(tsis.getValueAt(vlsisapp.jTablaSisApp.getSelectedRow(), 4));
            String usuario_id_usuario = String.valueOf(tsis.getValueAt(vlsisapp.jTablaSisApp.getSelectedRow(), 5));
            String activo = String.valueOf(tsis.getValueAt(vlsisapp.jTablaSisApp.getSelectedRow(), 6));

            vsisapp.btnModificar.setVisible(true);
            vlsisapp.setVisible(false);
            vsisapp.setVisible(true);
            vsisapp.btnGuardar.setVisible(false);
            vsisapp.lactivo.setVisible(true);
            vsisapp.txtActivo.setVisible(true);
            vsisapp.txtActivo.setText(String.valueOf(activo));
                      
                      
            sisappmvc.Cargar_comboboxServidorId(vsisapp.cbox_idServidor);
            sisappmvc.Cargar_comboboxIdUsuario(vsisapp.cbox_idEncargado);
            sisappmvc.Cargar_comboboxBD(vsisapp.cbox_idBD);
            sisappmvc.Cargar_comboboxLenguaje(vsisapp.cbox_idlenguaje);
            vsisapp.cbox_idlenguaje.setSelectedItem(lenguaje_sis); 
            vsisapp.cbox_idBD.setSelectedItem(software_bd);  
            vsisapp.cbox_idServidor.setSelectedItem(servidor_id_servidor);            
            vsisapp.cbox_idEncargado.setSelectedItem(usuario_id_usuario);
            vsisapp.txtNSis.setText(String.valueOf(nombre_sis));
              
            vsisapp.txtid.setText(String.valueOf(id_sistemas));
        }

        if (e.getSource() == vlsisbd.Seleccionar) {

            DefaultTableModel tbd = (DefaultTableModel) vlsisbd.jTablaBD.getModel();
            String id_bd = String.valueOf(tbd.getValueAt(vlsisbd.jTablaBD.getSelectedRow(), 0));
            String usuario = String.valueOf(tbd.getValueAt(vlsisbd.jTablaBD.getSelectedRow(), 1));
            String contrasena = String.valueOf(tbd.getValueAt(vlsisbd.jTablaBD.getSelectedRow(), 2));
            String software_bd = String.valueOf(tbd.getValueAt(vlsisbd.jTablaBD.getSelectedRow(), 3));
            String servidor_id_servidor = String.valueOf(tbd.getValueAt(vlsisbd.jTablaBD.getSelectedRow(), 4));
            String usuario_id_usuario = String.valueOf(tbd.getValueAt(vlsisbd.jTablaBD.getSelectedRow(), 5));
            String nombre_bd = String.valueOf(tbd.getValueAt(vlsisbd.jTablaBD.getSelectedRow(), 6));
            String activo = String.valueOf(tbd.getValueAt(vlsisbd.jTablaBD.getSelectedRow(), 7));
            
            vsisbd.btnModificar.setVisible(true);
            vlsisbd.setVisible(false);
            vsisbd.setVisible(true);
            vsisbd.btnGuardar.setVisible(false);
            vsisbd.lactivo.setVisible(true);
            vsisbd.txtActivo.setVisible(true);
            vsisbd.txtid.setVisible(true);

            vsisbd.txtUsuario.setText(String.valueOf(usuario));
            vsisbd.txtContrasena.setText(String.valueOf(contrasena));
            

            sisbdmvc.Cargar_comboboxServidorId(vsisbd.cbox_idServidor);
            sisbdmvc.Cargar_comboboxIdUsuario(vsisbd.cbox_idEncargado);
            //sisbdmvc.Cargar_comboboxLenguaje(vsisbd.cbox_lenguaje);
            vsisbd.cbox_lenguaje.setSelectedItem(software_bd);
            vsisbd.cbox_idServidor.setSelectedItem(servidor_id_servidor);
            vsisbd.cbox_idEncargado.setSelectedItem(usuario_id_usuario);
            vsisbd.txtid.setText(String.valueOf(id_bd));
            vsisbd.txtActivo.setText(String.valueOf(activo));
            vsisbd.txtNombreBD.setText(String.valueOf(nombre_bd));
        }

        

        if (e.getSource() == vlser.Seleccionar) {

            DefaultTableModel tser = (DefaultTableModel) vlser.jTablaServicio.getModel();
            String id_servicios = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 0));
            String nombre_serv = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 1));
            String tipo_serv = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 2));
            String sisapp_id_sistemas = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 3));
            String activo = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 4));

            vser.btnModificar.setVisible(true);
            vlser.setVisible(false);
            vser.setVisible(true);
            vser.btnGuardar.setVisible(false);
            vser.lactivo.setVisible(true);
            vser.txtActivo.setVisible(true);
            vser.txtid.setVisible(false);

            vser.txtNombre.setText(String.valueOf(nombre_serv));
            sermvc.Cargar_combobox_servicio(vser.cbox_tipo_serv);                      
            sermvc.Cargar_combobox(vser.cbox_idSistemaApp);
            vser.cbox_tipo_serv.setSelectedItem(tipo_serv);  
            vser.cbox_idSistemaApp.setSelectedItem(sisapp_id_sistemas);
            vser.txtAplicacion.setText(String.valueOf(sisapp_id_sistemas));

            vser.txtActivo.setText(String.valueOf(activo));
            vser.txtid.setText(String.valueOf(id_servicios));
        }

        if (e.getSource() == vlser.actualizar) {
            LlenarTablaSer(vlser.jTablaServicio);
            vlser.setVisible(false);
            vlser.setVisible(true);
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
        }

        if (e.getSource() == vlser.modificar) {

            DefaultTableModel tser = (DefaultTableModel) vlser.jTablaServicio.getModel();
            String id_servicios = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 0));
            String nombre_serv = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 1));
            String tipo_serv = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 2));
            String sisapp_id_sistemas = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 3));
            String activo = String.valueOf(tser.getValueAt(vlser.jTablaServicio.getSelectedRow(), 4));

            if (sisapp_id_sistemas.length() < 2) {
                JOptionPane.showMessageDialog(null, "El tipo de dato ingresado es incorrecto");
            }
            if (activo != "1" && activo != "0") {
                JOptionPane.showMessageDialog(null, "El tipo de dato ingresado es incorrecto0");
                activo = "1";
            }
            
            String idapp = sisapp_id_sistemas.substring(0, 2);
            int parseIdserv = parseInt(idapp.replaceAll("\\s", ""));
            ser.setSisApp(parseIdserv);
            ser.setActivo((char) Integer.parseInt(activo));
            ser.setId_servicios((char) Integer.parseInt(id_servicios));
            ser.setNombre_serv(nombre_serv);
            

            if (sermvc.modificar(ser)) {
                limpiarServicio();
                sermvc.Cargar_combobox(vser.cbox_idSistemaApp);
                //LlenarTablaSer(vlser.jTablaServicio);
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                vlser.setVisible(false);
                vlser.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "El tipo de dato ingresado es incorrecto");

            }

        }
        
        if (e.getSource() == vus.cbox_region ){
            if(vus.cbox_region.getSelectedIndex()>0){
                String cbox_region = (String) vus.cbox_region.getSelectedItem();                
                String idregion = cbox_region.substring(0, 2);
                int parseIdreg = parseInt(idregion.replaceAll("\\s", ""));  
                us.setId_comuna(parseIdreg);
                
                vus.setVisible(false);
                vus.cbox_comuna.removeAllItems();
                usmvc.Cargar_combobox_comuna(vus.cbox_comuna, us);
                vus.setVisible(true);
                System.out.println(parseIdreg);
            }
        }
        
        if (e.getSource() == vus.cbox_comuna ){
            if(vus.cbox_comuna.getSelectedIndex()>0){
                String cbox_comuna = (String) vus.cbox_comuna.getSelectedItem();                
                String idregion = cbox_comuna.substring(0, 3);
                int parseIdcom = parseInt(idregion.replaceAll("\\s", ""));  
                us.setId_comuna(parseIdcom);                
                System.out.println(parseIdcom);
            }
        }
    }
    
}


