
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;



public class Venta extends javax.swing.JFrame {
    public void mostrardatosClienteTabla(String Valor){
        Conectar conn = new Conectar();
        conn.conexion();
        DefaultTableModel modelo;
        modelo = new DefaultTableModel();
        modelo.addColumn ("Id:");
        modelo.addColumn ("Dni:");
        modelo.addColumn ("Datos:");
        modelo.addColumn ("Contacto");
        modelo.addColumn ("Puntos:");
        String sql;
        
        if(Valor.equals("")){
        sql= "select id_cliente, dni_cliente,datos_cliente,contacto_cliente,puntos_cliente from cliente";
        }
        else{
            sql = "select id_cliente, dni_cliente,datos_cliente,contacto_cliente,puntos_cliente from cliente where dni_cliente like '%"+Valor+"%'";
        }
        String[] datos = new String[5];
        com.mysql.jdbc.Statement st;
        
        
        try{
            ResultSet rs = (ResultSet) conn.Consultar(sql);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
            modelo.addRow(datos);
            }
            jTable2.setModel(modelo);
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(Clientes.class.getName()) .log(java.util.logging.Level.SEVERE,null,ex);
        }}
    public void precios(){
                Conectar conn = new Conectar();
        conn.conexion();
        String sql;
        
        sql= "select id_entradas,entradas_precio from entradas";
        
        com.mysql.jdbc.Statement st;
        
        
        try{
            ResultSet rs = (ResultSet) conn.Consultar(sql);
           
           rs.next();
           menores.setText(rs.getString("entradas_precio"));
           rs.next();
           mayores.setText(rs.getString("entradas_precio"));
           rs.next();
           jubilados.setText(rs.getString("entradas_precio"));
           
            
            
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(ModificarPreciosEntradas.class.getName()) .log(java.util.logging.Level.SEVERE,null,ex);
        }

}
    public void mostrarybuscardatosclienteTabla(String Valor){
        
        Conectar conn = new Conectar();
        conn.conexion();
        DefaultTableModel modeloCliente;
        modeloCliente = new DefaultTableModel();
        modeloCliente.addColumn ("Id");
        modeloCliente.addColumn ("Nombre");
        modeloCliente.addColumn ("Marca");
        modeloCliente.addColumn ("Precio");
        
        String sqle;
        
        if(Valor.equals("")){
        sqle= "select id_pro, nombre_pro, marca_pro, precio_pro from productos";
        }
        else{
            sqle = "select id_pro, nombre_pro, marca_pro, precio_pro from productos where nombre_pro like '%"+Valor+"%'";
        }
        String[] datos = new String[4];
        com.mysql.jdbc.Statement ste;
        
        
        try{
            ResultSet rs = (ResultSet) conn.Consultar(sqle);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            
            modeloCliente.addRow(datos);
            }
            jTable2.setModel(modeloCliente);
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(Venta.class.getName()) .log(java.util.logging.Level.SEVERE,null,ex);
        }
    }
    
