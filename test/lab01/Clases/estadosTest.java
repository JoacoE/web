/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

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
public class estadosTest {
    
    public estadosTest() {
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
     * Test of values method, of class estados.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        estados[] expResult = null;
        estados[] result = estados.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class estados.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        estados expResult = estados.ENVIADO;
        estados result = estados.ENVIADO;
        assertEquals(expResult, result);
        estados expResul = estados.PREPARACION;
        estados resul = estados.PREPARACION;
        assertEquals(expResul, resul);
        estados expResu = estados.RECIBIDO;
        estados resu = estados.RECIBIDO;
        assertEquals(expResu, resu);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
