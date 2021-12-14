/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectobiblioteca.controllersAndGui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import proyectobiblioteca.bussinesslogic.DocumentalDAO;
import proyectobiblioteca.domain.Documental;

/**
 * FXML Controller class
 *
 * @author victormanuel
 */
public class ModificarEliminarRecursoDocumentalController implements Initializable {
    DocumentalDAO documentalDAO = new DocumentalDAO();

    @FXML
    private TableColumn columnTitulo;

    @FXML
    private TableColumn columnAutor;

    @FXML
    private TableColumn columnEditor;

    @FXML
    private TableColumn columnTema;

    @FXML
    private TableColumn columnDescripcion;

    @FXML
    private TableColumn columnClasificacionLC;

    @FXML
    private TableColumn columnTipoMaterial;

    @FXML
    private TableView<Documental> tableViewRecursoDocumental;

    @FXML
    private CheckBox checkListTitulo;

    @FXML
    private CheckBox checkListAutor;

    @FXML
    private CheckBox checkListEditor;

    @FXML
    private CheckBox checkListTema;

    @FXML
    private CheckBox checkListCodigoBarras;

    private ObservableList<Documental> documentalList;

    private String filter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filter = "";
        setTableView();
        tableViewRecursoDocumental.setItems(documentalDAO.select(documentalList));
    }    
    
    public void clicSalir(ActionEvent actionEvent){
        
    }
    public void clicEditar(ActionEvent actionEvent){
        
    }
    public void clicEliminar(ActionEvent actionEvent){
        
    }
    public void clicBuscar(ActionEvent actionEvent){
        setTableView();
        //tableViewRecursoDocumental.setItems(documentalDAO.selectEditor(documentalList, "XALAPA" ,documentalDAO.SQL_SELECT_EDITOR));
    }

    public void setTableView() {
        documentalList = FXCollections.observableArrayList();
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.columnAutor.setCellValueFactory(new PropertyValueFactory("autor"));
        this.columnEditor.setCellValueFactory(new PropertyValueFactory("editor"));
        this.columnTema.setCellValueFactory(new PropertyValueFactory("tema"));
        this.columnDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.columnClasificacionLC.setCellValueFactory(new PropertyValueFactory("clasificacionLC"));
    }

    public void setCheckBoxEnableOrDisable(boolean titulo, boolean autor, boolean editor, boolean tema, boolean codigoBarras) {
        checkListTitulo.setDisable(titulo);
        checkListAutor.setDisable(autor);
        checkListEditor.setDisable(editor);
        checkListTema.setDisable(tema);
        checkListCodigoBarras.setDisable(codigoBarras);
    }

    public void clickTitulo(ActionEvent actionEvent) {
        if (checkListTitulo.isSelected()) {
            filter = "titulo";
            setCheckBoxEnableOrDisable(false, true, true, true, true);
        } else {
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }

    public void clickAutor(ActionEvent actionEvent) {
        if (checkListAutor.isSelected()) {
            filter = "autor";
            setCheckBoxEnableOrDisable(true, false, true, true, true);
        } else {
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }

    public void clickEditor(ActionEvent actionEvent) {
        if (checkListEditor.isSelected()) {
            filter = "editor";
            setCheckBoxEnableOrDisable(true, true, false, true, true);
        } else {
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }

    public void clickTema(ActionEvent actionEvent) {
        if (checkListTema.isSelected()) {
            filter = "tema";
            setCheckBoxEnableOrDisable(true, true, true, false, true);
        } else { 
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }

    public void clickCodigoBarras(ActionEvent actionEvent) {
        if (checkListCodigoBarras.isSelected()) {
            filter = "codigobarras";
            setCheckBoxEnableOrDisable(true, true, true, true, false);
        } else {
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }
}
