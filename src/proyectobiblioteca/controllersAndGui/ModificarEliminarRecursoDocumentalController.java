/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectobiblioteca.controllersAndGui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import proyectobiblioteca.bussinesslogic.DocumentalConstants;
import proyectobiblioteca.bussinesslogic.DocumentalDAO;
import proyectobiblioteca.domain.Documental;
import sun.net.www.MeteredStream;

/**
 * FXML Controller class
 *
 * @author victormanuel
 */
public class ModificarEliminarRecursoDocumentalController implements Initializable {
    DocumentalDAO documentalDAO = new DocumentalDAO();
    DocumentalConstants documentalConstants = new DocumentalConstants();

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
    private TableColumn columnNumeroCopias;

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

    @FXML
    private TextField textFieldBarraBusqueda;

    private ObservableList<Documental> documentalList;

    private String SQLQuery = "";
    private String valueSearch = ""; 
    private String tipoMaterial = "";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(textFieldBarraBusqueda.getText().isEmpty() || !textFieldBarraBusqueda.getText().isEmpty()){
            SQLQuery = DocumentalConstants.SQL_SELECT;
            tableViewRecursoDocumental.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            setTableView();
            tableViewRecursoDocumental.setItems(documentalDAO.select(documentalList, SQLQuery));
        }       
    }    
    
    public void clicSalir(ActionEvent actionEvent){
        
    }

    public void clicEditar(ActionEvent actionEvent){
        seleccionRecursoEditar();
    }
    public void clicEliminar(ActionEvent actionEvent){
        Alert alertInfo = new Alert(Alert.AlertType.WARNING);
        alertInfo.setTitle("Error");
        alertInfo.setHeaderText("No Implemented Yet!");
        alertInfo.setContentText("Sorry for the inconvenience this button is not working now");
        alertInfo.showAndWait();
    }
    public void clicBuscar(ActionEvent actionEvent){
        setTableView();
        valueSearch = textFieldBarraBusqueda.getText();

        if(!valueSearch.isEmpty() && (!checkListTitulo.isSelected() && !checkListAutor.isSelected() && !checkListEditor.isSelected()
            && !checkListTema.isSelected() && !checkListCodigoBarras.isSelected())) {
            Alert alertInfo = new Alert(Alert.AlertType.WARNING);
            alertInfo.setTitle("No selección de opción");
            alertInfo.setHeaderText("No se selecciono una opción");
            alertInfo.setContentText("Por favor seleccione una casilla para realizar la busqueda correspondiente");
            alertInfo.showAndWait();
        }

        if(valueSearch.isEmpty() && (!checkListTitulo.isSelected() && !checkListAutor.isSelected() && !checkListEditor.isSelected()
            && !checkListTema.isSelected() && !checkListCodigoBarras.isSelected())) {
            SQLQuery = DocumentalConstants.SQL_SELECT;
            tableViewRecursoDocumental.setItems(documentalDAO.select(documentalList, SQLQuery));
        }

        if(!valueSearch.isEmpty() && (checkListTitulo.isSelected() || checkListAutor.isSelected() || checkListEditor.isSelected()
            || checkListTema.isSelected() || checkListCodigoBarras.isSelected())) {        
            tableViewRecursoDocumental.setItems(documentalDAO.select(documentalList, valueSearch, SQLQuery));
            if(documentalList.isEmpty()) {
                Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                alertInfo.setTitle("Información");
                alertInfo.setHeaderText("No se encontró el resultado");
                alertInfo.setContentText("La búsqueda realizada no se encuentra en la base de datos, por favor de ingresar un valor válido.");
                alertInfo.showAndWait();
            }
        } 
        
        if(valueSearch.isEmpty() && (!checkListTitulo.isSelected() && !checkListAutor.isSelected() && !checkListEditor.isSelected()
            && !checkListTema.isSelected() && !checkListCodigoBarras.isSelected())) {
            SQLQuery = DocumentalConstants.SQL_SELECT;
            tableViewRecursoDocumental.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            setTableView();
            tableViewRecursoDocumental.setItems(documentalDAO.select(documentalList, SQLQuery));
            Alert alertInfo = new Alert(Alert.AlertType.WARNING);
            alertInfo.setTitle("Datos no ingresados");
            alertInfo.setHeaderText("Datos de barra de busqueda no ingresados");
            alertInfo.setContentText("Ingrese la información dentro de la barra de busqueda y seleccione algun metodo de busqueda");
            alertInfo.showAndWait();
        }
    }

    public void navigationScreen(String url) {
        try {
            Stage stage = (Stage) textFieldBarraBusqueda.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource(url)));
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setTableView() {
        documentalList = FXCollections.observableArrayList();
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.columnAutor.setCellValueFactory(new PropertyValueFactory("autor"));
        this.columnEditor.setCellValueFactory(new PropertyValueFactory("editor"));
        this.columnTema.setCellValueFactory(new PropertyValueFactory("tema"));
        this.columnDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.columnClasificacionLC.setCellValueFactory(new PropertyValueFactory("clasificacionLC"));
        this.columnTipoMaterial.setCellValueFactory(new PropertyValueFactory("tipoMaterial"));
        this.columnNumeroCopias.setCellValueFactory(new PropertyValueFactory("numCopias"));
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
            SQLQuery = DocumentalConstants.SQL_SELECT_TITULO;
            setCheckBoxEnableOrDisable(false, true, true, true, true);
        } else {
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }

    public void clickAutor(ActionEvent actionEvent) {
        if (checkListAutor.isSelected()) {
            SQLQuery = DocumentalConstants.SQL_SELECT_AUTOR;
            setCheckBoxEnableOrDisable(true, false, true, true, true);
        } else {
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }

    public void clickEditor(ActionEvent actionEvent) {
        if (checkListEditor.isSelected()) {
            SQLQuery = DocumentalConstants.SQL_SELECT_EDITOR;
            setCheckBoxEnableOrDisable(true, true, false, true, true);
        } else {
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }

    public void clickTema(ActionEvent actionEvent) {
        if (checkListTema.isSelected()) {
            SQLQuery = DocumentalConstants.SQL_SELECT_TEMA;
            setCheckBoxEnableOrDisable(true, true, true, false, true);
        } else { 
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }

    public void clickCodigoBarras(ActionEvent actionEvent) {
        if (checkListCodigoBarras.isSelected()) {
            SQLQuery = DocumentalConstants.SQL_SELECT_CODIGOBARRAS;
            setCheckBoxEnableOrDisable(true, true, true, true, false);
        } else {
            setCheckBoxEnableOrDisable(false, false, false, false, false);
        }
    }
    
    private void seleccionRecursoEditar(){
        try{
            Documental documentoEditar = tableViewRecursoDocumental.getSelectionModel().getSelectedItem();
            int idDocumento = documentoEditar.getIdRecursoDocumental();
            String titulo = documentoEditar.getTitulo();
            String materialDocumental = documentoEditar.getTipoMaterial();
            if (materialDocumental == null) {
                Alert alertInfo = new Alert(Alert.AlertType.WARNING);
                alertInfo.setTitle("Error");
                alertInfo.setHeaderText("No Row Selected");
                alertInfo.setContentText("Please select a row to edit");
                alertInfo.showAndWait();
            }else {
                if(materialDocumental.equals("libro")){
                    Documental.setIdRecursoDocumentalGuarda(idDocumento);
                    navigationScreen("ModificarLibro.fxml");
                }
                if(materialDocumental.equals("multimedia")) {
                    Documental.setIdRecursoDocumentalGuarda(idDocumento);
                    navigationScreen("ModificarMultimedia.fxml");
                }
            }
        }catch(NullPointerException exepcion){
            Alert alertInfo = new Alert(Alert.AlertType.WARNING);
            alertInfo.setTitle("No selección");
            alertInfo.setHeaderText("No selecciono un elemento de la tabla");
            alertInfo.setContentText("No se ha seleccionado un elemento dentro de la tabla, por favor seleccione un elemento.");
            alertInfo.showAndWait();
        }
    }
}
