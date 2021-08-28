package Ventanas;

import Clases.Conexion;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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

public class GestionarViviendas extends javax.swing.JFrame {
    
    //idVivienda es para indicarle al programa cual es la vivienda que queremos consultar al dar clic en uno de los registros.
    public static int idVivienda = 0; 
    int fila_clic;  //Para usar al hacer clic sobre una fila de la tabla.
     
    DefaultTableModel model = new DefaultTableModel(){  //Nos va a permitir generar el click en la tabla y establecer una conexión con los datos que se muestren dentro de la tabla.
        @Override
        public boolean isCellEditable(int filas, int columnas){
            return false;   //para que no se puedan editar las celdas de la tabla.
            }
        };
    /**
     * Creates new form GestionarViviendas
     */
    
    public GestionarViviendas() {
        initComponents();
        setSize(1090, 390);
        setTitle("Gestionar viviendas");
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_viviendas.getWidth(),
                jLabel_viviendas.getHeight(), Image.SCALE_DEFAULT));
        jLabel_viviendas.setIcon(icono);
        this.repaint();
        
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
        
        //Para colocar imagen en el botón de generar reporte.
        ImageIcon icono_pdf = new ImageIcon("src/imagenes/pdf.png");
        jButton_generarReporte.setIcon(icono_pdf);
        
        //------------------------------
        jTable_viviendas = new JTable(model); //Conexión con la tabla ya creada.
        jScrollPane1.setViewportView(jTable_viviendas);  //Ésta tabla esta dentro de jScrollPanel
            
        //Columnas de la tabla:
        model.addColumn("ID");  //Es necesario mostrar el ID porque después lo necesito en el método mouseClicked para moverme a "InformacionVivienda"
        model.addColumn("Orient");
        model.addColumn("Largo");
        model.addColumn("Ancho");
        model.addColumn("Cubierta");
        model.addColumn("Piso");
        model.addColumn("Terminacion");
        model.addColumn("Local");
        model.addColumn("Sala estar");
        model.addColumn("Comedor");       
        model.addColumn("Baño,lav,coc");
        model.addColumn("Hab matri");
        model.addColumn("Hab dob");
        model.addColumn("Hab sim");
        model.addColumn("Sala estudio");
        model.addColumn("Deposito");
        model.addColumn("Taller");
        
        mostrar_tabla();
        //------------------------------
        
        //------------------------------
        //Centrado y tamaños de las columnas de la tabla.
        
        //Para centrar el nombre de las columnas:
        ((DefaultTableCellRenderer)jTable_viviendas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        //Para centrar el contenido de las columnas:
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);      //En lugar de center se puede poner otras opciones.
        for(int i=0; i<17; i++){
            jTable_viviendas.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        //jTable_viviendas.getColumnModel().getColumn(0).setCellRenderer(tcr);  //Si quiero centrar una por una, en getColumn() va el número de la columna.
        
        //Para definir el tamaño de cada columna:
        TableColumnModel columnModel = jTable_viviendas.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(20);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(20);
        columnModel.getColumn(4).setPreferredWidth(35);
        columnModel.getColumn(5).setPreferredWidth(15);
        columnModel.getColumn(6).setPreferredWidth(60);
        columnModel.getColumn(7).setPreferredWidth(20);
        columnModel.getColumn(8).setPreferredWidth(50);
        columnModel.getColumn(9).setPreferredWidth(40);
        columnModel.getColumn(10).setPreferredWidth(60);
        columnModel.getColumn(11).setPreferredWidth(40);
        columnModel.getColumn(12).setPreferredWidth(40);
        columnModel.getColumn(13).setPreferredWidth(40);
        columnModel.getColumn(14).setPreferredWidth(55);
        columnModel.getColumn(15).setPreferredWidth(40);
        columnModel.getColumn(16).setPreferredWidth(20);
        
        //------------------------------
        
        //------------------------------
        //Evento que permite "escuchar" los clic que el usuario hace sobre la tabla, para luego obtener los datos del cliente que necesitamos
        //y abrir la interfaz "InformacionVivienda".
        jTable_viviendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                fila_clic = jTable_viviendas.rowAtPoint(e.getPoint());  //Se guarda el punto donde se esta haciendo click dentro de la variable fila_point.
                int columna_clic = 0;  //La columna 0 porque nos interesa obtener el id del cliente y éste se ubica en la columna 0. Con el id después conseguimos el resto de datos.
                
                if(fila_clic > -1){    //Cuando el usuario haga clic en cualquier fila mayor a -1, que se ejecute todo (podría ser otra condición).
                    idVivienda = (int)model.getValueAt(fila_clic, columna_clic);    //(int) es para castear un valor que no es entero.
                    InformacionVivienda informacionVivienda = new InformacionVivienda(GestionarViviendas.this, fila_clic, idVivienda);
                    informacionVivienda.setVisible(true);
                }
            }
        });
        //------------------------------
        
        //------------------------------
        //Para poder ordenar la tabla según las columnas:
        TableRowSorter<TableModel> jTable_modulos = new TableRowSorter<TableModel>(model);
        this.jTable_viviendas.setRowSorter(jTable_modulos);
        //------------------------------
        
    }   //Fin del constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_viviendas = new javax.swing.JTable();
        jButton_generarReporte = new javax.swing.JButton();
        jLabel_cub = new javax.swing.JLabel();
        jLabel_pi = new javax.swing.JLabel();
        jLabel_term = new javax.swing.JLabel();
        jLabel_viviendas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Viviendas registradas");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jTable_viviendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_viviendas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable_viviendas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1050, 180));

        jButton_generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_generarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, 80, 70));

        jLabel_cub.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_cub.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_cub.setText("Cubierta: \"1\": un agua, \"2\": dos aguas, \"3\": plana");
        getContentPane().add(jLabel_cub, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        jLabel_pi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_pi.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pi.setText("Piso: \"1\": sobre platea, \"2\": sobre pilotes");
        getContentPane().add(jLabel_pi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        jLabel_term.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_term.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_term.setText("Terminación: \"1\": placa cementicia, \"2\": tablas madera");
        getContentPane().add(jLabel_term, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));
        getContentPane().add(jLabel_viviendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generarReporteActionPerformed
        Document documento = new Document(); //Creo un objeto de la clase "Document", que luego nos permitirá generar el pdf

        //Para generar un archivo es necesario usar una estructura try-catch:
        try {
            String ruta = System.getProperty("user.home");  //Ruta donde se generará el pdf.
            //user.home es para obtener el nombre de usuario o ruta del usuario que esta usando el programa, porque no se sabe en que computadora se va a usar.

            //Ahora genero el pdf en la ruta que quiero y le asigno el nombre del cliente:
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + "Viviendas.pdf"));

            //acá se usa una librería sin el "import" para solucionar lo que indique arriba junto a los import de librerías.
            com.itextpdf.text.Image banner = com.itextpdf.text.Image.getInstance("src/imagenes/portadaPDF.png");
            banner.scaleToFit(650, 1000);   //650 es para el tamaño de la imagen y 1000 es la escala de visualización.
            banner.setAlignment(Chunk.ALIGN_CENTER);    //Para ubicar la imagen en el centro.

            documento.open();   //Abro el documento.
            documento.add(banner);  //Agrego el banner arriba.

                //Con el objeto del tipo "Paragraph" se le da formato al texto que queremos mostrar.
                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK));
                parrafo2.add("\n \n VIVIENDAS REGISTRADAS \n \n");     

                documento.add(parrafo2);

                //Propiedades de la tabla de viviendas:
                PdfPTable tablaViviendas = new PdfPTable(7);
                tablaViviendas.setWidthPercentage(100); //Porcentaje a la tabla (tamaño ancho).
                tablaViviendas.setWidths(new float[] {5, 10, 10, 10, 10, 10, 10}); //Ancho de cada columna.
                tablaViviendas.addCell("ID");
                tablaViviendas.addCell("Orientación");
                tablaViviendas.addCell("Largo terreno");
                tablaViviendas.addCell("Ancho terreno");
                tablaViviendas.addCell("Cubierta");
                tablaViviendas.addCell("Piso");
                tablaViviendas.addCell("Terminación");

                try {

                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select id_vivienda, orientacion, largo_terreno, ancho_terreno, cubierta, piso, terminacion from vivienda");                         
                    
                    ResultSet rs2 = pst2.executeQuery();
                    
                    if(rs2.next()){
                        do {                            
                            tablaViviendas.addCell(rs2.getString(1));
                            tablaViviendas.addCell(rs2.getString(2));
                            tablaViviendas.addCell(rs2.getString(3));
                            tablaViviendas.addCell(rs2.getString(4));
                            tablaViviendas.addCell(rs2.getString(5));
                            tablaViviendas.addCell(rs2.getString(6));
                            tablaViviendas.addCell(rs2.getString(7));
                              
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
                tablaModulos.setWidths(new float[] {5, 10, 10, 12, 13, 10, 10, 10, 10, 12, 10}); //Ancho de cada columna.
                tablaModulos.addCell("ID");
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
                
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen" + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF");
        }
    }//GEN-LAST:event_jButton_generarReporteActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarViviendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarViviendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarViviendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarViviendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarViviendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_generarReporte;
    private javax.swing.JLabel jLabel_cub;
    private javax.swing.JLabel jLabel_pi;
    private javax.swing.JLabel jLabel_term;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_viviendas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_viviendas;
    // End of variables declaration//GEN-END:variables

public void mostrar_tabla(){
    //Para armar la tabla de viviendas:
        try {
            Connection cn = Conexion.conectar();
   
            PreparedStatement pst = cn.prepareStatement(
                "select " 
                    + "v.id_vivienda, "     //Recordar dejar el espacio en blanco antes de cerrar comillas en cada renglon.
                    + "v.orientacion, "
                    + "v.largo_terreno, "
                    + "v.ancho_terreno, "
                    + "v.cubierta, "
                    + "v.piso, "
                    + "v.terminacion, "

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
                + "group by id_vivienda");
                                 
            ResultSet rs = pst.executeQuery();         
            
            //Estructura repetitiva que nos permite colocar los datos que vienen de la base de datos dentro de la tabla:
            
            while (rs.next()) {     //Mientras existan registros, se ejecuta el while.
                Object[] fila = new Object[17];  //Vector de tipo Object
                for (int i = 0; i < 17; i++) {
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
