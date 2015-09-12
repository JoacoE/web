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
public class Producto_StockTest {
    
    public Producto_StockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Producto_Stock instance = new Producto_Stock(2, 20.0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCantidad method, of class Producto_Stock.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Producto_Stock instance = new Producto_Stock(2, 20.0);
        int expResult = 2;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class Producto_Stock.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 2;
        Producto_Stock instance = new Producto_Stock(2, 20.0);
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecio method, of class Producto_Stock.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Producto_Stock instance = new Producto_Stock(2, 20.0);
        double expResult = 20.0;
        double result = instance.getPrecio();
        assertEquals(expResult, result, 20.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class Producto_Stock.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double precio = 20.0;
        Producto_Stock instance = new Producto_Stock(2, 20.0);
        instance.setPrecio(precio);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
