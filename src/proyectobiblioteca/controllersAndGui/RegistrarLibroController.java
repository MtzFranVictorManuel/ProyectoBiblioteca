package proyectobiblioteca.controllersAndGui;

import java.net.URL;
import java.sql.Date;
import static java.time.temporal.TemporalQueries.zone;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import proyectobiblioteca.bussinesslogic.DocumentalDAO;
import proyectobiblioteca.bussinesslogic.LibroDAO;
import proyectobiblioteca.domain.Documental;
import proyectobiblioteca.domain.Libro;

/**
 * FXML Controller class
 *
 * @author victormanuel
 */
public class RegistrarLibroController implements Initializable {
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
    private DatePicker datePickerFechaPublicacion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
        
    public void clicSalir(ActionEvent actionEvent){
        
    }
    
    public void clicRegistrar(ActionEvent actionEvent){       
            String codigoBarra = textFieldCodigoBarras.getText();
            String tituloLibro = textFieldTitulo.getText();
            String tipoMaterial = "libro";
            int volumenLibro = Integer.parseInt(textFieldVolumen.getText());
            int idRecursoDocumental;
            Date fechaPublicacion = Date.valueOf(datePickerFechaPublicacion.getValue()); 
            if(textFieldAutor.getText().isEmpty() || textFieldClasificacionLC.getText().isEmpty()
                    || textFieldCodigoBarras.getText().isEmpty() || textFieldDescripcion.getText().isEmpty()
                    || textFieldEdicion.getText().isEmpty() || textFieldEditor.getText().isEmpty() || textFieldIdioma.getText().isEmpty()
                    || textFieldIsbn.getText().isEmpty() || textFieldSerie.getText().isEmpty() || textFieldTemas.getText().isEmpty() 
                    || textFieldTipoObra.getText().isEmpty() || textFieldTitulo.getText().isEmpty() || textFieldVolumen.getText().isEmpty()
                    || datePickerFechaPublicacion.getValue() == null){
                datosCorrectos(true);
                datosErroneso(true);
                Alert alertInfo = new Alert(Alert.AlertType.ERROR);
                alertInfo.setTitle("Datos vacíos");
                alertInfo.setContentText("Los datos ingresados son vacions, por favor de validar que los datos sean correctos.");
                alertInfo.showAndWait();
            }else{
                datosCorrectos(true);
                if(documentaldao.selectCopiaExistes(codigoBarra, tituloLibro, tipoMaterial) == false){
                    documentaldao.insert(codigoBarra, textFieldAutor.getText(), tituloLibro, textFieldClasificacionLC.getText(), 
                            textFieldDescripcion.getText(), textFieldEditor.getText(), textFieldTemas.getText(), tipoMaterial, 1);
                    idRecursoDocumental = documentaldao.selectIdRecursoDocumental(tituloLibro, codigoBarra, textFieldAutor.getText());
                    if(idRecursoDocumental == 0){
                        Alert alertInfo = new Alert(Alert.AlertType.WARNING);
                        alertInfo.setTitle("Error");
                        alertInfo.setHeaderText("No se guardo el recurso documental");
                        alertInfo.setContentText("El recurso documental ingresado no fue guardado correctamente");
                        alertInfo.showAndWait();
                    }
                    Libro libroNuevo = new Libro();
                    libroNuevo.setEdicion(textFieldEdicion.getText());
                    libroNuevo.setIsbn(textFieldIsbn.getText());
                    libroNuevo.setFechaPublicacion(fechaPublicacion);
                    libroNuevo.setIdioma(textFieldIdioma.getText());
                    libroNuevo.setSerie(textFieldSerie.getText());
                    libroNuevo.setVolumen(volumenLibro);
                    libroNuevo.setTipoObraLiteraria(textFieldTipoObra.getText());
                    librodao.insertar(libroNuevo, idRecursoDocumental);
                    limpiarCampos();
                }
            }
    }   
    
    
    public boolean datosErroneso(boolean validar){
        while(validar == true){
            if(textFieldAutor.getText().isEmpty()){
                textFieldAutor.setStyle("-fx-border-color: red;");
            }if(textFieldClasificacionLC.getText().isEmpty()){
                textFieldClasificacionLC.setStyle("-fx-border-color: red;");
            }if(textFieldCodigoBarras.getText().isEmpty()){
                textFieldCodigoBarras.setStyle("-fx-border-color: red;");
            }if(textFieldDescripcion.getText().isEmpty()){
                textFieldDescripcion.setStyle("-fx-border-color: red;");
            }if(textFieldEdicion.getText().isEmpty()){
                textFieldEdicion.setStyle("-fx-border-color: red;");
            }if(textFieldEditor.getText().isEmpty()){
                textFieldEditor.setStyle("-fx-border-color: red;");
            }if(textFieldIdioma.getText().isEmpty()){
                textFieldIdioma.setStyle("-fx-border-color: red;");
            }if(textFieldIsbn.getText().isEmpty()){
                textFieldIsbn.setStyle("-fx-border-color: red;");
            }if(textFieldSerie.getText().isEmpty()){
                textFieldSerie.setStyle("-fx-border-color: red;");
            }if(textFieldTemas.getText().isEmpty()){
                textFieldTemas.setStyle("-fx-border-color: red;");
            }if(textFieldTipoObra.getText().isEmpty()){
                textFieldTipoObra.setStyle("-fx-border-color: red;");
            }if(textFieldTitulo.getText().isEmpty()){
                textFieldTitulo.setStyle("-fx-border-color: red;");
            }if(textFieldVolumen.getText().isEmpty()){
                textFieldVolumen.setStyle("-fx-border-color: red;");
            }if(datePickerFechaPublicacion.getValue() == null){
                datePickerFechaPublicacion.setStyle("-fx-border-color: red;");
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
            }if(!textFieldEdicion.getText().isEmpty()){
                textFieldEdicion.setStyle("-fx-border-color: off;");
            }if(!textFieldEditor.getText().isEmpty()){
                textFieldEditor.setStyle("-fx-border-color: off;");
            }if(!textFieldIdioma.getText().isEmpty()){
                textFieldIdioma.setStyle("-fx-border-color: off;");
            }if(!textFieldIsbn.getText().isEmpty()){
                textFieldIsbn.setStyle("-fx-border-color: off;");
            }if(!textFieldSerie.getText().isEmpty()){
                textFieldSerie.setStyle("-fx-border-color: off;");
            }if(!textFieldTemas.getText().isEmpty()){
                textFieldTemas.setStyle("-fx-border-color: off;");
            }if(!textFieldTipoObra.getText().isEmpty()){
                textFieldTipoObra.setStyle("-fx-border-color: off;");
            }if(!textFieldTitulo.getText().isEmpty()){
                textFieldTitulo.setStyle("-fx-border-color: off;");
            }if(!textFieldVolumen.getText().isEmpty()){
                textFieldVolumen.setStyle("-fx-border-color: off;");
            }if(datePickerFechaPublicacion.getValue() != null){
                datePickerFechaPublicacion.setStyle("-fx-border-color: off;");
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
        textFieldEdicion.setText("");
        textFieldEditor.setText("");
        textFieldIdioma.setText("");
        textFieldIsbn.setText("");
        textFieldSerie.setText("");
        textFieldTemas.setText("");
        textFieldTipoObra.setText("");
        textFieldTitulo.setText("");
        textFieldVolumen.setText("");
        datePickerFechaPublicacion.setValue(null);
    }
}
