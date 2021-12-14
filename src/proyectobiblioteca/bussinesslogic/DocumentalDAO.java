/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobiblioteca.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import proyectobiblioteca.dataaccess.DBConnection;
import proyectobiblioteca.domain.Documental;
/**
 *
 * @author Saulo
 */
public class DocumentalDAO implements IDocumental {
    private Connection connection;
    Connection connect = null;
    PreparedStatement preStatement = null;
    private static final String SQL_UPDATE = "UPDATE recursodocumental SET codigoBarras = ?, autor = ?,"
        + "titulo = ?, clasificacionLC = ?, descripcion = ?, editor = ?, tema = ? WHERE idRecursoDocumental = ?;";
    private static final String SQL_DELETE = "DELETE recursodocumental WHERE titulo = ?;";
    private static final String SQL_INSERT = "insert into recursodocumental (codigoBarras, autor, titulo, clasificacionLC, "
            + "descripcion, editor, tema, tipoMaterial, numCopias) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_SELECT_BUSCARCOPIA = "select * from recursodocumental where codigoBarras = ? and titulo = ? and tipoMaterial = ?;";
    private static final String SQL_UPDATE_GUARDARCOPIA = "update recursodocumental set numCopias = numCopias + 1 where idRecursoDocumental = ?;";
    
    public DocumentalDAO() {
        
    }

    public DocumentalDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ObservableList<Documental> select(ObservableList<Documental> tableInfo, String SQLQuery) {
        connect = DBConnection.getConnection();
        Documental documental = null;
        if (connect != null) {
            try {
                preStatement = connect.prepareStatement(SQLQuery);
                ResultSet rSet = preStatement.executeQuery();
                while (rSet.next()) {
                    documental = new Documental();
                    documental.setIdRecursoDocumental(rSet.getInt("idRecursoDocumental"));
                    documental.setCodigoBarras(rSet.getString("codigoBarras"));
                    documental.setAutor(rSet.getString("autor"));
                    documental.setTitulo(rSet.getString("titulo"));
                    documental.setClasificacionLC(rSet.getString("clasificacionLC"));
                    documental.setDescripcion(rSet.getString("descripcion"));
                    documental.setEditor(rSet.getString("editor"));
                    documental.setTema(rSet.getString("tema"));
                    documental.setTipoMaterial(rSet.getString("tipoMaterial"));
                    documental.setNumCopias(rSet.getInt("numCopias"));
                    tableInfo.add(documental);
                }

                DBConnection.close(rSet);
                return tableInfo;
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            } finally { 
                DBConnection.close(preStatement);
                if (this.connection == null) {
                    DBConnection.close(connect);
                }
            }
        }
        return tableInfo;
    }

    @Override
    public ObservableList<Documental> select(ObservableList<Documental> tableInfo, String value, String SQLQuery) {
        connect = DBConnection.getConnection();
        Documental documental = null;
        if (connect != null) {
            try {
                preStatement = connect.prepareStatement(SQLQuery);
                preStatement.setString(1, value);
                ResultSet rSet = preStatement.executeQuery();
                while (rSet.next()) {
                    documental = new Documental();
                    documental.setIdRecursoDocumental(rSet.getInt("idRecursoDocumental"));
                    documental.setCodigoBarras(rSet.getString("codigoBarras"));
                    documental.setAutor(rSet.getString("autor"));
                    documental.setTitulo(rSet.getString("titulo"));
                    documental.setClasificacionLC(rSet.getString("clasificacionLC"));
                    documental.setDescripcion(rSet.getString("descripcion"));
                    documental.setEditor(rSet.getString("editor"));
                    documental.setTema(rSet.getString("tema"));
                    documental.setTipoMaterial(rSet.getString("tipoMaterial"));
                    documental.setNumCopias(rSet.getInt("numCopias"));
                    tableInfo.add(documental);
                }
                DBConnection.close(rSet);
                return tableInfo;
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            } finally { 
                DBConnection.close(preStatement);
                if (this.connection == null) {
                    DBConnection.close(connect);
                }
            }
        }
        return tableInfo;
    }

