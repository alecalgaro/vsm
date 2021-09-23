package Ventanas;

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * @author Calgaro Alejandro
 */

public class RegistrarVivienda extends javax.swing.JFrame {
    
    int idCliente = 0;
    String nombre_cliente = "";
    private InformacionCliente informacionCliente;
    int idVivienda = 0;
    
    /**
     * Creates new form RegistrarVivienda
     */
    
    public RegistrarVivienda(InformacionCliente informacionCliente) {
        initComponents();
        idCliente = GestionarClientes.idCliente;
        this.informacionCliente = informacionCliente;
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select nombre_cliente from cliente where id_cliente = '" + idCliente + "'");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                nombre_cliente = rs.getString("nombre_cliente");
            }            
        } catch (SQLException e) {
            System.err.println("Error al consultar el nombre del cliente.");
        }
        
        setSize(790, 460);
        setTitle("Registrar vivienda para " + nombre_cliente);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_registrarVivienda.getWidth(),
                jLabel_registrarVivienda.getHeight(), Image.SCALE_DEFAULT));
        jLabel_registrarVivienda.setIcon(icono);
        this.repaint();
        
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
    }

    private RegistrarVivienda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo1 = new javax.swing.JLabel();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_sala_de_estar = new javax.swing.JLabel();
        jLabel_hab_doble = new javax.swing.JLabel();
        jLabel_local_comercial = new javax.swing.JLabel();
        jLabel_largo = new javax.swing.JLabel();
        txt_largo = new javax.swing.JTextField();
        jLabel_comedor = new javax.swing.JLabel();
        jLabel_hab_imple = new javax.swing.JLabel();
        jLabel_hab_matrimonial = new javax.swing.JLabel();
        jLabel_ancho = new javax.swing.JLabel();
        txt_ancho = new javax.swing.JTextField();
        jLabel_baño_lav_coc = new javax.swing.JLabel();
        jLabel_sala_de_estudio = new javax.swing.JLabel();
        jLabel_deposito = new javax.swing.JLabel();
        jLabel_taller = new javax.swing.JLabel();
        jLabel_orientacion1 = new javax.swing.JLabel();
        jButton_registrarVivienda = new javax.swing.JButton();
        jLabel_cubierta = new javax.swing.JLabel();
        jLabel_piso = new javax.swing.JLabel();
        jLabel_terminacion = new javax.swing.JLabel();
        cb_sala_estar = new javax.swing.JComboBox<>();
        cb_terminacion = new javax.swing.JComboBox<>();
        cb_cubierta = new javax.swing.JComboBox<>();
        cb_piso = new javax.swing.JComboBox<>();
        cb_orientacion = new javax.swing.JComboBox<>();
        cb_local_comercial = new javax.swing.JComboBox<>();
        cb_comedor = new javax.swing.JComboBox<>();
        cb_hab_matrimonial = new javax.swing.JComboBox<>();
        cb_hab_simple = new javax.swing.JComboBox<>();
        cb_deposito = new javax.swing.JComboBox<>();
        cb_taller = new javax.swing.JComboBox<>();
        cb_sala_estudio = new javax.swing.JComboBox<>();
        cb_hab_doble = new javax.swing.JComboBox<>();
        cb_baño_lav_coc = new javax.swing.JComboBox<>();
        jLabel_registrarVivienda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo1.setText("Información de la vivienda");
        getContentPane().add(jLabel_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Módulos");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        jLabel_sala_de_estar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sala_de_estar.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sala_de_estar.setText("Sala de estar:");
        getContentPane().add(jLabel_sala_de_estar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel_hab_doble.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hab_doble.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hab_doble.setText("Hab. doble:");
        getContentPane().add(jLabel_hab_doble, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        jLabel_local_comercial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_local_comercial.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_local_comercial.setText("Local comercial:");
        getContentPane().add(jLabel_local_comercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel_largo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_largo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_largo.setText("Largo terreno:");
        getContentPane().add(jLabel_largo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txt_largo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_largo.setForeground(new java.awt.Color(100, 100, 100));
        txt_largo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_largo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_largo.setDisabledTextColor(new java.awt.Color(1, 1, 1));
        txt_largo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_largoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_largo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 50, 25));

        jLabel_comedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_comedor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_comedor.setText("Comedor:");
        getContentPane().add(jLabel_comedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jLabel_hab_imple.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hab_imple.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hab_imple.setText("Hab. simple:");
        getContentPane().add(jLabel_hab_imple, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        jLabel_hab_matrimonial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hab_matrimonial.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hab_matrimonial.setText("Hab. matri:");
        getContentPane().add(jLabel_hab_matrimonial, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        jLabel_ancho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_ancho.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ancho.setText("Ancho terreno:");
        getContentPane().add(jLabel_ancho, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txt_ancho.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ancho.setForeground(new java.awt.Color(100, 100, 100));
        txt_ancho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ancho.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ancho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_anchoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_ancho, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 50, 25));

        jLabel_baño_lav_coc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_baño_lav_coc.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_baño_lav_coc.setText("Baño, lav, coc:");
        getContentPane().add(jLabel_baño_lav_coc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        jLabel_sala_de_estudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sala_de_estudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sala_de_estudio.setText("Sala estudio:");
        getContentPane().add(jLabel_sala_de_estudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));

        jLabel_deposito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_deposito.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_deposito.setText("Deposito:");
        getContentPane().add(jLabel_deposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, -1, -1));

        jLabel_taller.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_taller.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_taller.setText("Taller:");
        getContentPane().add(jLabel_taller, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, -1));

        jLabel_orientacion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_orientacion1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_orientacion1.setText("Orientación:");
        getContentPane().add(jLabel_orientacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jButton_registrarVivienda.setBackground(new java.awt.Color(64, 97, 164));
        jButton_registrarVivienda.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_registrarVivienda.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrarVivienda.setText("Registrar vivienda");
        jButton_registrarVivienda.setBorder(null);
        jButton_registrarVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarViviendaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarVivienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 180, 25));

        jLabel_cubierta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_cubierta.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_cubierta.setText("Cubierta:");
        getContentPane().add(jLabel_cubierta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel_piso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_piso.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_piso.setText("Piso:");
        getContentPane().add(jLabel_piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        jLabel_terminacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_terminacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_terminacion.setText("Terminación:");
        getContentPane().add(jLabel_terminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        cb_sala_estar.setBackground(new java.awt.Color(92, 124, 203));
        cb_sala_estar.setEditable(true);
        cb_sala_estar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_sala_estar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sala_estarActionPerformed(evt);
            }
        });
        getContentPane().add(cb_sala_estar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 45, -1));

        cb_terminacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Placa cementicia", "Tablas de madera" }));
        getContentPane().add(cb_terminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 150, -1));

        cb_cubierta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Un agua", "Dos aguas", "Plana" }));
        getContentPane().add(cb_cubierta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 75, 100, -1));

        cb_piso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sobre platea", "Sobre pilotes" }));
        getContentPane().add(cb_piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 110, -1));

        cb_orientacion.setBackground(new java.awt.Color(92, 124, 203));
        cb_orientacion.setEditable(true);
        cb_orientacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "S", "E", "O", "NE", "NO", "SE", "SO" }));
        cb_orientacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_orientacionActionPerformed(evt);
            }
        });
        getContentPane().add(cb_orientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 75, 50, -1));

        cb_local_comercial.setBackground(new java.awt.Color(92, 124, 203));
        cb_local_comercial.setEditable(true);
        cb_local_comercial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_local_comercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_local_comercialActionPerformed(evt);
            }
        });
        getContentPane().add(cb_local_comercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 45, -1));

        cb_comedor.setBackground(new java.awt.Color(92, 124, 203));
        cb_comedor.setEditable(true);
        cb_comedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_comedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_comedorActionPerformed(evt);
            }
        });
        getContentPane().add(cb_comedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 45, -1));

        cb_hab_matrimonial.setBackground(new java.awt.Color(92, 124, 203));
        cb_hab_matrimonial.setEditable(true);
        cb_hab_matrimonial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_hab_matrimonial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_hab_matrimonialActionPerformed(evt);
            }
        });
        getContentPane().add(cb_hab_matrimonial, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 45, -1));

        cb_hab_simple.setBackground(new java.awt.Color(92, 124, 203));
        cb_hab_simple.setEditable(true);
        cb_hab_simple.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_hab_simple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_hab_simpleActionPerformed(evt);
            }
        });
        getContentPane().add(cb_hab_simple, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 45, -1));

        cb_deposito.setBackground(new java.awt.Color(92, 124, 203));
        cb_deposito.setEditable(true);
        cb_deposito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_deposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_depositoActionPerformed(evt);
            }
        });
        getContentPane().add(cb_deposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 45, -1));

        cb_taller.setBackground(new java.awt.Color(92, 124, 203));
        cb_taller.setEditable(true);
        cb_taller.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_taller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tallerActionPerformed(evt);
            }
        });
        getContentPane().add(cb_taller, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 45, -1));

        cb_sala_estudio.setBackground(new java.awt.Color(92, 124, 203));
        cb_sala_estudio.setEditable(true);
        cb_sala_estudio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_sala_estudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sala_estudioActionPerformed(evt);
            }
        });
        getContentPane().add(cb_sala_estudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 45, -1));

        cb_hab_doble.setBackground(new java.awt.Color(92, 124, 203));
        cb_hab_doble.setEditable(true);
        cb_hab_doble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_hab_doble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_hab_dobleActionPerformed(evt);
            }
        });
        getContentPane().add(cb_hab_doble, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 45, -1));

        cb_baño_lav_coc.setBackground(new java.awt.Color(92, 124, 203));
        cb_baño_lav_coc.setEditable(true);
        cb_baño_lav_coc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cb_baño_lav_coc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_baño_lav_cocActionPerformed(evt);
            }
        });
        getContentPane().add(cb_baño_lav_coc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 45, -1));
        getContentPane().add(jLabel_registrarVivienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarViviendaActionPerformed
        int validacion_vacio = 0;
        int validacion_campos_correctos = 0;
        float validacion_largo = 0;   //Para controlar que no se elijan más módulos de los que entran en el largo del terreno.
        String orientacion, largo, ancho, cubierta, piso, terminacion, local_comercial, sala_de_estar, comedor, baño_lav_coc, hab_matrimonial, 
                hab_doble, hab_simple, sala_de_estudio, deposito, taller;
        int id_viv = 0;
        
        /*
        //---Si quiero usar la fecha en que se registro sería algo así:
        String dia, mes año;
        Calendar calendar = Calendar.getInstance();
        
        dia = Integer.toString(calendar.get(Calendar.DATE));
        mes = Integer.toString(calendar.get(Calendar.MONTH));
        año = Integer.toString(calendar.get(Calendar.YEAR));
        */
        
        //Para recuperar la información escrita:
        orientacion = cb_orientacion.getSelectedItem().toString();
        largo = txt_largo.getText().trim();
        ancho = txt_ancho.getText().trim();
        cubierta = Integer.toString(cb_cubierta.getSelectedIndex() + 1);    
        piso = Integer.toString(cb_piso.getSelectedIndex() + 1);
        terminacion = Integer.toString(cb_terminacion.getSelectedIndex() + 1);
        local_comercial = cb_local_comercial.getSelectedItem().toString();
        sala_de_estar = cb_sala_estar.getSelectedItem().toString();
        comedor = cb_comedor.getSelectedItem().toString();
        baño_lav_coc = cb_baño_lav_coc.getSelectedItem().toString();
        hab_matrimonial = cb_hab_matrimonial.getSelectedItem().toString();
        hab_doble = cb_hab_doble.getSelectedItem().toString();
        hab_simple = cb_hab_simple.getSelectedItem().toString();
        sala_de_estudio = cb_sala_estudio.getSelectedItem().toString();
        deposito = cb_deposito.getSelectedItem().toString();   
        taller = cb_taller.getSelectedItem().toString();
        
        //Validar que los campos no estén vacios y que no se ingrese algo incorrecto:
        //(al final valido que solo se puedan escribir los numeros o letras correspondientes, pero aca valido que, con esas letras o numeros, no se
        //ingresen algo de forma incorrecta, por ejemplo, NOO en orientacion, 11 en cubierta, etc.)
        
        if(largo.equals("")){
            txt_largo.setBackground(Color.red);
            validacion_vacio++;
        } 
        if(ancho.equals("")){
            txt_ancho.setBackground(Color.red);
            validacion_vacio++;
        }
        
        //Debo validar que todos los campos esten completos, que no se usen más módulos de los que entran en el largo del terreno y 
        //que no se ingrese algun campo incorrecto como NEE en orientacion, 11 en cubierta, etc.
        //Si validacion_vacio = 0, significa que todos los campos están completos, si es distinto de cero, alguno de los campos esta vacío.
        
        if (validacion_vacio != 0){
            JOptionPane.showMessageDialog(null, "Se deben completar todos los campos.");
        }
        
        if(validacion_vacio == 0){              
            validacion_largo = (float) ( (Integer.parseInt(local_comercial) * 3.76) + (Integer.parseInt(sala_de_estar) * 3.76) + (Integer.parseInt(comedor) * 3.76) 
                + (Integer.parseInt(baño_lav_coc) * 2.54) + (Integer.parseInt(hab_matrimonial) * 3.76) + (Integer.parseInt(hab_doble) * 3.76) 
                + (Integer.parseInt(hab_simple) * 2.54) + (Integer.parseInt(sala_de_estudio) * 2.54) + (Integer.parseInt(deposito) * 2.54) + (Integer.parseInt(taller) * 3.76));
        
            if(validacion_largo > Float.parseFloat(largo)){     //Antes tenía "Integer.parseInt(largo)
                JOptionPane.showMessageDialog(null, "La cantidad de modulos supera el largo del terreno");
            }
            else if(validacion_campos_correctos != 0){
                JOptionPane.showMessageDialog(null, "Campo/s incorrecto/s");  //Por si el usuario escribe por ejemplo: NOO en orientacion, 11 en cubierta, 00 en modulos, etc.
            }
            else {      //Si las validaciones anteriores son correctas, seguimos con el registro.
                try {      
                    //Primero inserto los datos de la tabla vivienda, para luego obtener el id de dicha vivienda ingresada y usarlo
                    //para insertar todos los modulo_vivienda correspondientes.
                    
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "insert into vivienda values (?,?,?,?,?,?,?,?)");   //Se usan "?" porque todavía no se conocen.

                    //---SI NECESITO EL NOMBRE DEL CLIENTE, LO TENGO EN LA VARIABLE nom_cliente.

                    pst.setInt(1, 0);   //En el id se le envía un 0 para que no haya un error, pero la base de datos comprueba si necesita ese valor o no.
                    pst.setInt(2, idCliente);   //idCliente
                    pst.setString(3, orientacion);
                    pst.setFloat(4, Float.parseFloat(largo));
                    pst.setFloat(5, Float.parseFloat(ancho));
                    pst.setInt(6, Integer.parseInt(cubierta));
                    pst.setInt(7, Integer.parseInt(piso));
                    pst.setInt(8, Integer.parseInt(terminacion));

                    pst.executeUpdate();    //Indica que se tiene que ejecutar toda la acción anterior.
                    
                    //Consulta para obtener el id de la última vivienda insertada, para usarlo al insertar los modulo_vivienda abajo.
                    PreparedStatement pst_id_viv = cn.prepareStatement(
                        "select max(id_vivienda) as id_vivienda from vivienda");        //Recordar usar as nombreAlias porque ese nombre es el que se usa abajo en rs.getInt(id_vivienda), sino aparece "max(id_vivienda)".
                    ResultSet rs = pst_id_viv.executeQuery();  //Ejecuta la consulta.
                    if(rs.next()){  //Si se encontro, se hace lo siguiente:
                        id_viv = rs.getInt("id_vivienda");
                    }
                    else id_viv = 1;   
                    
                    //idVivienda = id_viv;
                    
                    /*
                    PreparedStatement pst_mod_viv = cn.prepareStatement(
                            "insert into modulo-vivienda values (?,?,?,?)");   
                    pst_mod_viv.setInt(1, 0);   
                    pst_mod_viv.setInt(2, id_vivienda); 
                    pst_mod_viv.setInt(3, id_modulo);          
                    pst_mod_viv.setInt(4, Integer.parseInt(cantidad));
                    
                    pst_mod_viv.executeUpdate();    //Indica que se tiene que ejecutar toda la acción anterior.
                    */
                      
                    //Podría hacer un insert para cada modulo? viendo que la cantidad ingresada sea mayor a 0,  
                    //así me se el id_modulo de cada uno, la cantidad la saco del campo de texto ingresado y 
                    //el id_vivienda es de la última insertada que lo obtengo con max.

                    if(Integer.parseInt(local_comercial) != 0) {
                        PreparedStatement pst_lc = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_lc.setInt(1, 0);        //id autoincremental
                        pst_lc.setInt(2, id_viv);   //id de la última vivienda registrada.
                        pst_lc.setInt(3, 1);        //id_modulo
                        pst_lc.setInt(4, Integer.parseInt(local_comercial));    //cantidad
                        pst_lc.executeUpdate();    
                    }
                    
                    if(Integer.parseInt(sala_de_estar) != 0) {
                        PreparedStatement pst_se = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_se.setInt(1, 0);   
                        pst_se.setInt(2, id_viv); 
                        pst_se.setInt(3, 2);        //id_modulo
                        pst_se.setInt(4, Integer.parseInt(sala_de_estar));
                        pst_se.executeUpdate();    
                    }
                    
                    if(Integer.parseInt(comedor) != 0) {
                        PreparedStatement pst_co = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_co.setInt(1, 0);   
                        pst_co.setInt(2, id_viv); 
                        pst_co.setInt(3, 3);        //id_modulo
                        pst_co.setInt(4, Integer.parseInt(comedor));
                        pst_co.executeUpdate();    
                    }
                    
                    if(Integer.parseInt(baño_lav_coc) != 0) {
                        PreparedStatement pst_blc = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_blc.setInt(1, 0);   
                        pst_blc.setInt(2, id_viv); 
                        pst_blc.setInt(3, 4);        //id_modulo
                        pst_blc.setInt(4, Integer.parseInt(baño_lav_coc));
                        pst_blc.executeUpdate();    
                    }
                    
                    if(Integer.parseInt(hab_matrimonial) != 0) {
                        PreparedStatement pst_hdm = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_hdm.setInt(1, 0);   
                        pst_hdm.setInt(2, id_viv); 
                        pst_hdm.setInt(3, 5);        //id_modulo
                        pst_hdm.setInt(4, Integer.parseInt(hab_matrimonial));
                        pst_hdm.executeUpdate();    
                    }
                    
                    if(Integer.parseInt(hab_doble) != 0) {
                        PreparedStatement pst_hd = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_hd.setInt(1, 0);   
                        pst_hd.setInt(2, id_viv); 
                        pst_hd.setInt(3, 6);        //id_modulo
                        pst_hd.setInt(4, Integer.parseInt(hab_doble));
                        pst_hd.executeUpdate();    
                    }
                    
                    if(Integer.parseInt(hab_simple) != 0) {
                        PreparedStatement pst_hs = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_hs.setInt(1, 0);   
                        pst_hs.setInt(2, id_viv); 
                        pst_hs.setInt(3, 7);        //id_modulo
                        pst_hs.setInt(4, Integer.parseInt(hab_simple));
                        pst_hs.executeUpdate();    
                    }
                    
                    if(Integer.parseInt(sala_de_estudio) != 0) {
                        PreparedStatement pst_st = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_st.setInt(1, 0);   
                        pst_st.setInt(2, id_viv); 
                        pst_st.setInt(3, 8);        //id_modulo
                        pst_st.setInt(4, Integer.parseInt(sala_de_estudio));
                        pst_st.executeUpdate();    
                    }
                    
                    if(Integer.parseInt(deposito) != 0) {
                        PreparedStatement pst_de = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_de.setInt(1, 0);   
                        pst_de.setInt(2, id_viv); 
                        pst_de.setInt(3, 9);        //id_modulo
                        pst_de.setInt(4, Integer.parseInt(deposito));
                        pst_de.executeUpdate();    
                    }    
                    
                    if(Integer.parseInt(taller) != 0) {
                        PreparedStatement pst_ta = cn.prepareStatement(
                                "insert into modulo_vivienda values (?,?,?,?)");   
                        pst_ta.setInt(1, 0);   
                        pst_ta.setInt(2, id_viv); 
                        pst_ta.setInt(3, 10);        //id_modulo
                        pst_ta.setInt(4, Integer.parseInt(taller));
                        pst_ta.executeUpdate();    
                    }
                    
                    cn.close();     //Cierro la conexión a la base de datos. 
                    
                    Limpiar();  //Función escrita debajo.

                    JOptionPane.showMessageDialog(null, "Registro exitoso.");
                    this.dispose();
                    
                    
                    //Agrego la nueva vivienda a la tabla:
                    Object[] fila = new Object[17];  //de tipo Object porque tengo datos de diferentes tipos.
                    fila[0] = id_viv;    //idVivienda
                    fila[1] = orientacion;
                    fila[2] = largo;
                    fila[3] = ancho;
                    fila[4] = cubierta;
                    fila[5] = piso;
                    fila[6] = terminacion;
                    if(!local_comercial.equals("0")){fila[7] = local_comercial;} else{fila[7] = "";}
                    if(!sala_de_estar.equals("0")){fila[8] = sala_de_estar;} else{fila[8] = "";}
                    if(!comedor.equals("0")){fila[9] = comedor;} else{fila[9] = "";}
                    if(!baño_lav_coc.equals("0")){fila[10] = baño_lav_coc;}else{fila[10] = "";}
                    if(!hab_matrimonial.equals("0")){fila[11] = hab_matrimonial;}else{fila[11] = "";}
                    if(!hab_doble.equals("0")){fila[12] = hab_doble;} else{fila[12] = "";}
                    if(!hab_simple.equals("0")){fila[13] = hab_simple;} else{fila[13] = "";}
                    if(!sala_de_estudio.equals("0")){fila[14] = sala_de_estudio;} else{fila[14] = "";}
                    if(!deposito.equals("0")){fila[15] = deposito;} else{fila[15] = "";}
                    if(!taller.equals("0")){fila[16] = taller;} else{fila[16] = "";}
                    
                    informacionCliente.model.addRow(fila);

                } catch (SQLException e) {
                    System.out.println("Error en registrar la vivienda. " + e);
                    JOptionPane.showMessageDialog(null, "Error al registrar vivienda.");
                    }
            }    
        }   //cierre de if (validacion_vacio == 0)
           
    }//GEN-LAST:event_jButton_registrarViviendaActionPerformed
    
    private void txt_largoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_largoKeyTyped
        char c = evt.getKeyChar();
        if(c!='0' && c!='1' && c!='2' && c!='3' && c!='4' && c!='5' && c!='6' && c!='7' && c!='8' && c!='9' && c!='.') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_largoKeyTyped

    private void txt_anchoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anchoKeyTyped
        char c = evt.getKeyChar();
        if(c!='0' && c!='1' && c!='2' && c!='3' && c!='4' && c!='5' && c!='6' && c!='7' && c!='8' && c!='9' && c!='.') evt.consume();       //Solo se permite escribir numeros.
        //Seria lo mismo que hacer: if( (Character.getNumericValue(c) > 9) || c!='.' ) evt.consume();
    }//GEN-LAST:event_txt_anchoKeyTyped

    //Si quiero hacer algo al cerrar la ventana con la cruz roja.
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void cb_sala_estarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sala_estarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sala_estarActionPerformed

    private void cb_orientacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_orientacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_orientacionActionPerformed

    private void cb_local_comercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_local_comercialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_local_comercialActionPerformed

    private void cb_comedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_comedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_comedorActionPerformed

    private void cb_hab_matrimonialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hab_matrimonialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_hab_matrimonialActionPerformed

    private void cb_hab_simpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hab_simpleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_hab_simpleActionPerformed

    private void cb_depositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_depositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_depositoActionPerformed

    private void cb_tallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tallerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_tallerActionPerformed

    private void cb_sala_estudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sala_estudioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sala_estudioActionPerformed

    private void cb_hab_dobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hab_dobleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_hab_dobleActionPerformed

    private void cb_baño_lav_cocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_baño_lav_cocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_baño_lav_cocActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarVivienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_baño_lav_coc;
    private javax.swing.JComboBox<String> cb_comedor;
    private javax.swing.JComboBox<String> cb_cubierta;
    private javax.swing.JComboBox<String> cb_deposito;
    private javax.swing.JComboBox<String> cb_hab_doble;
    private javax.swing.JComboBox<String> cb_hab_matrimonial;
    private javax.swing.JComboBox<String> cb_hab_simple;
    private javax.swing.JComboBox<String> cb_local_comercial;
    private javax.swing.JComboBox<String> cb_orientacion;
    private javax.swing.JComboBox<String> cb_piso;
    private javax.swing.JComboBox<String> cb_sala_estar;
    private javax.swing.JComboBox<String> cb_sala_estudio;
    private javax.swing.JComboBox<String> cb_taller;
    private javax.swing.JComboBox<String> cb_terminacion;
    private javax.swing.JButton jButton_registrarVivienda;
    private javax.swing.JLabel jLabel_ancho;
    private javax.swing.JLabel jLabel_baño_lav_coc;
    private javax.swing.JLabel jLabel_comedor;
    private javax.swing.JLabel jLabel_cubierta;
    private javax.swing.JLabel jLabel_deposito;
    private javax.swing.JLabel jLabel_hab_doble;
    private javax.swing.JLabel jLabel_hab_imple;
    private javax.swing.JLabel jLabel_hab_matrimonial;
    private javax.swing.JLabel jLabel_largo;
    private javax.swing.JLabel jLabel_local_comercial;
    private javax.swing.JLabel jLabel_orientacion1;
    private javax.swing.JLabel jLabel_piso;
    private javax.swing.JLabel jLabel_registrarVivienda;
    private javax.swing.JLabel jLabel_sala_de_estar;
    private javax.swing.JLabel jLabel_sala_de_estudio;
    private javax.swing.JLabel jLabel_taller;
    private javax.swing.JLabel jLabel_terminacion;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_titulo1;
    private javax.swing.JTextField txt_ancho;
    private javax.swing.JTextField txt_largo;
    // End of variables declaration//GEN-END:variables

    public void Limpiar(){
        
        txt_largo.setText("");
        txt_ancho.setText("");
       }

}
