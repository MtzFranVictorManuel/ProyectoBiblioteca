/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectobiblioteca.domain;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victormanuel
 */
public class LibroTest {
    
    public LibroTest() {
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
     * Test of getIdLibro method, of class Libro.
     */
    @Test
    public void testGetIdLibro() {
        System.out.println("getIdLibro");
        Libro instance = new Libro();
        int expResult = 0;
        int result = instance.getIdLibro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEdicion method, of class Libro.
     */
    @Test
    public void testGetEdicion() {
        System.out.println("getEdicion");
        Libro instance = new Libro();
        String expResult = "";
        String result = instance.getEdicion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsbn method, of class Libro.
     */
    @Test
    public void testGetIsbn() {
        System.out.println("getIsbn");
        Libro instance = new Libro();
        String expResult = "";
        String result = instance.getIsbn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaPublicacion method, of class Libro.
     */
    @Test
    public void testGetFechaPublicacion() {
        System.out.println("getFechaPublicacion");
        Libro instance = new Libro();
        Date expResult = null;
        Date result = instance.getFechaPublicacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdioma method, of class Libro.
     */
    @Test
    public void testGetIdioma() {
        System.out.println("getIdioma");
        Libro instance = new Libro();
        String expResult = "";
        String result = instance.getIdioma();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerie method, of class Libro.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        Libro instance = new Libro();
        String expResult = "";
        String result = instance.getSerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolumen method, of class Libro.
     */
    @Test
    public void testGetVolumen() {
        System.out.println("getVolumen");
        Libro instance = new Libro();
        int expResult = 0;
        int result = instance.getVolumen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoObraLiteraria method, of class Libro.
     */
    @Test
    public void testGetTipoObraLiteraria() {
        System.out.println("getTipoObraLiteraria");
        Libro instance = new Libro();
        String expResult = "";
        String result = instance.getTipoObraLiteraria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFkIdRecursoDocumental method, of class Libro.
     */
    @Test
    public void testGetFkIdRecursoDocumental() {
        System.out.println("getFkIdRecursoDocumental");
        Libro instance = new Libro();
        int expResult = 0;
        int result = instance.getFkIdRecursoDocumental();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdLibro method, of class Libro.
     */
    @Test
    public void testSetIdLibro() {
        System.out.println("setIdLibro");
        int idLibro = 0;
        Libro instance = new Libro();
        instance.setIdLibro(idLibro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEdicion method, of class Libro.
     */
    @Test
    public void testSetEdicion() {
        System.out.println("setEdicion");
        String edicion = "";
        Libro instance = new Libro();
        instance.setEdicion(edicion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsbn method, of class Libro.
     */
    @Test
    public void testSetIsbn() {
        System.out.println("setIsbn");
        String isbn = "";
        Libro instance = new Libro();
        instance.setIsbn(isbn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaPublicacion method, of class Libro.
     */
    @Test
    public void testSetFechaPublicacion() {
        System.out.println("setFechaPublicacion");
        Date fechaPublicacion = null;
        Libro instance = new Libro();
        instance.setFechaPublicacion(fechaPublicacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdioma method, of class Libro.
     */
    @Test
    public void testSetIdioma() {
        System.out.println("setIdioma");
        String idioma = "";
        Libro instance = new Libro();
        instance.setIdioma(idioma);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSerie method, of class Libro.
     */
    @Test
    public void testSetSerie() {
        System.out.println("setSerie");
        String serie = "";
        Libro instance = new Libro();
        instance.setSerie(serie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVolumen method, of class Libro.
     */
    @Test
    public void testSetVolumen() {
        System.out.println("setVolumen");
        int volumen = 0;
        Libro instance = new Libro();
        instance.setVolumen(volumen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoObraLiteraria method, of class Libro.
     */
    @Test
    public void testSetTipoObraLiteraria() {
        System.out.println("setTipoObraLiteraria");
        String tipoObraLiteraria = "";
        Libro instance = new Libro();
        instance.setTipoObraLiteraria(tipoObraLiteraria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFkIdRecursoDocumental method, of class Libro.
     */
    @Test
    public void testSetFkIdRecursoDocumental() {
        System.out.println("setFkIdRecursoDocumental");
        int fkIdRecursoDocumental = 0;
        Libro instance = new Libro();
        instance.setFkIdRecursoDocumental(fkIdRecursoDocumental);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
