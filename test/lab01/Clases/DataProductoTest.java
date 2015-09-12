/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.Map;
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
public class DataProductoTest {
    
    public DataProductoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DataProducto instance = new DataProducto();
//        DataProducto inst = new DataProducto("pizza", "rica", 275.0);
//        DataProducto dp = new DataProducto();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class DataProducto.
     */
//    @Test
//    public void testGetNombre() {
//        System.out.println("getNombre");
//        DataProducto instance = new DataProducto();
//        String expResult = "pizza";
//        String result = instance.getNombre();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNombre method, of class DataProducto.
//     */
//    @Test
//    public void testSetNombre() {
//        System.out.println("setNombre");
//        String nombre = "pizza";
//        DataProducto instance = new DataProducto();
//        instance.setNombre(nombre);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDescripcion method, of class DataProducto.
//     */
//    @Test
//    public void testGetDescripcion() {
//        System.out.println("getDescripcion");
//        DataProducto instance = new DataProducto();
//        String expResult = "rica";
//        String result = instance.getDescripcion();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDescripcion method, of class DataProducto.
//     */
//    @Test
//    public void testSetDescripcion() {
//        System.out.println("setDescripcion");
//        String descripcion = "rica";
//        DataProducto instance = new DataProducto();
//        instance.setDescripcion(descripcion);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPrecio method, of class DataProducto.
//     */
//    @Test
//    public void testGetPrecio() {
//        System.out.println("getPrecio");
//        DataProducto instance = new DataProducto();
//        double expResult = 275.0;
//        double result = instance.getPrecio();
//        assertEquals(expResult, result, 275.0);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPrecio method, of class DataProducto.
//     */
//    @Test
//    public void testSetPrecio() {
//        System.out.println("setPrecio");
//        double precio = 275.0;
//        DataProducto instance = new DataProducto();
//        instance.setPrecio(precio);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getImagen method, of class DataProducto.
//     */
//    @Test
//    public void testGetImagen() {
//        System.out.println("getImagen");
//        DataProducto instance = new DataProducto();
//        String expResult = "hola";
//        String result = instance.getImagen();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setImagen method, of class DataProducto.
//     */
//    @Test
//    public void testSetImagen() {
//        System.out.println("setImagen");
//        String imagen = "hola";
//        DataProducto instance = new DataProducto();
//        instance.setImagen(imagen);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of getColDatIndividual method, of class DataProducto.
     */
    @Test
    public void testGetColDatIndividual() {
        System.out.println("getColDatIndividual");
        DataProducto instance = new DataProducto();
        Map expResult = null;
        Map result = instance.getColDatIndividual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatIndividual method, of class DataProducto.
     */
    @Test
    public void testSetDatIndividual() {
        System.out.println("setDatIndividual");
        DataIndividual di = null;
        DataProducto instance = new DataProducto();
        instance.setDatIndividual(di);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColDatIndividual method, of class DataProducto.
     */
    @Test
    public void testSetColDatIndividual() {
        System.out.println("setColDatIndividual");
        Map ColDatIndividual = null;
        DataProducto instance = new DataProducto();
        instance.setColDatIndividual(ColDatIndividual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColDatPromocional method, of class DataProducto.
     */
    @Test
    public void testGetColDatPromocional() {
        System.out.println("getColDatPromocional");
        DataProducto instance = new DataProducto();
        Map expResult = null;
        Map result = instance.getColDatPromocional();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatPromocional method, of class DataProducto.
     */
    @Test
    public void testSetDatPromocional() {
        System.out.println("setDatPromocional");
        DataPromocional dp = null;
        DataProducto instance = new DataProducto();
        instance.setDatPromocional(dp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColDatPromocional method, of class DataProducto.
     */
    @Test
    public void testSetColDatPromocional() {
        System.out.println("setColDatPromocional");
        Map ColDatPromocional = null;
        DataProducto instance = new DataProducto();
        instance.setColDatPromocional(ColDatPromocional);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
