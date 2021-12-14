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
    private TableView<Documental> tableViewRecusoDocumental;

    private ObservableList<Documental> documentalList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        documentalList = FXCollections.observableArrayList();
        this.columnTitulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.columnAutor.setCellValueFactory(new PropertyValueFactory("autor"));
        this.columnEditor.setCellValueFactory(new PropertyValueFactory("editor"));
        this.columnTema.setCellValueFactory(new PropertyValueFactory("tema"));
        this.columnDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.columnClasificacionLC.setCellValueFactory(new PropertyValueFactory("clasificacionLC"));
        this.columnTipoMaterial.setCellValueFactory(new PropertyValueFactory("tipoMaterial"));
        tableViewRecusoDocumental.setItems(documentalDAO.select(documentalList));
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
