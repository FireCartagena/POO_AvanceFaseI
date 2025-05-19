package vista;

import datos.Conexion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import datos.MaterialesCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Agregar_CD extends javax.swing.JFrame {

   Conexion co = new Conexion();
   Connection con = co.getConnection();
   
    public Agregar_CD()throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Agregar CD al sistema");
        
        //DESHABILITAR BOTON CERRAR
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Usar el boton SALIR del menu inicio!", "AVISO",JOptionPane.INFORMATION_MESSAGE);
          }
        });           
        consultarArtista();
        consultarGenero();
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
        txtTituloCd = new javax.swing.JTextField();
        lblTitulocd = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        lblArtista = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        lblGenero = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        txtDuracion = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        txtCanciones = new javax.swing.JTextField();
        lblCanciones = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JSeparator();
        txtFecha = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        txtDisponible = new javax.swing.JTextField();
        lblDisponible = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        lblCanciones1 = new javax.swing.JLabel();
        lblTituloLibro1 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        txtUbicacionCV = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlAgregarMenu.setBackground(new java.awt.Color(0, 0, 51));
        pnlAgregarMenu.setForeground(new java.awt.Color(102, 0, 204));
        pnlAgregarMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNewLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNewLibro.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLibro.setText("Agregar CD");
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

        txtTituloCd.setBackground(new java.awt.Color(0, 0, 51));
        txtTituloCd.setForeground(new java.awt.Color(102, 102, 102));
        txtTituloCd.setText("Ingrese título");
        txtTituloCd.setAlignmentX(0.8F);
        txtTituloCd.setBorder(null);
        txtTituloCd.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtTituloCd.setMinimumSize(new java.awt.Dimension(5, 20));
        txtTituloCd.setName("txtTituloCd"); // NOI18N
        txtTituloCd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTituloCdMousePressed(evt);
            }
        });
        pnlAgregarMenu.add(txtTituloCd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 260, 30));

        lblTitulocd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulocd.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulocd.setText("Título");
        lblTitulocd.setName("llblTituloRevista"); // NOI18N
        pnlAgregarMenu.add(lblTitulocd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jSeparator10.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator10.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 260, 10));

        lblArtista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArtista.setForeground(new java.awt.Color(255, 255, 255));
        lblArtista.setText("Artista");
        lblArtista.setName("lblArtista"); // NOI18N
        pnlAgregarMenu.add(lblArtista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jSeparator12.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator12.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 260, 10));

        lblGenero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Género");
        lblGenero.setName("lblGenero"); // NOI18N
        pnlAgregarMenu.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jSeparator13.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator13.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 260, 10));

        txtDuracion.setBackground(new java.awt.Color(0, 0, 51));
        txtDuracion.setForeground(new java.awt.Color(102, 102, 102));
        txtDuracion.setText("Ingrese duracion");
        txtDuracion.setAlignmentX(0.8F);
        txtDuracion.setBorder(null);
        txtDuracion.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtDuracion.setMinimumSize(new java.awt.Dimension(5, 20));
        txtDuracion.setName("txtDuracion"); // NOI18N
        txtDuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDuracionMousePressed(evt);
            }
        });
        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 260, 30));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Duración (En minutos)");
        lblFecha.setName("lblFecha"); // NOI18N
        pnlAgregarMenu.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 20));

        jSeparator14.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator14.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 260, 10));

        txtCanciones.setBackground(new java.awt.Color(0, 0, 51));
        txtCanciones.setForeground(new java.awt.Color(102, 102, 102));
        txtCanciones.setText("Ingrese canciones");
        txtCanciones.setAlignmentX(0.8F);
        txtCanciones.setBorder(null);
        txtCanciones.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtCanciones.setMinimumSize(new java.awt.Dimension(5, 20));
        txtCanciones.setName("txtCanciones"); // NOI18N
        txtCanciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCancionesMousePressed(evt);
            }
        });
        txtCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCancionesActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtCanciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 260, 30));

        lblCanciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCanciones.setForeground(new java.awt.Color(255, 255, 255));
        lblCanciones.setText("Número de canciones");
        lblCanciones.setName("lblCanciones"); // NOI18N
        pnlAgregarMenu.add(lblCanciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

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
        pnlAgregarMenu.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 110, 40));

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
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 110, 40));

        jSeparator15.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator15.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 260, 10));

        txtFecha.setBackground(new java.awt.Color(0, 0, 51));
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setText("Ingrese fecha de pulicación (dia/mes/año)");
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
        pnlAgregarMenu.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 260, 30));

        jSeparator16.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator16.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 260, 10));

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- -  - -" }));
        pnlAgregarMenu.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 260, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- -  - -" }));
        pnlAgregarMenu.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 260, -1));

        lblCanciones1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCanciones1.setForeground(new java.awt.Color(255, 255, 255));
        lblCanciones1.setText("Fecha de publicación");
        lblCanciones1.setName("lblCanciones"); // NOI18N
        pnlAgregarMenu.add(lblCanciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, -1, -1));

        lblTituloLibro1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTituloLibro1.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloLibro1.setText("Ubicación");
        lblTituloLibro1.setName("lblTituloLibro"); // NOI18N
        pnlAgregarMenu.add(lblTituloLibro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, -1, -1));

        jSeparator11.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator11.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 260, 10));

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
        pnlAgregarMenu.add(txtUbicacionCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 260, 30));

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

    private void txtTituloCdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTituloCdMousePressed
        if(txtTituloCd.getText().equals("Ingrese título"))
            txtTituloCd.setText("");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");

        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");

        if(txtFecha.getText().equals("") || txtFecha.getText() == null)
            txtFecha.setText("Ingrese fecha de pulicación (dia/mes/año))");
                      
       if(txtUbicacionCV.getText().equals("") || txtUbicacionCV.getText() == null)
        txtUbicacionCV.setText("Ingrese la ubicación");
    }//GEN-LAST:event_txtTituloCdMousePressed

    private void txtDuracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuracionMousePressed
        // TODO add your handling code here:

        if(txtDuracion.getText().equals("Ingrese duracion"))
            txtDuracion.setText("");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");

        if(txtFecha.getText().equals("") || txtFecha.getText() == null)
        txtFecha.setText("Ingrese fecha de pulicación (dia/mes/año))");
                      
       if(txtUbicacionCV.getText().equals("") || txtUbicacionCV.getText() == null)
        txtUbicacionCV.setText("Ingrese la ubicación");
    }//GEN-LAST:event_txtDuracionMousePressed

    private void txtDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionActionPerformed

    private void txtCancionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCancionesMousePressed
        // TODO add your handling code here:

        if(txtCanciones.getText().equals("Ingrese canciones"))
            txtCanciones.setText("");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");

        if(txtFecha.getText().equals("") || txtFecha.getText() == null)
        txtFecha.setText("Ingrese fecha de pulicación (dia/mes/año))");
                      
       if(txtUbicacionCV.getText().equals("") || txtUbicacionCV.getText() == null)
        txtUbicacionCV.setText("Ingrese la ubicación");
    }//GEN-LAST:event_txtCancionesMousePressed

    private void txtCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCancionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCancionesActionPerformed

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed

        //Comprobar que los datos no sean nulos ni vaciós
        if(txtTituloCd.getText().equals("Ingrese título")
            || txtCanciones.getText().equals("Ingrese canciones")
            || txtDuracion.getText().equals("Ingrese duracion")
            || txtDisponible.getText().equals("Ingrese cantidad")
            || txtUbicacionCV.getText().equals("Ingrese la ubicación")
            || txtFecha.getText().equals("Ingrese fecha de pulicación (dia/mes/año))")){
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                //Creación de variables que almacenan los datos introducidos
                MaterialesCRUD crud = new MaterialesCRUD();
                String titulo = txtTituloCd.getText();
                String artista = (String)jComboBox1.getSelectedItem();
                String genre = (String)jComboBox2.getSelectedItem();
                String duracion = txtDuracion.getText();
                String canciones = txtCanciones.getText();
                String disponible = txtDisponible.getText();
                String fecha = txtFecha.getText();
                String ubicacion = txtUbicacionCV.getText();
                int u_disponible=0;
                int num_canciones = 0;

                //Variable que almacenará el incremento del id artista y género
                int idArtista = 1;
                idArtista = incrementarArtista();
                
                int idGenero = 1;
                idGenero = incrementarGenero();

                //Condicional que evalua si se ha ingresado 8 caracteres dentro del apartado ID
                //if(id.length()== 8){
                    //Condicional que lanza mensaje de error si hay algún dato con tipo erróneo
                    if( titulo == null || "".equals(titulo)
                        || artista == null || "".equals(artista)
                        || genre == null || "".equals(genre)
                        || duracion == null || "".equals(duracion)
                        || canciones == null || "".equals(canciones)
                        || disponible == null || "".equals(disponible)
                        || ubicacion == null || "".equals(ubicacion)
                        || fecha == null || "".equals(fecha)){
                        JOptionPane.showMessageDialog(this, "Rellenar los campos solicitados \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    } else {

                        //Convertir datos de tipo String a enteros
                        u_disponible = Integer.parseInt(disponible);
                        num_canciones = Integer.parseInt(canciones);
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        java.sql.Date conversion = null;
                        Date fecha_publicacion;
                        
                        try {
                            fecha_publicacion = formato.parse(fecha);
                            conversion = new java.sql.Date(fecha_publicacion.getTime());
                        } catch (ParseException ex) {
                            Logger.getLogger(Agregar_CD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //Bloque de código para insertar información en tabla materiales
                        if(crud.insertarCD(titulo, duracion, canciones, u_disponible, artista, genre, conversion, ubicacion)>=1){

                            //Llamada al método limpiar campos
                        limpiarCampos();

                        //Cerrar ventana
                        JOptionPane.showMessageDialog(this, "Datos ingresados correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                        Dashboard dash = new Dashboard();
                        dash.setVisible(true);
                        this.dispose();
                        }
                    }
                /*}else if(id.length()<8) {
                    JOptionPane.showMessageDialog(this, "Error en Campo ID. Pocos caracteres. Debe tener 8 caracteres \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                } else if(id.length()>8){
                    JOptionPane.showMessageDialog(this, "Error en Campo ID. Excede de 8 caracteres \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }*/
            } catch (SQLException ex) {
                Logger.getLogger(Agregar_CD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Agregar_CD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelarMousePressed

    private void txtFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMousePressed

        if(txtFecha.getText().equals("Ingrese fecha de pulicación (dia/mes/año)"))
            txtFecha.setText("");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");
        
        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
        txtCanciones.setText("Ingrese canciones");
        
         if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");
                       
       if(txtUbicacionCV.getText().equals("") || txtUbicacionCV.getText() == null)
        txtUbicacionCV.setText("Ingrese la ubicación");
    }//GEN-LAST:event_txtFechaMousePressed

    private void txtDisponibleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDisponibleMousePressed

        if(txtDisponible.getText().equals("Ingrese cantidad"))
            txtDisponible.setText("");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");
        
        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");

        if(txtFecha.getText().equals("") || txtFecha.getText() == null)
            txtFecha.setText("Ingrese fecha de pulicación (dia/mes/año)");
        
        if(txtUbicacionCV.getText().equals("") || txtUbicacionCV.getText() == null)
         txtUbicacionCV.setText("Ingrese la ubicación");
    }//GEN-LAST:event_txtDisponibleMousePressed

    private void txtDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisponibleActionPerformed

    private void txtUbicacionCVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUbicacionCVMousePressed
        if(txtUbicacionCV.getText().equals("Ingrese la ubicación"))
        txtUbicacionCV.setText("");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");
        
        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");

        if(txtFecha.getText().equals("") || txtFecha.getText() == null)
            txtFecha.setText("Ingrese fecha de pulicación (dia/mes/año)");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");
    }//GEN-LAST:event_txtUbicacionCVMousePressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    public int incrementarArtista() throws SQLException{
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexion.getConnection();
        try{
            ps = con.prepareStatement("SELECT MAX(id) FROM artistas");
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
    
    public void consultarArtista(){
        String sql = "SELECT nombre_artista FROM ARTISTAS;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String nombreArtista = rs.getString("nombre_artista");
                jComboBox1.addItem(nombreArtista);
            }
            
        } catch (Exception e) {
            Logger.getLogger(Agregar_CD.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }
    
    public void consultarGenero(){
        String sql = "SELECT nombre_genero FROM GENEROS;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String nombreGenero = rs.getString("nombre_genero");
                jComboBox2.addItem(nombreGenero);
            }
            
        } catch (Exception e) {
            Logger.getLogger(Agregar_CD.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }
    
    public int incrementarGenero() throws SQLException{
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexion.getConnection();
        try{
            ps = con.prepareStatement("SELECT MAX(id) FROM generos");
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
    
    public void limpiarCampos(){
        txtTituloCd.setText("");
        txtDuracion.setText("");
        txtCanciones.setText("");
        txtDisponible.setText("");
        txtFecha.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblArtista;
    private javax.swing.JLabel lblCanciones;
    private javax.swing.JLabel lblCanciones1;
    private javax.swing.JLabel lblDisponible;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNewLibro;
    private javax.swing.JLabel lblTituloLibro1;
    private javax.swing.JLabel lblTitulocd;
    private javax.swing.JPanel pnlAgregarMenu;
    private javax.swing.JTextField txtCanciones;
    private javax.swing.JTextField txtDisponible;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTituloCd;
    private javax.swing.JTextField txtUbicacionCV;
    // End of variables declaration//GEN-END:variables
}
