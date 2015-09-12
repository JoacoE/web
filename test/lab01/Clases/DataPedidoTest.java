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
public class DataPedidoTest {
    
    public DataPedidoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getId method, of class DataPedido.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        int expResult = 1;
        long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class DataPedido.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class DataPedido.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        String expResult = "1/1/2000";
        String result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class DataPedido.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        String fecha = "1/1/2000";
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecio_total method, of class DataPedido.
     */
    @Test
    public void testGetPrecio_total() {
        System.out.println("getPrecio_total");
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        double expResult = 250.0;
        double result = instance.getPrecio_total();
        assertEquals(expResult, result, 250.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio_total method, of class DataPedido.
     */
    @Test
    public void testSetPrecio_total() {
        System.out.println("setPrecio_total");
        double precio_total = 250.0;
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        instance.setPrecio_total(precio_total);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class DataPedido.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        estados expResult = estados.ENVIADO;
        estados result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class DataPedido.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        estados estado = estados.ENVIADO;
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickUsr method, of class DataPedido.
     */
    @Test
    public void testGetNickUsr() {
        System.out.println("getNickUsr");
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        String expResult = "nickUsr";
        String result = instance.getNickUsr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setNickUsr method, of class DataPedido.
     */
    @Test
    public void testSetNickUsr() {
        System.out.println("setNickUsr");
        String nickUsr = "nickUsr";
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        instance.setNickUsr(nickUsr);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMailUsr method, of class DataPedido.
     */
    @Test
    public void testGetMailUsr() {
        System.out.println("getMailUsr");
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        String expResult = "j@j.com";
        String result = instance.getMailUsr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMailUsr method, of class DataPedido.
     */
    @Test
    public void testSetMailUsr() {
        System.out.println("setMailUsr");
        String mailUsr = "j@j.com";
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        instance.setMailUsr(mailUsr);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickRest method, of class DataPedido.
     */
    @Test
    public void testGetNickRest() {
        System.out.println("getNickRest");
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        String expResult = "nickRest";
        String result = instance.getNickRest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNickRest method, of class DataPedido.
     */
    @Test
    public void testSetNickRest() {
        System.out.println("setNickRest");
        String nickRest = "nickRest";
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        instance.setNickRest(nickRest);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColCarrito method, of class DataPedido.
     */
    @Test
    public void testGetColCarrito() {
        System.out.println("getColCarrito");
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        Map expResult = null;
        Map result = instance.getColCarrito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColCarrito method, of class DataPedido.
     */
    @Test
    public void testSetColCarrito() {
        System.out.println("setColCarrito");
        Map ColCarrito = null;
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        instance.setColCarrito(ColCarrito);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDatCarrito method, of class DataPedido.
     */
    @Test
    public void testSetDatCarrito() {
        System.out.println("setDatCarrito");
        DataCarrito dc = null;
        DataPedido instance = new DataPedido(1, "nickUsr", "j@j.com", "1/1/2000", "nickRest", null, 250.0, estados.ENVIADO);
        instance.setDatCarrito(dc);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
