/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobiblioteca.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proyectobiblioteca.dataaccess.DBConnection;
import proyectobiblioteca.domain.Documental;
import proyectobiblioteca.domain.Multimedia;

/**
 *
 * @author victormanuel
 */
public class MultimediaDAO {
    private Connection connection;
    Connection connect = null;
    PreparedStatement preStatement = null;
    Documental recursoDocumen = new Documental();
    
    private static final String INSERT_SQL_RECURSO = "insert into multimedia "
            + "(tipoMultimedia, duracion, formato, RecursoDocumental_idRecursoDocumental) values (?, ?, ?, ?);";
    private static final String UPDATE_SQL = "update multimedia set tipoMultimedia = ?, duracion = ?, formato = ? where RecursoDocumental_idRecursoDocumental = ?;";

    public MultimediaDAO() {
    }
    
    public int insert(Multimedia multimedia){
        connect = DBConnection.getConnection();
        int rows = 0;
        try{
            preStatement = connect.prepareStatement(INSERT_SQL_RECURSO);
            preStatement.setString(1, multimedia.getTipoMultimedia());
            preStatement.setTime(2, multimedia.getDuracion());
            preStatement.setString(3, multimedia.getFormato());
            preStatement.setInt(4, recursoDocumen.getIdRecursoDocumental());
        }catch(SQLException excepcionSQL){
            System.out.println("error" + excepcionSQL);
        }finally{
            DBConnection.close(preStatement);
            if(this.connection == null){
                DBConnection.close(connect);
            }
        }
        return rows;
    }
    
    public int update (Multimedia multimedia, int idRecursoDocumental){
        connect = DBConnection.getConnection();
        int rows = 0;
        if(connect != null){
            try{
                preStatement = connect.prepareStatement(UPDATE_SQL);
                preStatement.setString(1, multimedia.getTipoMultimedia());
                preStatement.setTime(2, multimedia.getDuracion());
                preStatement.setString(3, multimedia.getFormato());
                preStatement.setInt(4, idRecursoDocumental);
                rows = preStatement.executeUpdate();
            }catch(SQLException excepcionSQL){
                System.out.println("error" + excepcionSQL);
            }finally{
                DBConnection.close(preStatement);
                if(this.connection == null){
                    DBConnection.close(connect);
                }
            }
        }
        return rows;
    }
   
}
