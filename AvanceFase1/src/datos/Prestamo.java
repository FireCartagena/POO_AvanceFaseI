package datos;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

public class Prestamo {

    //Atributos
    public int id;
    public String codigo_material;
    public int codigo_usuario;
    public String fecha_prestamo;
    public String fecha_devolucion;

    //Constructor
    public Prestamo() {
    }

    public ArrayList<ArrayList<String>> mostrarMaterial() throws SQLException {
        //Crear Lista
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        //Crear objeto de tipo conexion
        Conexion co = new Conexion();
        Connection con = co.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //Codigo SQL para insertar registro a tabla
        String sql = "SELECT materiales.id, materiales.titulo, autores.nombre_autor AS Autor, materiales.numero_de_paginas, "
                + "editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.periodicidad, "
                + "materiales.fecha_publicacion, artistas.nombre_artista AS Artista, materiales.duracion, "
                + "materiales.numero_de_canciones, materiales.unidades_disponibles, directores.nombre_director as Director, "
                + "materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales "
                + "LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON "
                + "generos.id = materiales.codigo_genero LEFT JOIN tipo_material "
                + "ON tipo_material.id = materiales.codigo_tipo_material LEFT JOIN autores "
                + "on autores.id = materiales.codigo_autor LEFT JOIN artistas "
                + "ON artistas.id = materiales.codigo_artista LEFT JOIN editoriales "
                + "ON editoriales.id = materiales.codigo_editorial";
        //Preparar statement
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            ArrayList<String> row = new ArrayList<String>();
            row.add(rs.getString("id"));
            row.add(rs.getString("titulo"));
            row.add(rs.getString("Tipo"));
            row.add(rs.getString("Autor"));
            row.add(rs.getString("numero_de_paginas"));
            row.add(rs.getString("Editorial"));
            row.add(rs.getString("isbn"));
            row.add(rs.getString("periodicidad"));
            row.add(rs.getString("Artista"));
            row.add(rs.getString("Genero"));
            row.add(rs.getString("duracion"));
            row.add(rs.getString("numero_de_canciones"));
            row.add(rs.getString("Director"));
            row.add(rs.getString("unidades_disponibles"));
            result.add(row);
        }

