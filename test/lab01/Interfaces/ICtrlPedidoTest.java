/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;

import java.util.Map;
import lab01.Clases.DataPedido;
import lab01.Clases.DataProducto;
import lab01.Clases.estados;
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
public class ICtrlPedidoTest {
    
    public ICtrlPedidoTest() {
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
     * Test of setNickname method, of class ICtrlPedido.
     */
    @Test
    public void testSetNickname() {
        System.out.println("setNickname");
        String nick = "";
        ICtrlPedido instance = new ICtrlPedidoImpl();
        instance.setNickname(nick);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCat method, of class ICtrlPedido.
     */
    @Test
    public void testSetCat() {
        System.out.println("setCat");
        String nombre = "";
        ICtrlPedido instance = new ICtrlPedidoImpl();
        instance.setCat(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCat method, of class ICtrlPedido.
     */
    @Test
    public void testGetCat() {
        System.out.println("getCat");
        ICtrlPedido instance = new ICtrlPedidoImpl();
        String expResult = "";
        String result = instance.getCat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class ICtrlPedido.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        ICtrlPedido instance = new ICtrlPedidoImpl();
        String expResult = "";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of devListaDC method, of class ICtrlPedido.
     */
    @Test
    public void testDevListaDC() {
        System.out.println("devListaDC");
        ICtrlPedido instance = new ICtrlPedidoImpl();
        Map expResult = null;
        Map result = instance.devListaDC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of devListaDR method, of class ICtrlPedido.
     */
    @Test
    public void testDevListaDR() {
        System.out.println("devListaDR");
        ICtrlPedido instance = new ICtrlPedidoImpl();
        Map expResult = null;
        Map result = instance.devListaDR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMemRestaurante method, of class ICtrlPedido.
     */
    @Test
    public void testSetMemRestaurante() {
        System.out.println("setMemRestaurante");
        String nickname = "";
        ICtrlPedido instance = new ICtrlPedidoImpl();
        boolean expResult = false;
        boolean result = instance.setMemRestaurante(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of retColDCat method, of class ICtrlPedido.
     */
    @Test
    public void testRetColDCat() {
        System.out.println("retColDCat");
        ICtrlPedido instance = new ICtrlPedidoImpl();
        Map expResult = null;
        Map result = instance.retColDCat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of devListaProductos method, of class ICtrlPedido.
     */
    @Test
    public void testDevListaProductos() {
        System.out.println("devListaProductos");
        ICtrlPedido instance = new ICtrlPedidoImpl();
        DataProducto expResult = null;
        DataProducto result = instance.devListaProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectProductos method, of class ICtrlPedido.
     * @throws java.lang.Exception
     */
    @Test
    public void testSelectProductos() throws Exception {
        System.out.println("selectProductos");
        String nombre = "";
        int cantidad = 0;
        ICtrlPedido instance = new ICtrlPedidoImpl();
        instance.selectProductos(nombre, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    public class ICtrlPedidoImpl implements ICtrlPedido {

        @Override
        public void setNickname(String nick) {
        }

        @Override
        public void setCat(String nombre) {
        }

        @Override
        public String getCat() {
            return "";
        }

        @Override
        public String getNickname() {
            return "";
        }

        @Override
        public Map devListaDC() {
            return null;
        }

        @Override
        public Map devListaDR() {
            return null;
        }

        @Override
        public boolean setMemRestaurante(String nickname) {
            return false;
        }

        @Override
        public Map retColDCat() {
            return null;
        }

        @Override
        public DataProducto devListaProductos() {
            return null;
        }

        @Override
        public void selectProductos(String nombre, int cantidad) throws Exception {
        }

        @Override
        public void setMailCliente(String mail) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setMemCliente() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setMonto() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DataPedido altaPedido() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Map listDataPedidos() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void actualizarEPedido(String nickname, double id, estados estado) throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
