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
public class DataCarritoTest {
    
    public DataCarritoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DataCarrito instance = new DataCarrito("nomProd", true, 8, 125.0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNomProd method, of class DataCarrito.
     */
    @Test
    public void testGetNomProd() {
        System.out.println("getNomProd");
        DataCarrito instance = new DataCarrito("nomProd", true, 8, 125.0);
        String expResult = "nomProd";
        String result = instance.getNomProd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomProd method, of class DataCarrito.
     */
    @Test
    public void testSetNomProd() {
        System.out.println("setNomProd");
        String nomProd = "nomProd";
        DataCarrito instance = new DataCarrito("nomProd", true, 8, 125.0);
        instance.setNomProd(nomProd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPromo method, of class DataCarrito.
     */
    @Test
    public void testGetPromo() {
        System.out.println("getPromo");
        DataCarrito instance = new DataCarrito("nomProd", true, 8, 125.0);
        boolean expResult = true;
        boolean result = instance.getPromo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPromo method, of class DataCarrito.
     */
    @Test
    public void testSetPromo() {
        System.out.println("setPromo");
        boolean promo = false;
        DataCarrito instance = new DataCarrito("nomProd", true, 8, 125.0);
        instance.setPromo(promo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class DataCarrito.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DataCarrito instance = new DataCarrito("nomProd", true, 8, 125.0);
        int expResult = 8;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class DataCarrito.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 8;
        DataCarrito instance = new DataCarrito("nomProd", true, 8, 125.0);
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecio method, of class DataCarrito.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        DataCarrito instance = new DataCarrito("nomProd", true, 8, 125.0);
        double expResult = 125.0;
        double result = instance.getPrecio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class DataCarrito.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double precio = 125.0;
        DataCarrito instance = new DataCarrito("nomProd", true, 8, 125.0);
        instance.setPrecio(precio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
