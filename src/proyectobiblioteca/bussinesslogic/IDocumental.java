/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectobiblioteca.bussinesslogic;

import javafx.collections.ObservableList;
import proyectobiblioteca.domain.Documental;
/**
 *
 * @author victormanuel
 */
public interface IDocumental {

    public ObservableList<Documental> select(ObservableList<Documental> tableInfo, String SQLQuery);

    public ObservableList<Documental> select(ObservableList<Documental> tableInfo, String value, String SQLQuery);

    public boolean update(Documental documental, int idRecursoDocumental);
    
    public boolean updateCopia(int idRecursoDocumental);
    
    public boolean selectCopiaExistes(String codigoBarras, String titulo, String tipoMaterial);

    public int insert(String codigoBarras, String autor, String titulo, String clasificacionLC, 
            String descripcion, String editor, String tema, String tipoMaterial, int numCopias);
    
    public boolean delete(Documental documental);
    
    public int selectIdRecursoDocumental(String titulo, String codigoBarras, String autor);
}
