/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.ArrayList;
import java.util.Map;
import lab01.Clases.DataCarrito;
import lab01.Clases.DataProducto;
import lab01.Clases.Producto_Stock;
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
public class CtrlPedidoTest {
    
    public CtrlPedidoTest() {
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
     * Test of setNickname method, of class CtrlPedido.
     */
    @Test
    public void testSetNickname() {
        System.out.println("setNickname");
        String nick = "";
        CtrlPedido instance = new CtrlPedido();
        instance.setNickname(nick);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class CtrlPedido.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        CtrlPedido instance = new CtrlPedido();
        String expResult = "";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCat method, of class CtrlPedido.
     */
    @Test
    public void testSetCat() {
        System.out.println("setCat");
        String nombre = "";
        CtrlPedido instance = new CtrlPedido();
        instance.setCat(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCat method, of class CtrlPedido.
     */
    @Test
    public void testGetCat() {
        System.out.println("getCat");
        CtrlPedido instance = new CtrlPedido();
        String expResult = "";
        String result = instance.getCat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColDataCarrito method, of class CtrlPedido.
     */
    @Test
    public void testGetColDataCarrito() {
        System.out.println("getColDataCarrito");
        CtrlPedido instance = new CtrlPedido();
        Map expResult = null;
        Map result = instance.getColDataCarrito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDataCarrito method, of class CtrlPedido.
     */
    @Test
    public void testSetDataCarrito() {
        System.out.println("setDataCarrito");
        DataCarrito dc = null;
        CtrlPedido instance = new CtrlPedido();
        instance.setDataCarrito(dc);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColDataCarrito method, of class CtrlPedido.
     */
    @Test
    public void testSetColDataCarrito() {
        System.out.println("setColDataCarrito");
        Map ColDataCarrito = null;
        CtrlPedido instance = new CtrlPedido();
        instance.setColDataCarrito(ColDataCarrito);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCarrito method, of class CtrlPedido.
     */
    @Test
    public void testGetCarrito() {
        System.out.println("getCarrito");
        CtrlPedido instance = new CtrlPedido();
        ArrayList<Producto_Stock> expResult = null;
        ArrayList<Producto_Stock> result = instance.getCarrito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addCarrito method, of class CtrlPedido.
     */
    @Test
    public void testAddCarrito() {
        System.out.println("addCarrito");
        Producto_Stock pd = null;
        CtrlPedido instance = new CtrlPedido();
        instance.addCarrito(pd);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCarrito method, of class CtrlPedido.
     */
    @Test
    public void testSetCarrito() {
        System.out.println("setCarrito");
        ArrayList<Producto_Stock> carrito = null;
        CtrlPedido instance = new CtrlPedido();
        instance.setCarrito(carrito);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of devListaDC method, of class CtrlPedido.
     */
    @Test
    public void testDevListaDC() {
        System.out.println("devListaDC");
        CtrlPedido instance = new CtrlPedido();
        Map expResult = null;
        Map result = instance.devListaDC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of retColDCat method, of class CtrlPedido.
     */
    @Test
    public void testRetColDCat() {
        System.out.println("retColDCat");
        CtrlPedido instance = new CtrlPedido();
        Map expResult = null;
        Map result = instance.retColDCat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of devListaDR method, of class CtrlPedido.
     */
    @Test
    public void testDevListaDR() {
        System.out.println("devListaDR");
        CtrlPedido instance = new CtrlPedido();
        Map expResult = null;
        Map result = instance.devListaDR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMemRestaurante method, of class CtrlPedido.
     */
    @Test
    public void testSetMemRestaurante() {
        System.out.println("setMemRestaurante");
        String nickname = "";
        CtrlPedido instance = new CtrlPedido();
        boolean expResult = false;
        boolean result = instance.setMemRestaurante(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of devListaProductos method, of class CtrlPedido.
     */
    @Test
    public void testDevListaProductos() {
        System.out.println("devListaProductos");
        CtrlPedido instance = new CtrlPedido();
        DataProducto expResult = null;
        DataProducto result = instance.devListaProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectProductos method, of class CtrlPedido.
     */
    @Test
    public void testSelectProductos() throws Exception {
        System.out.println("selectProductos");
        String nombre = "";
        int cantidad = 0;
        CtrlPedido instance = new CtrlPedido();
        instance.selectProductos(nombre, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
