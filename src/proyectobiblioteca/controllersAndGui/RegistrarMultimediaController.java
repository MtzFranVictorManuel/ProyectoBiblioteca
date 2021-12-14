package proyectobiblioteca.controllersAndGui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
        String tipoMaterial = "libro";
        if(documentaldao.selectCopiaExistes(codigoBarra, tituloMultimedia, tipoMaterial) == false){
            System.out.println("no existe");
        }else{
            System.out.println("Si existe");
        }
        
    }

}
