package vista;

import datos.Conexion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import datos.MaterialesCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Agregar_Revista extends javax.swing.JFrame {
   Conexion co = new Conexion();
   Connection con = co.getConnection();
   
    public Agregar_Revista() throws SQLException{
        initComponents(); 
        this.setLocationRelativeTo(null);
        this.setTitle("Agregar Libro.");
        
        //DESHABILITAR BOTON CERRAR
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Usar el boton SALIR del menu inicio!", "AVISO",JOptionPane.INFORMATION_MESSAGE);
          }
        });           
        this.setTitle("Agregar revista al sistema");
        consultarEditoriales();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAgregarMenu = new javax.swing.JPanel();
        lblNewLibro = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        txtTituloRevista = new javax.swing.JTextField();
        lblTituloRevista = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        lblEditorial = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        txtPeriod = new javax.swing.JTextField();
        lblPeriodicidad = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        txtFecha = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        txtDisponible = new javax.swing.JTextField();
        lblDisponible = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        lblTituloLibro1 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        txtUbicacionCV = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlAgregarMenu.setBackground(new java.awt.Color(0, 0, 51));
        pnlAgregarMenu.setForeground(new java.awt.Color(102, 0, 204));
        pnlAgregarMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNewLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNewLibro.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLibro.setText("Agregar Revista");
        pnlAgregarMenu.add(lblNewLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));
        pnlAgregarMenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 92, -1, 170));
        pnlAgregarMenu.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 10, 440));

        jSeparator6.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator6.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 260, 10));

        jSeparator7.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator7.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 260, 10));

        txtTituloRevista.setBackground(new java.awt.Color(0, 0, 51));
        txtTituloRevista.setForeground(new java.awt.Color(102, 102, 102));
        txtTituloRevista.setText("Ingrese título");
        txtTituloRevista.setAlignmentX(0.8F);
        txtTituloRevista.setBorder(null);
        txtTituloRevista.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtTituloRevista.setMinimumSize(new java.awt.Dimension(5, 20));
        txtTituloRevista.setName("txtTituloRevista"); // NOI18N
        txtTituloRevista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTituloRevistaMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTituloRevistaMousePressed(evt);
            }
        });
        txtTituloRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloRevistaActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtTituloRevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 260, 30));

        lblTituloRevista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTituloRevista.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloRevista.setText("Título");
        lblTituloRevista.setName("llblTituloRevista"); // NOI18N
        pnlAgregarMenu.add(lblTituloRevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jSeparator10.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator10.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 260, 10));

        lblEditorial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEditorial.setForeground(new java.awt.Color(255, 255, 255));
        lblEditorial.setText("Editorial");
        lblEditorial.setName("lblEditorial"); // NOI18N
        pnlAgregarMenu.add(lblEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jSeparator12.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator12.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 260, 10));

        txtPeriod.setBackground(new java.awt.Color(0, 0, 51));
        txtPeriod.setForeground(new java.awt.Color(102, 102, 102));
        txtPeriod.setText("Ingrese Periodicidad");
        txtPeriod.setAlignmentX(0.8F);
        txtPeriod.setBorder(null);
        txtPeriod.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtPeriod.setMinimumSize(new java.awt.Dimension(5, 20));
        txtPeriod.setName("txtPeriod"); // NOI18N
        txtPeriod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPeriodMousePressed(evt);
            }
        });
        txtPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeriodActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 260, 30));

        lblPeriodicidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPeriodicidad.setForeground(new java.awt.Color(255, 255, 255));
        lblPeriodicidad.setText("Periodicidad");
        lblPeriodicidad.setName("lblPeriodicidad"); // NOI18N
        pnlAgregarMenu.add(lblPeriodicidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jSeparator13.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator13.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 260, 10));

        txtFecha.setBackground(new java.awt.Color(0, 0, 51));
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setText("dia/mes/año");
        txtFecha.setAlignmentX(0.8F);
        txtFecha.setBorder(null);
        txtFecha.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtFecha.setMinimumSize(new java.awt.Dimension(5, 20));
        txtFecha.setName("txtFecha"); // NOI18N
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaMousePressed(evt);
            }
        });
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 260, 30));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha de Publicación");
        lblFecha.setName("lblFecha"); // NOI18N
        pnlAgregarMenu.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, 20));

        jSeparator14.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator14.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 260, 10));

        txtDisponible.setBackground(new java.awt.Color(0, 0, 51));
        txtDisponible.setForeground(new java.awt.Color(102, 102, 102));
        txtDisponible.setText("Ingrese cantidad");
        txtDisponible.setAlignmentX(0.8F);
        txtDisponible.setBorder(null);
        txtDisponible.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtDisponible.setMinimumSize(new java.awt.Dimension(5, 20));
        txtDisponible.setName("txtDisponible"); // NOI18N
        txtDisponible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDisponibleMousePressed(evt);
            }
        });
        txtDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisponibleActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 260, 30));

        lblDisponible.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDisponible.setForeground(new java.awt.Color(255, 255, 255));
        lblDisponible.setText("Unidades disponibles");
        lblDisponible.setName("lblDisponible"); // NOI18N
        pnlAgregarMenu.add(lblDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, -1));

        btnAgregar.setForeground(new java.awt.Color(51, 0, 153));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.setName("btnAgregar"); // NOI18N
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });
        pnlAgregarMenu.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 393, 110, 40));

        btnCancelar.setForeground(new java.awt.Color(51, 0, 153));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-salir.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });
        pnlAgregarMenu.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 393, 110, 40));

        jComboBox3.setForeground(new java.awt.Color(0, 0, 51));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- -  - -" }));
        jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlAgregarMenu.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 260, -1));

        lblTituloLibro1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTituloLibro1.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloLibro1.setText("Ubicación");
        lblTituloLibro1.setName("lblTituloLibro"); // NOI18N
        pnlAgregarMenu.add(lblTituloLibro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, -1, -1));

        jSeparator11.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator11.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 260, 10));

        txtUbicacionCV.setBackground(new java.awt.Color(0, 0, 51));
        txtUbicacionCV.setForeground(new java.awt.Color(102, 102, 102));
        txtUbicacionCV.setText("Ingrese la ubicación");
        txtUbicacionCV.setAlignmentX(0.8F);
        txtUbicacionCV.setBorder(null);
        txtUbicacionCV.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtUbicacionCV.setMinimumSize(new java.awt.Dimension(5, 20));
        txtUbicacionCV.setName("txtTituloLibro"); // NOI18N
        txtUbicacionCV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUbicacionCVMousePressed(evt);
            }
        });
        pnlAgregarMenu.add(txtUbicacionCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 260, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAgregarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAgregarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloRevistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTituloRevistaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloRevistaMouseEntered

    private void txtTituloRevistaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTituloRevistaMousePressed
        if(txtTituloRevista.getText().equals("Ingrese título"))
             txtTituloRevista.setText("");

        if(txtPeriod.getText().equals("") || txtPeriod.getText() == null)
             txtPeriod.setText("Ingrese Periodicidad");

        if(txtFecha.getText().equals("") || txtFecha.getText() == null)
             txtFecha.setText("dia/mes/año");

        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
             txtDisponible.setText("Ingrese cantidad");

        if(txtUbicacionCV.getText().equals("") || txtUbicacionCV.getText() == null)
         txtUbicacionCV.setText("Ingrese la ubicación");
    }//GEN-LAST:event_txtTituloRevistaMousePressed

    private void txtTituloRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloRevistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloRevistaActionPerformed

    private void txtPeriodMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPeriodMousePressed
        if(txtPeriod.getText().equals("Ingrese Periodicidad"))
            txtPeriod.setText("");

        if(txtTituloRevista.getText().equals("") || txtTituloRevista.getText() == null)
            txtTituloRevista.setText("Ingrese título");

        if(txtFecha.getText().equals("") || txtFecha.getText() == null)
            txtFecha.setText("dia/mes/año");

        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");
        
        if(txtUbicacionCV.getText().equals("") || txtUbicacionCV.getText() == null)
            txtUbicacionCV.setText("Ingrese la ubicación");
    }//GEN-LAST:event_txtPeriodMousePressed

    private void txtPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeriodActionPerformed

    private void txtFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMousePressed
        if(txtFecha.getText().equals("dia/mes/año"))
            txtFecha.setText("");

        if(txtTituloRevista.getText().equals("") || txtTituloRevista.getText() == null)
            txtTituloRevista.setText("Ingrese título");

        if(txtPeriod.getText().equals("") || txtPeriod.getText() == null)
            txtPeriod.setText("Ingrese Periodicidad");

        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");
        
        if(txtUbicacionCV.getText().equals("") || txtUbicacionCV.getText() == null)
            txtUbicacionCV.setText("Ingrese la ubicación");
    }//GEN-LAST:event_txtFechaMousePressed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtDisponibleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDisponibleMousePressed
        if(txtDisponible.getText().equals("Ingrese cantidad"))
            txtDisponible.setText("");

        if(txtTituloRevista.getText().equals("") || txtTituloRevista.getText() == null)
            txtTituloRevista.setText("Ingrese título");

        if(txtPeriod.getText().equals("") || txtPeriod.getText() == null)
            txtPeriod.setText("Ingrese Periodicidad");
        
        if(txtFecha.getText().equals("") || txtFecha.getText() == null)
            txtFecha.setText("dia/mes/año");
        
        if(txtUbicacionCV.getText().equals("") || txtUbicacionCV.getText() == null)
            txtUbicacionCV.setText("Ingrese la ubicación");
    }//GEN-LAST:event_txtDisponibleMousePressed

    private void txtDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisponibleActionPerformed

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        //Comprobar que los datos no sean nulos ni vaciós
        if(txtTituloRevista.getText().equals("Ingrese título")
            || txtPeriod.getText().equals("Ingrese Periodicidad")
            || txtDisponible.getText().equals("Ingrese cantidad")
            || txtUbicacionCV.getText().equals("Ingrese la ubicación")
            || txtFecha.getText().equals("dia/mes/año")){
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                //Creación de variables que almacenan los datos introducidos
                MaterialesCRUD crud = new MaterialesCRUD();
                String titulo = txtTituloRevista.getText();
                String editorial = (String)jComboBox3.getSelectedItem();
                String period = txtPeriod.getText();
                String fecha = txtFecha.getText();
                String disponible = txtDisponible.getText();
                String ubicacion = txtUbicacionCV.getText();
                int u_disponible=0;
                
                //Variable que almacenará el incremento del id editorial
                int idEditorial = 1;
                idEditorial = incrementarIdEditorial();
                
                if(titulo == null || "".equals(titulo)
                        || editorial == null || "".equals(editorial)
                        || period == null || "".equals(period)
                        || fecha == null || "".equals(fecha)
                        || ubicacion == null || "".equals(ubicacion)
                        || disponible == null || "".equals(disponible)){
                    JOptionPane.showMessageDialog(this, "Rellenar los campos solicitados \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Convertir datos de tipo String a enteros
                    u_disponible = Integer.parseInt(disponible);
                    //Convetir dato ingresado a formato Fecha
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date conversion = null;

                    try {
                        Date fecha_publicacion = formato.parse(fecha);
                        conversion = new java.sql.Date(fecha_publicacion.getTime());
                    }catch(Exception e){
                        System.out.println("Error" + e);
                    }
                    
                    //Bloque de código para insertar información en tabla materiales
                    if(crud.insertarRevista(titulo, editorial, period, conversion, u_disponible, ubicacion)>=1){
                        //Llamada al método limpiar campos
                        limpiarCampos();
                        //Cerrar ventana
                        JOptionPane.showMessageDialog(this, "Datos ingresados correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                        Dashboard dash = new Dashboard();
                        dash.setVisible(true);
                        this.dispose();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Agregar_Revista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregarMousePressed

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        // TODO add your handling code here:
        try {
            Menu_Tipo_Material tipo = new Menu_Tipo_Material();
            tipo.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Agregar_Revista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelarMousePressed

    private void txtUbicacionCVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUbicacionCVMousePressed
        if(txtUbicacionCV.getText().equals("Ingrese la ubicación"))
            txtUbicacionCV.setText("");
        
        if(txtTituloRevista.getText().equals("") || txtTituloRevista.getText() == null)
            txtTituloRevista.setText("Ingrese título");

        if(txtPeriod.getText().equals("") || txtPeriod.getText() == null)
            txtPeriod.setText("Ingrese Periodicidad");
        
        if(txtFecha.getText().equals("") || txtFecha.getText() == null)
            txtFecha.setText("dia/mes/año");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");
    }//GEN-LAST:event_txtUbicacionCVMousePressed
    
    public int insertarEditorial(int idEditorial, String editorial){
        String sql = "INSERT INTO editoriales (id,nombre_editorial) values (?,?)";
        PreparedStatement stmt = null;
        //ResultSet rs = null;
        int rows = 0;

        try{
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            int index = 1;
            stmt.setInt(index++, idEditorial);
            stmt.setString(index, editorial);

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados " + rows);
        }catch(SQLException e){
            System.out.println("error" + e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }
    
    public int consultarEditoriales(){
        String sql = "SELECT id, nombre_editorial FROM EDITORIALES;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String nombreEditorial = rs.getString("nombre_editorial");
                jComboBox3.addItem(nombreEditorial);
            }   
        } catch (Exception e) {
            Logger.getLogger(Agregar_Libro.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return id;
    }
    
    public void limpiarCampos(){
        txtTituloRevista.setText("");
        txtPeriod.setText("");
        txtFecha.setText("");
        txtDisponible.setText("");
    }
    
    public int incrementarIdEditorial() throws SQLException{
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexion.getConnection();
        try{
            ps = con.prepareStatement("SELECT MAX(id) FROM editoriales");
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1) + 1;
            }
        }catch(SQLException e){
            System.out.println("Error: " + e);
        } finally{
            Conexion.close(con);
            Conexion.close(ps);
            Conexion.close(rs);
        }
        return id;
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
            java.util.logging.Logger.getLogger(Agregar_Revista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_Revista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_Revista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_Revista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    new Agregar_Revista().setVisible(true);    
                 } catch (SQLException ex) {
                    Logger.getLogger(Agregar_Revista.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblDisponible;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNewLibro;
    private javax.swing.JLabel lblPeriodicidad;
    private javax.swing.JLabel lblTituloLibro1;
    private javax.swing.JLabel lblTituloRevista;
    private javax.swing.JPanel pnlAgregarMenu;
    private javax.swing.JTextField txtDisponible;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPeriod;
    private javax.swing.JTextField txtTituloRevista;
    private javax.swing.JTextField txtUbicacionCV;
    // End of variables declaration//GEN-END:variables
}
