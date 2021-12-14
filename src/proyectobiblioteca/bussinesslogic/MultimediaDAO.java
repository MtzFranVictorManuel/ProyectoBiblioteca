/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobiblioteca.bussinesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import proyectobiblioteca.dataaccess.DBConnection;
import proyectobiblioteca.domain.Multimedia;

/**
 *
 * @author victormanuel
 */
public class MultimediaDAO {
    private Connection conectar;
    Connection connect = null;
    PreparedStatement preStatement = null;
    
    private static final String INSERT_SQL_RECURSO = "insert into multimedia "
            + "(tipoMultimedia, duracion, formato, RecursoDocumental_idRecursoDocumental) values (?, ?, ?, ?);";
    private static final String SELECT_SQL_COPIA = "select * from recursodocumental where codigoBarras = ? and titulo = ? and tipoMaterial = ?;";
    private static final String UPDATE_SQL = "";

    public MultimediaDAO() {
    }
    
    public int insert(Multimedia multimedia){
        conectar = DBConnection.getConnection();
        
    }
   
}
