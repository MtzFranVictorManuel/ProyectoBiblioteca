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
    private Connection conectarTransmision;
    Connection conectar = null;
    PreparedStatement preStatement = null;
    Documental recursoDocumen = new Documental();
    
    private static final String INSERT_SQL_RECURSO = "insert into multimedia "
            + "(tipoMultimedia, duracion, formato, RecursoDocumental_idRecursoDocumental) values (?, ?, ?, ?);";
    private static final String UPDATE_SQL = "";

    public MultimediaDAO() {
    }
    
    public int insert(Multimedia multimedia){
        conectar = DBConnection.getConnection();
        int rows = 0;
        try{
            preStatement = conectar.prepareStatement(INSERT_SQL_RECURSO);
            preStatement.setString(1, multimedia.getTipoMultimedia());
            preStatement.setTime(2, multimedia.getDuracion());
            preStatement.setString(3, multimedia.getFormato());
            preStatement.setInt(4, recursoDocumen.getIdRecursoDocumental());
        }catch(SQLException excepcionSQL){
            System.out.println("error" + excepcionSQL);
        }finally{
            DBConnection.close(preStatement);
            if(this.conectarTransmision == null){
                DBConnection.close(conectar);
            }
        }
        return rows;
    }
   
}
