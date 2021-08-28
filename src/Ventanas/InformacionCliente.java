package Ventanas;

import java.sql.*;
import Clases.Conexion;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static Ventanas.GestionarClientes.idCliente;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

//Se usan dos tipos de librerías, las que son "java..." son librerías que nos ofrece el jdk que nos da java
//y las otras son librerías de itexpdf.
//Cuando se intenta importar por ejemplo una librería de itexpdf con el mismo nombre que una del jdk, me indica un error.
//Para solucionar ésto, lo hacemos en la parte del "Botón generar pdf"

/**
 * @author Calgaro Alejandro
 */

public class InformacionCliente extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel(); //Nos va a permitir generar el clic en la tabla y establecer una conexión con los datos que se muestren dentro de la tabla.
    
    int idCliente = 0;
    public static int idVivienda = 0;
    private GestionarClientes gestionarClientes;
    int fila_clic;
    
    /**
     * Creates new form InformacionCliente
     */
    
    //Constructor que se usa desde ventana "GestionarClientes".
    public InformacionCliente(int id_cliente, GestionarClientes gestionarClientes) {
   
        idCliente = id_cliente;     //idCliente = al id que recibo desde cada pantalla.
        this.gestionarClientes = gestionarClientes;

        generar_ventana();  //Hago este metodo para no repetir código porque desde "RegistrarVivienda" tengo que usar el otro constructor que solo tiene idCliente.
        
        //Para que la tabla de viviendas este "a la escucha" de cuando se hace un clic
        jTable_viviendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fila_clic = jTable_viviendas.rowAtPoint(e.getPoint());
                int columna_clic = 0;  // = 0 para obtener el id que esta en la columna 0.

                if (fila_clic > -1) {
                    idVivienda = (int)model.getValueAt(fila_clic, columna_clic);
                    InformacionVivienda informacionVivienda = new InformacionVivienda(InformacionCliente.this, fila_clic, idVivienda);
                    informacionVivienda.setVisible(true);
                }
            }
        });
        
    }

    //Constructor que se usa desde ventana "RegistrarVivienda" porque solo tiene idCliente.
    public InformacionCliente(int id_cliente) {
        idCliente = id_cliente;
        
        generar_ventana();
        
        //Para que la tabla este "a la escucha" de cuando se hace un clic
        jTable_viviendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_clic = jTable_viviendas.rowAtPoint(e.getPoint());
                int columna_clic = 0;  // = 0 para obtener el id que esta en la columna 0.

                if (fila_clic > -1) {
                    idVivienda = (int)model.getValueAt(fila_clic, columna_clic);
                    InformacionVivienda informacionVivienda = new InformacionVivienda(InformacionCliente.this, fila_clic, idVivienda);
                    informacionVivienda.setVisible(true);
                }
            }
        });
    }
    
    //Este constructor se creo para corregir un error de "public void run().." abajo de todo.
    private InformacionCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane_viviendas = new javax.swing.JScrollPane();
        jTable_viviendas = new javax.swing.JTable();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_nombre = new javax.swing.JLabel();
        jLabel_dni = new javax.swing.JLabel();
        jLabel_telefono = new javax.swing.JLabel();
        jLabel_correo = new javax.swing.JLabel();
        jLabel_direccion = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        jButton_eliminarCliente = new javax.swing.JButton();
        jButton_actualizarCliente = new javax.swing.JButton();
        jButton_generarReporte = new javax.swing.JButton();
        jButton_registrarVivienda = new javax.swing.JButton();
        jLabel_informacionCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_viviendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ));
        jScrollPane_viviendas.setViewportView(jTable_viviendas);

        getContentPane().add(jScrollPane_viviendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1050, 100));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Información del cliente");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombre.setText("Nombre:");
        getContentPane().add(jLabel_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        jLabel_dni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_dni.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_dni.setText("DNI");
        getContentPane().add(jLabel_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        jLabel_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_telefono.setText("Télefono:");
        getContentPane().add(jLabel_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        jLabel_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_correo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_correo.setText("Correo");
        getContentPane().add(jLabel_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_direccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_direccion.setText("Dirección");
        getContentPane().add(jLabel_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

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
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 210, -1));

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
        getContentPane().add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 210, -1));

        txt_telefono.setBackground(new java.awt.Color(92, 124, 203));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 210, -1));

        txt_correo.setBackground(new java.awt.Color(92, 124, 203));
        txt_correo.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_correo.setForeground(new java.awt.Color(255, 255, 255));
        txt_correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_correo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 230, -1));

        txt_direccion.setBackground(new java.awt.Color(92, 124, 203));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 230, -1));

        jButton_eliminarCliente.setBackground(new java.awt.Color(64, 97, 164));
        jButton_eliminarCliente.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_eliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminarCliente.setText("Eliminar cliente");
        jButton_eliminarCliente.setBorder(null);
        jButton_eliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 210, 25));

        jButton_actualizarCliente.setBackground(new java.awt.Color(64, 97, 164));
        jButton_actualizarCliente.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jButton_actualizarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizarCliente.setText("Actualizar cliente");
        jButton_actualizarCliente.setBorder(null);
        jButton_actualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 210, 25));

        jButton_generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_generarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, 80, 70));

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
        getContentPane().add(jButton_registrarVivienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 210, 25));
        getContentPane().add(jLabel_informacionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_eliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarClienteActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, //this sería unComponentePadre (new InformacionCliente())
            "¿Desea confirmar la eliminación?", "Confirmación de eliminación",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);   //el null es para dejar el icono por defecto
        // 0=ok, 2=cancel
        
        if(opcion == 0){           
            try {
                Connection cn = Conexion.conectar();

                //Debo eliminar primero los modulo_vivienda, luego las viviendas y luego el cliente.

                //Elimino los módulos de todas las viviendas del cliente que se desea eliminar.
                //Uso select 1 en la subconsulta dentro del exists porque no es necesario devolver toda una columna con *
                PreparedStatement pst = cn.prepareStatement(   
                    "delete from modulo_vivienda "
                            + "where exists (select 1 "
                            +       "from vivienda where vivienda.id_vivienda = modulo_vivienda.id_vivienda "
                            +           "and vivienda.id_cliente = '" + idCliente + "')");           
                pst.executeUpdate();

                PreparedStatement pst1 = cn.prepareStatement(    //Elimino las viviendas del cliente que se desea eliminar.
                    "delete from vivienda where id_cliente = '" + idCliente + "'");             
                pst1.executeUpdate();

                PreparedStatement pst2 = cn.prepareStatement(    //Elimino el cliente.
                    "delete from cliente where id_cliente = '" + idCliente + "'");     
                pst2.executeUpdate();

                cn.close();

                //Envío un mensaje al usuario para avisar que se eliminó de forma correcta.
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente.");
                this.dispose(); //Para que la ventana "InformaciónCliente" se cierre automáticamente cuando el usuario da clic en "aceptar" del mensaje que le enviamos recién.

                gestionarClientes.model.removeRow(gestionarClientes.fila_clic);   //Elimino la fila correspondiente en la tabla de la ventana "GestionarClientes".

                } catch (SQLException e) {
                    System.err.println("Error al eliminar cliente" + e);  //Éste sirve para indicarle al programador donde esta el error en el código.
                    JOptionPane.showInternalMessageDialog(null, "Error al eliminar cliente"); //Éste sirve para avisarle al usuario que ocurrió un error.
                }
        }
    }//GEN-LAST:event_jButton_eliminarClienteActionPerformed

    private void jButton_actualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarClienteActionPerformed
        int validacion = 0; //Ésta variable me sirve para identificar que campos están vacios y completos de manera correcta.
        String nombre, dni, telefono, correo, direccion;
        
        //Guardo en las variables lo que hay en los campos de texto de la ventana.
        //con .getText() se obtiene el texto del campo de texto y con .trim() se eliminan espacios de inicio y final.
        nombre = txt_nombre.getText().trim();
        dni = txt_dni.getText().trim();
        telefono = txt_telefono.getText().trim();
        direccion = txt_direccion.getText().trim();
        correo = txt_correo.getText().trim();
        
        //Ahora empiezo a ver si tengo campos vacios comparando cada variable con "".
        if(nombre.equals("")){
            txt_nombre.setBackground(Color.red); //Para que el cuadro de texto se ponga rojo si esta incompleto.
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
        
        if (validacion == 0) {  //Si validacion = 0 significa que todos los campos están completos y puedo usar esos valores para la base de datos.
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(    //Se usan "?" porque todavía no sabemos el valor.
                    "update cliente set nombre_cliente=?, dni_cliente=?, telefono_cliente=?, direccion_cliente=?, correo_cliente=? "
                    + "where id_cliente = '" + idCliente + "'"); //Tener cuidado con las comillas simples '
                
                //Mandamos ésta información a la base de datos:
                pst.setString(1, nombre);
                pst.setString(2, dni);
                pst.setString(3, telefono);
                pst.setString(4, direccion);
                pst.setString(5, correo);
                
                //Ejecutamos todo lo anterior:
                pst.executeUpdate();
                cn.close();
                
                Limpiar();  //Método para limpiar los campos. Programado abajo.
                
                //Pinto los campos de color verde si todo salió bien.
                txt_nombre.setBackground(Color.green);
                txt_dni.setBackground(Color.green);
                txt_telefono.setBackground(Color.green);
                txt_direccion.setBackground(Color.green);
                txt_correo.setBackground(Color.green);         
                
                //Envío un mensaje al usuario para avisar que se actualizó de forma correcta.
                JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente.");
                this.dispose(); //Para que la ventana "InformaciónCliente" se cierre automáticamente cuando el usuario da clic en "aceptar" del mensaje que le enviamos recién.
                
                //Actualizo los datos de la fila correspondiente en la tabla de la ventana "GestionarModulos".
                gestionarClientes.model.setValueAt(nombre, gestionarClientes.fila_clic, 1);
                gestionarClientes.model.setValueAt(dni, gestionarClientes.fila_clic, 2);
                gestionarClientes.model.setValueAt(telefono, gestionarClientes.fila_clic, 3);
                gestionarClientes.model.setValueAt(direccion, gestionarClientes.fila_clic, 4);
                gestionarClientes.model.setValueAt(correo, gestionarClientes.fila_clic, 5);
                
            } catch (SQLException e) {
                System.err.println("Error en actualizar cliente" + e);  //Éste sirve para indicarle al programador donde esta el error en el código.
                JOptionPane.showInternalMessageDialog(null, "Error al actualizar cliente"); //Éste sirve para avisarle al usuario que ocurrió un error.
            }   
            
        } else {
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos");
        }
          
    }//GEN-LAST:event_jButton_actualizarClienteActionPerformed
    
    private void jButton_generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generarReporteActionPerformed
        Document documento = new Document(); //Creo un objeto de la clase "Document", que luego nos permitirá generar el pdf
        
        //Para generar un archivo es necesario usar una estructura try-catch:
        try {
            String ruta = System.getProperty("user.home");  //Ruta donde se generará el pdf.
                                            //user.home es para obtener el nombre de usuario o ruta del usuario que esta usando el programa, porque no se sabe en que computadora se va a usar.
            
            //Ahora genero el pdf en la ruta que quiero y le asigno el nombre del cliente:
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + txt_nombre.getText().trim() + ".pdf"));  
            
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
            tablaCliente.addCell("Dirección");
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
                System.err.print("Error al obtener datos del cliente. " + e);
                }
            
                //----------------------
                
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
                            "select id_vivienda, orientacion, largo_terreno, ancho_terreno, cubierta, piso, terminacion from vivienda where id_cliente = '" + idCliente + "'");                         
                    
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
                                + "where v.id_cliente = '" + idCliente + "' "       //RECORDAR SIEMPRE DEJAR UN ESPACIO AL FINAL ANTES DE " CUANDO HAGO UN SALTO DE LINEA.
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

    private void jButton_registrarViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarViviendaActionPerformed
        RegistrarVivienda registrarVivienda = new RegistrarVivienda(this);
        registrarVivienda.setVisible(true);
    }//GEN-LAST:event_jButton_registrarViviendaActionPerformed

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

    //Si quiero hacer algo al cerrar esta ventana con la cruz roja.
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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizarCliente;
    private javax.swing.JButton jButton_eliminarCliente;
    private javax.swing.JButton jButton_generarReporte;
    private javax.swing.JButton jButton_registrarVivienda;
    private javax.swing.JLabel jLabel_correo;
    private javax.swing.JLabel jLabel_direccion;
    private javax.swing.JLabel jLabel_dni;
    private javax.swing.JLabel jLabel_informacionCliente;
    private javax.swing.JLabel jLabel_nombre;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane_viviendas;
    private javax.swing.JTable jTable_viviendas;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    public void generar_ventana(){
        initComponents();    
        setSize(1090, 410);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon imagen_fondo = new ImageIcon("src/imagenes/fondoAzul.jpg");
        Icon icono = new ImageIcon(imagen_fondo.getImage().getScaledInstance(jLabel_informacionCliente.getWidth(),
                jLabel_informacionCliente.getHeight(), Image.SCALE_DEFAULT));
        jLabel_informacionCliente.setIcon(icono);
        this.repaint();
        
        //Para colocar icono que aparece en la ventana y en la barra de tareas.
        ImageIcon icono_ventana = new ImageIcon("src/imagenes/icono_vsm.png");
        setIconImage(icono_ventana.getImage());
        
        //Para colocar imagen en el botón de generar reporte.
        ImageIcon icono_pdf = new ImageIcon("src/imagenes/pdf.png");
        jButton_generarReporte.setIcon(icono_pdf);
        
        //Para conectarnos a la base de datos y obtener los datos del cliente que se seleccione en "GestionarClientes"
        //y para completar los campos de texto de "InformacionCliente" con esos datos obtenidos.
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select * from cliente where id_cliente = '" + idCliente + "'");
            ResultSet rs = pst.executeQuery(); 
            
            if(rs.next()){  //Si se encontro, se hace lo siguiente:
                setTitle("Información del cliente " + rs.getString("nombre_cliente"));
                //jLabel_titulo.setText("Información del cliente " + rs.getString("nombre_cliente"));
                
                //Completo los cuadros de la ventana con los datos obtenidos de la base de datos.
                txt_nombre.setText(rs.getString("nombre_cliente"));
                txt_dni.setText(rs.getString("dni_cliente"));
                txt_telefono.setText(rs.getString("telefono_cliente"));
                txt_direccion.setText(rs.getString("direccion_cliente"));
                txt_correo.setText(rs.getString("correo_cliente"));       
            }
            cn.close();   //Cierro la conexión.
            
        } catch (SQLException e) {
            System.err.println("Error en cargar cliente." + e); //Sirve para inviarle un mensaje al programador para saber en que parte del código ocurrió el error. 
            JOptionPane.showMessageDialog(null, "Error al cargar"); //Sirve para decirle al usuario que hubo un error.
        
        }   //Termina el try-catch del llenado de los datos del cliente en los campos de texto de "InformacionCliente".

        mostrar_tabla();
        
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
        columnModel.getColumn(11).setPreferredWidth(45);
        columnModel.getColumn(12).setPreferredWidth(40);
        columnModel.getColumn(13).setPreferredWidth(40);
        columnModel.getColumn(14).setPreferredWidth(55);
        columnModel.getColumn(15).setPreferredWidth(40);
        columnModel.getColumn(16).setPreferredWidth(20);
        
    }   //Cierre generar_ventana()
    
    public void mostrar_tabla(){
        //Llenado de la tabla de viviendas para mostrar la/s vivienda/s del cliente.     
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select " 
                    + "v.id_vivienda, "
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
                + "where v.id_cliente = '" + idCliente + "'"
                + "group by v.id_vivienda "
             );
            ResultSet rs = pst.executeQuery();
            
            jTable_viviendas = new JTable(model);   //Creo un objeto de tipo JTable dónde vamos a ingresar datos que vienen del objeto model.
            jScrollPane_viviendas.setViewportView(jTable_viviendas);    //Dentro del jScrollPane ponemos una JTable que a su vez tiene datos que vienen del objeto model.
            
            //Agregamos las columnas de la tabla:
            model.addColumn("ID");
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
            model.addColumn("Hab. matri.");
            model.addColumn("Hab. dob.");
            model.addColumn("Hab. sim.");
            model.addColumn("Sala estudio");
            model.addColumn("Deposito");
            model.addColumn("Taller");
            
            while(rs.next()){   //Mientras encuentre valores de la vivienda que estamos usando, continua ejecutando.
                Object[] fila = new Object[17];
                //El while sirve para llenar todas las columnas y el for para llenar todas las filas.
                for (int i = 0; i < 17; i++) {   //Para que rellene registro por registro.
                    fila[i] = rs.getObject(i + 1);  //i + 1 porque comienzo con 0.
                }
                model.addRow(fila);                
            }
            cn.close();           
            
        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla viviendas");
        }
    }
    
    public void Limpiar() {     //Para limpiar los campos de texto cuando se hace una actualización.
        txt_nombre.setText("");
        txt_dni.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
        txt_correo.setText("");    
    }
}
