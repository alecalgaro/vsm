package Ventanas;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * @author Calgaro Alejandro
 */

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    public Login() {
        initComponents();
        
        setTitle("Ingreso al sistema");
        setSize(310, 180);  //Para indicar el tamaño de la ventana
        setResizable(false);     //Evita que el usuario pueda modificar el tamaño de la ventana
        setLocationRelativeTo(null);    //Para que la ventana aparezca centrada
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);   //Para evitar que el programa finalice al cerrar la ventana.
                
        //Para poner la imagen de fondo en la ventana (jLabel_registrarCliente)
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_login.getWidth(), 
                jLabel_login.getHeight(), Image.SCALE_DEFAULT));    //Para adaptar la imagen a la ventana
        jLabel_login.setIcon(icono);   //Se indica que esa imagen que estamos escalando se tiene que ubicar dentro del jLabel_login    
        
        this.repaint(); //Línea opcional, para asegurarse de que se apliquen los cambios
        
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jButton_ingresar = new javax.swing.JButton();
        password_ = new javax.swing.JPasswordField();
        jLabel_login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(300, 180));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Ingrese la contraseña del sistema");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jButton_ingresar.setBackground(new java.awt.Color(64, 97, 164));
        jButton_ingresar.setFont(new java.awt.Font("Arial Narrow", 0, 15)); // NOI18N
        jButton_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ingresar.setText("Ingresar");
        jButton_ingresar.setBorder(null);
        jButton_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 90, 25));

        password_.setBackground(new java.awt.Color(92, 124, 203));
        password_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password_.setForeground(new java.awt.Color(255, 255, 255));
        password_.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password_.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        password_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_ActionPerformed(evt);
            }
        });
        getContentPane().add(password_, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 25));
        getContentPane().add(jLabel_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void password_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_ActionPerformed

    }//GEN-LAST:event_password_ActionPerformed

    private void jButton_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ingresarActionPerformed
        String password = "";
        int validacion = 0;
        //Para recuperar el password ingresado:
        password = new String(password_.getPassword());
        
        /* También se puede hacer:
        char [] pass = password_.getPassword();
        for (int i = 0; i < pass.length; i++) {
            password += pass[i];    //Concateno cada caracter del password ingresado.
        }*/
        
        if(password.equals("")){
            validacion++;
        }
        
        if (validacion == 0) {
            if(password.equals("master793")){   //Recordar usar "equals" y no ==
                VSM vsm = new VSM();
                vsm.setVisible(true);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes completar la contraseña.");
        }
    }//GEN-LAST:event_jButton_ingresarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ingresar;
    private javax.swing.JLabel jLabel_login;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JPasswordField password_;
    // End of variables declaration//GEN-END:variables
}
