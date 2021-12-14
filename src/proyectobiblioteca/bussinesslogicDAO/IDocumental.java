/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectobiblioteca.bussinesslogicDAO;

import proyectobiblioteca.domain.Documental;

/**
 *
 * @author Saulo
 */
public interface IDocumental {

    public Documental select();

    public int update(Documental documental, int idRecursoDocumental);
}
