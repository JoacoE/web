/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.ArrayList;
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
public class PedidoTest {
    
    public PedidoTest() {
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
     * Test of getId method, of class Pedido.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Pedido instance = new Pedido(125.0);
        long expResult = 1;
        long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Pedido.
     */
//    @Test
//    public void testSetId() {
//        System.out.println("setId");
//        int id = 1;
//        Pedido instance = new Pedido(125.0);
//        instance.setId(id);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of getFecha method, of class Pedido.
     */
//    @Test
//    public void testGetFecha() {
//        System.out.println("getFecha");
//        Pedido instance = new Pedido(1, "1/1/2000", 125.00, estados.PREPARACION);
//        String expResult = "1/1/2000";
//        String result = instance.getFecha();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of setFecha method, of class Pedido.
     */
//    @Test
//    public void testSetFecha() {
//        System.out.println("setFecha");
//        String fecha = "1/1/2000";
//        Pedido instance = new Pedido(1, "1/1/2000", 125.00, estados.PREPARACION);
//        instance.setFecha(fecha);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of getPrecio_total method, of class Pedido.
     */
    @Test
    public void testGetPrecio_total() {
        System.out.println("getPrecio_total");
        Pedido instance = new Pedido(125.00);
        double expResult = 125.0;
        double result = instance.getPrecio_total();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio_total method, of class Pedido.
     */
    @Test
    public void testSetPrecio_total() {
        System.out.println("setPrecio_total");
        double precio_total = 125.0;
        Pedido instance = new Pedido(125.00);
        instance.setPrecio_total(precio_total);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Pedido.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Pedido instance = new Pedido(125.00);
        estados expResult = estados.PREPARACION;
        estados result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Pedido.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetEstado() throws Exception {
        System.out.println("setEstado");
        estados estado = estados.PREPARACION;
        Pedido instance = new Pedido(125.00);
        instance.setEstado(estados.ENVIADO);
        instance.getDataPedido().setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDataPedido method, of class Pedido.
     */
    @Test
    public void testGetDataPedido() {
        System.out.println("getDataPedido");
        Pedido instance = new Pedido(125.0);
        DataPedido expResult = null;
        DataPedido result = instance.getDataPedido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDataPedido method, of class Pedido.
     */
    @Test
    public void testSetDataPedido() {
        System.out.println("setDataPedido");
        DataPedido dp = null;
        Pedido instance = new Pedido(125.00);
        instance.setDataPedido(dp);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCarrito method, of class Pedido.
     */
    @Test
    public void testGetCarrito() {
        System.out.println("getCarrito");
        Pedido instance = new Pedido(125.00);
        ArrayList<Producto_Stock> expResult = null;
        ArrayList<Producto_Stock> result = instance.getDataCarrito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCarrito method, of class Pedido.
     */
    @Test
    public void testSetCarrito() {
        System.out.println("setCarrito");
        ArrayList<Producto_Stock> carrito = null;
        Pedido instance = new Pedido(125.00);
        instance.setCarrito(carrito);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
