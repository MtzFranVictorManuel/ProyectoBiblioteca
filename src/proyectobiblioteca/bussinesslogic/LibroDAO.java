
package proyectobiblioteca.bussinesslogic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proyectobiblioteca.dataaccess.DBConnection;
import proyectobiblioteca.domain.Libro;


public class LibroDAO {
    private Connection connection;
    Connection connect = null;
    PreparedStatement preStatement = null;
    
    private static final String INSERT_SQL_LIBRO = "insert into libro (edicion, isbn, fechaPublicacion, idioma, serie, volumen, tipoObraLiteraria, RecursoDocumental_idRecursoDocumental) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?);";
    
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
            return registroExitoso = true;
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
    
     public boolean insertar2 (String edicion, String isbn, Date fechaPublicacion, String idioma, 
             String serie, int volumen, String tipoObra, int fkDocumentoID){
        connect = DBConnection.getConnection();
        boolean registroExitoso = false;
        try{
            preStatement = connect.prepareStatement(INSERT_SQL_LIBRO);
            preStatement.setString(1, edicion);
            preStatement.setString(2, isbn);
            preStatement.setDate(3, fechaPublicacion);
            preStatement.setString(4, idioma);
            preStatement.setString(5, serie);
            preStatement.setInt(6, volumen);
            preStatement.setString(7, tipoObra);
            preStatement.setInt(8, fkDocumentoID);
            return registroExitoso = true;
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
}