public void mostrarybuscardatosTabla(String Valor){
        Conectar conn = new Conectar();
        conn.conexion();
        DefaultTableModel modelo;
        modelo = new DefaultTableModel();
        modelo.addColumn ("Id");
        modelo.addColumn ("Pelicula");
        modelo.addColumn ("Formato");
        modelo.addColumn ("Genero");
        modelo.addColumn ("Idioma");
        String sql;
        
        if(Valor.equals("")){
        sql= "select id_peli, nombre_peli, formato_peli, genero_peli, idioma_peli from peliculas";
        }
        else{
            sql = "select id_peli, nombre_peli, formato_peli, genero_peli, idioma_peli from peliculas where nombre_peli like '%"+Valor+"%'";
        }
        String[] datos = new String[5];
        com.mysql.jdbc.Statement st;
        
        
        try{
            ResultSet rs = (ResultSet) conn.Consultar(sql);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
            modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(Venta.class.getName()) .log(java.util.logging.Level.SEVERE,null,ex);
        }
    }
    /**
     * Creates new form Venta
     */
    public Venta() {
        initComponents();
        mostrarybuscardatosTabla(jTextField1.getText());
        precios();
         mostrardatosClienteTabla(jTextField2.getText());
         this.setLocationRelativeTo(null);
        this.setResizable(false); //Quitar maximizar
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        txtid.setEnabled(false);
        txtdni.setEnabled(false);
        txtnombre.setEnabled(false);
        txttel.setEnabled(false);
        txtpuntos.setEnabled(false);
        Random a = new Random(System.currentTimeMillis());
        int azar = a.nextInt(99999999);
        jCodigoVenta.setText(Integer.valueOf(azar).toString());
        txtId.setVisible(false);
        txtid.setVisible(false);
        
        jButton1.setEnabled(false);
        jButton5.setEnabled(false);
        
        txttel.setVisible(false);
        txtGenero.setVisible(false);
        txtIdioma.setVisible(false);
        txtpuntos.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel18.setVisible(false);
        jLabel19.setVisible(false);



        
        
        
        
         
        
        //mostrarybuscardatosclienteTabla(jTextField2.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        menores = new javax.swing.JLabel();
        mayores = new javax.swing.JLabel();
        jubilados = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCantidadMenores = new javax.swing.JSpinner();
        jCantidadMayores = new javax.swing.JSpinner();
        jCantidadJubilados = new javax.swing.JSpinner();
        txtpreciomenores = new javax.swing.JTextField();
        txtpreciomayores = new javax.swing.JTextField();
        txtpreciojubilados = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jcalcular = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtubicaciones = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPuntosNuevos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFecha = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtdni = new javax.swing.JFormattedTextField();
        txtnombre = new javax.swing.JTextField();
        txtpuntos = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtPelicula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCodigoVenta = new javax.swing.JLabel();
        txtFormato = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtIdioma = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        jTabbedPane5.addTab("tab1", jTabbedPane1);

        jMenuItem1.setText("Seleccionar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem1);

        jMenuItem2.setText("Seleccionar Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Menores-Precio   $");

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Mayores-Precio   $");

        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel10.setText("Jubilados-Precio  $");

        menores.setText(" ");

        jLabel12.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Cantidad");

        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel13.setText("Cantidad");

        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel14.setText("Cantidad");

        jCantidadMenores.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCantidadMenoresStateChanged(evt);
            }
        });

        jCantidadMayores.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCantidadMayoresStateChanged(evt);
            }
        });

        jCantidadJubilados.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCantidadJubiladosStateChanged(evt);
            }
        });

        txtpreciomenores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtpreciomenores.setText("0");
        txtpreciomenores.setEnabled(false);

        txtpreciomayores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtpreciomayores.setText("0");
        txtpreciomayores.setEnabled(false);

        txtpreciojubilados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtpreciojubilados.setText("0");
        txtpreciojubilados.setEnabled(false);

        jButton4.setText("Calcular");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jcalcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcalcular.setText("0");
        jcalcular.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Ubicaciones seleccionadas:");

        txtubicaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtubicaciones.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel15.setText("Horario de inicio:");

        jFormattedTextField1.setColumns(4);
        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setToolTipText("");
        jFormattedTextField1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Imprimir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel2.setText("Fecha:");

        try {
            jFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtubicaciones))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCantidadJubilados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcalcular, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(jPuntosNuevos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtpreciojubilados, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(menores, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                                    .addComponent(mayores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jubilados)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jCantidadMenores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpreciomenores))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jCantidadMayores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpreciomayores, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(menores)
                            .addComponent(jLabel12)
                            .addComponent(jCantidadMenores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpreciomenores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mayores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jCantidadMayores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpreciomayores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jubilados)
                    .addComponent(jLabel14)
                    .addComponent(jCantidadJubilados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpreciojubilados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtubicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jcalcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jPuntosNuevos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel16.setText("DNI-CUIT:");

        jLabel17.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel17.setText("Nombre y Apellido:");

        jLabel18.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel18.setText("Teléfono");

        jLabel19.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel19.setText("Puntos:");

        txtdni.setColumns(11);
        try {
            txtdni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdni.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N

        txtnombre.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtpuntos.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtpuntos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpuntosKeyTyped(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel4.setText("Pelicula:");

        txtPelicula.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtPelicula.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel5.setText("Formato:");

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel6.setText("Género:");

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel7.setText("Idioma:");

        jCodigoVenta.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N

        txtFormato.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtFormato.setEnabled(false);

        txtId.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtId.setEnabled(false);

        txtGenero.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtGenero.setEnabled(false);

        txtIdioma.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtIdioma.setEnabled(false);

        txttel.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txttel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelKeyTyped(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtpuntos)
                                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtdni)
                                    .addComponent(txtnombre)
                                    .addComponent(txtPelicula)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jCodigoVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtpuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Venta", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu2);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel3.setText("Buscar pelicula");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 687, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Buscar Pelicula", jPanel2);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(jTable2);

        jLabel11.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel11.setText("Buscar CUIT:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(460, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Buscar Cliente", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        mostrarybuscardatosTabla(jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        mostrardatosClienteTabla(jTextField2.getText());
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if(fila>=0){
            txtId.setText(jTable1.getValueAt(fila, 0) .toString());
            txtPelicula.setText(jTable1.getValueAt(fila, 1) .toString());
            txtFormato.setText(jTable1.getValueAt(fila, 2) .toString());
            txtGenero.setText(jTable1.getValueAt(fila, 3) .toString());
            txtIdioma.setText(jTable1.getValueAt(fila, 4) .toString());
        
        }
        else{
            JOptionPane.showMessageDialog(null,"No seleccionó ninguna fila");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jCantidadMenoresStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCantidadMenoresStateChanged
        // TODO add your handling code here:
        int cantidad = Integer.parseInt(jCantidadMenores.getValue().toString());
        
        int precio = Integer.parseInt(menores.getText());
        
        int totalparcial =cantidad*precio;
        txtpreciomenores.setText(String.valueOf(totalparcial));
    }//GEN-LAST:event_jCantidadMenoresStateChanged

    private void jCantidadMayoresStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCantidadMayoresStateChanged
        // TODO add your handling code here:
        int cantidad = Integer.parseInt(jCantidadMayores.getValue().toString());
        
        int precio = Integer.parseInt(mayores.getText());
        
        int totalparcial =cantidad*precio;
        txtpreciomayores.setText(String.valueOf(totalparcial));
    }//GEN-LAST:event_jCantidadMayoresStateChanged

    private void jCantidadJubiladosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCantidadJubiladosStateChanged
        // TODO add your handling code here:
        int cantidad = Integer.parseInt(jCantidadJubilados.getValue().toString());
        
        int precio = Integer.parseInt(jubilados.getText());
        
        int totalparcial =cantidad*precio;
        txtpreciojubilados.setText(String.valueOf(totalparcial));
    }//GEN-LAST:event_jCantidadJubiladosStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int meno = Integer.parseInt(txtpreciomenores.getText());
        int mayo = Integer.parseInt(txtpreciomayores.getText());
        int jubi = Integer.parseInt(txtpreciojubilados.getText());
        
        int mmj = meno+mayo+jubi;
        jcalcular.setText(String.valueOf(mmj));
        jcalcular.setText(String.valueOf(mmj));

        
        int puntosactuales = Integer.parseInt(txtpuntos.getText());
        int puntosahora = mmj+puntosactuales;
        
        jPuntosNuevos.setText(String.valueOf(puntosahora));
        jPuntosNuevos.setVisible(false);
        jButton1.setEnabled(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            // TODO add your handling code here:
            dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jFormattedTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(c<'0' || c>'9')evt.consume();
    }//GEN-LAST:event_jFormattedTextField1KeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        //EVENTO KEYTYPED
        //CODIGO QUE NO ME VA A PERMITIR DIGITAR NÚMEROS
        char c = evt.getKeyChar();
        if((c<'a'||c>'z') &&(c<'A'||c>'Z'))evt.consume();
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txttelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelKeyTyped
        //EVENTO KEYTYPED
        //CODIGO QUE NO ME VA A PERMITIR DIGITAR LETRAS
        char c = evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();

    }//GEN-LAST:event_txttelKeyTyped

    private void txtpuntosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpuntosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtpuntosKeyTyped

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int fila = jTable2.getSelectedRow();
        if(fila>=0){
            txtid.setText(jTable2.getValueAt(fila, 0) .toString());
            txtdni.setText(jTable2.getValueAt(fila, 1) .toString());
            txtnombre.setText(jTable2.getValueAt(fila, 2) .toString());
            txttel.setText(jTable2.getValueAt(fila, 3) .toString());
            txtpuntos.setText(jTable2.getValueAt(fila, 4) .toString());
        
        }
        else{
            JOptionPane.showMessageDialog(null,"No seleccionó ninguna fila");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
          Conectar con = new Conectar();
            Connection cn = (Connection) con.conexion();
        try{
        String rutaInforme ="D:\\Usuarios\\User\\Desktop\\JavaApplication18\\src\\Reportes\\reporteTicket.jasper";
        Map parametros = new HashMap();
        parametros.put("id",jCodigoVenta.getText());
        JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,cn);
        JasperViewer ventanavisor = new JasperViewer(informe,false);
        ventanavisor.setTitle("Ticket");
        ventanavisor.setVisible(true);
        
        
        
        
        
        }catch (JRException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
//catch(HeadlessException | JRException e){
            //JOptionPane.showMessageDialog(null,"error en el reporte","Error",JOptionPane.ERROR_MESSAGE);
        //}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Conectar con = new Conectar();
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) con.conexion();
        // BOTON GUARDAR
        try{
            if ("".equals(jFecha.getText())|| "".equals(txtdni.getText())|| "".equals(jFormattedTextField1.getText())|| "".equals(txtPelicula.getText())|| "".equals(txtFormato.getText())|| "".equals(txtubicaciones.getText())|| "".equals(jcalcular.getText())|| "".equals(jCodigoVenta.getText())){
            JOptionPane.showMessageDialog(null, "Faltan completar campos","Ocurrió un error",JOptionPane.INFORMATION_MESSAGE);  
            }else{
             PreparedStatement pst = (PreparedStatement) cn.prepareStatement("insert into ventas (fecha_venta,cuit_venta,hinicio_venta,pelicula_venta,form_venta,ubi_venta,total_venta,codigo_venta) values (?,?,?,?,?,?,?,?)");
            pst.setString(1,jFecha.getText()); 
            pst.setString(2,txtdni.getText());
            pst.setString(3,jFormattedTextField1.getText());
            pst.setString(4,txtPelicula.getText());
            pst.setString(5,txtFormato.getText());
            pst.setString(6,txtubicaciones.getText());
            pst.setString(7,jcalcular.getText());
            pst.setString(8,jCodigoVenta.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nuevo venta realizada","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            
            }
        } catch (SQLException e){
            java.util.logging.Logger.getLogger(Usuario.class.getName()) .log(java.util.logging.Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(rootPane, e);
            JOptionPane.showMessageDialog(null, "Error SQL Consultar"+e);
        }
        
        //Conectar con = new Conectar();
        //com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) con.conexion();
        
      
        try{
            
            String sql = "update cliente set puntos_cliente = '"+jPuntosNuevos.getText()+"' where id_cliente = '"+txtid.getText()+"'";
            
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            JOptionPane.showMessageDialog(null,"Puntos actualizados","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE);
            ps.executeUpdate();
            
        }catch (SQLException e){
            java.util.logging.Logger.getLogger(Usuario.class.getName()) .log(java.util.logging.Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(null,"No seleccionó el cliente o la cantidad de entradas","Error",JOptionPane.INFORMATION_MESSAGE);
        }
       
        jButton5.setEnabled(true);
        jButton1.setEnabled(false);
        jButton4.setEnabled(false);
      
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JSpinner jCantidadJubilados;
    private javax.swing.JSpinner jCantidadMayores;
    private javax.swing.JSpinner jCantidadMenores;
    private javax.swing.JLabel jCodigoVenta;
    private javax.swing.JFormattedTextField jFecha;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JLabel jPuntosNuevos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jcalcular;
    private javax.swing.JLabel jubilados;
    private javax.swing.JLabel mayores;
    private javax.swing.JLabel menores;
    private javax.swing.JTextField txtFormato;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtPelicula;
    private javax.swing.JFormattedTextField txtdni;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtpreciojubilados;
    private javax.swing.JTextField txtpreciomayores;
    private javax.swing.JTextField txtpreciomenores;
    private javax.swing.JTextField txtpuntos;
    private javax.swing.JTextField txttel;
    public static javax.swing.JTextField txtubicaciones;
    // End of variables declaration//GEN-END:variables
}
