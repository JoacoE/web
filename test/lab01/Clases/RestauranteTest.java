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
public class RestauranteTest {
    
    public RestauranteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addCategoria method, of class Restaurante.
     */
    @Test
    public void testAddCategoria() {
        System.out.println("addCategoria");
        Categoria c = null;
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        instance.addCategoria(c);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of member method, of class Restaurante.
     */
    @Test
    public void testMember() {
        System.out.println("member");
        String nombre = "";
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        boolean expResult = false;
        boolean result = instance.member(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addProducto method, of class Restaurante.
     */
    @Test
    public void testAddProducto() {
        System.out.println("addProducto");
        Producto p = null;
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        instance.addProducto(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerColeccion method, of class Restaurante.
     */
    @Test
    public void testObtenerColeccion() {
        System.out.println("obtenerColeccion");
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        Map expResult = null;
        Map result = instance.obtenerColeccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of RestauranteADR method, of class Restaurante.
     */
    @Test
    public void testRestauranteADR() {
        System.out.println("RestauranteADR");
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        DataRestaurante expResult = null;
        DataRestaurante result = instance.RestauranteADR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerColProductos method, of class Restaurante.
     */
    @Test
    public void testObtenerColProductos() {
        System.out.println("obtenerColProductos");
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        Map expResult = null;
        Map result = instance.obtenerColProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerListaProductos method, of class Restaurante.
     */
    @Test
    public void testObtenerListaProductos() {
        System.out.println("obtenerListaProductos");
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        Map expResult = null;
        Map result = instance.obtenerListaProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProducto method, of class Restaurante.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        String nombre = "";
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        Producto expResult = null;
        Producto result = instance.getProducto(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of agregarProducto method, of class Restaurante.
     */
    @Test
    public void testAgregarProducto() throws Exception {
        System.out.println("agregarProducto");
        String nombre = "";
        int cantidad = 0;
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        DataCarrito expResult = null;
        DataCarrito result = instance.agregarProducto(nombre, cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProdCarrito method, of class Restaurante.
     */
    @Test
    public void testGetProdCarrito() {
        System.out.println("getProdCarrito");
        String nombre = "";
        Restaurante instance = new Restaurante("nick", "pasiva", "j@j.com", "Calle", null, null);
        Producto_Stock expResult = null;
        Producto_Stock result = instance.getProdCarrito(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
