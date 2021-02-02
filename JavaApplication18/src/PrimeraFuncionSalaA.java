
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class PrimeraFuncionSalaA extends javax.swing.JFrame {

    /**
     * Creates new form PrimeraFuncionSalaA
     */
    public PrimeraFuncionSalaA() {
        initComponents();
        botones();
        buscarButacasReservadas();
    }

    int filas=5;
    int columnas=6;
    int largoboton=140; //140
    int anchoboton=60; //60
    int ejeX=20; //-->
    int ejeY=20;//Abajo
     public JToggleButton [][] JTBotones = new JToggleButton[filas][columnas];
    
    //Filas son las que van hacia el eje X
    //Columnas son las que van hacia abajo eje Y
    
    public void botones(){
        JTBotones = new JToggleButton[filas][columnas];
        int contadorAsientos = 1;
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                JTBotones[i][j] = new JToggleButton();
                JTBotones[i][j].setBounds(ejeX,ejeY,largoboton,anchoboton);
                
                JTBotones[i][j].setText("Butaca "+contadorAsientos);
                JTBotones[i][j].setBackground(Color.GREEN);
                AccionBotones accion = new AccionBotones();
                JTBotones[i][j].addActionListener(accion);
                jPanel1.add(JTBotones[i][j]);
                ejeX+=160; //Separacion entre columnas
                contadorAsientos++;
            }
            ejeX=20; //Posicion inicial de los botones
            ejeY+=70; //Separacion de los botones en cuanto a las filas
        }
    
    }
    
    public void reservarButaca(int numeroButaca){
        
        try {
            Conectar con = new Conectar();
            Connection cn = (Connection) con.conexion();
            String sql;
        
            sql= "UPDATE reservaciones SET reservado = 'si' WHERE id_butaca = "+numeroButaca;
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            int mensaje = ps.executeUpdate();
            if (mensaje >0){
                JOptionPane.showConfirmDialog(null, "Butaca Vendida");
            }else{
                JOptionPane.showConfirmDialog(null, "Error al vender la butaca");
            }
        } catch (SQLException e){
            java.util.logging.Logger.getLogger(PrimeraFuncionSalaA.class.getName()) .log(java.util.logging.Level.SEVERE,null,e);
        }
    
    }
    public void quitarreservarcionButaca(int numeroButaca){
        
        try {
            Conectar con = new Conectar();
            Connection cn = (Connection) con.conexion();
            String sql;
        
            sql= "UPDATE reservaciones SET reservado = 'no' WHERE id_butaca = "+numeroButaca;
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.executeUpdate();
            /**int mensaje = ps.executeUpdate();
            if (mensaje >0){
                JOptionPane.showConfirmDialog(null, "¿Desea liberar la butaca?");
            }else{
                JOptionPane.showConfirmDialog(null, "Error");
            }*/
        } catch (SQLException e){
            java.util.logging.Logger.getLogger(PrimeraFuncionSalaA.class.getName()) .log(java.util.logging.Level.SEVERE,null,e);
        }
    
    }
    public void buscarButacasReservadas(){
        try {
             Conectar conn = new Conectar();
             conn.conexion();
            String sql;
        
            sql= "SELECT id_butaca,reservado from reservaciones";
            java.sql.ResultSet consulta;
            consulta = conn.Consultar(sql);
            int numero;
            String reservado;
            
            while(consulta.next()){
            numero=consulta.getInt("id_butaca");
            reservado=consulta.getString("reservado");
            
            for(int i=0;i<filas;i++){
                for(int j=0 ; j<columnas ;j++){
                if(JTBotones[i][j].getText().length()==8){
                String numeroLetra= JTBotones[i][j].getText().charAt(7)+"";
                int numeroN = Integer.parseInt(numeroLetra);
                    if((numero==numeroN) && (reservado.equals("si")) ){
                    JTBotones[i][j].setBackground(Color.RED);
                    JTBotones[i][j].setSelected(true);
                    
                    }
                
                
                }else if(JTBotones[i][j].getText().length()==9){
                
                    String numeroLetra= JTBotones[i][j].getText().charAt(7)+""+JTBotones[i][j].getText().charAt(8);
                    int numeroN = Integer.parseInt(numeroLetra);
                    if((numero==numeroN) && (reservado.equals("si")) ){
                    JTBotones[i][j].setBackground(Color.RED);
                    JTBotones[i][j].setSelected(true);
                    
                    }
                
                }
                
                    
                    
                    
                }
            }
            
            }
        } catch (Exception e) {
        }
    
    
    }
    public class AccionBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int tomar = 0;
            for(int i = 0; i < filas ;i++){
                for(int j = 0; j<columnas ; j++){
                if(e.getSource().equals(JTBotones[i][j])){
                
                if(JTBotones[i][j].isSelected()){
                    JTBotones[i][j].setBackground(Color.RED);
                    
                    if (JTBotones[i][j].getText().length()== 8) {
                        String numeroletra= JTBotones[i][j].getText().charAt(7)+"";// Comienza desde 0
                        int numero = Integer.parseInt(numeroletra);
                        reservarButaca(numero);
                        
                        jTextField1.setText(jTextField1.getText()+"-"+String.valueOf(numero+tomar));
                        
                    }else if(JTBotones[i][j].getText().length()== 9){
                        String numeroletra= JTBotones[i][j].getText().charAt(7)+""+JTBotones[i][j].getText().charAt(8);// Comienza desde 0
                        int numero = Integer.parseInt(numeroletra);
                        reservarButaca(numero);
                        jTextField1.setText(jTextField1.getText()+"-"+String.valueOf(numero+tomar));
                    
                    }
                    
                
                }else{
                     JTBotones[i][j].setBackground(Color.GREEN);
                     if (JTBotones[i][j].getText().length()== 8) {
                        String numeroletra= JTBotones[i][j].getText().charAt(7)+"";// Comienza desde 0
                        int numero = Integer.parseInt(numeroletra);
                        quitarreservarcionButaca(numero);
                    }else if(JTBotones[i][j].getText().length()== 9){
                        String numeroletra= JTBotones[i][j].getText().charAt(7)+""+JTBotones[i][j].getText().charAt(8);// Comienza desde 0
                        int numero = Integer.parseInt(numeroletra);
                        quitarreservarcionButaca(numero);
                    
                    }
                
                }
                }
                
                }
            
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setText("Estado de la primera función");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1007, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 204, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setText("Ubicaciones");

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setText("Ocupadas");

        jButton1.setText("Vender");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel4.setText("Libres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jButton1)
                                .addComponent(jButton2)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        Venta vender = new Venta();
        Venta.txtubicaciones.setText(jTextField1.getText());
        vender.show();
        
        
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
            java.util.logging.Logger.getLogger(PrimeraFuncionSalaA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrimeraFuncionSalaA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrimeraFuncionSalaA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrimeraFuncionSalaA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrimeraFuncionSalaA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
