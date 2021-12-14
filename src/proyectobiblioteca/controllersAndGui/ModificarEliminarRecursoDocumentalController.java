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
    private TableView<Documental> tableViewDocumental;

    private ObservableList<Documental> documentalList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        documentalList = FXCollections.observableArrayList();
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("columnTitulo"));
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("columnAutor"));
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("columnEditor"));
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("columnTemas"));
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("columnDescripcion"));
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("columnClasificacion"));
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("columTipoMaterial"));
        tableViewDocumental.setItems(documentalDAO.select(documentalList));
    }    
    
    public void clicSalir(ActionEvent actionEvent){
        
    }
    public void clicEditar(ActionEvent actionEvent){
        
    }
    public void clicEliminar(ActionEvent actionEvent){
        
    }
    public void clicBuscar(ActionEvent actionEvent){
        
    }
}
