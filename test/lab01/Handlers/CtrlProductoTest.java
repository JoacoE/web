/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.Map;
import lab01.Clases.DataIndividual;
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
public class CtrlProductoTest {
    
    public CtrlProductoTest() {
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
     * Test of registrarProducto method, of class CtrlProducto.
     */
    @Test
    public void testRegistrarProducto() {
        System.out.println("registrarProducto");
        DataIndividual di = null;
        String nomRest = "";
        boolean promocional = false;
        CtrlProducto instance = new CtrlProducto();
        instance.registrarProducto(di, nomRest, promocional);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of existeRestaurante method, of class CtrlProducto.
     */
    @Test
    public void testExisteRestaurante() {
        System.out.println("existeRestaurante");
        String nomRest = "";
        CtrlProducto instance = new CtrlProducto();
        boolean expResult = false;
        boolean result = instance.existeRestaurante(nomRest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listarIndividuales method, of class CtrlProducto.
     */
    @Test
    public void testListarIndividuales() {
        System.out.println("listarIndividuales");
        String nomRest = "";
        CtrlProducto instance = new CtrlProducto();
        Map expResult = null;
        Map result = instance.listarIndividuales(nomRest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
