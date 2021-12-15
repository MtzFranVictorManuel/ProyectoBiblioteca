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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.DataFormat;
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
    private TextField textFieldTitulo, textFieldAutor, textFieldEditor, 
            textFieldTemas, textFieldClasificacionLC,
            textFieldDuraion, textFieldFormato, textFieldTipoDocumento, textFieldCodigoBarras;
    
    @FXML
    private TextArea textFieldDescripcion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void clicSalir(ActionEvent actionEvent){
        
    }
    
    public void clicRegistrar(ActionEvent actionEvent){
        String codigoBarra = textFieldCodigoBarras.getText();
        String tituloMultimedia = textFieldTitulo.getText();
        String tipoMaterial = "multimedia";
        int idRecursoDocumental;
        if(documentaldao.selectCopiaExistes(codigoBarra, tituloMultimedia, tipoMaterial) == false){
            documentaldao.insert(textFieldCodigoBarras.getText(), textFieldAutor.getText(), 
                    textFieldTitulo.getText(), textFieldClasificacionLC.getText(), 
                    textFieldDescripcion.getText(), textFieldEditor.getText(), textFieldTemas.getText(), tipoMaterial, 0);
            idRecursoDocumental = documentaldao.selectIdRecursoDocumental(textFieldTitulo.getText(), textFieldCodigoBarras.getText(), textFieldAutor.getText());
            System.out.println(idRecursoDocumental);
            if(idRecursoDocumental == 0){
                Alert alertInfo = new Alert(Alert.AlertType.WARNING);
                alertInfo.setTitle("Error");
                alertInfo.setHeaderText("No se guardo el recurso documental");
                alertInfo.setContentText("El recurso documental ingresado no fue guardado correctamente");
                alertInfo.showAndWait();
            }
        multimedidao.insert(textFieldTipoDocumento.getText(), Time.valueOf(textFieldDuraion.getText()), textFieldFormato.getText(), idRecursoDocumental);            
        }else{
            if(alertaConfirmacion("", "", "")== true){
                idRecursoDocumental = documentaldao.selectIdRecursoDocumental(textFieldTitulo.getText(), textFieldCodigoBarras.getText(), textFieldAutor.getText());
                documentaldao.updateCopia(idRecursoDocumental);
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
}
