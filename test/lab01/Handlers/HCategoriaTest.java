/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.Map;
import lab01.Clases.Categoria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martin
 */
public class HCategoriaTest {
    
    public HCategoriaTest() {
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
     * Test of getinstance method, of class HCategoria.
     */
    @Test
    public void testGetinstance() {
        System.out.println("getinstance");
        HCategoria expResult = null;
        HCategoria result = HCategoria.getinstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addCategoria method, of class HCategoria.
     */
    @Test
    public void testAddCategoria() {
        System.out.println("addCategoria");
        Categoria c = null;
        HCategoria instance = null;
        instance.addCategoria(c);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of member method, of class HCategoria.
     */
    @Test
    public void testMember() {
        System.out.println("member");
        String nombre = "";
        HCategoria instance = null;
        boolean expResult = false;
        boolean result = instance.member(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerColeccion method, of class HCategoria.
     */
    @Test
    public void testObtenerColeccion() {
        System.out.println("obtenerColeccion");
        HCategoria instance = null;
        Map expResult = null;
        Map result = instance.obtenerColeccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
