/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectobiblioteca.bussinesslogic;

import java.sql.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectobiblioteca.domain.Multimedia;

/**
 *
 * @author victormanuel
 */
public class MultimediaDAOTest {
    
    public MultimediaDAOTest() {
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
     * Test of insert method, of class MultimediaDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String tipoMultimedia = "Dvd";
        Time duracion = Time.valueOf("00:30:30");
        String formato = "Mpg";
        int fkRecursoDocumental = 4;
        MultimediaDAO instance = new MultimediaDAO();
        int expResult = 0;
        int result = instance.insert(tipoMultimedia, duracion, formato, fkRecursoDocumental);
        if(result == 0){
            fail("The test case is a prototype.");
        }else{
            System.out.println("Bueno");
        }
    }

    /**
     * Test of update method, of class MultimediaDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Multimedia multimedia = null;
        int idRecursoDocumental = 0;
        MultimediaDAO instance = new MultimediaDAO();
        int expResult = 0;
        int result = instance.update(multimedia, idRecursoDocumental);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
