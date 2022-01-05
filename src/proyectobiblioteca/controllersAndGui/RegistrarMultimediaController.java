package proyectobiblioteca.controllersAndGui;

import java.net.URL;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.util.converter.DateTimeStringConverter;
import proyectobiblioteca.bussinesslogic.DocumentalDAO;
import proyectobiblioteca.bussinesslogic.MultimediaDAO;
import proyectobiblioteca.domain.Documental;
import proyectobiblioteca.domain.Multimedia;

/**
 * FXML Controller class
 *
 * @author victormanuel
 */
public class RegistrarMultimediaController implements Initializable {
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        formatoNumerico();
        textFieldDuraionSegundos.setText("00");
        textFieldDuraionMinutos.setText("00");
        textFieldDuraionHora.setText("00");
        
    }    
    
    public void clicSalir(ActionEvent actionEvent){
        
    }
    
    public void clicRegistrar(ActionEvent actionEvent){
        String codigoBarra = textFieldCodigoBarras.getText();
        String tituloMultimedia = textFieldTitulo.getText();
        String tipoMaterial = "multimedia";
        String duracion = textFieldDuraionHora.getText() + ":" + 
                textFieldDuraionMinutos.getText() + ":" + textFieldDuraionSegundos.getText();
        int idRecursoDocumental;
        if(textFieldAutor.getText().isEmpty() || textFieldClasificacionLC.getText().isEmpty() || textFieldCodigoBarras.getText().isEmpty() ||
                textFieldDescripcion.getText().isEmpty() || textFieldDuraionHora.getText().isEmpty() || textFieldDuraionMinutos.getText().isEmpty()
                || textFieldDuraionSegundos.getText().isEmpty() || textFieldEditor.getText().isEmpty() || textFieldFormato.getText().isEmpty() ||
                textFieldTemas.getText().isEmpty() || textFieldTipoDocumento.getText().isEmpty() || textFieldTitulo.getText().isEmpty()){
            datosCorrectos(true);
            datosErroenes(true);
            Alert alertInfo = new Alert(Alert.AlertType.ERROR);
            alertInfo.setTitle("Datos vacíos");
            alertInfo.setContentText("Los datos ingresados son vacions, por favor de validar que los datos sean correctos.");
            alertInfo.showAndWait();
        }else{
            datosCorrectos(true);
            if(documentaldao.selectCopiaExistes(codigoBarra, tituloMultimedia, tipoMaterial) == false){
                documentaldao.insert(textFieldCodigoBarras.getText(), textFieldAutor.getText(), 
                        textFieldTitulo.getText(), textFieldClasificacionLC.getText(), 
                        textFieldDescripcion.getText(), textFieldEditor.getText(), textFieldTemas.getText(), tipoMaterial, 1);
                idRecursoDocumental = documentaldao.selectIdRecursoDocumental(textFieldTitulo.getText(), textFieldCodigoBarras.getText(), textFieldAutor.getText());
                limpiarCampos();
                if(idRecursoDocumental == 0){
                    Alert alertInfo = new Alert(Alert.AlertType.WARNING);
                    alertInfo.setTitle("Error");
                    alertInfo.setHeaderText("No se guardo el recurso documental");
                    alertInfo.setContentText("El recurso documental ingresado no fue guardado correctamente");
                    alertInfo.showAndWait();
                }
                multimedidao.insert(textFieldTipoDocumento.getText(), Time.valueOf(duracion), textFieldFormato.getText(), idRecursoDocumental);            
            }else{
                if(alertaConfirmacion("Copias", "", "")== true){
                    idRecursoDocumental = documentaldao.selectIdRecursoDocumental(textFieldTitulo.getText(), textFieldCodigoBarras.getText(), textFieldAutor.getText());
                    documentaldao.updateCopia(idRecursoDocumental);
                    limpiarCampos();
                }
            } 
        }
    }
   
    public boolean alertaConfirmacion(String title, String headerText, String contentText){
        Alert alertEmptyInfo = new Alert(Alert.AlertType.CONFIRMATION);
        alertEmptyInfo.setTitle(title);
        alertEmptyInfo.setHeaderText(headerText);
        alertEmptyInfo.setContentText(contentText);
        Optional<ButtonType> result = alertEmptyInfo.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            return true;
        }
        return false;
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
    
    public boolean datosErroenes(boolean validar){
        while(validar == true){
            if(textFieldAutor.getText().isEmpty()){
                textFieldAutor.setStyle("-fx-border-color: red;");
            }if(textFieldClasificacionLC.getText().isEmpty()){
                textFieldClasificacionLC.setStyle("-fx-border-color: red;");
            }if(textFieldCodigoBarras.getText().isEmpty()){
                textFieldCodigoBarras.setStyle("-fx-border-color: red;");
            }if(textFieldDescripcion.getText().isEmpty()){
                textFieldDescripcion.setStyle("-fx-border-color: red;");
            }if(textFieldDuraionHora.getText().equals("00") || textFieldDuraionHora.getText().isEmpty()){
                textFieldDuraionHora.setStyle("-fx-border-color: red;");
            }if(textFieldDuraionMinutos.getText().equals("00") || textFieldDuraionMinutos.getText().isEmpty()){
                textFieldDuraionMinutos.setStyle("-fx-border-color: red;");
            }if(textFieldDuraionSegundos.getText().equals("00") || textFieldDuraionSegundos.getText().isEmpty()){
                textFieldDuraionSegundos.setStyle("-fx-border-color: red;");
            }if(textFieldEditor.getText().isEmpty()){
                textFieldEditor.setStyle("-fx-border-color: red;");
            }if(textFieldFormato.getText().isEmpty()){
                textFieldFormato.setStyle("-fx-border-color: red;");
            }if(textFieldTemas.getText().isEmpty()){
                textFieldTemas.setStyle("-fx-border-color: red;");
            }if(textFieldTipoDocumento.getText().isEmpty()){
                textFieldTipoDocumento.setStyle("-fx-border-color: red;");
            }if(textFieldTitulo.getText().isEmpty()){
                textFieldTitulo.setStyle("-fx-border-color: red;");
            }
            return validar = true;
        }
        return false;
    }
    
    public boolean datosCorrectos(boolean validar){
        while(validar == true){
            if(!textFieldAutor.getText().isEmpty()){
                textFieldAutor.setStyle("-fx-border-color: off;");
            }if(!textFieldClasificacionLC.getText().isEmpty()){
                textFieldClasificacionLC.setStyle("-fx-border-color: off;");
            }if(!textFieldCodigoBarras.getText().isEmpty()){
                textFieldCodigoBarras.setStyle("-fx-border-color: off;");
            }if(!textFieldDescripcion.getText().isEmpty()){
                textFieldDescripcion.setStyle("-fx-border-color: off;");
            }if(!textFieldDuraionHora.getText().equals("00") || textFieldDuraionHora.getText().isEmpty()){
                textFieldDuraionHora.setStyle("-fx-border-color: off;");
            }if(!textFieldDuraionMinutos.getText().equals("00") || textFieldDuraionMinutos.getText().isEmpty()){
                textFieldDuraionMinutos.setStyle("-fx-border-color: off;");
            }if(!textFieldDuraionSegundos.getText().equals("00") || textFieldDuraionSegundos.getText().isEmpty()){
                textFieldDuraionSegundos.setStyle("-fx-border-color: off;");
            }if(!textFieldEditor.getText().isEmpty()){
                textFieldEditor.setStyle("-fx-border-color: off;");
            }if(!textFieldFormato.getText().isEmpty()){
                textFieldFormato.setStyle("-fx-border-color: off;");
            }if(!textFieldTemas.getText().isEmpty()){
                textFieldTemas.setStyle("-fx-border-color: off;");
            }if(!textFieldTipoDocumento.getText().isEmpty()){
                textFieldTipoDocumento.setStyle("-fx-border-color: off;");
            }if(!textFieldTitulo.getText().isEmpty()){
                textFieldTitulo.setStyle("-fx-border-color: off;");
            }
            return validar = true;
        }
        return false;
    }
    
    public void limpiarCampos(){
        textFieldAutor.setText("");
        textFieldClasificacionLC.setText("");
        textFieldCodigoBarras.setText("");
        textFieldDescripcion.setText("");
        textFieldDuraionHora.setText("00");
        textFieldDuraionMinutos.setText("00");
        textFieldDuraionSegundos.setText("00");
        textFieldEditor.setText("");
        textFieldFormato.setText("");
        textFieldTemas.setText("");
        textFieldTipoDocumento.setText("");
        textFieldTitulo.setText("");
    }
}
