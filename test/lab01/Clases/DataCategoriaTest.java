/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martin
 */
public class DataCategoriaTest {
    
    private String nombre;
    
    public DataCategoriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        DataCategoria instancia;
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DataCategoria instancia = new DataCategoria(nombre);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setNombre method, of class DataCategoria.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        //String nombre = "";
        DataCategoria instancia = new DataCategoria(nombre);
        instancia.setNombre("pizza");
//        String result = instancia.getNombre();
//        assertEquals(instancia.getNombre(), result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class DataCategoria.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DataCategoria instance = new DataCategoria("pizza");
        String expResult = "pizza";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of DCatAC method, of class DataCategoria.
     */
    @Test
    public void testDCatAC() {
        System.out.println("DCatAC");
        DataCategoria instance = new DataCategoria("pizza");
        Categoria expResult = new Categoria("pizza");
        Categoria result = instance.DCatAC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
