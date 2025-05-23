/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import datos.Conexion;
import datos.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Pagar_Deuda extends javax.swing.JFrame {

    Conexion conn = new Conexion();
    Connection con = conn.getConnection();
    Prestamo pres = new Prestamo();

    public Pagar_Deuda() throws SQLException {
        initComponents();
        verDeuda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMora = new javax.swing.JTable();
        btnPagar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMora.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMora);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 440, 210));

        btnPagar.setBackground(new java.awt.Color(0, 102, 204));
        btnPagar.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar");
        btnPagar.setBorder(null);
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 70, 30));

        btnCancelar.setBackground(new java.awt.Color(255, 0, 51));
        btnCancelar.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tblMora.getSelectedRow();
            String user = tblMora.getValueAt(fila, 2).toString();

            //Condiciones
            if (!pres.existeUsuario(user)) {
                JOptionPane.showMessageDialog(this, "No existe usuario con ese Nickname. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            } else if (user.equals("") || user == null) {
                JOptionPane.showMessageDialog(this, "Campos vacíos. \n", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            int idUser = 0;
            float mora = 0;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            //Sentencia para seleccionar el id del usuario y almacenarlo en variable
            //Variable se pasará como parámetro del insert
            stmt = con.prepareStatement("SELECT usuarios.id FROM usuarios WHERE usuarios.nickname = '" + user + "'");
            rs = stmt.executeQuery();
            if (rs.next()) {
                idUser = rs.getInt("id");
            }
            
            stmt = con.prepareStatement("UPDATE usuarios SET mora='" + mora + "' WHERE usuarios.id='" + idUser + "'");
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "DEUDA CANCELADA. USUARIO SIN MORA \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            verDeuda();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        // TODO add your handling code here:
        Menu_Prestamos menu = new Menu_Prestamos();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarMousePressed

    public void verDeuda() throws SQLException {
        //Variables a utilizar
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //Sentencia que permite seleccionar datos de los uauarios que tienen una deuda
            String sql = "SELECT usuarios.nombre, usuarios.apellido, usuarios.nickname, usuarios.mora FROM usuarios";

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(); //Ejecución

            //Contador que ayuda a recorrer uno a uno las filas de la lista
            int count = 0;
            while (rs.next()) {
                count++;
            }

            String lista[][] = new String[count][4];
            int i = 0;
            ResultSet re = stmt.executeQuery("SELECT usuarios.nombre, usuarios.apellido, usuarios.nickname, usuarios.mora FROM usuarios");
            while (re.next()) {
                lista[i][0] = re.getString("nombre");
                lista[i][1] = re.getString("apellido");
                lista[i][2] = re.getString("nickname");
                lista[i][3] = re.getString("mora");
                i++;
            }

            //Ingresar los dtaos en la tabla
            tblMora.setModel(new DefaultTableModel(
                    lista,
                    new String[]{
                        "Nombre", "Apellido", "Nickname", "Mora",}));
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        } finally {

        }
    }

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
            java.util.logging.Logger.getLogger(Pagar_Deuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagar_Deuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagar_Deuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagar_Deuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pagar_Deuda().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Pagar_Deuda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMora;
    // End of variables declaration//GEN-END:variables
}
