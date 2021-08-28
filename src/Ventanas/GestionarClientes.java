package Ventanas;

import java.sql.*;
import Clases.Conexion;
import com.itextpdf.text.BadElementException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.PageSize;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class GestionarClientes extends javax.swing.JFrame {

    public static int idCliente = 0;    //variable que nos permite enviar datos entre ventanas. 
                                       //idCliente es para guardar el id del cliente sobre el que se hace clic y luego enviarlo a otra ventana.
    int fila_clic;  //Para usar al hacer clic sobre una fila de la tabla.
     
    DefaultTableModel model = new DefaultTableModel(){  //Nos va a permitir generar el clic en la tabla y establecer una conexión o interacción con los datos que se muestren dentro de la tabla.
        @Override
        public boolean isCellEditable(int filas, int columnas){
            return false;   //para que no se puedan editar las celdas de la tabla.
            }
        };
    
    /**
     * Creates new form GestionarClientes
     */
    
    public GestionarClientes() {
        initComponents();
        setTitle("Gestionar clientes");
        setSize(780, 360);  //Para indicar el tamaño de la ventana
        setResizable(false);     //Evita que el usuario pueda modificar el tamaño de la ventana
        setLocationRelativeTo(null);    //Para que la ventana aparezca centrada
   
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //Para poner la imagen de fondo en la ventana
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_gestionarClientes.getWidth(), 
                jLabel_gestionarClientes.getHeight(), Image.SCALE_DEFAULT));    //Para adaptar la imagen a la ventana
        jLabel_gestionarClientes.setIcon(icono);   //Se indica que esa imagen que estamos escalando se tiene que ubicar dentro del jLabel_gestionarClientes       
        
        this.repaint(); //Línea opcional, para asegurarse de que se apliquen los cambios
        
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
        
        //Para colocar imagen en el botón de generar reporte.
        ImageIcon icono_pdf = new ImageIcon("src/imagenes/pdf.png");
        jButton_generarReporte.setIcon(icono_pdf);
                  
        jTable_clientes = new JTable(model); //Conexión con la tabla ya creada.
        jScrollPane1.setViewportView(jTable_clientes);  //Ésta tabla esta dentro de jScrollPanel (se ve en la interfaz grafica)
            
        //Columnas de la tabla:
        model.addColumn("ID");  //Es necesario mostrar el ID porque después lo necesito en el método mouseClicked para moverme a "InformacionCliente"
        model.addColumn("Nombre");
        model.addColumn("DNI");
        model.addColumn("Teléfono");
        model.addColumn("Dirección");
        model.addColumn("Correo");
        
        mostrar_tabla();    //Definido al final del archivo, para armar la tabla de clientes.
        
        //------------------------------
        //Centrado y tamaños de las columnas de la tabla.
        
        //Para centrar el nombre de las columnas:
        ((DefaultTableCellRenderer)jTable_clientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        //Para centrar el contenido de las columnas:
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);      //En lugar de center se puede poner otras opciones.
        for(int i=0; i<6; i++){
            jTable_clientes.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        //jTable_viviendas.getColumnModel().getColumn(0).setCellRenderer(tcr);  //Si quiero centrar una por una, en getColumn() va el número de la columna.

        //Para definir el tamaño de cada columna:
        TableColumnModel columnModel = jTable_clientes.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(70);
        columnModel.getColumn(4).setPreferredWidth(80);
        columnModel.getColumn(5).setPreferredWidth(150);        
        //------------------------------

        //Evento que permite "escuchar" los clic que el usuario hace sobre la tabla, para luego obtener los datos del cliente que necesitamos
        //y abrir la interfaz "InformacionCliente".
        jTable_clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                fila_clic = jTable_clientes.rowAtPoint(e.getPoint());  //Se guarda el punto donde se hizo clic dentro de la variable fila_clic.
                int columna_clic = 0;  //La columna 0 porque nos interesa obtener el id del cliente y éste se ubica en la columna 0. Con el id después conseguimos el resto de datos.
                
                if(fila_clic > -1){    //Cuando el usuario haga clic en cualquier fila mayor a -1, que se ejecute todo (podría ser otra condición).
                    idCliente = (int)model.getValueAt(fila_clic, columna_clic);   
                    InformacionCliente informacionCliente = new InformacionCliente(idCliente, GestionarClientes.this);  
                    //Se envía idCliente y GestionarClientes para usar el constructor correspondiente de cuando venímos de esta pantalla. Sino se usa otro constructor solo con idCliente.
                    informacionCliente.setVisible(true);  
                }              
            }        
        });
    
        //Para poder ordenar la tabla según las columnas:
        TableRowSorter<TableModel> jTable_modulos = new TableRowSorter<TableModel>(model);
        this.jTable_clientes.setRowSorter(jTable_modulos);
        
    } //Fin del constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_textoClientesRegistrados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_clientes = new javax.swing.JTable();
        jButton_generarReporte = new javax.swing.JButton();
        txt_filtro = new javax.swing.JTextField();
        jLabel_filtro = new javax.swing.JLabel();
        jLabel_gestionarClientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_textoClientesRegistrados.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_textoClientesRegistrados.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_textoClientesRegistrados.setText("Clientes registrados");
        getContentPane().add(jLabel_textoClientesRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        jTable_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 720, 160));

        jButton_generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_generarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 70, 70));

        txt_filtro.setBackground(new java.awt.Color(64, 97, 164));
        txt_filtro.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        txt_filtro.setForeground(new java.awt.Color(255, 255, 255));
        txt_filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_filtroActionPerformed(evt);
            }
        });
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtroKeyTyped(evt);
            }
        });
        getContentPane().add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 150, -1));

        jLabel_filtro.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jLabel_filtro.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_filtro.setText("Filtrar por nombre:");
        getContentPane().add(jLabel_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, -1, -1));
        getContentPane().add(jLabel_gestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generarReporteActionPerformed
        
        Document documento = new Document(); //Creo un objeto de la clase "Document", que luego nos permitirá generar el pdf

        //Para generar un archivo es necesario usar una estructura try-catch:
        try {
            String ruta = System.getProperty("user.home");  //Ruta donde se generará el pdf.
            //user.home es para obtener el nombre de usuario o ruta del usuario que esta usando el programa, porque no se sabe en que computadora se va a usar y cada una tiene su nombre de usuario.

            //Ahora genero el pdf en la ruta que quiero y le asigno el nombre.
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + "Clientes.pdf"));

            //Acá se usa una librería sin el "import" para solucionar lo que indique arriba junto a los import de librerías.
            com.itextpdf.text.Image banner = com.itextpdf.text.Image.getInstance("src/imagenes/portadaPDF.png");
            banner.scaleToFit(650, 1000);   //650 es para el tamaño de la imagen y 1000 es la escala de visualización.
            banner.setAlignment(Chunk.ALIGN_CENTER);    //Para ubicar la imagen en el centro.

            //Con el objeto del tipo "Paragraph" se le da formato al texto que queremos mostrar.
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK)); //Fuente, tamaño, texto en negrita, color del texto.
            parrafo.add("\n \n CLIENTES REGISTRADOS \n \n");  //Con el método "add" podemos ir agregando cualquier texto dentro del pdf.
            
            documento.open();   //Abro el documento.
            documento.add(banner);  //agrego el banner arriba.
            documento.add(parrafo); //"parrafo" es el objeto que cree anteriormente con el texto.

            //Propiedades de la tabla clientes:
            PdfPTable tablaClientes = new PdfPTable(5);
            tablaClientes.setWidthPercentage(100); //Porcentaje a la tabla (tamaño ancho).
            tablaClientes.setWidths(new float[] {23, 11, 14, 20, 30}); //Ancho de cada columna. 
            tablaClientes.addCell("Nombre");
            tablaClientes.addCell("DNI");
            tablaClientes.addCell("Teléfono");
            tablaClientes.addCell("Dirección");
            tablaClientes.addCell("Correo");

            try {
                //Conexión con la base de datos.
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                    "select nombre_cliente, dni_cliente, telefono_cliente, direccion_cliente, correo_cliente from cliente");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tablaClientes.addCell(rs.getString(1));
                        tablaClientes.addCell(rs.getString(2));
                        tablaClientes.addCell(rs.getString(3));
                        tablaClientes.addCell(rs.getString(4));
                        tablaClientes.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tablaClientes);
                } 

            } catch (SQLException e) {
                System.err.print("Error al obtener datos del clientes. " + e);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen" + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");
        }
    }//GEN-LAST:event_jButton_generarReporteActionPerformed

    TableRowSorter trs; //Para usar en el filtro por nombre.
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
        jTable_clientes.setRowSorter(trs);
    }//GEN-LAST:event_txt_filtroKeyTyped

    private void txt_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_filtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtroActionPerformed

    private void jTable_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_clientesMouseClicked
        int seleccion = jTable_clientes.rowAtPoint(evt.getPoint()); //fila
        idCliente = (int) jTable_clientes.getValueAt(seleccion, 0); //fila y columna del id
        InformacionCliente informacionCliente = new InformacionCliente(idCliente, GestionarClientes.this);  //Abro la ventana "InformacionCliente" con el cliente cuyo "ID" sea el que le hice clic.
        informacionCliente.setVisible(true);
    }//GEN-LAST:event_jTable_clientesMouseClicked

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
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_generarReporte;
    private javax.swing.JLabel jLabel_filtro;
    private javax.swing.JLabel jLabel_gestionarClientes;
    private javax.swing.JLabel jLabel_textoClientesRegistrados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_clientes;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables

public void mostrar_tabla(){
    //Para armar la tabla de clientes:
    try {
        Connection cn = Conexion.conectar();
            
        PreparedStatement pst = cn.prepareStatement(
             "select id_cliente, nombre_cliente, dni_cliente, telefono_cliente, direccion_cliente, correo_cliente from cliente");
        ResultSet rs = pst.executeQuery();
            
        //Estructura repetitiva que nos permite colocar los datos que vienen de la base de datos dentro de la tabla:
        //El while para las filas y el for para las columnas.
        while (rs.next()) {     //Mientras existan registros, se ejecuta el while.
            Object[] fila = new Object[6];  //Vector de tipo Object porque hay datos de distinto tipo.
            for (int i = 0; i < 6; i++) {
                fila[i] = rs.getObject(i + 1);  //i + 1 porque comienza en 0, si lo hago comenzar en 1, sería solo i.
            }
                model.addRow(fila); //Agregar la fila.
        }
            
        cn.close();
            
    } catch (SQLException e) {
        System.err.println("Error en el llenado de la tabla.");
    }
}

}


