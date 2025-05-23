package vista;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class EditarCD extends javax.swing.JFrame {

   Conexion co = new Conexion();
   Connection con = co.getConnection();
   
   public EditarCD(String codigo)throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Editar CD");
        
       //Crear conexion y llamar datos 
       PreparedStatement ps = null;
       ResultSet rs = null;
       Conexion conn = new Conexion();
       Connection con = conn.getConnection();
       
       try{
           String sql = "SELECT materiales.id, materiales.titulo, artistas.nombre_artista as Artista, generos.nombre_genero AS Genero, materiales.duracion, materiales.numero_de_canciones, materiales.unidades_disponibles, tipo_material.tipo_material AS Tipo from materiales LEFT JOIN artistas on artistas.id = materiales.codigo_artista LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material WHERE materiales.id ='"+codigo+"'";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           if(rs.next()){           
                txtIdCd.setText(rs.getString("id"));
                txtTituloCd.setText(rs.getString("titulo"));
                txtArtista.setText(rs.getString("Artista"));
                txtGenero.setText(rs.getString("Genero"));
                txtCanciones.setText(rs.getString("numero_de_canciones"));
                txtDuracion.setText(rs.getString("duracion"));
                txtDisponible.setText(rs.getString("unidades_disponibles"));
                txtTipo.setText(rs.getString("Tipo"));
           }
         
       } catch(Exception e){
           System.out.println(e);
       } finally {
           Conexion.close(con);
           Conexion.close(ps);
           Conexion.close(rs);
       }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAgregarMenu = new javax.swing.JPanel();
        txtIdCd = new javax.swing.JTextField();
        lblCD = new javax.swing.JLabel();
        lblNewLibro = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        txtTituloCd = new javax.swing.JTextField();
        lblTitulocd = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtArtista = new javax.swing.JTextField();
        lblArtista = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        txtGenero = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        txtDuracion = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        txtCanciones = new javax.swing.JTextField();
        lblCanciones = new javax.swing.JLabel();
        btnActualizarCD = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JSeparator();
        txtTipo = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        txtDisponible = new javax.swing.JTextField();
        lblDisponible = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlAgregarMenu.setBackground(new java.awt.Color(0, 0, 51));
        pnlAgregarMenu.setForeground(new java.awt.Color(102, 0, 204));
        pnlAgregarMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdCd.setBackground(new java.awt.Color(0, 0, 51));
        txtIdCd.setForeground(new java.awt.Color(102, 102, 102));
        txtIdCd.setText("Ingrese ID de CD");
        txtIdCd.setAlignmentX(0.8F);
        txtIdCd.setBorder(null);
        txtIdCd.setEnabled(false);
        txtIdCd.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtIdCd.setMinimumSize(new java.awt.Dimension(5, 20));
        txtIdCd.setName("txtIdCd"); // NOI18N
        txtIdCd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIdCdMousePressed(evt);
            }
        });
        txtIdCd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCdActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtIdCd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 260, 30));

        lblCD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCD.setForeground(new java.awt.Color(255, 255, 255));
        lblCD.setText("CD ID");
        lblCD.setName("lblCD"); // NOI18N
        pnlAgregarMenu.add(lblCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblNewLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNewLibro.setForeground(new java.awt.Color(255, 255, 255));
        lblNewLibro.setText("Editar CD");
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
        pnlAgregarMenu.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 260, 10));

        txtTituloCd.setBackground(new java.awt.Color(0, 0, 51));
        txtTituloCd.setForeground(new java.awt.Color(102, 102, 102));
        txtTituloCd.setText("Ingrese título");
        txtTituloCd.setAlignmentX(0.8F);
        txtTituloCd.setBorder(null);
        txtTituloCd.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtTituloCd.setMinimumSize(new java.awt.Dimension(5, 20));
        txtTituloCd.setName("txtTituloCd"); // NOI18N
        txtTituloCd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTituloCdMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTituloCdMousePressed(evt);
            }
        });
        txtTituloCd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloCdActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtTituloCd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 260, 30));

        lblTitulocd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulocd.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulocd.setText("Título");
        lblTitulocd.setName("llblTituloRevista"); // NOI18N
        pnlAgregarMenu.add(lblTitulocd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jSeparator10.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator10.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 260, 10));

        txtArtista.setBackground(new java.awt.Color(0, 0, 51));
        txtArtista.setForeground(new java.awt.Color(102, 102, 102));
        txtArtista.setText("Ingrese artista");
        txtArtista.setAlignmentX(0.8F);
        txtArtista.setBorder(null);
        txtArtista.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtArtista.setMinimumSize(new java.awt.Dimension(5, 20));
        txtArtista.setName("txtArtista"); // NOI18N
        txtArtista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtArtistaMousePressed(evt);
            }
        });
        txtArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtistaActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtArtista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 260, 30));

        lblArtista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArtista.setForeground(new java.awt.Color(255, 255, 255));
        lblArtista.setText("Artista");
        lblArtista.setName("lblArtista"); // NOI18N
        pnlAgregarMenu.add(lblArtista, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jSeparator12.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator12.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 260, 10));

        txtGenero.setBackground(new java.awt.Color(0, 0, 51));
        txtGenero.setForeground(new java.awt.Color(102, 102, 102));
        txtGenero.setText("Ingrese genero");
        txtGenero.setAlignmentX(0.8F);
        txtGenero.setBorder(null);
        txtGenero.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtGenero.setMinimumSize(new java.awt.Dimension(5, 20));
        txtGenero.setName("txtGenero"); // NOI18N
        txtGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtGeneroMousePressed(evt);
            }
        });
        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 260, 30));

        lblGenero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Género");
        lblGenero.setName("lblGenero"); // NOI18N
        pnlAgregarMenu.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jSeparator13.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator13.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 260, 10));

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
        pnlAgregarMenu.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 260, 30));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Duración");
        lblFecha.setName("lblFecha"); // NOI18N
        pnlAgregarMenu.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, 20));

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

        btnActualizarCD.setForeground(new java.awt.Color(51, 0, 153));
        btnActualizarCD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-agregar.png"))); // NOI18N
        btnActualizarCD.setText("Actualizar");
        btnActualizarCD.setBorder(null);
        btnActualizarCD.setName("btnActualizarCD"); // NOI18N
        btnActualizarCD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnActualizarCDMousePressed(evt);
            }
        });
        btnActualizarCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCDActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(btnActualizarCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 110, 40));

        btnCancelar.setForeground(new java.awt.Color(51, 0, 153));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-salir.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
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

        txtTipo.setBackground(new java.awt.Color(0, 0, 51));
        txtTipo.setForeground(new java.awt.Color(102, 102, 102));
        txtTipo.setText("Ingrese tipo material");
        txtTipo.setAlignmentX(0.8F);
        txtTipo.setBorder(null);
        txtTipo.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtTipo.setMinimumSize(new java.awt.Dimension(5, 20));
        txtTipo.setName("txtTipo"); // NOI18N
        txtTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTipoMousePressed(evt);
            }
        });
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 260, 30));

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("Tipo material");
        lblTipo.setName("lblTipo"); // NOI18N
        pnlAgregarMenu.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, -1, -1));

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

    private void txtIdCdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdCdMousePressed
        // TODO add your handling code here:
//        if(txtIdCd.getText().equals("Ingrese ID de Revista"));
//            txtIdCd.setText("");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtArtista.getText().equals("") || txtArtista.getText() == null)
            txtArtista.setText("Ingrese artista");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duración");

        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
            txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtIdCdMousePressed

    private void txtIdCdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCdActionPerformed

    private void txtTituloCdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTituloCdMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloCdMouseEntered

    private void txtTituloCdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTituloCdMousePressed
        // TODO add your handling code here:

        if(txtTituloCd.getText().equals("Ingrese título"))
            txtTituloCd.setText("");

        if(txtIdCd.getText().equals("") || txtIdCd.getText() == null)
            txtIdCd.setText("Ingrese ID de CD");

        if(txtArtista.getText().equals("") || txtArtista.getText() == null)
            txtArtista.setText("Ingrese artista");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");

        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
        txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtTituloCdMousePressed

    private void txtTituloCdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloCdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloCdActionPerformed

    private void txtArtistaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtArtistaMousePressed
        // TODO add your handling code here:

        if(txtArtista.getText().equals("Ingrese artista"))
            txtArtista.setText("");

        if(txtIdCd.getText().equals("") || txtIdCd.getText() == null)
            txtIdCd.setText("Ingrese ID de CD");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");

        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
        txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtArtistaMousePressed

    private void txtArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArtistaActionPerformed

    private void txtGeneroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGeneroMousePressed
        // TODO add your handling code here:

        if(txtGenero.getText().equals("Ingrese genero"))
            txtGenero.setText("");

        if(txtIdCd.getText().equals("") || txtIdCd.getText() == null)
            txtIdCd.setText("Ingrese ID de CD");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtArtista.getText().equals("") || txtArtista.getText() == null)
            txtArtista.setText("Ingrese artista");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");

        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
        txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtGeneroMousePressed

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    private void txtDuracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuracionMousePressed
        // TODO add your handling code here:

        if(txtDuracion.getText().equals("Ingrese duracion"))
            txtDuracion.setText("");

        if(txtIdCd.getText().equals("") || txtIdCd.getText() == null)
            txtIdCd.setText("Ingrese ID de CD");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtArtista.getText().equals("") || txtArtista.getText() == null)
            txtArtista.setText("Ingrese artista");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
        txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtDuracionMousePressed

    private void txtDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionActionPerformed

    private void txtCancionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCancionesMousePressed
        // TODO add your handling code here:

        if(txtCanciones.getText().equals("Ingrese canciones"))
            txtCanciones.setText("");

        if(txtIdCd.getText().equals("") || txtIdCd.getText() == null)
            txtIdCd.setText("Ingrese ID de CD");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtArtista.getText().equals("") || txtArtista.getText() == null)
            txtArtista.setText("Ingrese artista");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");
        
        if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
        txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtCancionesMousePressed

    private void txtCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCancionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCancionesActionPerformed

    private void btnActualizarCDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarCDMousePressed

        //Comprobar que los datos no sean nulos ni vaciós
        if(txtIdCd.getText().equals("Ingrese ID de CD") || txtTituloCd.getText().equals("Ingrese título")
            || txtArtista.getText().equals("Ingrese artista")
            || txtGenero.getText().equals("Ingrese genero")|| txtCanciones.getText().equals("Ingrese canciones")
            || txtDuracion.getText().equals("Ingrese duracion")
            || txtDisponible.getText().equals("Ingrese cantidad")
            || txtTipo.getText().equals("Ingrese tipo material")){
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtIdCd.requestFocus();
        } else {

            try {
                //Creación de variables que almacenan los datos introducidos
                String id = txtIdCd.getText();
                String titulo = txtTituloCd.getText();
                String artista = txtArtista.getText();
                String genre = txtGenero.getText();
                String duracion = txtDuracion.getText();
                String canciones = txtCanciones.getText();
                String disponible = txtDisponible.getText();
                String tipo = txtTipo.getText();
                int u_disponible=0;
                int num_canciones = 0;

                //Variable que almacenará el incremento del id artista y género
                int idArtista = 1;
                idArtista = incrementarArtista();
                
                int idGenero = 1;
                idGenero = incrementarGenero();

                //Condicional que evalua si se ha ingresado 8 caracteres dentro del apartado ID
                if(id.length()== 8){
                    //Condicional que lanza mensaje de error si hay algún dato con tipo erróneo
                    if(id == null || "".equals(id)
                        || titulo == null || "".equals(titulo)
                        || artista == null || "".equals(artista)
                        || genre == null || "".equals(genre)
                        || duracion == null || "".equals(duracion)
                        || canciones == null || "".equals(canciones)
                        || disponible == null || "".equals(disponible) 
                        || tipo == null || "".equals(tipo)){
                        JOptionPane.showMessageDialog(this, "Rellenar los campos solicitados \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                        txtIdCd.requestFocus();
                    } else {

                        //Convertir datos de tipo String a enteros
                        u_disponible = Integer.parseInt(disponible);
                        num_canciones = Integer.parseInt(canciones);

                        //Llamar a los siguientes métodos, pasándole parámetros
                        insertarArtista(idArtista, artista);
                        insertarGenero(idGenero, genre);

                        //Bloque de código para insertar información en tabla materiales
                        String sql = "UPDATE materiales SET titulo = ?,codigo_artista = ?,codigo_genero = ?,duracion = ?,numero_de_canciones = ?,unidades_disponibles = ? WHERE id ='"+id+"'";
                        PreparedStatement stmt = null;
                        //ResultSet rs = null;
                        int rows = 0;

                        try{
                            con = Conexion.getConnection();
                            stmt = con.prepareStatement(sql);
                            int index = 1;
                            //stmt.setString(index++, id);
                            stmt.setString(index++, titulo);
                            stmt.setInt(index++, idArtista);
                            stmt.setInt(index++, idGenero);
                            stmt.setString(index++, duracion);
                            stmt.setString(index++, canciones);
                            stmt.setInt(index, u_disponible);

                            rows = stmt.executeUpdate();
                            System.out.println("Registros afectados " + rows);
                        }catch(SQLException e){
                            System.out.println("Error" + e);
                        } finally{
                            Conexion.close(stmt);
                            Conexion.close(con);
                        }
                        //Llamada al método limpiar campos
                        limpiarCampos();

                        //Cerrar ventana
                        JOptionPane.showMessageDialog(this, "Datos ingresados correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                        Dashboard dash = new Dashboard();
                        dash.setVisible(true);
                        this.dispose();
                    }
                }else if(id.length()<8) {
                    JOptionPane.showMessageDialog(this, "Error en Campo ID. Pocos caracteres. Debe tener 8 caracteres \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                } else if(id.length()>8){
                    JOptionPane.showMessageDialog(this, "Error en Campo ID. Excede de 8 caracteres \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Agregar_CD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnActualizarCDMousePressed

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        // TODO add your handling code here:
        try{
            VistaCD cd = new VistaCD();
            cd.setVisible(true);
            this.dispose();
        } catch (SQLException e){
            System.out.println("ERROR. " +e);
        }
    }//GEN-LAST:event_btnCancelarMousePressed

    private void txtTipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTipoMousePressed

        if(txtTipo.getText().equals("Ingrese tipo material"))
            txtTipo.setText("");

//        if(txtIdCd.getText().equals("") || txtIdCd.getText() == null)
//            txtIdCd.setText("Ingrese ID de CD");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtArtista.getText().equals("") || txtArtista.getText() == null)
            txtArtista.setText("Ingrese artista");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");
        
        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
        txtCanciones.setText("Ingrese canciones");
        
         if(txtDisponible.getText().equals("") || txtDisponible.getText() == null)
            txtDisponible.setText("Ingrese cantidad");
    }//GEN-LAST:event_txtTipoMousePressed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtDisponibleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDisponibleMousePressed
        // TODO add your handling code here:

        if(txtDisponible.getText().equals("Ingrese cantidad"))
            txtDisponible.setText("");

        if(txtIdCd.getText().equals("") || txtIdCd.getText() == null)
            txtIdCd.setText("Ingrese ID de CD");

        if(txtTituloCd.getText().equals("") || txtTituloCd.getText() == null)
            txtTituloCd.setText("Ingrese título");

        if(txtArtista.getText().equals("") || txtArtista.getText() == null)
            txtArtista.setText("Ingrese artista");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");
        
        if(txtCanciones.getText().equals("") || txtCanciones.getText() == null)
            txtCanciones.setText("Ingrese canciones");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
            txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtDisponibleMousePressed

    private void txtDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisponibleActionPerformed

    private void btnActualizarCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarCDActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

  
    public int insertarArtista(int idArtista, String artista){
        String sql = "INSERT INTO artistas (id,nombre_artista) values (?,?)";
                    PreparedStatement stmt = null;
                    //ResultSet rs = null;
                    int rows = 0;
                    
                    try{
                        con = Conexion.getConnection();
                        stmt = con.prepareStatement(sql);
                        int index = 1;
                        stmt.setInt(index++, idArtista);
                        stmt.setString(index, artista);
                        
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
    
    public int insertarGenero(int idGenero, String genre){
        String sql = "INSERT INTO generos (id,nombre_genero) values (?,?)";
                    PreparedStatement stmt = null;
                    //ResultSet rs = null;
                    int rows = 0;
                    
                    try{
                        con = Conexion.getConnection();
                        stmt = con.prepareStatement(sql);
                        int index = 1;
                        stmt.setInt(index++, idGenero);
                        stmt.setString(index, genre);
                        
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
        txtIdCd.setText("");
        txtTituloCd.setText("");
        txtArtista.setText("");
        txtGenero.setText("");
        txtDuracion.setText("");
        txtCanciones.setText("");
        txtDisponible.setText("");
        txtTipo.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCD;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JSeparator jSeparator10;
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
    private javax.swing.JLabel lblCD;
    private javax.swing.JLabel lblCanciones;
    private javax.swing.JLabel lblDisponible;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNewLibro;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulocd;
    private javax.swing.JPanel pnlAgregarMenu;
    private javax.swing.JTextField txtArtista;
    private javax.swing.JTextField txtCanciones;
    private javax.swing.JTextField txtDisponible;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIdCd;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTituloCd;
    // End of variables declaration//GEN-END:variables
}
