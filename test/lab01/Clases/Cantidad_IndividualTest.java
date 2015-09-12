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
public class Cantidad_IndividualTest {
    
    public Cantidad_IndividualTest() {
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
     * Test of getCantidad method, of class Cantidad_Individual.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Cantidad_Individual instance = new Cantidad_Individual();
        int expResult = 2;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class Cantidad_Individual.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 2;
        Cantidad_Individual instance = new Cantidad_Individual();
        instance.setCantidad(cantidad);
        //assertEquals(cantidad, instance);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProdIndividual method, of class Cantidad_Individual.
     */
    @Test
    public void testGetProdIndividual() {
        System.out.println("getProdIndividual");
        Cantidad_Individual instance = new Cantidad_Individual();
        Individual expResult = null;
        Individual result = instance.getProdIndividual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProdIndividual method, of class Cantidad_Individual.
     */
    @Test
    public void testSetProdIndividual() {
        System.out.println("setProdIndividual");
        Individual prodIndividual = null;
        Cantidad_Individual instance = new Cantidad_Individual();
        instance.setProdIndividual(prodIndividual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
