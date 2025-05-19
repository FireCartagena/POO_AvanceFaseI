package datos;

import datos.Globales;
import datos.Conexion;
import vista.Dashboard;
import vista.Ver_Roles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Rol {

    //Atributos
    public int id;
    public String rol;
    public int numero_prestamos;
    public int dias_prestamo;

    //Constructor
    public Rol() {
    }

    //Metodo agregar rol
    public void agregarRol(String rol, int numero_prestamos, int dias_prestamo) throws SQLException {
        //Crear objeto de tipo conexion
        Connection con = Conexion.getConnection();

        //Codigo SQL para insertar registro a tabla
        String sql = "INSERT INTO `rol`(rol, numero_prestamos, dias_prestamo) VALUES(?,?,?)";
        //Preparar statement
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            stmt = con.prepareStatement(sql);
            int index = 1;
            stmt.setString(index++, rol);
            stmt.setInt(index++, numero_prestamos);
            stmt.setInt(index, dias_prestamo);

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados " + rows);
                //Confirmar cambio efectivo
                if(rows > 0){
                    JOptionPane.showMessageDialog(null, "Nuevo rol agregado exitosamente !", "AVISO",JOptionPane.INFORMATION_MESSAGE);
                    Ver_Roles ver = null;
                    ver = new Ver_Roles();
                    ver.setVisible(true);                    
                }else{
                    JOptionPane.showMessageDialog(null, "Rol no pudo ser agregado!", "ERROR",JOptionPane.ERROR_MESSAGE);
                    Ver_Roles ver = null;
                    ver = new Ver_Roles();
                    ver.setVisible(true);
                }            
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }

    //Metodo select all roles
    public ArrayList<ArrayList<String>> mostrarRoles() throws SQLException {
        //Crear Lista
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        //Crear objeto de tipo conexion
        Connection con = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //Codigo SQL para insertar registro a tabla
        String sql = "SELECT id, rol, numero_prestamos, dias_prestamo FROM rol";
        //Preparar statement
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            ArrayList<String> row = new ArrayList<>();
            row.add(rs.getString("id"));
            row.add(rs.getString("rol"));
            row.add(rs.getString("numero_prestamos"));
            row.add(rs.getString("dias_prestamo"));
            result.add(row);
        }

        return result;
    }


    public List<Rol> verRol(String idRol) throws SQLException {
        //Crear objeto de tipo conexion
        Connection con = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Rol> role = new ArrayList<>();

        try {
            String sql = "SELECT id, rol, numero_prestamos, dias_prestamo FROM rol WHERE id ='" + idRol + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                Rol rolData = new Rol();
                rolData.id = rs.getInt("id");
                rolData.rol = rs.getString("rol");
                rolData.numero_prestamos = rs.getInt("numero_prestamos");
                rolData.dias_prestamo = rs.getInt("dias_prestamo");
                role.add(rolData);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Conexion.close(con);
            Conexion.close(ps);
            Conexion.close(rs);
        }

        for (int i = 0; i < role.size(); i++) {
            String id = Integer.toString(role.get(i).id);
            String rol = role.get(i).rol;
            int numero_prestamos = role.get(i).numero_prestamos;
            int dias_prestamo = role.get(i).dias_prestamo;
        }
        return role;
    }

    public void actualizarRol(String id, String rol, String numero_prestamos, String dias_prestamo) throws SQLException {
        //Crear objeto de tipo conexion
        Connection con = Conexion.getConnection();
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            String sql = "UPDATE rol SET rol = ?, numero_prestamos = ?, dias_prestamo = ? WHERE id ='" + id + "'";
            stmt = con.prepareStatement(sql);

            int index = 1;
            stmt.setString(index++, rol);
            stmt.setString(index++, numero_prestamos);
            stmt.setString(index, dias_prestamo);

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados " + rows);
                //Confirmar cambio efectivo
                if(rows > 0){
                    JOptionPane.showMessageDialog(null, "Rol actualizado exitosamente !", "AVISO",JOptionPane.INFORMATION_MESSAGE);
                    Ver_Roles ver = null;
                    ver = new Ver_Roles();
                    ver.setVisible(true);                    
                }else{
                    JOptionPane.showMessageDialog(null, "Rol no pudo ser actualizado!", "ERROR",JOptionPane.ERROR_MESSAGE);
                    Ver_Roles ver = null;
                    ver = new Ver_Roles();
                    ver.setVisible(true);
                }              
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }

    public void eliminarRol(String id) throws SQLException {
        //Crear objeto de tipo conexion
        Connection con = Conexion.getConnection();
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            String sql = "DELETE FROM rol WHERE id ='" + id + "'";
            stmt = con.prepareStatement(sql);

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados " + rows);
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
    }
}
