package datos;

import entidades.Materiales;
import entidades.TipoMaterial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MaterialesCRUD extends Utils{
     private final String SQL_INSERT_INTO_MATERIALES
            = "INSERT INTO materiales\n" +
              "(id, titulo, codigo_tipo_material, codigo_autor, "
            + "numero_de_paginas, codigo_editorial, isbn, periodicidad, "
            + "fecha_publicacion, codigo_artista, codigo_genero, duracion, "
            + "numero_de_canciones, codigo_director, unidades_disponibles)\n" +
              "VALUES\n" +
              "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
     
    private final String SQL_UPDATE_MATERIALES
            = "UPDATE materiales SET titulo=?, codigo_tipo_material=?, "
            + "codigo_autor=?, numero_de_paginas=?, codigo_editorial=?, isbn=?, "
            + "periodicidad=?, fecha_publicacion=?, codigo_artista=?, "
            + "codigo_genero=?, duracion=?, numero_de_canciones=?, "
            + "codigo_director=?, unidades_disponibles=? WHERE id=?";
    
    private final String SQL_DELETE_MATERIALES
            = "DELETE FROM materiales WHERE id=?";
    
    private final String SQL_SELECT_MATERIALES
            = "SELECT * FROM materiales ORDER BY id";
    
    
     /**
     * Metodo que inserta un registro en la tabla Materiales de forma general
     *
     * @param id
     * @param titulo
     * @param codigo_tipo_material
     * @param codigo_autor
     * @param numero_de_paginas
     * @param codigo_editorial
     * @param isbn
     * @param periodicidad
     * @param fecha_publicacion
     * @param codigo_artista
     * @param codigo_genero
     * @param duracion
     * @param numero_de_canciones
     * @param codigo_director
     * @param unidades_disponibles
     * @return int con el num de registros afectadas
     */
    public int insert(String id, String titulo, int codigo_tipo_material, 
            Integer codigo_autor, String numero_de_paginas, Integer codigo_editorial, 
            String isbn, String periodicidad, Date fecha_publicacion, 
            Integer codigo_artista, Integer codigo_genero, String duracion, 
            Integer numero_de_canciones, Integer codigo_director, Integer unidades_disponibles) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_INTO_MATERIALES);
            int index = 1;//contador de columnas
            
            stmt.setString(index++, id);
            stmt.setString(index++, titulo);
            stmt.setInt(index++, codigo_tipo_material);
            if(codigo_autor!=null){
                stmt.setInt(index++, codigo_autor);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(numero_de_paginas!=null){
                stmt.setString(index++, numero_de_paginas);
            } else {
                stmt.setNull(index++, java.sql.Types.VARCHAR);
            }
            if(codigo_editorial!=null){
                stmt.setInt(index++, codigo_editorial);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(isbn!=null){
                stmt.setString(index++, isbn);
            } else {
                stmt.setNull(index++, java.sql.Types.VARCHAR);
            }
            if(periodicidad!=null){
                stmt.setString(index++, periodicidad);
            } else {
                stmt.setNull(index++, java.sql.Types.VARCHAR);
            }
            if(fecha_publicacion != null){
                stmt.setDate(index++, java.sql.Date.valueOf(df.format(fecha_publicacion)));
            } else {
                stmt.setNull(index++, java.sql.Types.DATE);
            }   
            if(codigo_artista!=null){
                stmt.setInt(index++, codigo_artista);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(codigo_genero!=null){
                stmt.setInt(index++, codigo_genero);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(duracion!=null){
                stmt.setString(index++, duracion);
            } else {
                stmt.setNull(index++, java.sql.Types.VARCHAR);
            }
            if(numero_de_canciones!=null){
                stmt.setInt(index++, numero_de_canciones);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(codigo_director!=null){
                stmt.setInt(index++, codigo_director);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(unidades_disponibles!=null){
                stmt.setInt(index++, unidades_disponibles);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            rows = stmt.executeUpdate();//no. registros afectados
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int insertarLibros(String titulo, int pag, int idEditorial, String isbn, java.sql.Date conversion, int u_disponible, String autor, String editorial, String ubicacion, int codigo){        
        String sql = "INSERT INTO materiales (id,titulo,codigo_tipo_material,"
                + "codigo_autor,numero_de_paginas,codigo_editorial,isbn,"
                + "fecha_publicacion,unidades_disponibles, ubicacion) VALUES (?,?,4,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        Connection conn = null;
        int rows = 0;
        
        //Llamar a los siguientes métodos, pasándole parámetros para obtener sus respectivos ID
        int autorID = consultarAutorPorNombre(autor);
        int editorialID = consultarEditorialPorNombre(editorial);

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            int index = 1;
            if(codigo==1){
                stmt.setString(index++, crearID("LIB"));
            } else {
                stmt.setString(index++, crearID("OBR"));   
            }
            stmt.setString(index++, titulo);
            stmt.setInt(index++, autorID);
            stmt.setInt(index++, pag);
            stmt.setInt(index++, editorialID);
            stmt.setString(index++, isbn);
            stmt.setDate(index++, conversion);
            stmt.setInt(index++, u_disponible);
            stmt.setString(index++, ubicacion);

            rows = stmt.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(MaterialesCRUD.class.getName()).log(Level.ERROR, "Hubo un problema durante la insercion de datos", e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int insertarCV(String titulo, String num_pag, String autorCV, int u_disponible, java.sql.Date fecha, String ubicacion){        
        String sql = "INSERT INTO materiales (id,titulo,codigo_tipo_material,"
                + "numero_de_paginas, ubicacion, nombre_autor_CV,"
                + "fecha_publicacion,unidades_disponibles) VALUES (?,?,6,?,?,?,?,?)";
        PreparedStatement stmt = null;
        Connection conn = null;
        int rows = 0;
        
        //Llamar a los siguientes métodos, pasándole parámetros para obtener sus respectivos ID
        //int autorID = consultarAutorPorNombre(autor);
        //int editorialID = consultarEditorialPorNombre(editorial);

        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            int index = 1;
            stmt.setString(index++, crearID("CV"));
            stmt.setString(index++, titulo);
            stmt.setString(index++, num_pag);
            stmt.setString(index++, ubicacion);
            stmt.setString(index++, autorCV);
            stmt.setDate(index++, fecha);
            stmt.setInt(index++, u_disponible);
            rows = stmt.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(MaterialesCRUD.class.getName()).log(Level.ERROR, "Hubo un problema durante la insercion de datos", e);
            //resultado = 0;
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int insertarCD(String titulo, String duracion, String canciones, int u_disponible, String artista, String genero, java.sql.Date conversion, String ubicacion){
        String sql = "INSERT INTO materiales (id,titulo, fecha_publicacion, codigo_artista,codigo_tipo_material,codigo_genero,duracion,numero_de_canciones,unidades_disponibles, ubicacion)"
        + "VALUES (?,?,?,1,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        int rows = 0;
        int idArtista = consultarArtistaPorNombre(artista);
        int idGenero = consultarGeneroPorNombre(genero);

        try{
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            int index = 1;
            stmt.setString(index++, crearID("CDA"));
            stmt.setString(index++, titulo);
            stmt.setDate(index++, conversion);
            stmt.setInt(index++, idArtista);
            stmt.setInt(index++, idGenero);
            stmt.setString(index++, duracion);
            stmt.setString(index++, canciones);
            stmt.setInt(index++, u_disponible);

            rows = stmt.executeUpdate();
        }catch(Exception e){
            Logger.getLogger(MaterialesCRUD.class.getName()).log(Level.FATAL, "Error al hacer la instruccion INSERTARCD...", e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }
    
    public int insertarDVD(String titulo, String director, String genre, String duracion, java.sql.Date conversion, String u_disponible, String ubicacion){
        String sql = "INSERT INTO materiales (id,titulo,codigo_director,codigo_tipo_material,codigo_genero,duracion, u_disponibles, ubicacion)"
                        + "VALUES (?,?,?,2,?,?, ?, ?)";
        int idGenero = consultarGeneroPorNombre(genre);
        int idDirector = consultarDirectorPorNombre(director);
        PreparedStatement stmt = null;
        //ResultSet rs = null;
        int rows = 0;

        try{
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            int index = 1;
            stmt.setString(index++, crearID("DVD"));
            stmt.setString(index++, titulo);
            stmt.setInt(index++, idDirector);
            stmt.setInt(index++, idGenero);
            stmt.setString(index, duracion);
            stmt.setDate(index++, conversion);
            stmt.setString(index++, u_disponible);
            stmt.setString(index++, ubicacion);
            rows = stmt.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(MaterialesCRUD.class.getName()).log(Level.FATAL, "Hubo un error al ejecutar la instruccion INSERTARDVD...", e);
        } finally{
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return rows;
    }
    
    public int insertarRevista(String titulo, String editorial, String periodo, java.sql.Date conversion, int u_disponible, String ubicacion){
        String sql = "INSERT INTO materiales (id,titulo,codigo_editorial,codigo_tipo_material,periodicidad,fecha_publicacion,unidades_disponibles, ubicacion)"
                 + "VALUES (?,?,?,3,?,?,?,?)";
        int idEditorial = consultarEditorialPorNombre(editorial);
         PreparedStatement stmt = null;
         int rows = 0;

         try{
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            int index = 1;
            stmt.setString(index++, crearID("REV"));
            stmt.setString(index++, titulo);
            stmt.setInt(index++, idEditorial);
            stmt.setString(index++, periodo);
            stmt.setDate(index++, conversion);
            stmt.setInt(index++, u_disponible);
            rows = stmt.executeUpdate();
         }catch(SQLException e){
            
         } finally{
             Conexion.close(stmt);
             Conexion.close(con);
         } 
        return rows;
    }
    
    /**
     * Metodo que inserta un registro en la tabla Materiales
     *
     * @param id
     * @param titulo
     * @param codigo_tipo_material
     * @param codigo_autor
     * @param numero_de_paginas
     * @param codigo_editorial
     * @param isbn
     * @param periodicidad
     * @param fecha_publicacion
     * @param codigo_artista
     * @param codigo_genero
     * @param duracion
     * @param numero_de_canciones
     * @param codigo_director
     * @param unidades_disponibles
     * @return int con el num de registros afectadas
     */
    public int update(String id, String titulo, Integer codigo_tipo_material, 
            Integer codigo_autor, String numero_de_paginas, Integer codigo_editorial, 
            String isbn, String periodicidad, Date fecha_publicacion, 
            Integer codigo_artista, Integer codigo_genero, String duracion, 
            Integer numero_de_canciones, Integer codigo_director, Integer unidades_disponibles) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_MATERIALES);
            int index = 1;

            stmt.setString(index++, titulo);
            stmt.setInt(index++, codigo_tipo_material);
            if(codigo_autor!=null){
                stmt.setInt(index++, codigo_autor);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(numero_de_paginas!=null){
                stmt.setString(index++, numero_de_paginas);
            } else {
                stmt.setNull(index++, java.sql.Types.VARCHAR);
            }
            if(codigo_editorial!=null){
                stmt.setInt(index++, codigo_editorial);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(isbn!=null){
                stmt.setString(index++, isbn);
            } else {
                stmt.setNull(index++, java.sql.Types.VARCHAR);
            }
            if(periodicidad!=null){
                stmt.setString(index++, periodicidad);
            } else {
                stmt.setNull(index++, java.sql.Types.VARCHAR);
            }
            if(fecha_publicacion != null){
                stmt.setDate(index++, java.sql.Date.valueOf(df.format(fecha_publicacion)));
            } else {
                stmt.setNull(index++, java.sql.Types.DATE);
            }   
            if(codigo_artista!=null){
                stmt.setInt(index++, codigo_artista);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(codigo_genero!=null){
                stmt.setInt(index++, codigo_genero);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(duracion!=null){
                stmt.setString(index++, duracion);
            } else {
                stmt.setNull(index++, java.sql.Types.VARCHAR);
            }
            if(numero_de_canciones!=null){
                stmt.setInt(index++, numero_de_canciones);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(codigo_director!=null){
                stmt.setInt(index++, codigo_director);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            if(unidades_disponibles!=null){
                stmt.setInt(index++, unidades_disponibles);
            } else {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            }
            stmt.setString(index++, id);
            rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(MaterialesCRUD.class.getName()).log(Level.FATAL, "Hubo un error al ejecutar la instruccion de UPDATE", e);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    /**
     * Metodo que elimina un registro existente
     *
     * @param id Es la llave primaria de la tabla Materiales
     * @return int numero de registros afectados
     */
    public int delete(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_MATERIALES);
            stmt.setString(1, id);
            rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    /**
     * Metodo que regresa el contenido de la tabla de personas
     */
    public List<Materiales> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Materiales material = null;
        List<Materiales> materiales = new ArrayList<Materiales>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_MATERIALES);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String titulo = rs.getString(2);
                Integer codigoTipoMaterial = rs.getInt(3);
                TipoMaterial tm = new TipoMaterial();
                tm.setId(codigoTipoMaterial);
                Integer codigoAutor = rs.getInt(4);
                String numeroPaginas = rs.getString(5);
                Integer codigoEditorial = rs.getInt(6);
                String isbn = rs.getString(7);
                String periodicidad = rs.getString(8);
                Date fechaPublicacion = rs.getDate(9);
                Integer codigoArtista = rs.getInt(10);
                Integer codigoGenero = rs.getInt(11);
                String duracion = rs.getString(12);
                String numCanciones = rs.getString(13);
                Integer codigoDirector = rs.getInt(14);
                Integer unidadesDisp = rs.getInt(15);
                
                material = new Materiales();
                material.setId(id);
                material.setTitulo(titulo);
                material.setCodigoTipoMaterial(codigoTipoMaterial);
                //material.setCodigoTipoMaterial(tm);
                material.setCodigoAutor(codigoAutor);
                material.setNumeroDePaginas(numeroPaginas);
                material.setCodigoEditorial(codigoEditorial);
                material.setIsbn(isbn);
                material.setPeriodicidad(periodicidad);
                material.setFechaPublicacion(fechaPublicacion);
                material.setCodigoArtista(codigoArtista);
                material.setCodigoGenero(codigoGenero);
                material.setDuracion(duracion);
                material.setNumeroDeCanciones(numCanciones);
                material.setCodigoDirector(codigoDirector);
                material.setUnidadesDisponibles(unidadesDisp);
                materiales.add(material);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return materiales;
    }
}
