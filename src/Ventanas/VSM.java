package Ventanas;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import Clases.Conexion;

/**
 * @author Calgaro Alejandro
 */

public class VSM extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    public VSM() {
        initComponents();
        setSize(370, 500);  //Para indicar el tamaño de la ventana
        setResizable(false);     //Evita que el usuario pueda modificar el tamaño de la ventana
        setTitle("VSM");
        setLocationRelativeTo(null);    //Para que la ventana aparezca centrada
        
        //Para poner la imagen de fondo en la ventana
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_inicio.getWidth(), 
                jLabel_inicio.getHeight(), Image.SCALE_DEFAULT));    //Para adaptar la imagen a la ventana
        jLabel_inicio.setIcon(icono);   //Se indica que esa imagen que estamos escalando se tiene que ubicar dentro del jLabel_inicio      
        
        this.repaint(); //Línea opcional, para asegurarse de que se apliquen los cambios
    
        //Para agregar la imagen principal de la ventana:
        
        ImageIcon imagen_logo = new ImageIcon("src/imagenes/logo_vsm.png");
        Icon icono_logo = new ImageIcon(imagen_logo.getImage().getScaledInstance(jLabel_logo.getWidth(),
                jLabel_logo.getHeight(), Image.SCALE_SMOOTH));
        jLabel_logo.setIcon(icono_logo);
        this.repaint();
        
        /* Si necesito escalar la imagen de forma manual se hace así:
        Image imagen_logo = new ImageIcon("src/imagenes/logo_vsm.png").getImage();
        ImageIcon logo = new ImageIcon(imagen_logo.getScaledInstance(150, 100, Image.SCALE_SMOOTH));
        jLabel_logo.setIcon(logo);
        this.repaint();
        */
        
        //SE PONEN LAS IMÁGENES ASÍ PORQUE SI SE LO HACE DIRECTO DESDE EL DISEÑO DE LA INTERFAZ PROVOCA ALGUNOS ERRORES.
    
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
        
    } //Cierre del constructor 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_logo = new javax.swing.JLabel();
        jButton_registrarCliente = new javax.swing.JButton();
        jButton_gestionarClientes = new javax.swing.JButton();
        jButton_gestionarViviendas = new javax.swing.JButton();
        jButton_gestionarModulos = new javax.swing.JButton();
        jLabel_inicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_logo.setToolTipText("");
        getContentPane().add(jLabel_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 190, 120));

        jButton_registrarCliente.setBackground(new java.awt.Color(64, 97, 164));
        jButton_registrarCliente.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_registrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrarCliente.setText("Registrar cliente");
        jButton_registrarCliente.setBorder(null);
        jButton_registrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 150, 25));

        jButton_gestionarClientes.setBackground(new java.awt.Color(64, 97, 164));
        jButton_gestionarClientes.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_gestionarClientes.setForeground(new java.awt.Color(255, 255, 255));
        jButton_gestionarClientes.setText("Gestionar clientes");
        jButton_gestionarClientes.setBorder(null);
        jButton_gestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 150, 25));

        jButton_gestionarViviendas.setBackground(new java.awt.Color(64, 97, 164));
        jButton_gestionarViviendas.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_gestionarViviendas.setForeground(new java.awt.Color(255, 255, 255));
        jButton_gestionarViviendas.setText("Gestionar viviendas");
        jButton_gestionarViviendas.setBorder(null);
        jButton_gestionarViviendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionarViviendasActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionarViviendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 150, 25));

        jButton_gestionarModulos.setBackground(new java.awt.Color(64, 97, 164));
        jButton_gestionarModulos.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_gestionarModulos.setForeground(new java.awt.Color(255, 255, 255));
        jButton_gestionarModulos.setText("Gestionar módulos");
        jButton_gestionarModulos.setBorder(null);
        jButton_gestionarModulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionarModulosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionarModulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 150, 25));
        getContentPane().add(jLabel_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarClienteActionPerformed
        RegistrarCliente registrarCliente = new RegistrarCliente();
        registrarCliente.setVisible(true);
    }//GEN-LAST:event_jButton_registrarClienteActionPerformed

    private void jButton_gestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionarClientesActionPerformed
        GestionarClientes gestionarClientes = new GestionarClientes();
        gestionarClientes.setVisible(true);     
    }//GEN-LAST:event_jButton_gestionarClientesActionPerformed

    private void jButton_gestionarViviendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionarViviendasActionPerformed
        GestionarViviendas gestionarViviendas = new GestionarViviendas();
        gestionarViviendas.setVisible(true);
    }//GEN-LAST:event_jButton_gestionarViviendasActionPerformed

    private void jButton_gestionarModulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionarModulosActionPerformed
        GestionarModulos gestionarModulos = new GestionarModulos();
        gestionarModulos.setVisible(true);
    }//GEN-LAST:event_jButton_gestionarModulosActionPerformed

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
            java.util.logging.Logger.getLogger(VSM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VSM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VSM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VSM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VSM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_gestionarClientes;
    private javax.swing.JButton jButton_gestionarModulos;
    private javax.swing.JButton jButton_gestionarViviendas;
    private javax.swing.JButton jButton_registrarCliente;
    private javax.swing.JLabel jLabel_inicio;
    private javax.swing.JLabel jLabel_logo;
    // End of variables declaration//GEN-END:variables


}
