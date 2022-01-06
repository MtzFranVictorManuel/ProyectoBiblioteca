/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobiblioteca.domain;

/**
 *
 * @author victormanuel
 */
public class Documental {
    private int idRecursoDocumental;
    private String codigoBarras;
    private String autor;
    private String titulo;
    private String clasificacionLC;
    private String descripcion;
    private String editor;
    private String tema;
    private String tipoMaterial;
    private int numCopias;
    private static int idRecursoDocumentalGuarda;

    public Documental() {
    
    }

    public Documental(int idRecursoDocumental) {
        this.idRecursoDocumental = idRecursoDocumental;
    }

    public Documental(String codigoBarras, String autor, String titulo, String clasificacionLC, String descripcion, String editor, String tema, String tipoMaterial, int numCopias) {
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

    public Documental(int idRecursoDocumental, String codigoBarras, String autor, String titulo, String clasificacionLC, 
        String descripcion, String editor, String tema, String tipoMaterial, int numCopias) {
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
        this.idRecursoDocumental = idRecursoDocumental;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClasificacionLC() {
        return clasificacionLC;
    }

    public void setClasificacionLC(String clasificacionLC) {
        this.clasificacionLC = clasificacionLC;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }

    public static int getIdRecursoDocumentalGuarda() {
        return idRecursoDocumentalGuarda;
    }

    public static void setIdRecursoDocumentalGuarda(int idRecursoDocumentalGuarda) {
        Documental.idRecursoDocumentalGuarda = idRecursoDocumentalGuarda;
    }
}
