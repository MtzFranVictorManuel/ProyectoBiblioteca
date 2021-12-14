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
        SQLQuery = DocumentalConstants.SQL_SELECT;
        tableViewRecursoDocumental.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        setTableView();
        tableViewRecursoDocumental.setItems(documentalDAO.select(documentalList, SQLQuery));
    }    
    
    public void clicSalir(ActionEvent actionEvent){
        
    }

    public void clicEditar(ActionEvent actionEvent){
        Documental documental = new Documental();
        documentalList = tableViewRecursoDocumental.getSelectionModel().getSelectedItems();
        if (documentalList.isEmpty()) {
            Alert alertInfo = new Alert(Alert.AlertType.WARNING);
            alertInfo.setTitle("Error");
            alertInfo.setHeaderText("No Row Selected");
            alertInfo.setContentText("Please select a row to edit");
            alertInfo.showAndWait();
        } else {
            documental = documentalList.get(0);
            tipoMaterial = documental.getTipoMaterial();
            if(tipoMaterial.equals("Libro")) {
                navigationScreen("RegistrarLibro.fxml");
            }
            if(tipoMaterial.equals("Multimedia")) {
                navigationScreen("RegistrarMultimedia.fxml");
            }
        }
    }
    public void clicEliminar(ActionEvent actionEvent){
        
    }
    public void clicBuscar(ActionEvent actionEvent){
        setTableView();
        valueSearch = textFieldBarraBusqueda.getText();

        if(!valueSearch.isEmpty() && (!checkListTitulo.isSelected() && !checkListAutor.isSelected() && !checkListEditor.isSelected()
            && !checkListTema.isSelected() && !checkListCodigoBarras.isSelected())) {
            Alert alertInfo = new Alert(Alert.AlertType.WARNING);
            alertInfo.setTitle("Error");
            alertInfo.setHeaderText("No Option Selected");
            alertInfo.setContentText("Please select a option to do the search");
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
                alertInfo.setTitle("INFORMATION");
                alertInfo.setHeaderText("NO RESULTS");
                alertInfo.setContentText("The consult you make does not have any results in the database.");
                alertInfo.showAndWait();
            }
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
}
