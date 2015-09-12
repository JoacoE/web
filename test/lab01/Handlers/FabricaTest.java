/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import lab01.Interfaces.ICtrlPedido;
import lab01.Interfaces.ICtrlProducto;
import lab01.Interfaces.ICtrlUsuario;
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
public class FabricaTest {
    
    public FabricaTest() {
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
     * Test of getInstance method, of class Fabrica.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Fabrica expResult = null;
        Fabrica result = Fabrica.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getICtrlUsuario method, of class Fabrica.
     */
    @Test
    public void testGetICtrlUsuario() {
        System.out.println("getICtrlUsuario");
        Fabrica instance = null;
        ICtrlUsuario expResult = null;
        ICtrlUsuario result = instance.getICtrlUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getICtrlProducto method, of class Fabrica.
     */
    @Test
    public void testGetICtrlProducto() {
        System.out.println("getICtrlProducto");
        Fabrica instance = null;
        ICtrlProducto expResult = null;
        ICtrlProducto result = instance.getICtrlProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getICtrlPedido method, of class Fabrica.
     */
    @Test
    public void testGetICtrlPedido() {
        System.out.println("getICtrlPedido");
        Fabrica instance = null;
        ICtrlPedido expResult = null;
        ICtrlPedido result = instance.getICtrlPedido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
