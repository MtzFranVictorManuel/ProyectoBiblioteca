/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobiblioteca.domain;

/**
 *
 * @author Saulo
 */
public class Documental {
    private static int idRecursoDocumental;
    private static String codigoBarras;
    private static String autor;
    private static String titulo;
    private static String clasificacionLC;
    private static String descripcion;
    private static String editor;
    private static String tema;
    private static String tipoMaterial;
    private static String numCopias;

    public Documental() {
    
    }

    public Documental(int idRecursoDocumental, String codigoBarras, String autor, String titulo, String clasificacionLC, 
        String descripcion, String editor, String tema, String tipoMaterial, String numCopias) {
        this.idRecursoDocumental = idRecursoDocumental;
        this.codigoBarras = codigoBarras;
        this.autor = autor;
        this.titulo = titulo;
        this.clasificacionLC = clasificacionLC;
        this.descripcion = descripcion;
        this.editor = editor;
        this.tema = tema;
        this.tipoMaterial = tipoMaterial;
        this.numCopias = numCopias;
    }

    public int getIdRecursoDocumental() {
        return idRecursoDocumental;
    }

    public void setIdRecursoDocumental(int idRecursoDocumental) {
        Documental.idRecursoDocumental = idRecursoDocumental;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        Documental.codigoBarras = codigoBarras;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        Documental.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public static void setTitulo(String titulo) {
        Documental.titulo = titulo;
    }

    public String getClasificacionLC() {
        return clasificacionLC;
    }

    public void setClasificacionLC(String clasificacionLC) {
        Documental.clasificacionLC = clasificacionLC;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        Documental.descripcion = descripcion;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        Documental.editor = editor;
    }

    public String getTema() {
        return tema;
    }

    public static void setTema(String tema) {
        Documental.tema = tema;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        Documental.tipoMaterial = tipoMaterial;
    }

    public String getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(String numCopias) {
        Documental.numCopias = numCopias;
    }

}
