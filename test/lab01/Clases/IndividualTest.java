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
public class IndividualTest {
    
    public IndividualTest() {
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
     * Test of getDataIndividual method, of class Individual.
     */
    @Test
    public void testGetDataIndividual() {
        System.out.println("getDataIndividual");
        Individual instance = new Individual("pizza", "rica", 200.0, 8);
        DataIndividual expResult = new DataIndividual("pizza", "rica", 200.0, 8);
        DataIndividual result = instance.getDataIndividual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDataCarrito method, of class Individual.
     */
    @Test
    public void testGetDataCarrito() {
        System.out.println("getDataCarrito");
        int cantidad = 0;
        Individual instance = new Individual("pizza", "rica", 200.0, 8);
        DataCarrito expResult = null;
        DataCarrito result = instance.getDataCarrito(cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
