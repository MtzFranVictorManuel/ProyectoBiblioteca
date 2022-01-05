/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectobiblioteca.bussinesslogic;

import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectobiblioteca.domain.Documental;

/**
 *
 * @author victormanuel
 */
public class DocumentalDAOTest {
    
    public DocumentalDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of select method, of class DocumentalDAO.
     */
    @Test
    public void testSelect_ObservableList_String() {
        System.out.println("select");
        ObservableList<Documental> tableInfo = null;
        String SQLQuery = "";
        DocumentalDAO instance = new DocumentalDAO();
        ObservableList<Documental> expResult = null;
        ObservableList<Documental> result = instance.select(tableInfo, SQLQuery);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select method, of class DocumentalDAO.
     */
    @Test
    public void testSelect_3args() {
        System.out.println("select");
        ObservableList<Documental> tableInfo = null;
        String value = "";
        String SQLQuery = "";
        DocumentalDAO instance = new DocumentalDAO();
        ObservableList<Documental> expResult = null;
        ObservableList<Documental> result = instance.select(tableInfo, value, SQLQuery);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DocumentalDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Documental documental = null;
        int idRecursoDocumental = 0;
        DocumentalDAO instance = new DocumentalDAO();
        boolean expResult = false;
        boolean result = instance.update(documental, idRecursoDocumental);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCopia method, of class DocumentalDAO.
     */
    @Test
    public void testUpdateCopia() {
        System.out.println("updateCopia");
        int idRecursoDocumental = 9;
        DocumentalDAO instance = new DocumentalDAO();
        boolean expResult = false;
        boolean result = instance.updateCopia(idRecursoDocumental);
        if(result == false){
            fail("mal");
        }else{
            System.out.println("good");
        }
    }

    /**
     * Test of selectCopiaExistes method, of class DocumentalDAO.
     */
    @Test
    public void testSelectCopiaExistes() {
        System.out.println("selectCopiaExistes");
        String codigoBarras = "";
        String titulo = "";
        String tipoMaterial = "";
        DocumentalDAO instance = new DocumentalDAO();
        boolean expResult = false;
        boolean result = instance.selectCopiaExistes(codigoBarras, titulo, tipoMaterial);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class DocumentalDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String codigoBarras = "2394723";
        String autor = "EllonMosk";
        String titulo = "El universo";
        String clasificacionLC = "CFFG -TG56";
        String descripcion = "Libro del universo";
        String editor = "mundo";
        String tema = "El universo";
        String tipoMaterial = "libro";
        int numCopias = 0;
        DocumentalDAO instance = new DocumentalDAO();
        int expResult = 0;
        int result = instance.insert(codigoBarras, autor, titulo, clasificacionLC, descripcion, editor, tema, tipoMaterial, numCopias);
        assertEquals(expResult, result);
        if(result == 0){
            fail("The test case is a prototype.");
        }else{
            System.out.println("Bueno");
        }        
    }

    /**
     * Test of delete method, of class DocumentalDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Documental documental = null;
        DocumentalDAO instance = new DocumentalDAO();
        boolean expResult = false;
        boolean result = instance.delete(documental);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectIdRecursoDocumental method, of class DocumentalDAO.
     */
    @Test
    public void testSelectIdRecursoDocumental() {
        System.out.println("selectIdRecursoDocumental");
        String titulo = "El universo";
        String codigoBarras = "2394723";
        String autor = "EllonMosk";
        DocumentalDAO instance = new DocumentalDAO();
        int expResult = 0;
        int result = instance.selectIdRecursoDocumental(titulo, codigoBarras, autor);
        if(result == expResult){
             fail("The test case is a prototype.");
        }else{
            System.out.println("bueno" + result);
        }  
    }    
}
