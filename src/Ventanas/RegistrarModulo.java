package Ventanas;

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * @author Calgaro Alejandro
 */

public class RegistrarModulo extends javax.swing.JFrame {

    private GestionarModulos gestionarModulos;
            
    /**
     * Creates new form RegistrarModulo
     */
    
    public RegistrarModulo(GestionarModulos gestionarModulos) {
        initComponents();
        setTitle("Registrar módulo");
        setSize(370, 550);  //Para indicar el tamaño de la ventana
        setResizable(false);     //Evita que el usuario pueda modificar el tamaño de la ventana
        setLocationRelativeTo(null);    //Para que la ventana aparezca centrada
   
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        this.gestionarModulos = gestionarModulos;   //Lo uso para actualizar la tabla cuando se cierra esta pantalla luego de registrar.
        
        //Para poner la imagen de fondo en la ventana
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_registrarModulo.getWidth(), 
                jLabel_registrarModulo.getHeight(), Image.SCALE_DEFAULT));    //Para adaptar la imagen a la ventana
        jLabel_registrarModulo.setIcon(icono);   //Se indica que esa imagen que estamos escalando se tiene que ubicar dentro del jLabel_gestionarClientes      
        
        this.repaint(); //Línea opcional, para asegurarse de que se apliquen los cambios
   
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
        
    }

    private RegistrarModulo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_DatosDelModulo = new javax.swing.JLabel();
        jLabel_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel_idModulo = new javax.swing.JLabel();
        txt_idModulo = new javax.swing.JTextField();
        jLabel_idBloque = new javax.swing.JLabel();
        txt_idBloque = new javax.swing.JTextField();
        jLabel_costoMateriales = new javax.swing.JLabel();
        txt_costoMateriales = new javax.swing.JTextField();
        jLabel_costosExtras = new javax.swing.JLabel();
        txt_costosExtras = new javax.swing.JTextField();
        jLabel_informacionAdicional = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_informacionAdicional = new javax.swing.JTextArea();
        jButton_registrarModulo = new javax.swing.JButton();
        jLabel_registrarModulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_DatosDelModulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_DatosDelModulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DatosDelModulo.setText("Datos del módulo");
        getContentPane().add(jLabel_DatosDelModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombre.setText("Nombre:");
        getContentPane().add(jLabel_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(92, 124, 203));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 210, -1));

        jLabel_idModulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_idModulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_idModulo.setText("ID módulo");
        getContentPane().add(jLabel_idModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        txt_idModulo.setBackground(new java.awt.Color(92, 124, 203));
        txt_idModulo.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_idModulo.setForeground(new java.awt.Color(255, 255, 255));
        txt_idModulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idModulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_idModulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idModuloKeyTyped(evt);
            }
        });
        getContentPane().add(txt_idModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 85, -1));

        jLabel_idBloque.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_idBloque.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_idBloque.setText("ID Bloque");
        getContentPane().add(jLabel_idBloque, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        txt_idBloque.setBackground(new java.awt.Color(92, 124, 203));
        txt_idBloque.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_idBloque.setForeground(new java.awt.Color(255, 255, 255));
        txt_idBloque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idBloque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_idBloque, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 85, -1));

        jLabel_costoMateriales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_costoMateriales.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_costoMateriales.setText("Costo de materiales:");
        getContentPane().add(jLabel_costoMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        txt_costoMateriales.setBackground(new java.awt.Color(92, 124, 203));
        txt_costoMateriales.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_costoMateriales.setForeground(new java.awt.Color(255, 255, 255));
        txt_costoMateriales.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_costoMateriales.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_costoMateriales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_costoMaterialesKeyTyped(evt);
            }
        });
        getContentPane().add(txt_costoMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 85, -1));

        jLabel_costosExtras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_costosExtras.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_costosExtras.setText("Costos extras:");
        getContentPane().add(jLabel_costosExtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        txt_costosExtras.setBackground(new java.awt.Color(92, 124, 203));
        txt_costosExtras.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_costosExtras.setForeground(new java.awt.Color(255, 255, 255));
        txt_costosExtras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_costosExtras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_costosExtras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_costosExtrasKeyTyped(evt);
            }
        });
        getContentPane().add(txt_costosExtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 85, -1));

        jLabel_informacionAdicional.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_informacionAdicional.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_informacionAdicional.setText("Información adicional:");
        getContentPane().add(jLabel_informacionAdicional, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        jTextArea_informacionAdicional.setColumns(20);
        jTextArea_informacionAdicional.setRows(5);
        jScrollPane1.setViewportView(jTextArea_informacionAdicional);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 260, 80));

        jButton_registrarModulo.setBackground(new java.awt.Color(64, 97, 164));
        jButton_registrarModulo.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_registrarModulo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrarModulo.setText("Registrar");
        jButton_registrarModulo.setBorder(null);
        jButton_registrarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarModuloActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 150, 25));
        getContentPane().add(jLabel_registrarModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarModuloActionPerformed
        int validacion = 0;
        String nombre_modulo, id_modulo, id_bloque, costo_materiales, costos_extras, informacion_adicional; 
        
        //Para recuperar la información escrita:
        nombre_modulo = txt_nombre.getText().trim();
        id_modulo = txt_idModulo.getText().trim();
        id_bloque = txt_idBloque.getText().trim();
        costo_materiales = txt_costoMateriales.getText().trim();
        costos_extras = txt_costosExtras.getText().trim();
        informacion_adicional = jTextArea_informacionAdicional.getText();
        
        //Validar que los campos no estén vacios:
        if(nombre_modulo.equals("")){  //"" es un espacio en blanco.
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        if(id_modulo.equals("")){  //"" es un espacio en blanco.
            txt_idModulo.setBackground(Color.red);
            validacion++;
        }
        if(id_bloque.equals("")){ 
            txt_idBloque.setBackground(Color.red);
            validacion++;
        }
        if(costo_materiales.equals("")){
            txt_costoMateriales.setBackground(Color.red);
            validacion++;
        }
        if(costos_extras.equals("")){
            txt_costosExtras.setBackground(Color.red);
            validacion++;
        }   
        
        if (validacion == 0) {  //Si validacion = 0, significa que todos los campos están completos, 
                                //si es distinto de cero, alguno de los campos esta vacío. 
            
            float costo_mat = Float.parseFloat(costo_materiales);
            float costos_ext = Float.parseFloat(costos_extras);
            
            try {
                
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into modulo values (?,?,?,?,?,?)");    //Se usan "?" porque todavía no se conocen.
                //Éstos son los 6 valores que quiero insertar en la base de datos.
                pst.setInt(1, Integer.parseInt(id_modulo));         
                pst.setString(2, id_bloque);
                pst.setString(3, nombre_modulo);
                pst.setFloat(4, costo_mat);
                pst.setFloat(5, costos_ext);
                pst.setString(6, informacion_adicional);
                
                pst.executeUpdate();    //Indica que se tiene que ejecutar toda la acción anterior.
                cn.close();     //Cierra la conexión a la base de datos.
                
                Limpiar();  //Función escrita debajo.
                
                txt_nombre.setBackground(Color.green);
                txt_idModulo.setBackground(Color.green);
                txt_idBloque.setBackground(Color.green);
                txt_costoMateriales.setBackground(Color.green);
                txt_costosExtras.setBackground(Color.green);
                
                JOptionPane.showMessageDialog(null, "Registro exitoso.");
                this.dispose();
                
                //Agrego el nuevo dato a la tabla:
                Object[] fila = new Object[5];  //de tipo Object porque tengo datos de diferentes tipos.
                fila[0] = Integer.parseInt(id_modulo);
                fila[1] = nombre_modulo;
                fila[2] = id_bloque;
                fila[3] = Float.parseFloat(costo_materiales);
                fila[4] = Float.parseFloat(costos_extras);
                gestionarModulos.model.addRow(fila);
                
            } catch (SQLException e) {
                System.out.println("Error en registrar módulo." + e);
                JOptionPane.showMessageDialog(null, "Error al registrar módulo.");
            }            
        } 
        
        if (validacion != 0){
            JOptionPane.showMessageDialog(null, "Se deben completar todos los campos.");
        }
        
    }//GEN-LAST:event_jButton_registrarModuloActionPerformed

    private void txt_idModuloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idModuloKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.        
    }//GEN-LAST:event_txt_idModuloKeyTyped

    private void txt_costoMaterialesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costoMaterialesKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_costoMaterialesKeyTyped

    private void txt_costosExtrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costosExtrasKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();       //Solo se permite escribir numeros.
    }//GEN-LAST:event_txt_costosExtrasKeyTyped

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
            java.util.logging.Logger.getLogger(RegistrarModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarModulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_registrarModulo;
    private javax.swing.JLabel jLabel_DatosDelModulo;
    private javax.swing.JLabel jLabel_costoMateriales;
    private javax.swing.JLabel jLabel_costosExtras;
    private javax.swing.JLabel jLabel_idBloque;
    private javax.swing.JLabel jLabel_idModulo;
    private javax.swing.JLabel jLabel_informacionAdicional;
    private javax.swing.JLabel jLabel_nombre;
    private javax.swing.JLabel jLabel_registrarModulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_informacionAdicional;
    private javax.swing.JTextField txt_costoMateriales;
    private javax.swing.JTextField txt_costosExtras;
    private javax.swing.JTextField txt_idBloque;
    private javax.swing.JTextField txt_idModulo;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    public void Limpiar(){
        txt_nombre.setText("");
        txt_idModulo.setText("");
        txt_idBloque.setText("");
        txt_costoMateriales.setText("");
        txt_costosExtras.setText("");
    }

}
