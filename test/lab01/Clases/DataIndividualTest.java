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
public class DataIndividualTest {
    
    public DataIndividualTest() {
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
     * Test of getDataNombre method, of class DataIndividual.
     */
    @Test
    public void testGetDataNombre() {
        System.out.println("getDataNombre");
        DataIndividual instance = new DataIndividual("pizza", "rica", 125, "hola", 8);
        String expResult = "pizza";
        String result = instance.getDataNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDataNombre method, of class DataIndividual.
     */
    @Test
    public void testSetDataNombre() {
        System.out.println("setDataNombre");
        String nombre = "pizza";
        DataIndividual instance = new DataIndividual("pizza", "rica", 125, "hola", 8);
        instance.setDataNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDataDescripcion method, of class DataIndividual.
     */
    @Test
    public void testGetDataDescripcion() {
        System.out.println("getDataDescripcion");
        DataIndividual instance = new DataIndividual("pizza", "rica", 125, "hola", 8);
        String expResult = "rica";
        String result = instance.getDataDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDataDescripcion method, of class DataIndividual.
     */
    @Test
    public void testSetDataDescripcion() {
        System.out.println("setDataDescripcion");
        String descripcion = "rica";
        DataIndividual instance = new DataIndividual();
        instance.setDataDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDataPrecio method, of class DataIndividual.
     */
    @Test
    public void testGetDataPrecio() {
        System.out.println("getDataPrecio");
        DataIndividual instance = new DataIndividual("pizza", "rica", 125, "hola", 8);
        double expResult = 125.0;
        double result = instance.getDataPrecio();
        assertEquals(expResult, result, 125.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDataPrecio method, of class DataIndividual.
     */
    @Test
    public void testSetDataPrecio() {
        System.out.println("setDataPrecio");
        double precio = 200.0;
        DataIndividual instance = new DataIndividual();
        instance.setDataPrecio(precio);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDataImagen method, of class DataIndividual.
     */
    @Test
    public void testGetDataImagen() {
        System.out.println("getDataImagen");
        DataIndividual instance = new DataIndividual("pizza", "rica", 125, "hola", 8);
        String expResult = "hola";
        String result = instance.getDataImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDataImagen method, of class DataIndividual.
     */
    @Test
    public void testSetDataImagen() {
        System.out.println("setDataImagen");
        String imagen = "";
        DataIndividual instance = new DataIndividual("pizza", "rica", 125, "hola", 8);
        instance.setDataImagen(imagen);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class DataIndividual.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DataIndividual instance = new DataIndividual("pizza", "rica", 125, "hola", 8);
        int expResult = 8;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class DataIndividual.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 8;
        DataIndividual instance = new DataIndividual("pizza", "rica", 125, "hola", 8);
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
