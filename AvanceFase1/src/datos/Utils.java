package datos;

import vista.Agregar_Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    
    Connection con = null;        
    PreparedStatement stmt = null;
    
    public String crearID(String tipoMaterial){
        //Estructura del ID: DVD00001
        String sql = "SELECT id FROM materiales";
        int[] arrayID = new int[8];
        int i = 0;
        String id = "";
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            //vamos convirtiendo cada ID en int quitando las tres primera letras
            //y depositando el numero en un array
            while (rs.next()) {                
                String nombreAutor = rs.getString("id");                
                String tipoID = nombreAutor.length() < 2 ? nombreAutor : nombreAutor.substring(0, 3);
                if(tipoID.equalsIgnoreCase(tipoMaterial)){
                    int numberId = Integer.parseInt(nombreAutor.substring(3));
                    arrayID[i] = numberId;
                    i++;
                }
            }
            //voy identificando el numero mayor
            int numMayor = arrayID[0];
            for (int j = 0; j < arrayID.length; j++){
                if (arrayID[j] > numMayor) {
                    numMayor = arrayID[j];
                }
            }
            //vamos a ver cuantos digitos tiene el numero resultante
            int conteo = (int)Math.floor(Math.log10(numMayor) + 1);
                                    
            //agregamos los ceros según la cantidad de digitos del numero mayor
            int resultado = 0;
            if(conteo <= 1){
                resultado = numMayor+1;
                id = String.valueOf(tipoMaterial+"0000"+resultado);
            } else if(conteo == 2) {
                resultado = numMayor+1;
                id = String.valueOf(tipoMaterial+"000"+resultado);
            } else if(conteo == 3) {
                resultado = numMayor+1;
                id = String.valueOf(tipoMaterial+"00"+resultado);
            } else if(conteo == 4) {
                resultado = numMayor+1;
                id = String.valueOf(tipoMaterial+"0"+resultado);
            } else {
                resultado = numMayor+1;
                id = String.valueOf(tipoMaterial+resultado);
            }
        } catch (Exception e) {
            Logger.getLogger(Agregar_Libro.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return id;
    }
    
    public int incremento_id () throws SQLException {
        int id = 1;
        stmt = null;
        ResultSet rs = null;
        con = Conexion.getConnection();
        try{
            stmt = con.prepareStatement("SELECT MAX(id) FROM autores");
            rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt(1) + 1;
            }
        }catch(SQLException e){
            Logger.getLogger(Agregar_Libro.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return id;
    }
    
    public int consultarAutorPorNombre(String autor){
        String sql = "SELECT id, nombre_autor FROM AUTORES WHERE nombre_autor = '"+autor+"';";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String nombreAutor = rs.getString("nombre_autor");
                id = rs.getInt("id");
            }
            
        } catch (Exception e) {
            Logger.getLogger(Agregar_Libro.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return id;
    }
    
    public int consultarEditorialPorNombre(String editorial){
        String sql = "SELECT id, nombre_editorial FROM EDITORIALES WHERE nombre_editorial = '"+editorial+"';";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String nombreAutor = rs.getString("nombre_editorial");
                id = rs.getInt("id");
            }
            
        } catch (Exception e) {
            Logger.getLogger(Agregar_Libro.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return id;
    }
    
    public int consultarArtistaPorNombre(String artista){
        String sql = "SELECT id, nombre_artista FROM ARTISTAS WHERE nombre_artista = '"+artista+"';";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String nombreArtista = rs.getString("nombre_artista");
                id = rs.getInt("id");
            }
            
        } catch (Exception e) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return id;
    }
    
    public int consultarGeneroPorNombre(String genero){
        String sql = "SELECT id, nombre_genero FROM GENEROS WHERE nombre_genero = '"+genero+"';";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String nombreGenero = rs.getString("nombre_genero");
                id = rs.getInt("id");
            }
            
        } catch (Exception e) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return id;
    }
    
    public int consultarDirectorPorNombre(String director){
        String sql = "SELECT id, nombre_director FROM DIRECTORES WHERE nombre_director = '"+director+"';";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String nombreDirector = rs.getString("nombre_director");
                id = rs.getInt("id");
            }
            
        } catch (Exception e) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return id;
    }
    
    public int insertarAutor (int idAutor, String autor){
        
        String sql = "INSERT INTO autores (id,nombre_autor) values (?,?)";
        PreparedStatement stmt = null;
        int rows = 0;

        try{
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            int index = 1;
            stmt.setInt(index++, idAutor);
            stmt.setString(index, autor);

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados " + rows);
        }catch(SQLException e){
            Logger.getLogger(Agregar_Libro.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }
    
    public int insertarEditorial (int idEditorial,String editorial){
        String sql = "INSERT INTO editoriales (id, nombre_editorial) values (?,?)";
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
            Logger.getLogger(Agregar_Libro.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }
    
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
    
    public int insertarDirector(int idDirector, String director){
        String sql = "INSERT INTO directores (id,nombre_director) values (?,?)";
                    PreparedStatement stmt = null;
                    //ResultSet rs = null;
                    int rows = 0;
                    
                    try{
                        con = Conexion.getConnection();
                        stmt = con.prepareStatement(sql);
                        int index = 1;
                        stmt.setInt(index++, idDirector);
                        stmt.setString(index, director);
                        
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
}
