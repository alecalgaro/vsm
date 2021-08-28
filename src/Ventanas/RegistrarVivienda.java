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
        txt_orientacion = new javax.swing.JTextField();
        jLabel_orientacion = new javax.swing.JLabel();
        jLabel_sala_de_estar = new javax.swing.JLabel();
        txt_sala_de_estar = new javax.swing.JTextField();
        jLabel_hab_doble = new javax.swing.JLabel();
        txt_hab_doble = new javax.swing.JTextField();
        jLabel_local_comercial = new javax.swing.JLabel();
        txt_local_comercial = new javax.swing.JTextField();
        jLabel_largo = new javax.swing.JLabel();
        txt_largo = new javax.swing.JTextField();
        jLabel_comedor = new javax.swing.JLabel();
        txt_comedor = new javax.swing.JTextField();
        jLabel_hab_imple = new javax.swing.JLabel();
        txt_hab_simple = new javax.swing.JTextField();
        jLabel_hab_matrimonial = new javax.swing.JLabel();
        txt_hab_matrimonial = new javax.swing.JTextField();
        jLabel_ancho = new javax.swing.JLabel();
        txt_ancho = new javax.swing.JTextField();
        jLabel_baño_lav_coc = new javax.swing.JLabel();
        txt_baño_lav_coc = new javax.swing.JTextField();
        jLabel_sala_de_estudio = new javax.swing.JLabel();
        txt_sala_de_estudio = new javax.swing.JTextField();
        jLabel_deposito = new javax.swing.JLabel();
        txt_deposito = new javax.swing.JTextField();
        jLabel_taller = new javax.swing.JLabel();
        txt_taller = new javax.swing.JTextField();
        jLabel_orientacion1 = new javax.swing.JLabel();
        jLabel_orientacion2 = new javax.swing.JLabel();
        jButton_registrarVivienda = new javax.swing.JButton();
        jLabel_cubierta = new javax.swing.JLabel();
        txt_cubierta = new javax.swing.JTextField();
        jLabel_cub = new javax.swing.JLabel();
        jLabel_piso = new javax.swing.JLabel();
        txt_piso = new javax.swing.JTextField();
        jLabel_pi = new javax.swing.JLabel();
        jLabel_terminacion = new javax.swing.JLabel();
        txt_terminacion = new javax.swing.JTextField();
        jLabel_term = new javax.swing.JLabel();
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
        getContentPane().add(jLabel_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Módulos");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        txt_orientacion.setBackground(new java.awt.Color(92, 124, 203));
        txt_orientacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_orientacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_orientacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_orientacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_orientacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_orientacionKeyTyped(evt);
            }
        });
        getContentPane().add(txt_orientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 30, 25));

        jLabel_orientacion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel_orientacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_orientacion.setText("\"NE\", \"NO\", \"SE\", \"SO\")");
        getContentPane().add(jLabel_orientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabel_sala_de_estar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sala_de_estar.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sala_de_estar.setText("Sala de estar:");
        getContentPane().add(jLabel_sala_de_estar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        txt_sala_de_estar.setBackground(new java.awt.Color(92, 124, 203));
        txt_sala_de_estar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_sala_de_estar.setForeground(new java.awt.Color(255, 255, 255));
        txt_sala_de_estar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_sala_de_estar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_sala_de_estar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sala_de_estarKeyTyped(evt);
            }
        });
        getContentPane().add(txt_sala_de_estar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 30, 25));

        jLabel_hab_doble.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hab_doble.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hab_doble.setText("Hab. doble:");
        getContentPane().add(jLabel_hab_doble, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        txt_hab_doble.setBackground(new java.awt.Color(92, 124, 203));
        txt_hab_doble.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_hab_doble.setForeground(new java.awt.Color(255, 255, 255));
        txt_hab_doble.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hab_doble.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_hab_doble.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hab_dobleKeyTyped(evt);
            }
        });
        getContentPane().add(txt_hab_doble, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 30, 25));

        jLabel_local_comercial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_local_comercial.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_local_comercial.setText("Local comercial:");
        getContentPane().add(jLabel_local_comercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        txt_local_comercial.setBackground(new java.awt.Color(92, 124, 203));
        txt_local_comercial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_local_comercial.setForeground(new java.awt.Color(255, 255, 255));
        txt_local_comercial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_local_comercial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_local_comercial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_local_comercialKeyTyped(evt);
            }
        });
        getContentPane().add(txt_local_comercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 30, 25));

        jLabel_largo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_largo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_largo.setText("Largo terreno:");
        getContentPane().add(jLabel_largo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txt_largo.setBackground(new java.awt.Color(92, 124, 203));
        txt_largo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_largo.setForeground(new java.awt.Color(255, 255, 255));
        txt_largo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_largo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        txt_comedor.setBackground(new java.awt.Color(92, 124, 203));
        txt_comedor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_comedor.setForeground(new java.awt.Color(255, 255, 255));
        txt_comedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_comedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_comedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_comedorKeyTyped(evt);
            }
        });
        getContentPane().add(txt_comedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 30, 25));

        jLabel_hab_imple.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hab_imple.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hab_imple.setText("Hab. simple:");
        getContentPane().add(jLabel_hab_imple, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        txt_hab_simple.setBackground(new java.awt.Color(92, 124, 203));
        txt_hab_simple.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_hab_simple.setForeground(new java.awt.Color(255, 255, 255));
        txt_hab_simple.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hab_simple.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_hab_simple.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hab_simpleKeyTyped(evt);
            }
        });
        getContentPane().add(txt_hab_simple, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 30, 25));

        jLabel_hab_matrimonial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hab_matrimonial.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hab_matrimonial.setText("Hab. matri:");
        getContentPane().add(jLabel_hab_matrimonial, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        txt_hab_matrimonial.setBackground(new java.awt.Color(92, 124, 203));
        txt_hab_matrimonial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_hab_matrimonial.setForeground(new java.awt.Color(255, 255, 255));
        txt_hab_matrimonial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hab_matrimonial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_hab_matrimonial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hab_matrimonialKeyTyped(evt);
            }
        });
        getContentPane().add(txt_hab_matrimonial, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 30, 25));

        jLabel_ancho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_ancho.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ancho.setText("Ancho terreno:");
        getContentPane().add(jLabel_ancho, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txt_ancho.setBackground(new java.awt.Color(92, 124, 203));
        txt_ancho.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ancho.setForeground(new java.awt.Color(255, 255, 255));
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

        txt_baño_lav_coc.setBackground(new java.awt.Color(92, 124, 203));
        txt_baño_lav_coc.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_baño_lav_coc.setForeground(new java.awt.Color(255, 255, 255));
        txt_baño_lav_coc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_baño_lav_coc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_baño_lav_coc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_baño_lav_cocKeyTyped(evt);
            }
        });
        getContentPane().add(txt_baño_lav_coc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 30, 25));

        jLabel_sala_de_estudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sala_de_estudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sala_de_estudio.setText("Sala estudio:");
        getContentPane().add(jLabel_sala_de_estudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));

        txt_sala_de_estudio.setBackground(new java.awt.Color(92, 124, 203));
        txt_sala_de_estudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_sala_de_estudio.setForeground(new java.awt.Color(255, 255, 255));
        txt_sala_de_estudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_sala_de_estudio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_sala_de_estudio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sala_de_estudioKeyTyped(evt);
            }
        });
        getContentPane().add(txt_sala_de_estudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 30, 25));

        jLabel_deposito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_deposito.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_deposito.setText("Deposito:");
        getContentPane().add(jLabel_deposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, -1, -1));

        txt_deposito.setBackground(new java.awt.Color(92, 124, 203));
        txt_deposito.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_deposito.setForeground(new java.awt.Color(255, 255, 255));
        txt_deposito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_deposito.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_deposito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_depositoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_deposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 30, 25));

        jLabel_taller.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_taller.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_taller.setText("Taller:");
        getContentPane().add(jLabel_taller, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, -1));

        txt_taller.setBackground(new java.awt.Color(92, 124, 203));
        txt_taller.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_taller.setForeground(new java.awt.Color(255, 255, 255));
        txt_taller.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_taller.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_taller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tallerActionPerformed(evt);
            }
        });
        txt_taller.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tallerKeyTyped(evt);
            }
        });
        getContentPane().add(txt_taller, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 30, 25));

        jLabel_orientacion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_orientacion1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_orientacion1.setText("Orientación:");
        getContentPane().add(jLabel_orientacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel_orientacion2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel_orientacion2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_orientacion2.setText("(\"N\", \"S\", \"E\", \"O\"");
        getContentPane().add(jLabel_orientacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

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

        txt_cubierta.setBackground(new java.awt.Color(92, 124, 203));
        txt_cubierta.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_cubierta.setForeground(new java.awt.Color(255, 255, 255));
        txt_cubierta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cubierta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_cubierta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cubiertaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cubierta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 30, 25));

        jLabel_cub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_cub.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_cub.setText("(\"1\": un agua, \"2\": dos aguas, \"3\": plana)");
        getContentPane().add(jLabel_cub, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        jLabel_piso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_piso.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_piso.setText("Piso:");
        getContentPane().add(jLabel_piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        txt_piso.setBackground(new java.awt.Color(92, 124, 203));
        txt_piso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_piso.setForeground(new java.awt.Color(255, 255, 255));
        txt_piso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_piso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_piso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pisoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 30, 25));

        jLabel_pi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_pi.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pi.setText("(\"1\": sobre platea, \"2\": sobre pilotes)");
        getContentPane().add(jLabel_pi, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

        jLabel_terminacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_terminacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_terminacion.setText("Terminación:");
        getContentPane().add(jLabel_terminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        txt_terminacion.setBackground(new java.awt.Color(92, 124, 203));
        txt_terminacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_terminacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_terminacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_terminacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_terminacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_terminacionKeyTyped(evt);
            }
        });
        getContentPane().add(txt_terminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 30, 25));

        jLabel_term.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_term.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_term.setText("(\"1\": placa cementicia, \"2\": tablas madera)");
        getContentPane().add(jLabel_term, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));
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
        orientacion = txt_orientacion.getText().trim();
        largo = txt_largo.getText().trim();
        ancho = txt_ancho.getText().trim();
        cubierta = txt_cubierta.getText().trim();
        piso = txt_piso.getText().trim(); 
        terminacion = txt_terminacion.getText().trim(); 
        local_comercial = txt_local_comercial.getText().trim();
        sala_de_estar = txt_sala_de_estar.getText().trim();
        comedor = txt_comedor.getText().trim();
        baño_lav_coc = txt_baño_lav_coc.getText().trim();
        hab_matrimonial = txt_hab_matrimonial.getText().trim();
        hab_doble = txt_hab_doble.getText().trim();
        hab_simple = txt_hab_simple.getText().trim();
        sala_de_estudio = txt_sala_de_estudio.getText().trim();
        deposito = txt_deposito.getText().trim();    
        taller = txt_taller.getText().trim(); 
        
        //Validar que los campos no estén vacios y que no se ingrese algo incorrecto:
        //(al final valido que solo se puedan escribir los numeros o letras correspondientes, pero aca valido que, con esas letras o numeros, no se
        //ingresen algo de forma incorrecta, por ejemplo, NOO en orientacion, 11 en cubierta, etc.)
        
        if(orientacion.equals("")){  //"" es un espacio en blanco.
            txt_orientacion.setBackground(Color.red);
            validacion_vacio++;
        } else if (!orientacion.equals("N") && !orientacion.equals("S") && !orientacion.equals("E") && !orientacion.equals("O") 
                && !orientacion.equals("NE") && !orientacion.equals("NO") && !orientacion.equals("SE") && !orientacion.equals("SO")) {
            txt_orientacion.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(largo.equals("")){
            txt_largo.setBackground(Color.red);
            validacion_vacio++;
        } 
        if(ancho.equals("")){
            txt_ancho.setBackground(Color.red);
            validacion_vacio++;
        }
        if(cubierta.equals("")){
            txt_cubierta.setBackground(Color.red);
            validacion_vacio++;
        } else if(!cubierta.equals("1") && !cubierta.equals("2") && !cubierta.equals("3")){
            txt_cubierta.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(piso.equals("")){
            txt_piso.setBackground(Color.red);
            validacion_vacio++;
        } else if(!piso.equals("1") && !piso.equals("2")){
            txt_piso.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(terminacion.equals("")){
            txt_terminacion.setBackground(Color.red);
            validacion_vacio++;
        } else if(!terminacion.equals("1") && !terminacion.equals("2")){
            txt_terminacion.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(local_comercial.equals("")){
            txt_local_comercial.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(local_comercial) < 1) && !local_comercial.equals("0")){
            txt_local_comercial.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(sala_de_estar.equals("")){
            txt_sala_de_estar.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(sala_de_estar) < 1) && !sala_de_estar.equals("0")){
            txt_sala_de_estar.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(comedor.equals("")){  
            txt_comedor.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(comedor) < 1) && !comedor.equals("0")){
            txt_comedor.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(baño_lav_coc.equals("")){
            txt_baño_lav_coc.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(baño_lav_coc) < 1) && !baño_lav_coc.equals("0")){
            txt_baño_lav_coc.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(hab_matrimonial.equals("")){
            txt_hab_matrimonial.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(hab_matrimonial) < 1) && !hab_matrimonial.equals("0")){
            txt_hab_matrimonial.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(hab_doble.equals("")){
            txt_hab_doble.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(hab_doble) < 1) && !hab_doble.equals("0")){
            txt_hab_doble.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(hab_simple.equals("")){
            txt_hab_simple.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(hab_simple) < 1) && !hab_simple.equals("0")){
            txt_hab_simple.setBackground(Color.red);
            validacion_campos_correctos++;
        }        
        if(sala_de_estudio.equals("")){
            txt_sala_de_estudio.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(sala_de_estudio) < 1) && !sala_de_estudio.equals("0")){
            txt_sala_de_estudio.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(deposito.equals("")){
            txt_deposito.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(deposito) < 1) && !deposito.equals("0")){
            txt_deposito.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(taller.equals("")){
            txt_taller.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(taller) < 1) && !taller.equals("0")){
            txt_taller.setBackground(Color.red);
            validacion_campos_correctos++;
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

                    txt_orientacion.setBackground(Color.green);
                    txt_largo.setBackground(Color.green);
                    txt_ancho.setBackground(Color.green);
                    txt_cubierta.setBackground(Color.green);
                    txt_piso.setBackground(Color.green);
                    txt_terminacion.setBackground(Color.green);
                    txt_local_comercial.setBackground(Color.green);
                    txt_sala_de_estar.setBackground(Color.green);
                    txt_comedor.setBackground(Color.green);
                    txt_baño_lav_coc.setBackground(Color.green);
                    txt_hab_matrimonial.setBackground(Color.green);
                    txt_hab_doble.setBackground(Color.green);
                    txt_hab_simple.setBackground(Color.green);
                    txt_sala_de_estudio.setBackground(Color.green);
                    txt_deposito.setBackground(Color.green);
                    txt_taller.setBackground(Color.green);

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
    
    //Validaciones de letras y numeros:
    
    private void txt_orientacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_orientacionKeyTyped
        char c = evt.getKeyChar();
        if(c!='N' && c!='S' && c!='E' && c!='O') evt.consume();    //Solo se permite escribir esas letras.
    }//GEN-LAST:event_txt_orientacionKeyTyped

    private void txt_largoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_largoKeyTyped
        char c = evt.getKeyChar();
        if(c!='0' && c!='1' && c!='2' && c!='3' && c!='4' && c!='5' && c!='6' && c!='7' && c!='8' && c!='9' && c!='.') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_largoKeyTyped

    private void txt_anchoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anchoKeyTyped
        char c = evt.getKeyChar();
        if(c!='0' && c!='1' && c!='2' && c!='3' && c!='4' && c!='5' && c!='6' && c!='7' && c!='8' && c!='9' && c!='.') evt.consume();       //Solo se permite escribir numeros.
        //Seria lo mismo que hacer: if( (Character.getNumericValue(c) > 9) || c!='.' ) evt.consume();
    }//GEN-LAST:event_txt_anchoKeyTyped

    private void txt_local_comercialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_local_comercialKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_local_comercialKeyTyped

    private void txt_sala_de_estarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sala_de_estarKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_sala_de_estarKeyTyped

    private void txt_comedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_comedorKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_comedorKeyTyped

    private void txt_baño_lav_cocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_baño_lav_cocKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_baño_lav_cocKeyTyped

    private void txt_hab_matrimonialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hab_matrimonialKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_hab_matrimonialKeyTyped

    private void txt_hab_dobleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hab_dobleKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_hab_dobleKeyTyped

    private void txt_hab_simpleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hab_simpleKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_hab_simpleKeyTyped

    private void txt_sala_de_estudioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sala_de_estudioKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_sala_de_estudioKeyTyped

    private void txt_depositoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_depositoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_depositoKeyTyped

    private void txt_tallerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tallerKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_tallerKeyTyped

    private void txt_cubiertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cubiertaKeyTyped
        char c = evt.getKeyChar();
        if(c!='1' && c!='2' && c!='3') evt.consume();       //Solo se permite escribir esos tres numeros.
    }//GEN-LAST:event_txt_cubiertaKeyTyped

    private void txt_pisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pisoKeyTyped
        char c = evt.getKeyChar();
        if(c!='1' && c!='2') evt.consume();       //Solo se permite escribir esos dos numeros.
    }//GEN-LAST:event_txt_pisoKeyTyped

    private void txt_terminacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_terminacionKeyTyped
        char c = evt.getKeyChar();
        if(c!='1' && c!='2') evt.consume();       //Solo se permite escribir esos dos numeros.
    }//GEN-LAST:event_txt_terminacionKeyTyped

    private void txt_tallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tallerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tallerActionPerformed

    //Si quiero hacer algo al cerrar la ventana con la cruz roja.
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JButton jButton_registrarVivienda;
    private javax.swing.JLabel jLabel_ancho;
    private javax.swing.JLabel jLabel_baño_lav_coc;
    private javax.swing.JLabel jLabel_comedor;
    private javax.swing.JLabel jLabel_cub;
    private javax.swing.JLabel jLabel_cubierta;
    private javax.swing.JLabel jLabel_deposito;
    private javax.swing.JLabel jLabel_hab_doble;
    private javax.swing.JLabel jLabel_hab_imple;
    private javax.swing.JLabel jLabel_hab_matrimonial;
    private javax.swing.JLabel jLabel_largo;
    private javax.swing.JLabel jLabel_local_comercial;
    private javax.swing.JLabel jLabel_orientacion;
    private javax.swing.JLabel jLabel_orientacion1;
    private javax.swing.JLabel jLabel_orientacion2;
    private javax.swing.JLabel jLabel_pi;
    private javax.swing.JLabel jLabel_piso;
    private javax.swing.JLabel jLabel_registrarVivienda;
    private javax.swing.JLabel jLabel_sala_de_estar;
    private javax.swing.JLabel jLabel_sala_de_estudio;
    private javax.swing.JLabel jLabel_taller;
    private javax.swing.JLabel jLabel_term;
    private javax.swing.JLabel jLabel_terminacion;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_titulo1;
    private javax.swing.JTextField txt_ancho;
    private javax.swing.JTextField txt_baño_lav_coc;
    private javax.swing.JTextField txt_comedor;
    private javax.swing.JTextField txt_cubierta;
    private javax.swing.JTextField txt_deposito;
    private javax.swing.JTextField txt_hab_doble;
    private javax.swing.JTextField txt_hab_matrimonial;
    private javax.swing.JTextField txt_hab_simple;
    private javax.swing.JTextField txt_largo;
    private javax.swing.JTextField txt_local_comercial;
    private javax.swing.JTextField txt_orientacion;
    private javax.swing.JTextField txt_piso;
    private javax.swing.JTextField txt_sala_de_estar;
    private javax.swing.JTextField txt_sala_de_estudio;
    private javax.swing.JTextField txt_taller;
    private javax.swing.JTextField txt_terminacion;
    // End of variables declaration//GEN-END:variables

    public void Limpiar(){
        txt_orientacion.setText("");
        txt_largo.setText("");
        txt_ancho.setText("");
        txt_cubierta.setText("");
        txt_piso.setText("");
        txt_terminacion.setText("");
        txt_local_comercial.setText("");
        txt_sala_de_estar.setText("");
        txt_comedor.setText("");
        txt_baño_lav_coc.setText("");
        txt_hab_matrimonial.setText("");
        txt_hab_doble.setText("");
        txt_hab_simple.setText("");
        txt_sala_de_estudio.setText("");
        txt_deposito.setText("");
        txt_taller.setText("");
       }

}
