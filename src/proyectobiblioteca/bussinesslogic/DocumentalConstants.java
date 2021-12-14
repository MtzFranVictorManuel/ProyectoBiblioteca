/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobiblioteca.bussinesslogic;

/**
 *
 * @author victormanuel
 */
public class DocumentalConstants {
    public static final String SQL_SELECT = "SELECT * FROM recursodocumental;";
    public static final String SQL_SELECT_TITULO = "SELECT * FROM recursodocumental WHERE titulo = ?;";
    public static final String SQL_SELECT_AUTOR = "SELECT * FROM recursodocumental WHERE autor = ?;";
    public static final String SQL_SELECT_EDITOR = "SELECT * FROM recursodocumental WHERE editor = ?;";
    public static final String SQL_SELECT_TEMA = "SELECT * FROM recursodocumental WHERE tema = ?;";
    public static final String SQL_SELECT_CODIGOBARRAS = "SELECT * FROM recursodocumental WHERE codigobarras = ?;";
}
