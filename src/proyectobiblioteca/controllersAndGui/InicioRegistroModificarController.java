/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectobiblioteca.controllersAndGui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author victormanuel
 */
public class InicioRegistroModificarController implements Initializable {

    @FXML
    private ImageView imagenLogo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("img/flor-azul.jpeg");
        Image image = new Image(file.toURI().toString());
        imagenLogo.setImage(image);
        
    }    
    
    public void clicRegistrarLibro(ActionEvent actionEvent){
        navigationScreen("RegistrarLibro.fxml");
    }
    
    public void clicRegistrarMultimedia(ActionEvent actionEvent){
        navigationScreen("RegistrarMultimedia.fxml");
    }
    
    public void clicSalir(ActionEvent actionEvent){
    }
    
    public void clicModificarRecurso(ActionEvent actionEvent){
        navigationScreen("ModificarEliminarRecursoDocumental.fxml");
    }
    
    public void navigationScreen(String url) {
        try {
            Stage stage = (Stage) imagenLogo.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource(url)));
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