    @Override
    public boolean update(Documental documental, int idRecursoDocumental) {
        connect = DBConnection.getConnection();
        if(connect != null){
            try{
                preStatement = connect.prepareStatement(SQL_UPDATE);
                preStatement.setString(1, documental.getCodigoBarras());
                preStatement.setString(2, documental.getAutor());
                preStatement.setString(3, documental.getTitulo());
                preStatement.setString(4, documental.getClasificacionLC());
                preStatement.setString(5, documental.getDescripcion());
                preStatement.setString(6, documental.getEditor());
                preStatement.setString(7, documental.getTema());
                preStatement.setInt(8, idRecursoDocumental);
            }catch(SQLException excepcion){
                System.out.println(excepcion.getMessage());
            }finally { 
                DBConnection.close(preStatement);
                if (this.connection == null) {
                    DBConnection.close(connect);
                }
            }
        }
        return true;
    }
    
    @Override
    public boolean updateCopia(int idRecursoDocumental){
        connect = DBConnection.getConnection();
        if(connect != null){
            try{
                preStatement = connect.prepareStatement(SQL_UPDATE_GUARDARCOPIA);
                preStatement.setInt(1, idRecursoDocumental);
            }catch(SQLException excepcion){
                System.out.println(excepcion.getMessage());
            }finally { 
                DBConnection.close(preStatement);
                if (this.connection == null) {
                    DBConnection.close(connect);
                }
            }
        }
        return true;   
    }

    @Override
    public Documental selectCopiaExistes(String codigoBarras, String titulo, String tipoMaterial){
        connect = DBConnection.getConnection();
        Documental documental = null;
        if(connect != null){
            try{
                preStatement = connect.prepareStatement(SQL_SELECT_BUSCARCOPIA);
                preStatement.setString(1, codigoBarras);
                preStatement.setString(2, titulo);
                preStatement.setString(3, tipoMaterial);
                ResultSet rSet = preStatement.executeQuery();
                if(rSet.next()){
                    documental = new Documental();
                    documental.setIdRecursoDocumental(rSet.getInt("idRecursoDocumental"));
                    documental.setCodigoBarras(rSet.getString("codigoBarras"));
                    documental.setAutor(rSet.getString("autor"));
                    documental.setTitulo(rSet.getString("titulo"));
                    documental.setClasificacionLC(rSet.getString("clasificacionLC"));
                    documental.setDescripcion(rSet.getString("descripcion"));
                    documental.setEditor(rSet.getString("editor"));
                    documental.setTema(rSet.getString("tema"));
                    documental.setTipoMaterial(rSet.getString("tipoMaterial"));
                    documental.setNumCopias(rSet.getInt("numCopias"));
                    return documental;
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
        return documental;
    }    
    
    @Override
    public int insert(Documental documental){
        connect = DBConnection.getConnection();
        int rows = 0;
        try{
            preStatement = connect.prepareStatement(SQL_INSERT);
            preStatement.setString(1, documental.getCodigoBarras());
            preStatement.setString(2, documental.getAutor());
            preStatement.setString(3, documental.getTitulo());
            preStatement.setString(4, documental.getClasificacionLC());
            preStatement.setString(5, documental.getDescripcion());
            preStatement.setString(6, documental.getEditor());
            preStatement.setString(7, documental.getTema());
            preStatement.setString(8, documental.getTipoMaterial());
            preStatement.setInt(9, documental.getNumCopias());
        }catch(SQLException excepcion){
            System.out.println(excepcion.getMessage());
        }finally { 
            DBConnection.close(preStatement);
            if (this.connection == null) {
                DBConnection.close(connect);
            }
        }
        return rows;
    }
        
    @Override
    public boolean delete(Documental documental) {
        return true;
    }
}
