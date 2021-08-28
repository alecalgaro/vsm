package Ventanas;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.sql.*;
import Clases.Conexion;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * @author Calgaro Alejandro
 */

public class RegistrarCliente extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarCliente
     */
    
    public RegistrarCliente() {
        initComponents();
        
        setTitle("Registrar nuevo cliente");
        setSize(370, 500);  //Para indicar el tamaño de la ventana
        setResizable(false);     //Evita que el usuario pueda modificar el tamaño de la ventana
        setLocationRelativeTo(null);    //Para que la ventana aparezca centrada
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);   //Para evitar que el programa finalice al cerrar la ventana de registro de nuevo usuario
                
        //Para poner la imagen de fondo en la ventana (jLabel_registrarCliente)
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_registrarCliente.getWidth(), 
                jLabel_registrarCliente.getHeight(), Image.SCALE_DEFAULT));    //Para adaptar la imagen a la ventana
        jLabel_registrarCliente.setIcon(icono);   //Se indica que esa imagen que estamos escalando se tiene que ubicar dentro del jLabel_registrarCliente      
        
        this.repaint(); //Línea opcional, para asegurarse de que se apliquen los cambios
        
        //Para agregar la imagen principal de la ventana:
        ImageIcon imagen_logo = new ImageIcon("src/imagenes/agregar.png");
        Icon icono_logo = new ImageIcon(imagen_logo.getImage().getScaledInstance(jButton_registrarCliente.getWidth(),
                jButton_registrarCliente.getHeight(), Image.SCALE_DEFAULT));
        jButton_registrarCliente.setIcon(icono_logo);
        this.repaint();
        
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
        
    } //Fin del constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_textoDatosDelCliente = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel_nombre = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        jLabel_dni = new javax.swing.JLabel();
        jLabel_telefono = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel_correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        jLabel_direccion = new javax.swing.JLabel();
        jButton_registrarCliente = new javax.swing.JButton();
        jLabel_registrarCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_textoDatosDelCliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_textoDatosDelCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_textoDatosDelCliente.setText("Datos del cliente");
        getContentPane().add(jLabel_textoDatosDelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(92, 124, 203));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 210, -1));

        jLabel_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombre.setText("Nombre:");
        getContentPane().add(jLabel_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        txt_dni.setBackground(new java.awt.Color(92, 124, 203));
        txt_dni.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_dni.setForeground(new java.awt.Color(255, 255, 255));
        txt_dni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dniKeyTyped(evt);
            }
        });
        getContentPane().add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 210, -1));

        jLabel_dni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_dni.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_dni.setText("DNI");
        getContentPane().add(jLabel_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        jLabel_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_telefono.setText("Tel./Cel:");
        getContentPane().add(jLabel_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        txt_telefono.setBackground(new java.awt.Color(92, 124, 203));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 210, -1));

        jLabel_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_correo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_correo.setText("Correo:");
        getContentPane().add(jLabel_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        txt_correo.setBackground(new java.awt.Color(92, 124, 203));
        txt_correo.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_correo.setForeground(new java.awt.Color(255, 255, 255));
        txt_correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_correo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 210, -1));

        txt_direccion.setBackground(new java.awt.Color(92, 124, 203));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 210, -1));

        jLabel_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_direccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_direccion.setText("Dirección:");
        getContentPane().add(jLabel_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        jButton_registrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 70, 70));
        getContentPane().add(jLabel_registrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarClienteActionPerformed
        
        int validacion = 0;
        String nombre, dni, telefono, direccion, correo;
        
        //Para recuperar la información escrita:
        nombre = txt_nombre.getText().trim();
        dni = txt_dni.getText().trim();
        telefono = txt_telefono.getText().trim();
        direccion = txt_direccion.getText().trim();
        correo = txt_correo.getText().trim();         
        
        //Validar que los campos no estén vacios:
        if(nombre.equals("")){  //"" es un espacio en blanco.
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        if(dni.equals("")){
            txt_dni.setBackground(Color.red);
            validacion++;
        }
        if(telefono.equals("")){
            txt_telefono.setBackground(Color.red);
            validacion++;
        }
        if(direccion.equals("")){
            txt_direccion.setBackground(Color.red);
            validacion++;
        }
        if(correo.equals("")){
            txt_correo.setBackground(Color.red);
            validacion++;
        } 
        
        if (validacion == 0) {  //Si validacion = 0, significa que todos los campos están completos, 
                                //si es distinto de cero, alguno de los campos esta vacío. 
            
            try {
                
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into cliente values (?,?,?,?,?,?)");    //Se usan "?" porque todavía no se conocen.
                //Éstos son los 6 valores que quiero insertar en la base de datos.
                pst.setInt(1, 0);           //En el id se le envía un 0 para que no haya un error, pero la base de datos comprueba si necesita ese valor o no.
                pst.setString(2, nombre);
                pst.setString(3, dni);
                pst.setString(4, telefono);
                pst.setString(5, direccion);
                pst.setString(6, correo);               
                
                pst.executeUpdate();    //Indica que se tiene que ejecutar toda la acción anterior.
                cn.close();     //Cierra la conexión a la base de datos.
                
                Limpiar();  //Función escrita debajo.
                
                txt_nombre.setBackground(Color.green);
                txt_dni.setBackground(Color.green);
                txt_telefono.setBackground(Color.green);
                txt_direccion.setBackground(Color.green);
                txt_correo.setBackground(Color.green);
                
                JOptionPane.showMessageDialog(null, "Registro exitoso.");
                this.dispose();
                
            } catch (SQLException e) {
                System.out.println("Error al registrar cliente." + e);
                JOptionPane.showMessageDialog(null, "ERROR al registrar cliente.");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos.");
        }
        
    }//GEN-LAST:event_jButton_registrarClienteActionPerformed

    
    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    //Validaciones de numero y letras: 
    
    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c>' ') && (c<'á'||c>'ú') && (c<'Á'||c>'Ú')) evt.consume();  //Solo se permite escribir letras, espacios y tildes.
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_dniKeyTyped
  
    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_telefonoKeyTyped

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
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_registrarCliente;
    private javax.swing.JLabel jLabel_correo;
    private javax.swing.JLabel jLabel_direccion;
    private javax.swing.JLabel jLabel_dni;
    private javax.swing.JLabel jLabel_nombre;
    private javax.swing.JLabel jLabel_registrarCliente;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JLabel jLabel_textoDatosDelCliente;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    public void Limpiar(){
        txt_nombre.setText("");
        txt_dni.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
        txt_correo.setText("");           
    }
            
}
