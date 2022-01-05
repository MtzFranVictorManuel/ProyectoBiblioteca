/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectobiblioteca.bussinesslogic;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectobiblioteca.domain.Libro;

/**
 *
 * @author victormanuel
 */
public class LibroDAOTest {
    
    public LibroDAOTest() {
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
     * Test of insertar method, of class LibroDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        String edicion = "Nueva";
        String isbn = "GRT";
        Date fechaPublicacion = Date.valueOf(LocalDate.now());
        String idioma = "español";
        String serie = "ninguna";
        String tipoObraLiteraria = "ninguna";
        Libro libro = new Libro(edicion, isbn, fechaPublicacion, idioma, serie, 0, tipoObraLiteraria);
        int fkDocumentoID = 13;
        LibroDAO instance = new LibroDAO();
        boolean expResult = false;
        boolean result = instance.insertar(libro, fkDocumentoID);
        if(result == expResult){
            fail("Error de ingresar");
        }else{
            System.err.println("Bueno");
        }
    }

    /**
     * Test of insertar2 method, of class LibroDAO.
     */
    @Test
    public void testInsertar2() {
        System.out.println("insertar2");
        String edicion = "Nuevo";
        String isbn = "n";
        Date fechaPublicacion = Date.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        String idioma = "n";
        String serie = "n";
        int volumen = 0;
        String tipoObra = "n";
        int fkDocumentoID = 13;
        LibroDAO instance = new LibroDAO();
        boolean expResult = false;
        boolean result = instance.insertar2(edicion, isbn, fechaPublicacion, idioma, serie, volumen, tipoObra, fkDocumentoID);
        if(result == expResult){
            fail("Error de ingresar");
        }else{
            System.err.println("Bueno" + fechaPublicacion.toString());
        }
    }
    
}
