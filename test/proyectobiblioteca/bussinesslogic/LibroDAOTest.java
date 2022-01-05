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
        int fkDocumentoID = 19;
        LibroDAO instance = new LibroDAO();
        boolean expResult = false;
        boolean result = instance.insertar(libro, fkDocumentoID);
        if(result == expResult){
            fail("Error de ingresar");
        }else{
            System.err.println("Bueno");
        }
    }  
}
