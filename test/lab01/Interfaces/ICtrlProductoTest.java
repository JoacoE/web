/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;

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
public class ICtrlProductoTest {
    
    public ICtrlProductoTest() {
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
     * Test of registrarProducto method, of class ICtrlProducto.
     */
    @Test
    public void testRegistrarProducto() {
        System.out.println("registrarProducto");
        DataIndividual di = null;
        String nomRest = "";
        boolean promocional = false;
        ICtrlProducto instance = new ICtrlProductoImpl();
        instance.registrarProducto(di, nomRest, promocional);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of existeRestaurante method, of class ICtrlProducto.
     */
    @Test
    public void testExisteRestaurante() {
        System.out.println("existeRestaurante");
        String nomRest = "";
        ICtrlProducto instance = new ICtrlProductoImpl();
        boolean expResult = false;
        boolean result = instance.existeRestaurante(nomRest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listarIndividuales method, of class ICtrlProducto.
     */
    @Test
    public void testListarIndividuales() {
        System.out.println("listarIndividuales");
        String nomRest = "";
        ICtrlProducto instance = new ICtrlProductoImpl();
        Map expResult = null;
        Map result = instance.listarIndividuales(nomRest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class ICtrlProductoImpl implements ICtrlProducto {

        public void registrarProducto(DataIndividual di, String nomRest, boolean promocional) {
        }

        public boolean existeRestaurante(String nomRest) {
            return false;
        }

        public Map listarIndividuales(String nomRest) {
            return null;
        }
    }
    
}
