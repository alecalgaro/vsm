package Ventanas;

import Clases.Conexion;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Calgaro Alejandro
 */

public class GestionarModulos extends javax.swing.JFrame {

    public static int idModulo = 0; //idModulo es para indicarle al programa cual es el modulo que queremos consultar al dar click en uno de los registros.
    int fila_clic;  //Para usar al hacer clic sobre una fila de la tabla.
     
    DefaultTableModel model = new DefaultTableModel(){  //Nos va a permitir generar el click en la tabla y establecer una conexión con los datos que se muestren dentro de la tabla.
        @Override
        public boolean isCellEditable(int filas, int columnas){
            return false;   //para que no se puedan editar las celdas de la tabla.
            }
        }; 
    
    /**
     * Creates new form GestionarModulos
     */
    
    public GestionarModulos() {
        initComponents();
        setTitle("Gestionar módulos");
        setSize(680, 370);  //Para indicar el tamaño de la ventana
        setResizable(false);     //Evita que el usuario pueda modificar el tamaño de la ventana
        setLocationRelativeTo(null);    //Para que la ventana aparezca centrada
   
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //Para poner la imagen de fondo en la ventana
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_gestionarModulos.getWidth(), 
                jLabel_gestionarModulos.getHeight(), Image.SCALE_DEFAULT));    //Para adaptar la imagen a la ventana
        jLabel_gestionarModulos.setIcon(icono);   //Se indica que esa imagen que estamos escalando se tiene que ubicar dentro del jLabel_gestionarClientes       
        
        this.repaint(); //Línea opcional, para asegurarse de que se apliquen los cambios
        
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
          
        jTable_modulos = new JTable(model); //Conexión con la tabla ya creada.
        jScrollPane1.setViewportView(jTable_modulos);  //Ésta tabla esta dentro de jScrollPanel
            
        //Columnas de la tabla:
        model.addColumn("ID");  
        model.addColumn("Nombre");
        model.addColumn("ID bloque");
        model.addColumn("Costos materiales");
        model.addColumn("Costos extras");

        mostrar_tabla();  //Completa los datos en la tabla (programado al final).
        
        //------------------------------
        //Centrado y tamaños de las columnas de la tabla.
        
        //Para centrar el nombre de las columnas:
        ((DefaultTableCellRenderer)jTable_modulos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        //Para centrar el contenido de las columnas:
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);      //En lugar de center se puede poner otras opciones.
        for(int i=0; i<5; i++){
            jTable_modulos.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        //jTable_viviendas.getColumnModel().getColumn(0).setCellRenderer(tcr);  //Si quiero centrar una por una, en getColumn() va el número de la columna.

        //Para definir el tamaño de cada columna:
        TableColumnModel columnModel = jTable_modulos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(80);
        columnModel.getColumn(4).setPreferredWidth(70);        
        //------------------------------
        
        //Evento que permite "escuchar" los clic que el usuario hace sobre la tabla, para luego obtener los datos del cliente que necesitamos
        //y abrir la interfaz "InformacionModulo".
        jTable_modulos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                fila_clic = jTable_modulos.rowAtPoint(e.getPoint());  //Se guarda el punto donde se esta haciendo click dentro de la variable fila_clic.
                int columna_clic = 0;  //La columna 0 porque nos interesa obtener el id del modulo y éste se ubica en la columna 0. Con el id después conseguimos el resto de datos.
                
                if(fila_clic > -1){    //Cuando el usuario haga click en cualquier fila mayor a -1, que se ejecute todo (podría ser otra condición).
                    idModulo = (int)model.getValueAt(fila_clic, columna_clic);   
                    InformacionModulo informacionModulo = new InformacionModulo(GestionarModulos.this);  //Abro la ventana "InformacionModulo" con el módulo cuyo "ID" sea el que le hice clic.
                    informacionModulo.setVisible(true);  
                }                    
            }           
        });      
        
        //Para poder ordenar la tabla según las columnas:
        TableRowSorter<TableModel> jTable_modulos = new TableRowSorter<TableModel>(model);
        this.jTable_modulos.setRowSorter(jTable_modulos);
            
    }   //FIN DEL CONSTRUCTOR.

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_textoClientesRegistrados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_modulos = new javax.swing.JTable();
        jButton_registrarModulo = new javax.swing.JButton();
        jLabel_filtro = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        jLabel_gestionarModulos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_textoClientesRegistrados.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_textoClientesRegistrados.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_textoClientesRegistrados.setText("Módulos registrados");
        getContentPane().add(jLabel_textoClientesRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jTable_modulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_modulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_modulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_modulos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 580, 190));

        jButton_registrarModulo.setBackground(new java.awt.Color(64, 97, 164));
        jButton_registrarModulo.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_registrarModulo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrarModulo.setText("Registrar módulo");
        jButton_registrarModulo.setBorder(null);
        jButton_registrarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarModuloActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 150, 25));

        jLabel_filtro.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jLabel_filtro.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_filtro.setText("Filtrar por nombre:");
        getContentPane().add(jLabel_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, -1));

        txt_filtro.setBackground(new java.awt.Color(92, 124, 203));
        txt_filtro.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        txt_filtro.setForeground(new java.awt.Color(255, 255, 255));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtroKeyTyped(evt);
            }
        });
        getContentPane().add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 150, -1));
        getContentPane().add(jLabel_gestionarModulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarModuloActionPerformed
        RegistrarModulo registrarModulo = new RegistrarModulo(this);
        registrarModulo.setVisible(true);
    }//GEN-LAST:event_jButton_registrarModuloActionPerformed
    
    TableRowSorter trs = null; //Para usar en el filtro por nombre.
    //Se le pone la propiedad "KeyTyped" al cuadro de texto para que reconozca cuando se escribe.
    private void txt_filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyTyped
         
        txt_filtro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                //"(?i)" es para que no se "case sensitive", es decir, que no reconozca entre mayúsculas y minúsculas.
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txt_filtro.getText(), 1));  //El 1 es para filtrar en la columna de nombres, en esta función comienzan en 0.
            }
        });  
        trs = new TableRowSorter(model);    //"model" es el DefaultTableModel de arriba
        jTable_modulos.setRowSorter(trs);
    }//GEN-LAST:event_txt_filtroKeyTyped

    //Al hacer clic en un módulo, abro la ventana con la información de dicho módulo.
    private void jTable_modulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_modulosMouseClicked
        int seleccion = jTable_modulos.rowAtPoint(evt.getPoint());
        idModulo = (int) jTable_modulos.getValueAt(seleccion, 0);
        InformacionModulo informacionModulo = new InformacionModulo(GestionarModulos.this);  //Abro la ventana "InformacionModulo" con el módulo cuyo "ID" sea el que le hice clic.
        informacionModulo.setVisible(true);
    }//GEN-LAST:event_jTable_modulosMouseClicked

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
            java.util.logging.Logger.getLogger(GestionarModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarModulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_registrarModulo;
    private javax.swing.JLabel jLabel_filtro;
    private javax.swing.JLabel jLabel_gestionarModulos;
    private javax.swing.JLabel jLabel_textoClientesRegistrados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_modulos;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables

     public void mostrar_tabla(){
    //Para armar la tabla de módulos:
        try {
            Connection cn = Conexion.conectar();
            
            PreparedStatement pst = cn.prepareStatement(
                    "select id_modulo, nombre_modulo, id_bloque, costo_materiales, costos_extras from modulo");          
            ResultSet rs = pst.executeQuery();
            
            //jTable_modulos = new JTable(model); //Conexión con la tabla ya creada.
            //jScrollPane1.setViewportView(jTable_modulos);  //Ésta tabla esta dentro de jScrollPanel 

            //Estructura repetitiva que nos permite colocar los datos que vienen de la base de datos dentro de la tabla:
            while (rs.next()) {     //Mientras existan registros, se ejecuta el while.
                Object[] fila = new Object[5];  //Vector de tipo Object porque tengo datos de diferentes tipos.
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);  //i + 1 porque comienza en 0, si lo hago comenzar en 1, sería solo i.
                }
                model.addRow(fila); //Agregar la fila.
            }
            
            cn.close(); //Cierro la conexión.
            
        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla.");
        }
    }
 
}
