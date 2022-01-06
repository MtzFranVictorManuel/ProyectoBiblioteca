/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectobiblioteca.controllersAndGui;

import com.mysql.cj.xdevapi.Type;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;
import java.util.logging.SimpleFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyectobiblioteca.bussinesslogic.DocumentalDAO;
import proyectobiblioteca.bussinesslogic.LibroDAO;
import proyectobiblioteca.domain.Documental;

/**
 * FXML Controller class
 *
 * @author victormanuel
 */
public class ModificarLibroController implements Initializable {
    LibroDAO librodao = new LibroDAO();
    DocumentalDAO documentaldao = new DocumentalDAO();
    Documental documental = new Documental();
    
    @FXML
    private TextField textFieldTitulo;
    
    @FXML
    private TextField textFieldAutor;
    
    @FXML
    private TextField textFieldEditor;
    
    @FXML
    private TextField textFieldTemas;
    
    @FXML
    private TextArea textFieldDescripcion;
    
    @FXML
    private TextField textFieldClasificacionLC;
    
    @FXML
    private TextField textFieldCodigoBarras;
    
    @FXML
    private TextField textFieldIsbn;
    
    @FXML
    private TextField textFieldEdicion;
    
    @FXML
    private TextField textFieldVolumen;
    
    @FXML
    private TextField textFieldIdioma;
    
    @FXML
    private TextField textFieldSerie;
    
    @FXML
    private TextField textFieldTipoObra;
    
    @FXML
    private TextField textFieldNumeroCopias;
    
    @FXML
    private DatePicker datePickerFechaPublicacion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
     public void clicSalir(ActionEvent actionEvent){
         navigationScreen("ModificarEliminarRecursoDocumental.fxml");
    }
     
    public void clicGuardarCambios(ActionEvent actionEvent){
        
    }
    
    public void navigationScreen(String url) {
        try {
            Stage stage = (Stage) textFieldAutor.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource(url)));
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
