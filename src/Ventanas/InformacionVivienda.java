package Ventanas;

import Clases.Conexion;
import static Ventanas.InformacionCliente.idVivienda;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Calgaro Alejandro
 */

public class InformacionVivienda extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel(); //Nos va a permitir generar el clic en la tabla y establecer una conexión con los datos que se muestren dentro de la tabla.
    
    int idCliente = 0;
    int idVivienda = 0;
    String nombre_cliente = "";
    String orientacion, largo_terreno, ancho_terreno, cubierta, piso, terminacion, largo_ocupado, local_comercial, sala_de_estar, comedor, baño_lav_coc, hab_matrimonial, 
                    hab_doble, hab_simple, sala_de_estudio, deposito, taller;
    
    float validacion_largo = 0;
    float costoMateriales = 0;
    float costosExtras = 0;
    float costoTotal = 0;
    
    //Estas cuatro variables son para actualizar o eliminar en las ventanas "GestionarViviendas" o "InformacionCliente"
    //si actualizo algo o elimino aquí en "InformacionVivienda".
    String desde;
    int fila_clic;  
    private GestionarViviendas gestionarViviendas;
    private InformacionCliente informacionCliente;
    
    /**
     * Creates new form InformacionVivienda
     */
    
    //Contructor para cuando vengo de la ventana "GestionarViviendas"
    public InformacionVivienda(GestionarViviendas gestionarViviendas, int fila, int idVivienda) {
        this.gestionarViviendas = gestionarViviendas;
        this.fila_clic = fila;
        this.idVivienda = idVivienda;
        generar_ventana();  //Hago este metodo para no repetir código.
    }
    
    //Contructor para cuando vengo de la ventana "InformacionCliente"
    public InformacionVivienda(InformacionCliente informacionCliente, int fila, int idVivienda) {
        this.informacionCliente = informacionCliente;
        this.fila_clic = fila;
        this.idVivienda = idVivienda;
        generar_ventana();  //Hago este metodo para no repetir código.
    }

    private InformacionVivienda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
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
        txt_largo_terreno = new javax.swing.JTextField();
        jLabel_comedor = new javax.swing.JLabel();
        txt_comedor = new javax.swing.JTextField();
        jLabel_hab_simple = new javax.swing.JLabel();
        txt_hab_simple = new javax.swing.JTextField();
        jLabel_hab_matrimonial = new javax.swing.JLabel();
        txt_hab_matrimonial = new javax.swing.JTextField();
        jLabel_ancho = new javax.swing.JLabel();
        txt_ancho_terreno = new javax.swing.JTextField();
        jLabel_baño_lav_coc = new javax.swing.JLabel();
        txt_baño_lav_coc = new javax.swing.JTextField();
        jLabel_sala_de_estudio = new javax.swing.JLabel();
        txt_sala_de_estudio = new javax.swing.JTextField();
        jLabel_deposito = new javax.swing.JLabel();
        txt_deposito = new javax.swing.JTextField();
        jLabel_taller = new javax.swing.JLabel();
        txt_taller = new javax.swing.JTextField();
        jButton_crearDiseño = new javax.swing.JButton();
        jButton_eliminarVivienda = new javax.swing.JButton();
        jButton_actualizarVivienda = new javax.swing.JButton();
        jButton_generarReporteCompleto = new javax.swing.JButton();
        jLabel_titulo1 = new javax.swing.JLabel();
        jLabel_orientacion1 = new javax.swing.JLabel();
        jLabel_orientacion2 = new javax.swing.JLabel();
        jLabel_cubierta = new javax.swing.JLabel();
        txt_cubierta = new javax.swing.JTextField();
        jLabel_cub = new javax.swing.JLabel();
        jLabel_pi = new javax.swing.JLabel();
        txt_piso = new javax.swing.JTextField();
        jLabel_piso = new javax.swing.JLabel();
        jLabel_terminacion = new javax.swing.JLabel();
        txt_terminacion = new javax.swing.JTextField();
        jLabel_term = new javax.swing.JLabel();
        jLabel_informacionVivienda = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Módulos");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        txt_orientacion.setBackground(new java.awt.Color(92, 124, 203));
        txt_orientacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_orientacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_orientacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_orientacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_orientacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_orientacionKeyTyped(evt);
            }
        });
        getContentPane().add(txt_orientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 30, 25));

        jLabel_orientacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_orientacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_orientacion.setText("Orientación:");
        getContentPane().add(jLabel_orientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel_sala_de_estar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sala_de_estar.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sala_de_estar.setText("Sala de estar:");
        getContentPane().add(jLabel_sala_de_estar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

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
        getContentPane().add(jLabel_hab_doble, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

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
        getContentPane().add(txt_hab_doble, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 30, 25));

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

        txt_largo_terreno.setBackground(new java.awt.Color(92, 124, 203));
        txt_largo_terreno.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_largo_terreno.setForeground(new java.awt.Color(255, 255, 255));
        txt_largo_terreno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_largo_terreno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_largo_terreno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_largo_terrenoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_largo_terreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 50, 25));

        jLabel_comedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_comedor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_comedor.setText("Comedor:");
        getContentPane().add(jLabel_comedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

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
        getContentPane().add(txt_comedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 30, 25));

        jLabel_hab_simple.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hab_simple.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hab_simple.setText("Hab. simple:");
        getContentPane().add(jLabel_hab_simple, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

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
        getContentPane().add(txt_hab_simple, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 30, 25));

        jLabel_hab_matrimonial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hab_matrimonial.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hab_matrimonial.setText("Hab. matri:");
        getContentPane().add(jLabel_hab_matrimonial, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

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
        getContentPane().add(txt_hab_matrimonial, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 30, 25));

        jLabel_ancho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_ancho.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ancho.setText("Ancho terreno:");
        getContentPane().add(jLabel_ancho, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txt_ancho_terreno.setBackground(new java.awt.Color(92, 124, 203));
        txt_ancho_terreno.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ancho_terreno.setForeground(new java.awt.Color(255, 255, 255));
        txt_ancho_terreno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ancho_terreno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ancho_terreno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ancho_terrenoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_ancho_terreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 50, 25));

        jLabel_baño_lav_coc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_baño_lav_coc.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_baño_lav_coc.setText("Baño, lav, coc:");
        getContentPane().add(jLabel_baño_lav_coc, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        txt_baño_lav_coc.setBackground(new java.awt.Color(92, 124, 203));
        txt_baño_lav_coc.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_baño_lav_coc.setForeground(new java.awt.Color(255, 255, 255));
        txt_baño_lav_coc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_baño_lav_coc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_baño_lav_coc, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 30, 25));

        jLabel_sala_de_estudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sala_de_estudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sala_de_estudio.setText("Sala estudio:");
        getContentPane().add(jLabel_sala_de_estudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, -1));

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
        getContentPane().add(txt_sala_de_estudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 30, 25));

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
        getContentPane().add(txt_deposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 30, 25));

        jLabel_taller.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_taller.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_taller.setText("Taller:");
        getContentPane().add(jLabel_taller, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, -1));

        txt_taller.setBackground(new java.awt.Color(92, 124, 203));
        txt_taller.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_taller.setForeground(new java.awt.Color(255, 255, 255));
        txt_taller.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_taller.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_taller.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tallerKeyTyped(evt);
            }
        });
        getContentPane().add(txt_taller, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 30, 25));

        jButton_crearDiseño.setBackground(new java.awt.Color(64, 97, 164));
        jButton_crearDiseño.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_crearDiseño.setForeground(new java.awt.Color(255, 255, 255));
        jButton_crearDiseño.setText("Crear diseño");
        jButton_crearDiseño.setBorder(null);
        jButton_crearDiseño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearDiseñoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_crearDiseño, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 150, 25));

        jButton_eliminarVivienda.setBackground(new java.awt.Color(64, 97, 164));
        jButton_eliminarVivienda.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_eliminarVivienda.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminarVivienda.setText("Eliminar vivienda");
        jButton_eliminarVivienda.setBorder(null);
        jButton_eliminarVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarViviendaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminarVivienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 150, 25));

        jButton_actualizarVivienda.setBackground(new java.awt.Color(64, 97, 164));
        jButton_actualizarVivienda.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_actualizarVivienda.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizarVivienda.setText("Actualizar vivienda");
        jButton_actualizarVivienda.setBorder(null);
        jButton_actualizarVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarViviendaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizarVivienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 150, 25));

        jButton_generarReporteCompleto.setBackground(new java.awt.Color(64, 97, 164));
        jButton_generarReporteCompleto.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_generarReporteCompleto.setForeground(new java.awt.Color(255, 255, 255));
        jButton_generarReporteCompleto.setText("Generar reporte completo");
        jButton_generarReporteCompleto.setBorder(null);
        jButton_generarReporteCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generarReporteCompletoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_generarReporteCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 180, 25));

        jLabel_titulo1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo1.setText("Información de la vivienda");
        getContentPane().add(jLabel_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel_orientacion1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel_orientacion1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_orientacion1.setText("\"NE\", \"NO\", \"SE\", \"SO\")");
        getContentPane().add(jLabel_orientacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabel_orientacion2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel_orientacion2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_orientacion2.setText("(\"N\", \"S\", \"E\", \"O\"");
        getContentPane().add(jLabel_orientacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

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

        jLabel_pi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_pi.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pi.setText("(\"1\": sobre platea, \"2\": sobre pilotes)");
        getContentPane().add(jLabel_pi, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

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

        jLabel_piso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_piso.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_piso.setText("Piso:");
        getContentPane().add(jLabel_piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, -1));

        jLabel_terminacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_terminacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_terminacion.setText("Terminación:");
        getContentPane().add(jLabel_terminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

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
        getContentPane().add(jLabel_informacionVivienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_crearDiseñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearDiseñoActionPerformed
        FileWriter flwriter = null;
            try {
		//Crea el flujo para escribir en el archivo
		flwriter = new FileWriter("C:\\Users\\aleja\\Desktop\\VSM\\archivo.txt");
		//Crea un buffer o flujo intermedio antes de escribir directamente en el archivo
		BufferedWriter bfwriter = new BufferedWriter(flwriter);
                    //Escribe los datos en el archivo. Primero escribo las caracteristicas de la vivienda y luego
                    //van el nombre del modulo y debajo la cantidad, así para cada modulo.
                    bfwriter.write(orientacion + "\n" + largo_terreno + "\n" + ancho_terreno + "\n" + largo_ocupado + "\n" 
                            + cubierta + "\n" + piso + "\n" + terminacion + "\n"
                            + "lc \n" + local_comercial + "\n" + "se \n" + sala_de_estar + "\n" + "co \n" + comedor + "\n" 
                            + "blc \n" + baño_lav_coc + "\n" + "hdm \n" + hab_matrimonial + "\n" + "hd \n" + hab_doble + "\n" 
                            + "hs \n" + hab_simple + "\n" + "st \n" + sala_de_estudio + "\n" + "de \n" + deposito + "\n" + "ta \n" + taller);
                                        
                    //Cierra el buffer intermedio
                    bfwriter.close();
                    System.out.println("Archivo creado satisfactoriamente.");   //Mensaje para comprobar.
                    JOptionPane.showMessageDialog(null, "Abra el template de AutoCAD y ejecute el comando 'vsm'.");  //Mensaje para el usuario.
 
            } catch (IOException e) {
		e.printStackTrace();
            
            } finally {
		if (flwriter != null) {
                    try {   //Cierra el flujo principal
                        flwriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
			}
		}
            }
    }//GEN-LAST:event_jButton_crearDiseñoActionPerformed

    private void jButton_eliminarViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarViviendaActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, //this sería unComponentePadre (new InformacionVivienda())
            "¿Desea confirmar la eliminación?", "Confirmación de eliminación",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);   //el null es para icono por defecto
        // 0=ok, 2=cancel
        
        if(opcion == 0){          
            try {
                Connection cn = Conexion.conectar();

                //PreparedStatement pst = cn.prepareStatement(
                    //"SET FOREIGN_KEY_CHECKS=0");
                //pst.executeUpdate();
                
                //Primero elimino los módulos de esa vivienda y luego elimino la vivienda.
                
                PreparedStatement pst2 = cn.prepareStatement(   //Elimino los módulos de la vivienda eliminada.
                    "delete from modulo_vivienda where id_vivienda = '" + idVivienda + "'");            
                pst2.executeUpdate();

                PreparedStatement pst3 = cn.prepareStatement(    //Elimino la vivienda.
                    "delete from vivienda where id_vivienda = '" + idVivienda + "'");             
                pst3.executeUpdate();

                //PreparedStatement pst4 = cn.prepareStatement(
                    //"SET FOREIGN_KEY_CHECKS=1");
                //pst4.executeUpdate();

                cn.close();

                //Envío un mensaje al usuario para avisar que se eliminó de forma correcta.
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente.");

                if(desde == "GestionarViviendas"){
                    gestionarViviendas.model.removeRow(gestionarViviendas.fila_clic);   //Elimino la fila correspondiente en la tabla de la ventana "GestionarViviendas".
                }
                else{
                    informacionCliente.model.removeRow(informacionCliente.fila_clic);   //Elimino la fila correspondiente en la tabla de la ventana "InformacionCliente".
                }

                this.dispose(); //Para que la ventana "InformaciónVivienda" se cierre automáticamente cuando el usuario da clic en "aceptar" del mensaje que le enviamos recién.  

                } catch (SQLException e) {
                    System.err.println("Error al eliminar vivienda" + e);  //Éste sirve para indicarle al programador donde esta el error en el código.
                    JOptionPane.showInternalMessageDialog(null, "Error al eliminar vivienda"); //Éste sirve para avisarle al usuario que ocurrió un error.
                }
        }
    }//GEN-LAST:event_jButton_eliminarViviendaActionPerformed

    private void jButton_actualizarViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarViviendaActionPerformed
        int validacion_vacio = 0;
        int validacion_campos_correctos = 0;
        //float validacion_largo = 0;   //Para controlar que no se elijan más módulos de los que entran en el largo del terreno.
        String act_orientacion, act_largo_terreno, act_ancho_terreno, act_largo_ocupado, act_cubierta, act_piso, act_terminacion, act_local_comercial, 
            act_sala_de_estar, act_comedor, act_baño_lav_coc, act_hab_matrimonial, act_hab_doble, act_hab_simple, act_sala_de_estudio, act_deposito, act_taller;
        
        /*
        //---Si necesito usar la fecha en que se registro sería algo así:
        String dia, mes año;
        Calendar calendar = Calendar.getInstance();
        
        dia = Integer.toString(calendar.get(Calendar.DATE));
        mes = Integer.toString(calendar.get(Calendar.MONTH));
        año = Integer.toString(calendar.get(Calendar.YEAR));
        */
        
        //Para recuperar la información escrita luego de presionar el botón "Actualizar":
        act_orientacion = txt_orientacion.getText().trim();
        act_largo_terreno = txt_largo_terreno.getText().trim();
        act_ancho_terreno = txt_ancho_terreno.getText().trim();
        act_cubierta = txt_cubierta.getText().trim();
        act_piso = txt_piso.getText().trim();
        act_terminacion = txt_terminacion.getText().trim();
        act_local_comercial = txt_local_comercial.getText().trim();
        act_sala_de_estar = txt_sala_de_estar.getText().trim();
        act_comedor = txt_comedor.getText().trim();
        act_baño_lav_coc = txt_baño_lav_coc.getText().trim();
        act_hab_matrimonial = txt_hab_matrimonial.getText().trim();
        act_hab_doble = txt_hab_doble.getText().trim();
        act_hab_simple = txt_hab_simple.getText().trim();
        act_sala_de_estudio = txt_sala_de_estudio.getText().trim();
        act_deposito = txt_deposito.getText().trim();
        act_taller = txt_taller.getText().trim();
        
        //Validar que los campos no estén vacios:
        if(act_orientacion.equals("")){  //"" es un espacio en blanco.
            txt_orientacion.setBackground(Color.red);
            validacion_vacio++;
        } else if (!act_orientacion.equals("N") && !act_orientacion.equals("S") && !act_orientacion.equals("E") && !act_orientacion.equals("O") 
                && !act_orientacion.equals("NE") && !act_orientacion.equals("NO") && !act_orientacion.equals("SE") && !act_orientacion.equals("SO")) {
            txt_orientacion.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_largo_terreno.equals("")){
            txt_largo_terreno.setBackground(Color.red);
            validacion_vacio++;
        }
        if(act_ancho_terreno.equals("")){
            txt_ancho_terreno.setBackground(Color.red);
            validacion_vacio++;
        }
        if(act_cubierta.equals("")){
            txt_cubierta.setBackground(Color.red);
            validacion_vacio++;
        } else if(!act_cubierta.equals("1") && !act_cubierta.equals("2") && !act_cubierta.equals("3")){
            txt_cubierta.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_piso.equals("")){
            txt_piso.setBackground(Color.red);
            validacion_vacio++;
        } else if(!act_piso.equals("1") && !act_piso.equals("2")){
            txt_piso.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_terminacion.equals("")){
            txt_terminacion.setBackground(Color.red);
            validacion_vacio++;
        } else if(!act_terminacion.equals("1") && !act_terminacion.equals("2")){
            txt_terminacion.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_local_comercial.equals("")){
            txt_local_comercial.setBackground(Color.red);
            validacion_vacio++;   
        } else if ( (Integer.parseInt(act_local_comercial) < 1) && !act_local_comercial.equals("0")){
            txt_local_comercial.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_sala_de_estar.equals("")){
            txt_sala_de_estar.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(act_sala_de_estar) < 1) && !act_sala_de_estar.equals("0")){
            txt_sala_de_estar.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_comedor.equals("")){  
            txt_comedor.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(act_comedor) < 1) && !act_comedor.equals("0")){
            txt_comedor.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_baño_lav_coc.equals("")){
            txt_baño_lav_coc.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(act_baño_lav_coc) < 1) && !act_baño_lav_coc.equals("0")){
            txt_baño_lav_coc.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_hab_matrimonial.equals("")){
            txt_hab_matrimonial.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(act_hab_matrimonial) < 1) && !act_hab_matrimonial.equals("0")){
            txt_hab_matrimonial.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_hab_doble.equals("")){
            txt_hab_doble.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(act_hab_doble) < 1) && !act_hab_doble.equals("0")){
            txt_hab_doble.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_hab_simple.equals("")){
            txt_hab_simple.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(act_hab_simple) < 1) && !act_hab_simple.equals("0")){
            txt_hab_simple.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_sala_de_estudio.equals("")){
            txt_sala_de_estudio.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(act_sala_de_estudio) < 1) && !act_sala_de_estudio.equals("0")){
            txt_sala_de_estudio.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_deposito.equals("")){
            txt_deposito.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(act_deposito) < 1) && !act_deposito.equals("0")){
            txt_deposito.setBackground(Color.red);
            validacion_campos_correctos++;
        }
        if(act_taller.equals("")){
            txt_taller.setBackground(Color.red);
            validacion_vacio++;
        } else if ( (Integer.parseInt(act_taller) < 1) && !act_taller.equals("0")){
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
            validacion_largo = (float) ( (Integer.parseInt(act_local_comercial) * 3.76) + (Integer.parseInt(act_sala_de_estar) * 3.76) + (Integer.parseInt(act_comedor) * 3.76) 
                + (Integer.parseInt(act_baño_lav_coc) * 2.54) + (Integer.parseInt(act_hab_matrimonial) * 3.76) + (Integer.parseInt(act_hab_doble) * 3.76) 
                + (Integer.parseInt(act_hab_simple) * 2.54) + (Integer.parseInt(act_sala_de_estudio) * 2.54) + (Integer.parseInt(act_deposito) * 2.54) + (Integer.parseInt(act_taller) * 3.76));
            
            if(validacion_largo > Float.parseFloat(act_largo_terreno)){
                JOptionPane.showMessageDialog(null, "La cantidad de modulos supera el largo del terreno");
            }
            
            else if(validacion_campos_correctos != 0){
                JOptionPane.showMessageDialog(null, "Campo/s incorrecto/s");  //Por si el usuario escribe por ejemplo: NOO en orientacion, 11 en cubierta, 00 en modulos, etc.
            }
            
            else {      //Si las validaciones anteriores son correctas, seguimos con la actualizacion.
                try {
                
                Connection cn = Conexion.conectar();

                 PreparedStatement pst = cn.prepareStatement(
                        "update vivienda set orientacion=?, largo_terreno=?, ancho_terreno=?, cubierta=?, piso=?, terminacion=? where id_vivienda = '" + idVivienda + "'"); //Tener cuidado con las comillas simples '
                 
                //Éstos son los valores que quiero insertar en la base de datos.
                //---SI NECESITO EL NOMBRE DEL CLIENTE, LO TENGO EN LA VARIABLE nom_cliente.
                
                pst.setString(1, act_orientacion);
                pst.setFloat(2, Float.parseFloat(act_largo_terreno));
                pst.setFloat(3, Float.parseFloat(act_ancho_terreno));
                pst.setInt(4, Integer.parseInt(act_cubierta));
                pst.setInt(5, Integer.parseInt(act_piso));
                pst.setInt(6, Integer.parseInt(act_terminacion));
                
                pst.executeUpdate();    //Indica que se tiene que ejecutar toda la acción anterior. 
                
                //Si cambia de un número distinto de 0 a 0, se elimina el modulo_vivienda.
                //Si cambia de 0 a un número distinto de 0, se inserta ese modulo_vivienda.
                //Si cambia de un número distinto de 0 a otro número distinto de 0, se actualiza ese modulo_vivienda. 
                
                if(!local_comercial.equals("0") && act_local_comercial.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_lc = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '1' and id_vivienda = '" + idVivienda + "'"); 
                    pst_lc.executeUpdate();
                }
                else if(local_comercial.equals("0") && !act_local_comercial.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_lc = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_lc.setInt(1, 0);   
                    pst_lc.setInt(2, idVivienda); 
                    pst_lc.setInt(3, 1);        //id_modulo
                    pst_lc.setInt(4, Integer.parseInt(act_local_comercial));
                    pst_lc.executeUpdate();
                }
                else if(!local_comercial.equals("0") && !act_local_comercial.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_lc = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 1 and id_vivienda = '" + idVivienda + "'");
                    pst_lc.setInt(1, Integer.parseInt(act_local_comercial));
                    pst_lc.executeUpdate();
                }
                
                //--
                
                if(!sala_de_estar.equals("0") && act_sala_de_estar.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_se = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '2' and id_vivienda = '" + idVivienda + "'"); 
                    pst_se.executeUpdate();
                }
                else if(sala_de_estar.equals("0") && !act_sala_de_estar.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_se = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_se.setInt(1, 0);   
                    pst_se.setInt(2, idVivienda); 
                    pst_se.setInt(3, 2);        //id_modulo
                    pst_se.setInt(4, Integer.parseInt(act_sala_de_estar));
                    pst_se.executeUpdate();
                }
                else if(!sala_de_estar.equals("0") && !act_sala_de_estar.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_se = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 2 and id_vivienda = '" + idVivienda + "'");
                    pst_se.setInt(1, Integer.parseInt(act_sala_de_estar));
                    pst_se.executeUpdate();
                }
                
                //--
                
                if(!comedor.equals("0") && act_comedor.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_co = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '3' and id_vivienda = '" + idVivienda + "'"); 
                    pst_co.executeUpdate();
                }
                else if(comedor.equals("0") && !act_comedor.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_co = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_co.setInt(1, 0);   
                    pst_co.setInt(2, idVivienda); 
                    pst_co.setInt(3, 3);        //id_modulo
                    pst_co.setInt(4, Integer.parseInt(act_comedor));
                    pst_co.executeUpdate();
                }
                else if(!comedor.equals("0") && !act_comedor.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_co = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 3 and id_vivienda = '" + idVivienda + "'");
                    pst_co.setInt(1, Integer.parseInt(act_comedor));
                    pst_co.executeUpdate();
                }

                //--
                
                if(!baño_lav_coc.equals("0") && act_baño_lav_coc.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_blc = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '4' and id_vivienda = '" + idVivienda + "'"); 
                    pst_blc.executeUpdate();
                }
                else if(baño_lav_coc.equals("0") && !act_baño_lav_coc.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_blc = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_blc.setInt(1, 0);   
                    pst_blc.setInt(2, idVivienda); 
                    pst_blc.setInt(3, 4);        //id_modulo
                    pst_blc.setInt(4, Integer.parseInt(act_baño_lav_coc));
                    pst_blc.executeUpdate();
                }
                else if(!baño_lav_coc.equals("0") && !act_baño_lav_coc.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_blc = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 4 and id_vivienda = '" + idVivienda + "'");
                    pst_blc.setInt(1, Integer.parseInt(act_baño_lav_coc));
                    pst_blc.executeUpdate();
                }
                
                //--
                
                if(!hab_matrimonial.equals("0") && act_hab_matrimonial.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_hdm = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '5' and id_vivienda = '" + idVivienda + "'"); 
                    pst_hdm.executeUpdate();
                }
                else if(hab_matrimonial.equals("0") && !act_hab_matrimonial.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_hdm = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_hdm.setInt(1, 0);   
                    pst_hdm.setInt(2, idVivienda); 
                    pst_hdm.setInt(3, 5);        //id_modulo
                    pst_hdm.setInt(4, Integer.parseInt(act_hab_matrimonial));
                    pst_hdm.executeUpdate();
                }
                else if(!hab_matrimonial.equals("0") && !act_hab_matrimonial.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_hdm = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 5 and id_vivienda = '" + idVivienda + "'");
                    pst_hdm.setInt(1, Integer.parseInt(act_hab_matrimonial));
                    pst_hdm.executeUpdate();
                }
                
                //--
                
                if(!hab_doble.equals("0") && act_hab_doble.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_hd = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '6' and id_vivienda = '" + idVivienda + "'"); 
                    pst_hd.executeUpdate();
                }
                else if(hab_doble.equals("0") && !act_hab_doble.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_hd = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_hd.setInt(1, 0);   
                    pst_hd.setInt(2, idVivienda); 
                    pst_hd.setInt(3, 6);        //id_modulo
                    pst_hd.setInt(4, Integer.parseInt(act_hab_doble));
                    pst_hd.executeUpdate();
                }
                else if(!hab_doble.equals("0") && !act_hab_doble.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_hd = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 6 and id_vivienda = '" + idVivienda + "'");
                    pst_hd.setInt(1, Integer.parseInt(act_hab_doble));
                    pst_hd.executeUpdate();
                }
                
                //--
                
                if(!hab_simple.equals("0") && act_hab_simple.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_hs = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '7' and id_vivienda = '" + idVivienda + "'"); 
                    pst_hs.executeUpdate();
                }
                else if(hab_simple.equals("0") && !act_hab_simple.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_hs = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_hs.setInt(1, 0);   
                    pst_hs.setInt(2, idVivienda); 
                    pst_hs.setInt(3, 7);        //id_modulo
                    pst_hs.setInt(4, Integer.parseInt(act_hab_simple));
                    pst_hs.executeUpdate();
                }
                else if(!hab_simple.equals("0") && !act_hab_simple.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_hs = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 7 and id_vivienda = '" + idVivienda + "'");
                    pst_hs.setInt(1, Integer.parseInt(act_hab_simple));
                    pst_hs.executeUpdate();
                }
                
                //--
                
                if(!sala_de_estudio.equals("0") && act_sala_de_estudio.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_st = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '8' and id_vivienda = '" + idVivienda + "'"); 
                    pst_st.executeUpdate();
                }
                else if(sala_de_estudio.equals("0") && !act_sala_de_estudio.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_st = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_st.setInt(1, 0);   
                    pst_st.setInt(2, idVivienda); 
                    pst_st.setInt(3, 8);        //id_modulo
                    pst_st.setInt(4, Integer.parseInt(act_sala_de_estudio));
                    pst_st.executeUpdate();
                }
                else if(!sala_de_estudio.equals("0") && !act_sala_de_estudio.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_st = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 8 and id_vivienda = '" + idVivienda + "'");
                    pst_st.setInt(1, Integer.parseInt(act_sala_de_estudio));
                    pst_st.executeUpdate();
                }
                
                //--
                
                if(!deposito.equals("0") && act_deposito.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_de = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '9' and id_vivienda = '" + idVivienda + "'"); 
                    pst_de.executeUpdate();
                }
                else if(deposito.equals("0") && !act_deposito.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_de = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_de.setInt(1, 0);   
                    pst_de.setInt(2, idVivienda); 
                    pst_de.setInt(3, 9);        //id_modulo
                    pst_de.setInt(4, Integer.parseInt(act_deposito));
                    pst_de.executeUpdate();
                }
                else if(!deposito.equals("0") && !act_deposito.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_de = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 9 and id_vivienda = '" + idVivienda + "'");
                    pst_de.setInt(1, Integer.parseInt(act_deposito));
                    pst_de.executeUpdate();
                }
                
                //--
                
                if(!taller.equals("0") && act_taller.equals("0")){   //Elimino el modulo_vivienda.
                    PreparedStatement pst_ta = cn.prepareStatement(    
                        "delete from modulo_vivienda where id_modulo = '10' and id_vivienda = '" + idVivienda + "'"); 
                    pst_ta.executeUpdate();
                }
                else if(taller.equals("0") && !act_taller.equals("0")){  //Inserto el modulo_vivienda.
                    PreparedStatement pst_ta = cn.prepareStatement(
                        "insert into modulo_vivienda values (?,?,?,?)");
                    pst_ta.setInt(1, 0);   
                    pst_ta.setInt(2, idVivienda); 
                    pst_ta.setInt(3, 10);        //id_modulo
                    pst_ta.setInt(4, Integer.parseInt(act_taller));
                    pst_ta.executeUpdate();
                }
                else if(!taller.equals("0") && !act_taller.equals("0")){  //Actualizo el modulo_vivienda.
                    PreparedStatement pst_ta = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 10 and id_vivienda = '" + idVivienda + "'");
                    pst_ta.setInt(1, Integer.parseInt(act_taller));
                    pst_ta.executeUpdate();
                }
                
                /*
                PreparedStatement pst_se = cn.prepareStatement(
                        "update modulo_vivienda set cantidad=? where id_modulo = 2 and id_vivienda = '" + idVivienda + "'");
                pst_se.setInt(1, Integer.parseInt(sala_de_estar));
                pst_se.executeUpdate();
                */

                cn.close();     //Cierra la conexión a la base de datos.
                
                Limpiar();  //Función escrita debajo.
                
                txt_orientacion.setBackground(Color.green);
                txt_largo_terreno.setBackground(Color.green);
                txt_ancho_terreno.setBackground(Color.green);
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
                
                JOptionPane.showMessageDialog(null, "Actualización exitosa.");
                this.dispose();
                if(desde == "GestionarViviendas"){
                    //Actualizo los datos de la fila correspondiente en la ventana "GestionarViviendas".
                    gestionarViviendas.model.setValueAt(act_orientacion, gestionarViviendas.fila_clic, 1);
                    gestionarViviendas.model.setValueAt(act_largo_terreno, gestionarViviendas.fila_clic, 2);
                    gestionarViviendas.model.setValueAt(act_ancho_terreno, gestionarViviendas.fila_clic, 3);
                    gestionarViviendas.model.setValueAt(act_cubierta, gestionarViviendas.fila_clic, 4);
                    gestionarViviendas.model.setValueAt(act_piso, gestionarViviendas.fila_clic, 5);
                    gestionarViviendas.model.setValueAt(act_terminacion, gestionarViviendas.fila_clic, 6);
                    if(!act_local_comercial.equals("0")){gestionarViviendas.model.setValueAt(act_local_comercial, gestionarViviendas.fila_clic, 7);} 
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 7);}
                    if(!act_sala_de_estar.equals("0")){gestionarViviendas.model.setValueAt(act_sala_de_estar, gestionarViviendas.fila_clic, 8);}
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 8);}
                    if(!act_comedor.equals("0")){gestionarViviendas.model.setValueAt(act_comedor, gestionarViviendas.fila_clic, 9);}
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 9);}
                    if(!act_baño_lav_coc.equals("0")){gestionarViviendas.model.setValueAt(act_baño_lav_coc, gestionarViviendas.fila_clic, 10);}
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 10);}
                    if(!act_hab_matrimonial.equals("0")){gestionarViviendas.model.setValueAt(act_hab_matrimonial, gestionarViviendas.fila_clic, 11);}
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 11);}
                    if(!act_hab_doble.equals("0")){gestionarViviendas.model.setValueAt(act_hab_doble, gestionarViviendas.fila_clic, 12);}
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 12);}
                    if(!act_hab_simple.equals("0")){gestionarViviendas.model.setValueAt(act_hab_simple, gestionarViviendas.fila_clic, 13);}
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 13);}
                    if(!act_sala_de_estudio.equals("0")){gestionarViviendas.model.setValueAt(act_sala_de_estudio, gestionarViviendas.fila_clic, 14);}
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 14);}
                    if(!act_deposito.equals("0")){gestionarViviendas.model.setValueAt(act_deposito, gestionarViviendas.fila_clic, 15);}
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 15);}
                    if(!act_taller.equals("0")){gestionarViviendas.model.setValueAt(act_taller, gestionarViviendas.fila_clic, 16);}
                        else{gestionarViviendas.model.setValueAt("", gestionarViviendas.fila_clic, 16);}
                }
                else{
                    //Actualizo los datos de la fila correspondiente en la ventana "InformacionCliente".
                    informacionCliente.model.setValueAt(act_orientacion, informacionCliente.fila_clic, 1);
                    informacionCliente.model.setValueAt(act_largo_terreno, informacionCliente.fila_clic, 2);
                    informacionCliente.model.setValueAt(act_ancho_terreno, informacionCliente.fila_clic, 3);
                    informacionCliente.model.setValueAt(act_cubierta, informacionCliente.fila_clic, 4);
                    informacionCliente.model.setValueAt(act_piso, informacionCliente.fila_clic, 5);
                    informacionCliente.model.setValueAt(act_terminacion, informacionCliente.fila_clic, 6);
                    if(!act_local_comercial.equals("0")){informacionCliente.model.setValueAt(act_local_comercial, informacionCliente.fila_clic, 7);} 
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 7);}
                    if(!act_sala_de_estar.equals("0")){informacionCliente.model.setValueAt(act_sala_de_estar, informacionCliente.fila_clic, 8);}
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 8);}
                    if(!act_comedor.equals("0")){informacionCliente.model.setValueAt(act_comedor, informacionCliente.fila_clic, 9);}
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 9);}
                    if(!act_baño_lav_coc.equals("0")){informacionCliente.model.setValueAt(act_baño_lav_coc, informacionCliente.fila_clic, 10);}
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 10);}
                    if(!act_hab_matrimonial.equals("0")){informacionCliente.model.setValueAt(act_hab_matrimonial, informacionCliente.fila_clic, 11);}
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 11);}
                    if(!act_hab_doble.equals("0")){informacionCliente.model.setValueAt(act_hab_doble, informacionCliente.fila_clic, 12);}
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 12);}
                    if(!act_hab_simple.equals("0")){informacionCliente.model.setValueAt(act_hab_simple, informacionCliente.fila_clic, 13);}
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 13);}
                    if(!act_sala_de_estudio.equals("0")){informacionCliente.model.setValueAt(act_sala_de_estudio, informacionCliente.fila_clic, 14);}
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 14);}
                    if(!act_deposito.equals("0")){informacionCliente.model.setValueAt(act_deposito, informacionCliente.fila_clic, 15);}
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 15);}
                    if(!act_taller.equals("0")){informacionCliente.model.setValueAt(act_taller, informacionCliente.fila_clic, 16);}
                        else{informacionCliente.model.setValueAt("", informacionCliente.fila_clic, 16);}
                }
            
                } catch (SQLException e) {
                    System.out.println("Error al actualizar vivienda." + e);
                    JOptionPane.showMessageDialog(null, "Error al actualizar vivienda.");
                    }
            }    
        }
        
    }//GEN-LAST:event_jButton_actualizarViviendaActionPerformed

    private void jButton_generarReporteCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generarReporteCompletoActionPerformed
        
        //Para generar un reporte con los datos del cliente, la vivienda seleccionada y los costos aproximados
        //de acuerdo a los módulos utilizados en la vivienda.
        
        if(Integer.parseInt(local_comercial) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select costo_materiales, costos_extras from modulo where id_bloque = 'lc'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);     //Voy sumando los costos de cada modulo
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }
        
        if(Integer.parseInt(sala_de_estar) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select costo_materiales, costos_extras from modulo where id_bloque = 'se'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }
        
        if(Integer.parseInt(comedor) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                     "select costo_materiales, costos_extras from modulo where id_bloque = 'co'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }
        
        if(Integer.parseInt(baño_lav_coc) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select costo_materiales, costos_extras from modulo where id_bloque = 'blc'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }
        
        if(Integer.parseInt(hab_matrimonial) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select costo_materiales, costos_extras from modulo where id_bloque = 'hdm'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }
        
        if(Integer.parseInt(hab_doble) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select costo_materiales, costos_extras from modulo where id_bloque = 'hd'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }
        
        if(Integer.parseInt(hab_simple) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select costo_materiales, costos_extras from modulo where id_bloque = 'hs'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }
        
        if(Integer.parseInt(sala_de_estudio) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select costo_materiales, costos_extras from modulo where id_bloque = 'st'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }
        
        if(Integer.parseInt(deposito) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select costo_materiales, costos_extras from modulo where id_bloque = 'de'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }  
        
        if(Integer.parseInt(taller) != 0){
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select costo_materiales, costos_extras from modulo where id_bloque = 'ta'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    costoMateriales = costoMateriales + rs.getFloat(1);
                    costosExtras = costosExtras + rs.getFloat(2);
                }
                cn.close();
                
            } catch (SQLException e) {
                System.err.println("Error al obtener costos");
            }
        }
            
        costoTotal = costoMateriales + costosExtras;    //Costo total para mostrar en el reporte.
        
        //Creación del PDF:
        Document documento = new Document(); //Creo un objeto de la clase "Document", que luego nos permitirá generar el pdf
        
        //Para generar un archivo es necesario usar una estructura try-catch:
        try {
            String ruta = System.getProperty("user.home");  //Ruta donde se generará el pdf.
                                            //user.home es para obtener el nombre de usuario o ruta del usuario que esta usando el programa, porque no se sabe en que computadora se va a usar.
            
            //Ahora genero el pdf en la ruta que quiero y le asigno el nombre del cliente:
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + nombre_cliente + "-Completo.pdf"));  
            
            //acá se usa una librería sin el "import" para solucionar lo que indique arriba junto a los import de librerías.
            com.itextpdf.text.Image banner = com.itextpdf.text.Image.getInstance("src/imagenes/portadaPDF.png");
            banner.scaleToFit(650, 1000);   //650 es para el tamaño de la imagen y 1000 es la escala de visualización.
            banner.setAlignment(Chunk.ALIGN_CENTER);    //Para ubicar la imagen en el centro.

            //Con el objeto del tipo "Paragraph" se le da formato al texto que queremos mostrar.
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK)); //Fuente, tamaño, texto en negrita, color del texto.
            parrafo.add("\n \n INFORMACIÓN DEL CLIENTE \n \n");  //Con el método "add" podemos ir agregando cualquier texto dentro del pdf.     

            documento.open();   //Abro el documento.
            documento.add(banner);  //Agrego el banner arriba.
            documento.add(parrafo); //"parrafo" es el objeto que cree anteriormente con el texto.

            //Propiedades de la tabla cliente:
            PdfPTable tablaCliente = new PdfPTable(5);
            tablaCliente.setWidthPercentage(100); //Porcentaje a la tabla (tamaño ancho).
            tablaCliente.setWidths(new float[] {23, 11, 14, 20, 30}); //Ancho de cada columna.
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("DNI");
            tablaCliente.addCell("Teléfono");
            tablaCliente.addCell("Direccion");
            tablaCliente.addCell("Correo");
               
            try {
                //Conexión con la base de datos.
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select nombre_cliente, dni_cliente, telefono_cliente, direccion_cliente, correo_cliente from cliente where id_cliente = '" + idCliente + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tablaCliente.addCell(rs.getString(1));
                        tablaCliente.addCell(rs.getString(2));
                        tablaCliente.addCell(rs.getString(3));
                        tablaCliente.addCell(rs.getString(4));
                        tablaCliente.addCell(rs.getString(5));

                    } while (rs.next());

                    documento.add(tablaCliente);
                }
                
                cn.close();
                
                } catch (SQLException e) {
                System.err.print("Error al obtener datos del clientes. " + e);
                }
            
                //-------------------
                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK));
                parrafo2.add("\n \n INFORMACIÓN DE LA VIVIENDA \n \n");     

                documento.add(parrafo2);

                //Propiedades de la tabla de viviendas:
                PdfPTable tablaViviendas = new PdfPTable(6);
                tablaViviendas.setWidthPercentage(100); //Porcentaje a la tabla (tamaño ancho).
                tablaViviendas.setWidths(new float[] {10, 10, 10, 10, 10, 10}); //Ancho de cada columna.
                tablaViviendas.addCell("Orientación");
                tablaViviendas.addCell("Largo terreno");
                tablaViviendas.addCell("Ancho terreno");
                tablaViviendas.addCell("Cubierta");
                tablaViviendas.addCell("Piso");
                tablaViviendas.addCell("Terminación");

                try {

                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select orientacion, largo_terreno, ancho_terreno, cubierta, piso, terminacion from vivienda where id_vivienda = '" + idVivienda + "'");                         
                    
                    ResultSet rs2 = pst2.executeQuery();
                    
                    if(rs2.next()){
                        do {                            
                            tablaViviendas.addCell(rs2.getString(1));
                            tablaViviendas.addCell(rs2.getString(2));
                            tablaViviendas.addCell(rs2.getString(3));
                            tablaViviendas.addCell(rs2.getString(4));
                            tablaViviendas.addCell(rs2.getString(5));
                            tablaViviendas.addCell(rs2.getString(6));
                              
                        } while (rs2.next());
                        documento.add(tablaViviendas);
                    }

                    cn2.close();
                    
                } catch (SQLException e) {
                    System.err.println("Error al cargar viviendas " + e);
                }

                //----------------------
                Paragraph parrafo3 = new Paragraph();
                parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo3.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK));
                parrafo3.add("\n \n MÓDULOS \n \n");     

                documento.add(parrafo3);

                //Propiedades de la tabla de viviendas:
                PdfPTable tablaModulos = new PdfPTable(11);
                tablaModulos.setWidthPercentage(100); //Porcentaje a la tabla (tamaño ancho).
                tablaModulos.setWidths(new float[] {12, 8, 10, 12, 13, 10, 10, 10, 10, 12, 10}); //Ancho de cada columna.
                tablaModulos.addCell("ID vivienda");
                tablaModulos.addCell("Local");
                tablaModulos.addCell("Sala estar");
                tablaModulos.addCell("Comedor");
                tablaModulos.addCell("Baño, lav, cocina");
                tablaModulos.addCell("Hab. matr.");
                tablaModulos.addCell("Hab. dob.");
                tablaModulos.addCell("Hab. sim.");
                tablaModulos.addCell("Sala estudio");
                tablaModulos.addCell("Deposito");
                tablaModulos.addCell("Taller");

                try {

                    Connection cn3 = Conexion.conectar();
                    PreparedStatement pst3 = cn3.prepareStatement(
                                "select " 
                                + "v.id_vivienda, "         //RECORDAR SIEMPRE DEJAR UN ESPACIO AL FINAL ANTES DE " CUANDO HAGO UN SALTO DE LINEA.
                            
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=1 and mv.id_vivienda=v.id_vivienda) as 'Local', "
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=2 and mv.id_vivienda=v.id_vivienda) as 'Sala estar', "
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=3 and mv.id_vivienda=v.id_vivienda) as 'Comedor', "
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=4 and mv.id_vivienda=v.id_vivienda) as 'Baño,lav,coc', "
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=5 and mv.id_vivienda=v.id_vivienda) as 'Hab mat', "
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=6 and mv.id_vivienda=v.id_vivienda) as 'Hab doble', "
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=7 and mv.id_vivienda=v.id_vivienda) as 'Hab simple', "
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=8 and mv.id_vivienda=v.id_vivienda) as 'Sala est', "
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=9 and mv.id_vivienda=v.id_vivienda) as 'Deposito', "
                                + "(select mv.cantidad FROM modulo_vivienda mv WHERE mv.id_modulo=10 and mv.id_vivienda=v.id_vivienda) as 'Taller' "

                                + "from vivienda v inner join modulo_vivienda mv1 on v.id_vivienda = mv1.id_vivienda "
                                + "where v.id_vivienda = '" + idVivienda + "' "       //RECORDAR SIEMPRE DEJAR UN ESPACIO AL FINAL ANTES DE " CUANDO HAGO UN SALTO DE LINEA.
                                + "group by id_vivienda");
                    
                    ResultSet rs3 = pst3.executeQuery();
                    
                    if(rs3.next()){
                        do {                            
                            tablaModulos.addCell(rs3.getString(1));
                            tablaModulos.addCell(rs3.getString(2));
                            tablaModulos.addCell(rs3.getString(3));
                            tablaModulos.addCell(rs3.getString(4));
                            tablaModulos.addCell(rs3.getString(5));
                            tablaModulos.addCell(rs3.getString(6));
                            tablaModulos.addCell(rs3.getString(7));
                            tablaModulos.addCell(rs3.getString(8));
                            tablaModulos.addCell(rs3.getString(9));
                            tablaModulos.addCell(rs3.getString(10));
                            tablaModulos.addCell(rs3.getString(11));
                              
                        } while (rs3.next());
                        documento.add(tablaModulos);
                    }

                    cn3.close();
                    
                } catch (SQLException e) {
                    System.err.println("Error al cargar módulos. " + e);
                }
                
            Paragraph parrafo4 = new Paragraph();
            parrafo4.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo4.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK));
            parrafo4.add("\n \n COSTOS APROXIMADOS \n \n");     

            documento.add(parrafo4);
                
            //Propiedades de la tabla de costos:
            PdfPTable tablaCostos = new PdfPTable(3);
            tablaCostos.setWidthPercentage(100); //Porcentaje a la tabla (tamaño ancho).
            tablaCostos.setWidths(new float[] {20, 20, 20}); //Ancho de cada columna.
            tablaCostos.addCell("Materiales");
            tablaCostos.addCell("Extras");
            tablaCostos.addCell("Total");
            tablaCostos.addCell(Float.toString(costoMateriales));
            tablaCostos.addCell(Float.toString(costosExtras));
            tablaCostos.addCell(Float.toString(costoTotal));
            documento.add(tablaCostos);
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen" + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");
        }
    }//GEN-LAST:event_jButton_generarReporteCompletoActionPerformed

    //Validaciones de letras y numeros:
    
    private void txt_orientacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_orientacionKeyTyped
        char c = evt.getKeyChar();
        if(c!='N' && c!='S' && c!='E' && c!='O') evt.consume();        //Solo se permite escribir esas cuatro letras.
    }//GEN-LAST:event_txt_orientacionKeyTyped

    private void txt_largo_terrenoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_largo_terrenoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_largo_terrenoKeyTyped

    private void txt_ancho_terrenoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ancho_terrenoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_ancho_terrenoKeyTyped

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

    //Si quiero hacer algo al cerrar la ventana con la cruz roja.
    //Desde "Design", haciendo clic derecho en JFrame - Events - Window - WindowClosign
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
            java.util.logging.Logger.getLogger(InformacionVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionVivienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_actualizarVivienda;
    private javax.swing.JButton jButton_crearDiseño;
    private javax.swing.JButton jButton_eliminarVivienda;
    private javax.swing.JButton jButton_generarReporteCompleto;
    private javax.swing.JLabel jLabel_ancho;
    private javax.swing.JLabel jLabel_baño_lav_coc;
    private javax.swing.JLabel jLabel_comedor;
    private javax.swing.JLabel jLabel_cub;
    private javax.swing.JLabel jLabel_cubierta;
    private javax.swing.JLabel jLabel_deposito;
    private javax.swing.JLabel jLabel_hab_doble;
    private javax.swing.JLabel jLabel_hab_matrimonial;
    private javax.swing.JLabel jLabel_hab_simple;
    private javax.swing.JLabel jLabel_informacionVivienda;
    private javax.swing.JLabel jLabel_largo;
    private javax.swing.JLabel jLabel_local_comercial;
    private javax.swing.JLabel jLabel_orientacion;
    private javax.swing.JLabel jLabel_orientacion1;
    private javax.swing.JLabel jLabel_orientacion2;
    private javax.swing.JLabel jLabel_pi;
    private javax.swing.JLabel jLabel_piso;
    private javax.swing.JLabel jLabel_sala_de_estar;
    private javax.swing.JLabel jLabel_sala_de_estudio;
    private javax.swing.JLabel jLabel_taller;
    private javax.swing.JLabel jLabel_term;
    private javax.swing.JLabel jLabel_terminacion;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_titulo1;
    private javax.swing.JTextField txt_ancho_terreno;
    private javax.swing.JTextField txt_baño_lav_coc;
    private javax.swing.JTextField txt_comedor;
    private javax.swing.JTextField txt_cubierta;
    private javax.swing.JTextField txt_deposito;
    private javax.swing.JTextField txt_hab_doble;
    private javax.swing.JTextField txt_hab_matrimonial;
    private javax.swing.JTextField txt_hab_simple;
    private javax.swing.JTextField txt_largo_terreno;
    private javax.swing.JTextField txt_local_comercial;
    private javax.swing.JTextField txt_orientacion;
    private javax.swing.JTextField txt_piso;
    private javax.swing.JTextField txt_sala_de_estar;
    private javax.swing.JTextField txt_sala_de_estudio;
    private javax.swing.JTextField txt_taller;
    private javax.swing.JTextField txt_terminacion;
    // End of variables declaration//GEN-END:variables

    public void generar_ventana(){
        initComponents();
        
        //Defino la variable "desde" según si el clic viene de la ventana "InformacionCliente" o de "GestionarViviendas". 
        //Luego lo uso para saber en la tabla de que ventana tengo que actualizar o eliminar la fila de la vivienda correspondiente.
        if(informacionCliente != null){
            desde = "InformaciónCliente";
        }
        else{
            desde = "GestionarViviendas";
        }

        setSize(790, 460); 
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_informacionVivienda.getWidth(),
                jLabel_informacionVivienda.getHeight(), Image.SCALE_DEFAULT));
        jLabel_informacionVivienda.setIcon(icono);
        this.repaint();
        
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
        
        //Para conectarnos a la base de datos y obtener los datos de la vivienda que se seleccione en "GestionarViviendas"
        //o en "InformacionCliente" y para completar los campos de texto de "InformacionVivienda" con esos datos obtenidos.
        try {
            Connection cn = Conexion.conectar();
            
            //Primero obtengo el id_cliente, orientacion y tamaño del terreno de la vivienda (los uso más abajo)
            PreparedStatement pst = cn.prepareStatement(
                "select id_cliente, orientacion, largo_terreno, ancho_terreno, cubierta, piso, terminacion from vivienda where id_vivienda = '" + idVivienda + "'");    
            ResultSet rs = pst.executeQuery(); 
            
            //Luego obtengo la cantidad de cada módulo y ese dato lo guardo en cada variable "local_comercial", "comedor", etc. 
            //para colocarla en cada cuadro de texto más abajo.
            
            PreparedStatement pst_lc = cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 1 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_lc = pst_lc.executeQuery();
            if(rs_lc.next()){ local_comercial = Integer.toString(rs_lc.getInt("cantidad")); }
            else local_comercial = "0";
            
            PreparedStatement pst_se= cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 2 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_se = pst_se.executeQuery();
            if(rs_se.next()){ sala_de_estar = Integer.toString(rs_se.getInt("cantidad")); }
            else sala_de_estar = "0";
            
            PreparedStatement pst_co = cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 3 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_co = pst_co.executeQuery();
            if(rs_co.next()){ comedor = Integer.toString(rs_co.getInt("cantidad"));}
            else comedor = "0";
            
            PreparedStatement pst_blc = cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 4 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_blc = pst_blc.executeQuery();
            if(rs_blc.next()){ baño_lav_coc = Integer.toString(rs_blc.getInt("cantidad"));}
            else baño_lav_coc = "0";
            
            PreparedStatement pst_hdm = cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 5 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_hdm = pst_hdm.executeQuery();
            if(rs_hdm.next()){ hab_matrimonial = Integer.toString(rs_hdm.getInt("cantidad"));}
            else hab_matrimonial = "0";
            
            PreparedStatement pst_hd = cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 6 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_hd = pst_hd.executeQuery();
            if(rs_hd.next()){ hab_doble = Integer.toString(rs_hd.getInt("cantidad"));}
            else hab_doble = "0";
            
            PreparedStatement pst_hs = cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 7 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_hs = pst_hs.executeQuery();
            if(rs_hs.next()){ hab_simple = Integer.toString(rs_hs.getInt("cantidad"));}
            else hab_simple = "0";
            
            PreparedStatement pst_st = cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 8 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_st = pst_st.executeQuery();
            if(rs_st.next()){ sala_de_estudio = Integer.toString(rs_st.getInt("cantidad"));}
            else sala_de_estudio = "0";
            
            PreparedStatement pst_de = cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 9 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_de = pst_de.executeQuery();
            if(rs_de.next()){ deposito = Integer.toString(rs_de.getInt("cantidad"));}
            else deposito = "0";
            
            PreparedStatement pst_ta = cn.prepareStatement(
                "select cantidad from modulo_vivienda where id_modulo = 10 and id_vivienda = '" + idVivienda + "'");
            ResultSet rs_ta = pst_ta.executeQuery();
            if(rs_ta.next()){ taller = Integer.toString(rs_ta.getInt("cantidad"));}
            else taller = "0";
            
            if(rs.next()){  //Si se encontro (consulta del comienzo), se hace lo siguiente:
                orientacion = rs.getString("orientacion");
                largo_terreno = Float.toString(rs.getFloat("largo_terreno"));
                ancho_terreno = Float.toString(rs.getFloat("ancho_terreno"));
                cubierta = Integer.toString(rs.getInt("cubierta"));
                piso = Integer.toString(rs.getInt("piso"));
                terminacion = Integer.toString(rs.getInt("terminacion"));
                idCliente = rs.getInt("id_cliente");
                
                //Busco el nombre del cliente dueño de la vivienda:
                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                         "select nombre_cliente from cliente where id_cliente = '" + idCliente + "'");
                    ResultSet rs2 = pst2.executeQuery();
            
                    if(rs2.next()){
                         nombre_cliente = rs2.getString("nombre_cliente");
                    }       
                    cn2.close();  
                } catch (SQLException e) {
                      System.err.println("Error al consultar el nombre del cliente.");
                }
                
                setTitle("Información de vivienda de " + nombre_cliente);  
                
                /*
                //Obtengo los valores para escribir el archivo .txt al presionar "Crear diseño"
                orientacion = rs.getString("orientacion");
                largo_terreno = rs.getString("largo_terreno");
                ancho_terreno = rs.getString("ancho_terreno");
                cubierta = rs.getString("cubierta");
                piso = rs.getString("piso");
                terminacion = rs.getString("terminacion");
                local_comercial = rs.getString("local_comercial");
                sala_de_estar = rs.getString("sala_de_estar");
                comedor = rs.getString("comedor");
                baño_lav_coc = rs.getString("baño_lav_coc");
                hab_matrimonial = rs.getString("hab_matrimonial");
                hab_doble = rs.getString("hab_doble");
                hab_simple = rs.getString("hab_simple");
                sala_de_estudio = rs.getString("sala_de_estudio");
                deposito = rs.getString("deposito");
                taller = rs.getString("taller");
                */
                
                //Valido que los módulos elegidos entren en el terreno.
                validacion_largo = (float) ( (Integer.parseInt(local_comercial) * 3.76) + (Integer.parseInt(sala_de_estar) * 3.76) + (Integer.parseInt(comedor) * 3.76) 
                    + (Integer.parseInt(baño_lav_coc) * 2.54) + (Integer.parseInt(hab_matrimonial) * 3.76) + (Integer.parseInt(hab_doble) * 3.76) 
                    + (Integer.parseInt(hab_simple) * 2.54) + (Integer.parseInt(sala_de_estudio) * 2.54) + (Integer.parseInt(deposito) * 2.54) + (Integer.parseInt(taller) * 3.76) );
                
                largo_ocupado = Float.toString(validacion_largo);
                
                //Completo campos de la pantalla con la información obtenida de la base de datos:
                txt_orientacion.setText(orientacion);
                txt_largo_terreno.setText(largo_terreno);
                txt_ancho_terreno.setText(ancho_terreno);
                txt_cubierta.setText(cubierta);
                txt_piso.setText(piso);
                txt_terminacion.setText(terminacion);
                txt_local_comercial.setText(local_comercial);
                txt_sala_de_estar.setText(sala_de_estar);
                txt_comedor.setText(comedor);
                txt_baño_lav_coc.setText(baño_lav_coc);
                txt_hab_matrimonial.setText(hab_matrimonial);
                txt_hab_doble.setText(hab_doble);
                txt_hab_simple.setText(hab_simple);
                txt_sala_de_estudio.setText(sala_de_estudio);
                txt_deposito.setText(deposito);
                txt_taller.setText(taller);
            }
            cn.close();   //Cierro la conexión.
            
        } catch (SQLException e) {
            System.err.println("Error en cargar vivienda." + e); //Sirve para inviarle un mensaje al programador para saber en que parte del código ocurrió el error. 
            JOptionPane.showMessageDialog(null, "Error al cargar");   //Sirve para decirle al usuario que hubo un error.
        
        }   //Termina el try-catch del llenado de los datos de la vivienda en los campos de texto de "InformacionVivienda".
        
    }
    
    public void Limpiar(){
        txt_orientacion.setText("");
        txt_largo_terreno.setText("");
        txt_ancho_terreno.setText("");
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
