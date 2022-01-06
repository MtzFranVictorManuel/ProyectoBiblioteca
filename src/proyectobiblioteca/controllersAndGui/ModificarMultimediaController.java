/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectobiblioteca.controllersAndGui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import proyectobiblioteca.bussinesslogic.DocumentalDAO;
import proyectobiblioteca.bussinesslogic.MultimediaDAO;
import proyectobiblioteca.domain.Documental;
import proyectobiblioteca.domain.Multimedia;

/**
 * FXML Controller class
 *
 * @author victormanuel
 */
public class ModificarMultimediaController implements Initializable {
    MultimediaDAO multimedidao = new MultimediaDAO();
    DocumentalDAO documentaldao = new DocumentalDAO();
    Multimedia multimedia = new Multimedia();
    Documental documento = new Documental();
    
    @FXML
    private TextField textFieldTitulo;
    
    @FXML
    private TextField textFieldAutor;
    
    @FXML
    private TextField textFieldEditor;
    
    @FXML
    private TextField textFieldTemas;
    
    @FXML
    private TextField textFieldClasificacionLC;
    
    @FXML
    private TextField textFieldDuraionHora;
    
    @FXML
    private TextField textFieldDuraionMinutos;
    
    @FXML
    private TextField textFieldDuraionSegundos;
    
    @FXML
    private TextField textFieldFormato;
    
    @FXML
    private TextField textFieldTipoDocumento;
                
    @FXML
    private TextField textFieldCodigoBarras;
            
    @FXML
    private TextArea textFieldDescripcion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void clicSalir(ActionEvent actionEvent){
        navigationScreen("ModificarEliminarRecursoDocumental.fxml");
    }
    
    public void clicRegistrar(ActionEvent actionEvent){
        navigationScreen("ModificarEliminarRecursoDocumental.fxml");
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
    
        
    public void formatoNumerico(){
        textFieldDuraionHora.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 if(!newValue.matches("\\d*")){
                     textFieldDuraionHora.setText(newValue.replaceAll("[^\\d]", ""));
                 }               
                 if(textFieldDuraionHora.getText().length()>2){
                     String hora = textFieldDuraionHora.getText().substring(0, 2);
                     textFieldDuraionHora.setText(hora);
                 }
            }               
        }); 
        textFieldDuraionMinutos.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 if(!newValue.matches("\\d*")){
                     textFieldDuraionMinutos.setText(newValue.replaceAll("[^\\d]", ""));
                 }               
                 if(textFieldDuraionMinutos.getText().length()>2){
                     String hora = textFieldDuraionMinutos.getText().substring(0, 2);
                     textFieldDuraionMinutos.setText(hora);
                 }
            }               
        }); 
        textFieldDuraionSegundos.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 if(!newValue.matches("\\d*")){
                     textFieldDuraionSegundos.setText(newValue.replaceAll("[^\\d]", ""));
                 }               
                 if(textFieldDuraionSegundos.getText().length()>2){
                     String hora = textFieldDuraionSegundos.getText().substring(0, 2);
                     textFieldDuraionSegundos.setText(hora);
                 }
            }               
        }); 
        textFieldCodigoBarras.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 if(!newValue.matches("\\d*")){
                     textFieldCodigoBarras.setText(newValue.replaceAll("[^\\d]", ""));
                 }               
            }               
        }); 
    }
    
    @FXML
    private void maximoTiempo(KeyEvent event){
        try{
            int horas = Integer.parseInt(textFieldDuraionHora.getText());
            int segundos = Integer.parseInt(textFieldDuraionSegundos.getText());
            int minutos = Integer.parseInt(textFieldDuraionMinutos.getText());
            if(segundos >= 60){
                minutos = minutos + 1;
                segundos = segundos - 60;
                String minutosNuevos = String.valueOf(minutos);
                String segundosNuevos = String.valueOf(segundos);
                textFieldDuraionSegundos.setText(segundosNuevos);
                textFieldDuraionMinutos.setText(minutosNuevos);
            }else if(minutos >= 60){
                horas = horas + 1;
                minutos = minutos - 60;
                String horasNuevo = String.valueOf(horas);
                String minutosNuevo = String.valueOf(minutos);
                textFieldDuraionHora.setText(horasNuevo);
                textFieldDuraionMinutos.setText(minutosNuevo);
            }else if(horas >= 24){
                Alert alertInfo = new Alert(Alert.AlertType.WARNING);
                alertInfo.setTitle("Error");
                alertInfo.setHeaderText("Numero de horas mayor");
                alertInfo.setContentText("El numero de horas que se ingresa son mayores a 24 horas, verifique que el tiempo sea correcto.");
                alertInfo.showAndWait();
            }
        }catch(NumberFormatException numerosExc){
            Logger.getLogger(RegistrarMultimediaController.class.getName()).log(Level.SEVERE, null, numerosExc);
        }   
    }
}
