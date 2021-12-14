/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobiblioteca.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Saulo
 */
public class ConnectDB {
    protected Connection connection;
    private String url = "";
    private String user = "";
    private String password = ""; 

    public Connection getDataBaseConnection() {
        connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url,user,password);
        } catch(ClassNotFoundException exClassNotFoundException) {

        } catch(SQLException exSQL) {
            System.out.println("Error: " + exSQL);
        }
        
        return connection;
    }

    public Connection closeDataBaseConnection(){
        try{
            if(connection != null){
                if(!connection.isClosed()){
                    connection.close();
                }
            }
        }catch(SQLException exSQL){
            System.out.println("Error: "+ exSQL);
        }
        
        return connection;
    }
}
