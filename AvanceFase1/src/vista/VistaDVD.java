package vista;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import datos.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaDVD extends javax.swing.JFrame {

    public VistaDVD() throws SQLException {
        initComponents();
        this.setTitle("DVD en sistema");
        this.setLocationRelativeTo(null);
        EditarDVD();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDVD = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        lblCD = new javax.swing.JLabel();
        btnAtras1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDVD.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tblDVD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDVD);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 900, -1));

        btnUpdate.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnUpdate.setBorder(null);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUpdate.setLabel("Actualizar");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUpdateMousePressed(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 90, 40));

        lblCD.setBackground(new java.awt.Color(255, 255, 255));
        lblCD.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        lblCD.setForeground(new java.awt.Color(255, 255, 255));
        lblCD.setText("DVD- Biblioteca");
        jPanel1.add(lblCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        btnAtras1.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnAtras1.setText("Atrás");
        btnAtras1.setBorder(null);
        btnAtras1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtras1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAtras1MousePressed(evt);
            }
        });
        btnAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Abrir formulario para editar CD
    private void btnUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMousePressed
        try{
            //verificamos si hay algun registro seleccionado, si no mostramos un error
            if(this.tblDVD.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null,"Debe seleccionar un registro para poder actualizar datos!");
            }
            else{
                //Seleccionamos numero de registro seleccionado
                int linea = this.tblDVD.getSelectedRow();
                int modelRow = tblDVD.convertRowIndexToModel(linea);
                String s = tblDVD.getModel().getValueAt(modelRow, 0)+"";

                EditarCD cd = new EditarCD(s);
                cd.setVisible(true);
                this.dispose();               
            }

        } catch (SQLException e){
            System.out.println("ERROR. " +e);
        }
    }//GEN-LAST:event_btnUpdateMousePressed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAtras1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtras1MousePressed
        // TODO add your handling code here:
        ElegirVistaMateriales vista = new ElegirVistaMateriales();
        vista.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_btnAtras1MousePressed

    private void btnAtras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtras1ActionPerformed

    public void EditarDVD() throws SQLException{
       PreparedStatement ps = null;
       ResultSet rs = null;
       Conexion conn = new Conexion();
       Connection con = conn.getConnection();
       
       try{
           String sql = "SELECT materiales.id, materiales.titulo, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=2";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           int cont = 0;
           while(rs.next()){
               cont++;
           }
           
           String list [][] = new String [cont][6];
           int i = 0;
           ResultSet re = ps.executeQuery("SELECT materiales.id, materiales.titulo, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=2");
           while(re.next()){
               list[i][0] = re.getString("id");
               list[i][1] = re.getString("titulo");
               list[i][2] = re.getString("Tipo");
               list[i][3] = re.getString("Director");
               list[i][4] = re.getString("Genero");
               list[i][5] = re.getString("duracion");
               i++;
           }
           tblDVD.setModel(new DefaultTableModel(
           list,
                new String[]{
                    "ID", "Título","Material","Director","Género", "Duración"
                }
           ));
           
       } catch(SQLException e){
           System.out.println("ERROR: " + e);
       } finally {
           Conexion.close(con);
           Conexion.close(ps);
           Conexion.close(rs);
       }
    }
    
    
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
            java.util.logging.Logger.getLogger(VistaDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaDVD().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaDVD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCD;
    private javax.swing.JTable tblDVD;
    // End of variables declaration//GEN-END:variables
}
