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
    private static final String SQL_SELECT = "SELECT * FROM recursodocumental;";
    private static final String SQL_SELECT_TITULO = "SELECT * FROM recursodocumental WHERE titulo = ?;";
    private static final String SQL_SELECT_AUTOR = "SELECT * FROM recursodocumental WHERE autor = ?;";
    private static final String SQL_SELECT_EDITOR = "SELECT * FROM recursodocumental WHERE editor = ?;";
    private static final String SQL_SELECT_TEMA = "SELECT * FROM recursodocumental WHERE tema = ?;";
    private static final String SQL_SELECT_CODIGOBARRAS = "SELECT * FROM recursodocumental WHERE codigobarras = ?;";
    private static final String SQL_UPDATE = "UPDATE recursodocumental SET idRecursoDocumental = ?, codigoBarras = ?, autor = ?,"
        + "titulo = ?, clasificacionLC = ?, descripcion = ?, editor = ?, tema = ?, tipoMaterial = ?, numCopias = ? WHERE idRecursoDocumental = ?;";
    private static final String SQL_DELETE = "DELETE recursodocumental WHERE titulo = ?;";

    public DocumentalDAO() {
        
    }

    public DocumentalDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ObservableList<Documental> select(ObservableList<Documental> tableInfo) {
        connect = DBConnection.getConnection();
        Documental documental = null;
        if (connect != null) {
            try {
                preStatement = connect.prepareStatement(SQL_SELECT);
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
    public ObservableList<Documental> selectTitulo(ObservableList<Documental> tableInfo, String titulo) {
        connect = DBConnection.getConnection();
        Documental documental = null;
        if (connect != null) {
            try {
                preStatement = connect.prepareStatement(SQL_SELECT_TITULO);
                preStatement.setString(1, titulo);
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
    public ObservableList<Documental> selectAutor(ObservableList<Documental> tableInfo, String autor) {
        connect = DBConnection.getConnection();
        Documental documental = null;
        if (connect != null) {
            try {
                preStatement = connect.prepareStatement(SQL_SELECT_AUTOR);
                preStatement.setString(1, autor);
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
    public ObservableList<Documental> selectEditor(ObservableList<Documental> tableInfo, String editor) {
        connect = DBConnection.getConnection();
        Documental documental = null;
        if (connect != null) {
            try {
                preStatement = connect.prepareStatement(SQL_SELECT_EDITOR);
                preStatement.setString(1, editor);
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
    public ObservableList<Documental> selectTema(ObservableList<Documental> tableInfo, String tema) {
        connect = DBConnection.getConnection();
        Documental documental = null;
        if (connect != null) {
            try {
                preStatement = connect.prepareStatement(SQL_SELECT_TEMA);
                preStatement.setString(1, tema);
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
    public ObservableList<Documental> selectCodigoBarras(ObservableList<Documental> tableInfo, String codigoBarras) {
        connect = DBConnection.getConnection();
        Documental documental = null;
        if (connect != null) {
            try {
                preStatement = connect.prepareStatement(SQL_SELECT_CODIGOBARRAS);
                preStatement.setString(1, codigoBarras);
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
        return true;
    }

    @Override
    public boolean delete(Documental documental) {
        return true;
    }
}