        return result;
    }

    public boolean materialDisp(String id_material) throws SQLException {
        boolean res = false;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();

        PreparedStatement stmt = con.prepareStatement("SELECT unidades_disponibles FROM materiales WHERE id = '" + id_material + "' LIMIT 1");
        ResultSet re = stmt.executeQuery();
        if (re.next()) {
            int d = Integer.parseInt(re.getString("unidades_disponibles"));
            if (d >= 1) {
                res = true;
            }
        }
        return res;
    }

    public boolean existeMaterial(String id_material) throws SQLException {
        boolean res = false;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();

        String sql = "SELECT id FROM materiales WHERE id = '" + id_material + "' LIMIT 1";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            res = true;
        }
        Conexion.close(con);
        Conexion.close(stmt);
        Conexion.close(rs);

        return res;
    }

    public boolean existeUsuario(String user) throws SQLException {
        boolean res = false;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();

        Statement stm = con.createStatement();
        ResultSet re = stm.executeQuery("SELECT * FROM usuarios WHERE nickname = '" + user + "' LIMIT 1");
        if (re.next()) {
            res = true;
        }
        return res;
    }

    public boolean verificarMora(String nickname) throws SQLException {
        boolean res = false;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();

        PreparedStatement stmt = con.prepareStatement("SELECT mora FROM usuarios WHERE nickname = '" + nickname + "' LIMIT 1");
        ResultSet re = stmt.executeQuery();

        if (re.next()) {
            Float m = re.getFloat("mora");

            if (m > 0) {
                JOptionPane.showMessageDialog(null, "No se puede realizar prestamo, cuenta con una mora de " + m);
                res = true;
            }
        }
        return res;
    }

    public boolean verificarPrestamo(String user, String id_material) throws SQLException {
        boolean res = false;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();

        Statement stm = con.createStatement();
        //SELECT prestamos.id, prestamos.codigo_material AS Material, socios.documento AS Socio, prestamos.fecha_prestamo, prestamos.fecha_devolucion FROM prestamos LEFT JOiN materiales ON materiales.id = prestamos.codigo_material LEFT JOIN socios on socios.id = prestamos.codigo_socio
        ResultSet re = stm.executeQuery("SELECT prestamos.id, prestamos.codigo_material AS Material, "
                + "usuarios.email AS Usuario, prestamos.fecha_prestamo, prestamos.fecha_devolucion FROM prestamos "
                + "LEFT JOiN materiales ON materiales.id = prestamos.codigo_material "
                + "LEFT JOIN usuarios on usuarios.id = prestamos.codigo_usuario "
                + "WHERE codigo_material = '" + id_material + "'AND usuarios.nickname= '" + user + "'");
        if (re.next()) {
            res = true;
        }
        return res;
    }

    public void insertarPrestamo(String user, String id_material) throws SQLException {

        Conexion conn = new Conexion();
        Connection con = conn.getConnection();

        int idUsuario = 0;
        int idPrestamo = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        //Convertir fecha de prestamo a tipo Date, para evitar problemas en tabla prestamos
        java.util.Date hoy = new java.util.Date();
        java.util.Date ahora = establecerFecha(hoy, 0);

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String prestamo_hoy = formato.format(ahora);
        java.sql.Date conversion = null;

        try {
            java.util.Date fecha = formato.parse(prestamo_hoy);
            conversion = new java.sql.Date(fecha.getTime());
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        //Convertir fecha de devolución a tipo Date, para evitar problemas en tabla prestamos
        java.util.Date actual = new java.util.Date();
        //Adicionar 5 días a la fecha actual.
        java.util.Date regresar = fechaDevolucion(actual, 5);
        SimpleDateFormat formato_dev = new SimpleDateFormat("dd-MM-yyyy");
        String prestamo_dev = formato_dev.format(regresar);
        java.sql.Date devolver = null;

        try {

            java.util.Date fecha = formato.parse(prestamo_dev);
            devolver = new java.sql.Date(fecha.getTime());
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        //Sentencia para seleccionar el id del usuario y almacenarlo en variable
        //Variable se pasará como parámetro del insert
        stmt = con.prepareStatement("SELECT usuarios.id FROM usuarios WHERE usuarios.nickname = '" + user + "'");
        rs = stmt.executeQuery();
        if (rs.next()) {
            idUsuario = rs.getInt("id");
        }
        System.out.println(idUsuario);

        //Bloque para seleccionar el id máximo de tabla prestamos y evitar que se salte y almacenarlo en variable
        //Variable se pasará como parámetro del insert
        //Será el id de prestamos
        stmt = con.prepareStatement("SELECT MAX(id) FROM prestamos");
        rs = stmt.executeQuery();
        while (rs.next()) {
            idPrestamo = rs.getInt(1) + 1;
        }
        System.out.println(idPrestamo);

        //Bloque de código para insertar información en tabla prestamos
        String sql = "INSERT INTO prestamos (id, codigo_material, codigo_usuario, fecha_prestamo, fecha_devolucion)"
                + "values (?,?,?,?,?)";

        int rows = 0;

        try {
            stmt = con.prepareStatement(sql);

            int index = 1;
            stmt.setInt(index++, idPrestamo);
            stmt.setString(index++, id_material);
            stmt.setInt(index++, idUsuario);
            stmt.setDate(index++, conversion);
            stmt.setDate(index, devolver);

            rows = stmt.executeUpdate();

            //Actualizar unidades disponibles de materiales
            stmt = con.prepareStatement("UPDATE materiales SET unidades_disponibles = unidades_disponibles -1 WHERE `id` = '" + id_material + "'");
            stmt.executeUpdate();

            System.out.println("Registros afectados " + rows);
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }

    //Método para establecer fecha
    public static java.util.Date establecerFecha(java.util.Date ahora, int dia) {
        Calendar cale = new GregorianCalendar();
        cale.setTimeInMillis(ahora.getTime());
        cale.add(Calendar.DATE, dia);
        return new java.sql.Date(cale.getTimeInMillis());
    }

    //Método para establecer fecha de devolución
    public static java.sql.Date fechaDevolucion(java.util.Date fch, int dias) {
        Calendar cale = new GregorianCalendar();
        cale.setTimeInMillis(fch.getTime());
        cale.add(Calendar.DATE, dias);
        return new java.sql.Date(cale.getTimeInMillis());
    }

    public void regresarMaterial(String nickname, String material_id) throws SQLException, ParseException {
        int idUser = 0;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();

        //Sentencia para seleccionar el id del usuario y almacenarlo en variable
        //Variable se pasará como parámetro del insert
        stmt = con.prepareStatement("SELECT usuarios.id FROM usuarios WHERE usuarios.nickname = '" + nickname + "'");
        rs = stmt.executeQuery();
        if (rs.next()) {
            idUser = rs.getInt("id");
        }


        ResultSet re = stmt.executeQuery("SELECT usuarios.id, materiales.id, prestamos.fecha_devolucion, DATEDIFF(now(),prestamos.fecha_devolucion) AS Atraso FROM prestamos JOIN usuarios ON prestamos.codigo_usuario = usuarios.id JOIN materiales ON materiales.id = prestamos.codigo_material AND prestamos.codigo_usuario='" + idUser + "'");
        if (re.next()) {
            String diferencia = re.getString("Atraso");
            int diferencia_dias = Integer.parseInt(diferencia);
            float costo = (float) 0.5;
            
            if (diferencia_dias > 0) {
                float mora = (float) (diferencia_dias * costo);
                
                stmt = con.prepareStatement("UPDATE usuarios SET mora='" + mora + "' WHERE usuarios.id='" + idUser + "'");
                stmt.executeUpdate();
                stmt = con.prepareStatement("DELETE FROM prestamos WHERE codigo_material = '" + material_id + "' AND codigo_usuario = '" + idUser + "' LIMIT 1");
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "¡SANCIONADO POR ENTREGA ATRASADA! ($" + diferencia_dias + ") \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                stmt = con.prepareStatement("DELETE FROM prestamos WHERE codigo_material = '" + material_id + "' AND codigo_usuario = '" + idUser + "' LIMIT 1");
                stmt.executeUpdate();
                
                stmt2 = con.prepareStatement("UPDATE materiales SET unidades_disponibles = unidades_disponibles+1 WHERE id = '" + material_id + "';");
                stmt2.executeUpdate();
                JOptionPane.showMessageDialog(null, "¡Devolución realizada! Gracias por la entrega. \n", "HECHO", JOptionPane.INFORMATION_MESSAGE);
            }

            Conexion.close(con);
            Conexion.close(rs);

        }
    }
}
