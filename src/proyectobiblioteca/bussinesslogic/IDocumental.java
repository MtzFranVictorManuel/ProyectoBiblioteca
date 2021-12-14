/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectobiblioteca.bussinesslogic;

import javafx.collections.ObservableList;
import proyectobiblioteca.domain.Documental;
/**
 *
 * @author Saulo
 */
public interface IDocumental {

    public ObservableList<Documental> select(ObservableList<Documental> tableInfo, String SQLQuery);

    public ObservableList<Documental> select(ObservableList<Documental> tableInfo, String value, String SQLQuery);

    public boolean update(Documental documental, int idRecursoDocumental);
    
    public boolean updateCopia(int idRecursoDocumental);
    
    public Documental selectCopiaExistes(String codigoBarras, String titulo, String tipoMaterial);

    public int insert(Documental documental);
    
    public boolean delete(Documental documental);
}
