
package proyectobiblioteca.bussinesslogic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectobiblioteca.dataaccess.DBConnection;
import proyectobiblioteca.domain.Libro;


public class LibroDAO {
    private Connection connection;
    Connection connect = null;
    PreparedStatement preStatement = null;
    
    private static final String INSERT_SQL_LIBRO = "insert into libro (edicion, isbn, fechaPublicacion, idioma, serie, volumen, tipoObraLiteraria, RecursoDocumental_idRecursoDocumental) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_SELECT_LIBRO = "select * from libro where RecursoDocumental_idRecursoDocumental = ?;";
    private static final String SQL_UPDATE_LIBRO = "update libro set edicion = ?, isbn = ?, fechaPublicacion = ?, idioma = ?, serie = ?, volumen = ?, tipoObraLiteraria = ? where RecursoDocumental_idRecursoDocumental = ?;";
    
    public LibroDAO(){
        
    }
    
    public boolean insertar (Libro libro, int fkDocumentoID){
        connect = DBConnection.getConnection();
        boolean registroExitoso = false;
        try{
            preStatement = connect.prepareStatement(INSERT_SQL_LIBRO);
            preStatement.setString(1, libro.getEdicion());
            preStatement.setString(2, libro.getIsbn());
            preStatement.setDate(3, libro.getFechaPublicacion());
            preStatement.setString(4, libro.getIdioma());
            preStatement.setString(5, libro.getSerie());
            preStatement.setInt(6, libro.getVolumen());
            preStatement.setString(7, libro.getTipoObraLiteraria());
            preStatement.setInt(8, fkDocumentoID);
            preStatement.executeUpdate();
            registroExitoso = true;
        }catch(SQLException excepcionSQL){
            System.out.println("error" + excepcionSQL);
        }finally{
            DBConnection.close(preStatement);
            if(this.connection == null){
                DBConnection.close(connect);
            }
        }
        return registroExitoso;
    }
    
    public Libro seleccionarLibro (int idRecursoDocumental){
        connect = DBConnection.getConnection();
         Libro libro = null;
        if(connect != null){
            try{
                preStatement = connect.prepareStatement(SQL_SELECT_LIBRO);
                preStatement.setInt(1, idRecursoDocumental);
                ResultSet rSet = preStatement.executeQuery();
                if(rSet.next()){
                    libro = new Libro();
                    libro.setIdLibro(rSet.getInt("idLibro"));
                    libro.setEdicion(rSet.getString("edicion"));
                    libro.setIsbn(rSet.getString("isbn"));
                    libro.setFechaPublicacion(rSet.getDate("fechaPublicacion"));
                    libro.setIdioma(rSet.getString("idioma"));
                    libro.setSerie(rSet.getString("serie"));
                    libro.setVolumen(rSet.getInt("volumen"));
                    libro.setTipoObraLiteraria(rSet.getString("tipoObraLiteraria"));
                    return libro;
                }
            }catch(SQLException excepcion){
                System.out.println(excepcion.getMessage());
            }finally { 
                DBConnection.close(preStatement);
                if (this.connection == null) {
                    DBConnection.close(connect);
                }
            }
        }
        return libro;
    }
    
        public boolean update(Libro libro, int idRecursoDocumental) {
        connect = DBConnection.getConnection();
        boolean confirmar = false;
        if(connect != null){
            try{
                preStatement = connect.prepareStatement(SQL_UPDATE_LIBRO);
                preStatement.setString(1, libro.getEdicion());
                preStatement.setString(2, libro.getIsbn());
                preStatement.setDate(3, libro.getFechaPublicacion());
                preStatement.setString(4, libro.getIdioma());
                preStatement.setString(5, libro.getSerie());
                preStatement.setInt(6, libro.getVolumen());
                preStatement.setString(7, libro.getTipoObraLiteraria());
                preStatement.setInt(8, idRecursoDocumental);
                preStatement.executeUpdate();
                confirmar = true;
            }catch(SQLException excepcion){
                System.out.println(excepcion.getMessage());
            }finally { 
                DBConnection.close(preStatement);
                if (this.connection == null) {
                    DBConnection.close(connect);
                }
            }
        }
        return confirmar;
    }
}
