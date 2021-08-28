package Ventanas;

import Clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Calgaro Alejandro
 */

public class InformacionModulo extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel(); //Nos va a permitir generar el clic en la tabla y establecer una conexión con los datos que se muestren dentro de la tabla.
    int idModulo = 0;
    private GestionarModulos gestionarModulos;
    
    /**
     * Creates new form InformacionModulo
     */
    
    public InformacionModulo(GestionarModulos gestionarModulos) {
        idModulo = GestionarModulos.idModulo;
        this.gestionarModulos = gestionarModulos;   //Lo uso para actualizar la tabla cuando se cierra esta pantalla luego de eliminar o actualizar.
        
        initComponents();
        setTitle("Información del módulo");
        setSize(370, 560);  //Para indicar el tamaño de la ventana
        setResizable(false);     //Evita que el usuario pueda modificar el tamaño de la ventana
        setLocationRelativeTo(null);    //Para que la ventana aparezca centrada
   
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //Para poner la imagen de fondo en la ventana
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_informacionModulo.getWidth(), 
                jLabel_informacionModulo.getHeight(), Image.SCALE_DEFAULT));    //Para adaptar la imagen a la ventana
        jLabel_informacionModulo.setIcon(icono);   //Se indica que esa imagen que estamos escalando se tiene que ubicar dentro del jLabel_gestionarModulos       
        
        this.repaint(); //Línea opcional, para asegurarse de que se apliquen los cambios
        
        //Para colocar el icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
        
        //Para conectarnos a la base de datos y obtener los datos del modulo que se seleccione en "GestionarModulo"
        //y para completar los campos de texto de "InformacionModulo" con esos datos obtenidos.
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select nombre_modulo, id_bloque, costo_materiales, costos_extras, informacion_adicional from modulo where id_modulo = '" + idModulo + "'");
            ResultSet rs = pst.executeQuery(); 
            
            if(rs.next()){  //Si se encontro, se hace lo siguiente:
                txt_nombreModulo.setText(rs.getString("nombre_modulo"));
                txt_idModulo.setText(Integer.toString(idModulo));
                txt_idBloque.setText(rs.getString("id_bloque"));
                txt_costoMateriales.setText(rs.getString("costo_materiales"));
                txt_costosExtras.setText(rs.getString("costos_extras"));
                jTextArea_informacionAdicional.setText(rs.getString("informacion_adicional"));
            }
            cn.close();   //Cierro la conexión.
            
        } catch (SQLException e) {
            System.err.println("Error en cargar modulo." + e); //Sirve para inviarle un mensaje al programador para saber en que parte del código ocurrió el error. 
            JOptionPane.showMessageDialog(null, "Error al cargar información");  //Sirve para decirle al usuario que hubo un error.
        
        }   //Termina el try-catch del llenado de los datos del modulo en los campos de texto de "InformacionModulo".
    }

    private InformacionModulo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_DatosDelModulo = new javax.swing.JLabel();
        jLabel_nombreModulo = new javax.swing.JLabel();
        txt_nombreModulo = new javax.swing.JTextField();
        jLabel_costoMateriales = new javax.swing.JLabel();
        txt_costoMateriales = new javax.swing.JTextField();
        jLabel_costosExtras = new javax.swing.JLabel();
        txt_costosExtras = new javax.swing.JTextField();
        jLabel_idModulo = new javax.swing.JLabel();
        txt_idModulo = new javax.swing.JTextField();
        jLabel_idBloque = new javax.swing.JLabel();
        txt_idBloque = new javax.swing.JTextField();
        jLabel_informacionAdicional = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_informacionAdicional = new javax.swing.JTextArea();
        jButton_eliminarModulo = new javax.swing.JButton();
        jButton_actualizarModulo = new javax.swing.JButton();
        jLabel_informacionModulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_DatosDelModulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_DatosDelModulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DatosDelModulo.setText("Información del módulo");
        getContentPane().add(jLabel_DatosDelModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel_nombreModulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombreModulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombreModulo.setText("Nombre:");
        getContentPane().add(jLabel_nombreModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        txt_nombreModulo.setBackground(new java.awt.Color(92, 124, 203));
        txt_nombreModulo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombreModulo.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombreModulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombreModulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombreModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 210, -1));

        jLabel_costoMateriales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_costoMateriales.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_costoMateriales.setText("Costo de materiales:");
        getContentPane().add(jLabel_costoMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        txt_costoMateriales.setBackground(new java.awt.Color(92, 124, 203));
        txt_costoMateriales.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
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
        txt_costosExtras.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_costosExtras.setForeground(new java.awt.Color(255, 255, 255));
        txt_costosExtras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_costosExtras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_costosExtras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_costosExtrasKeyTyped(evt);
            }
        });
        getContentPane().add(txt_costosExtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 85, -1));

        jLabel_idModulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_idModulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_idModulo.setText("ID módulo");
        getContentPane().add(jLabel_idModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        txt_idModulo.setBackground(new java.awt.Color(92, 124, 203));
        txt_idModulo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
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
        txt_idBloque.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_idBloque.setForeground(new java.awt.Color(255, 255, 255));
        txt_idBloque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idBloque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_idBloque, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 85, -1));

        jLabel_informacionAdicional.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_informacionAdicional.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_informacionAdicional.setText("Información adicional:");
        getContentPane().add(jLabel_informacionAdicional, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        jTextArea_informacionAdicional.setColumns(20);
        jTextArea_informacionAdicional.setRows(5);
        jScrollPane1.setViewportView(jTextArea_informacionAdicional);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 260, 80));

        jButton_eliminarModulo.setBackground(new java.awt.Color(64, 97, 164));
        jButton_eliminarModulo.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_eliminarModulo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminarModulo.setText("Eliminar");
        jButton_eliminarModulo.setBorder(null);
        jButton_eliminarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarModuloActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminarModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 150, 25));

        jButton_actualizarModulo.setBackground(new java.awt.Color(64, 97, 164));
        jButton_actualizarModulo.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_actualizarModulo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizarModulo.setText("Actualizar");
        jButton_actualizarModulo.setBorder(null);
        jButton_actualizarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarModuloActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizarModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 150, 25));
        getContentPane().add(jLabel_informacionModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_eliminarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarModuloActionPerformed
    int opcion = JOptionPane.showConfirmDialog(this, //this sería unComponentePadre (new InformacionModulo())
        "¿Desea confirmar la eliminación?", "Confirmación de eliminación",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);   //el null es para icono por defecto
    // 0=ok, 2=cancel
        
    if(opcion == 0){
        try {
            Connection cn = Conexion.conectar();
            
            //Primero debo eliminar ese módulo de las viviendas en las que fue utilizado y luego elimino el módulo en sí.
            
            PreparedStatement pst = cn.prepareStatement(   //Elimino los módulo_vivienda correspondientes al módulo a eliminar.
                "delete from modulo_vivienda where id_modulo = '" + idModulo + "'");            
            pst.executeUpdate();
            
            PreparedStatement pst1 = cn.prepareStatement(   //Elimino el módulo.
                "delete from modulo where id_modulo = '" + idModulo + "'");              
            pst1.executeUpdate();
            
            cn.close();
            
            //Envío un mensaje al usuario para avisar que se eliminó de forma correcta.
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente.");
            this.dispose(); //Para que la ventana "InformaciónCliente" se cierre automáticamente cuando el usuario da click en "aceptar" del mensaje que le enviamos recién.
            
            gestionarModulos.model.removeRow(gestionarModulos.fila_clic);   //Elimino la fila correspondiente en la tabla de la ventana "GestionarModulos".
                
            } catch (SQLException e) {
                System.err.println("Error al eliminar modulo" + e);  //Éste sirve para indicarle al programador donde esta el error en el código.
                JOptionPane.showInternalMessageDialog(null, "Error al eliminar modulo"); //Éste sirve para avisarle al usuario que ocurrió un error.
            }   
        }
    }//GEN-LAST:event_jButton_eliminarModuloActionPerformed

    private void jButton_actualizarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarModuloActionPerformed
        int validacion = 0; //Ésta variable me sirve para identificar que campos están vacios y completos de manera correcta.
        String nombre_modulo, id_modulo, id_bloque, costo_materiales, costos_extras, informacion_adicional;
        
        //Guardo en las variables lo que hay en los campos de texto de la ventana.
        //con .getText() se obtiene el texto del campo de texto y con .trim() se eliminan espacios de inicio y final.
        nombre_modulo = txt_nombreModulo.getText().trim();
        id_modulo = txt_idModulo.getText().trim();
        id_bloque = txt_idBloque.getText().trim();
        costo_materiales = txt_costoMateriales.getText().trim();
        costos_extras = txt_costosExtras.getText().trim();
        informacion_adicional = jTextArea_informacionAdicional.getText();
        
        //Ahora empiezo a ver si tengo campos vacios comparando cada variable con "".
        if(nombre_modulo.equals("")){
            txt_nombreModulo.setBackground(Color.red); //Para que el cuadro de texto se ponga rojo si esta incompleto.
            validacion++;
        }   
        if(id_modulo.equals("")){
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
        
        if (validacion == 0) {  //Si validacion = 0 significa que todos los campos están completos y puedo usar esos valores para la base de datos.
            
            float costo_mat = Float.parseFloat(costo_materiales);
            float costos_ext = Float.parseFloat(costos_extras);
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(    //Se usan "?" porque todavía no sabemos el valor.
                    "update modulo set id_modulo=?, nombre_modulo=?, id_bloque=?, costo_materiales=?, costos_extras=?, informacion_adicional=? "
                    + "where id_modulo = '" + idModulo + "'"); //Tener cuidado con las comillas simples '
                               
                //Mandamos ésta información a la base de datos:
                pst.setInt(1, Integer.parseInt(id_modulo));
                pst.setString(2, nombre_modulo);
                pst.setString(3, id_bloque);
                pst.setFloat(4, costo_mat);
                pst.setFloat(5, costos_ext);
                pst.setString(6, informacion_adicional);
                
                //Ejecutamos todo lo anterior:
                pst.executeUpdate();
                cn.close();
                
                Limpiar();  //Método para limpiar los campos. Programado abajo.
                
                //Pinto los campos de color verde si todo salió bien.
                txt_nombreModulo.setBackground(Color.green);
                txt_idModulo.setBackground(Color.green);
                txt_idBloque.setBackground(Color.green);
                txt_costoMateriales.setBackground(Color.green);
                txt_costosExtras.setBackground(Color.green);
                
                //Envío un mensaje al usuario para avisar que se actualizó de forma correcta.
                JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente.");
                this.dispose(); //Para que la ventana "InformaciónModulo" se cierre automáticamente cuando el usuario da click en "aceptar" del mensaje que le enviamos recién.
                
                //Actualizo los datos de la fila correspondiente en la ventana "GestionarModulos".
                gestionarModulos.model.setValueAt(Integer.parseInt(id_modulo), gestionarModulos.fila_clic, 0);
                gestionarModulos.model.setValueAt(nombre_modulo, gestionarModulos.fila_clic, 1);
                gestionarModulos.model.setValueAt(id_bloque, gestionarModulos.fila_clic, 2);
                gestionarModulos.model.setValueAt(Float.parseFloat(costo_materiales), gestionarModulos.fila_clic, 3);
                gestionarModulos.model.setValueAt(Float.parseFloat(costos_extras), gestionarModulos.fila_clic, 4);
            
            } catch (SQLException e) {
                System.err.println("Error en actualizar modulo" + e);  //Éste sirve para indicarle al programador donde esta el error en el código.
                JOptionPane.showInternalMessageDialog(null, "Error al actualizar modulo"); //Éste sirve para avisarle al usuario que ocurrió un error.
            }   
            
        } else {
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos");
        }
    }//GEN-LAST:event_jButton_actualizarModuloActionPerformed

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

    //Si quiero hacer algo cuando cierre esta pantalla con la cruz roja.
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
            java.util.logging.Logger.getLogger(InformacionModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionModulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizarModulo;
    private javax.swing.JButton jButton_eliminarModulo;
    private javax.swing.JLabel jLabel_DatosDelModulo;
    private javax.swing.JLabel jLabel_costoMateriales;
    private javax.swing.JLabel jLabel_costosExtras;
    private javax.swing.JLabel jLabel_idBloque;
    private javax.swing.JLabel jLabel_idModulo;
    private javax.swing.JLabel jLabel_informacionAdicional;
    private javax.swing.JLabel jLabel_informacionModulo;
    private javax.swing.JLabel jLabel_nombreModulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_informacionAdicional;
    private javax.swing.JTextField txt_costoMateriales;
    private javax.swing.JTextField txt_costosExtras;
    private javax.swing.JTextField txt_idBloque;
    private javax.swing.JTextField txt_idModulo;
    private javax.swing.JTextField txt_nombreModulo;
    // End of variables declaration//GEN-END:variables

    public void Limpiar(){
        txt_nombreModulo.setText("");
        txt_idModulo.setText("");
        txt_idBloque.setText("");
        txt_costoMateriales.setText("");
        txt_costosExtras.setText("");
    }
    
}
