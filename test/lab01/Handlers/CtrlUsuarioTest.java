/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.Map;
import lab01.Clases.DataCliente;
import lab01.Clases.Restaurante;
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
public class CtrlUsuarioTest {
    
    public CtrlUsuarioTest() {
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
     * Test of setCat method, of class CtrlUsuario.
     */
    @Test
    public void testSetCat() {
        System.out.println("setCat");
        Map cate = null;
        CtrlUsuario instance = new CtrlUsuario();
        instance.setCat(cate);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNickname method, of class CtrlUsuario.
     */
    @Test
    public void testSetNickname() {
        System.out.println("setNickname");
        String nick = "";
        CtrlUsuario instance = new CtrlUsuario();
        instance.setNickname(nick);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class CtrlUsuario.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        CtrlUsuario instance = new CtrlUsuario();
        String expResult = "";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarDatos method, of class CtrlUsuario.
     */
    @Test
    public void testIngresarDatos() {
        System.out.println("ingresarDatos");
        String nickname = "";
        String nombre = "";
        String email = "";
        String direccion = "";
        CtrlUsuario instance = new CtrlUsuario();
        boolean expResult = false;
        boolean result = instance.ingresarDatos(nickname, nombre, email, direccion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCliente method, of class CtrlUsuario.
     */
    @Test
    public void testRegistrarCliente() {
        System.out.println("registrarCliente");
        String apellido = "";
        String img = "";
        String fecha = "";
        CtrlUsuario instance = new CtrlUsuario();
        instance.registrarCliente(apellido, img, fecha);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarRestaurante method, of class CtrlUsuario.
     */
    @Test
    public void testRegistrarRestaurante() {
        System.out.println("registrarRestaurante");
        CtrlUsuario instance = new CtrlUsuario();
        instance.registrarRestaurante(null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of datosAdicionales method, of class CtrlUsuario.
     */
    @Test
    public void testDatosAdicionales_String_String() {
        System.out.println("datosAdicionales");
        String apellido = "";
        String img = "";
        CtrlUsuario instance = new CtrlUsuario();
        instance.datosAdicionales(apellido, img);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarioByNickname method, of class CtrlUsuario.
     */
    @Test
    public void testGetUsuarioByNickname() {
        System.out.println("getUsuarioByNickname");
        String nickname = "";
        CtrlUsuario instance = new CtrlUsuario();
        DataCliente expResult = null;
        DataCliente result = instance.getUsuarioByNickname(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRestauranteByNickname method, of class CtrlUsuario.
     */
    @Test
    public void testGetRestauranteByNickname() {
        System.out.println("getRestauranteByNickname");
        String nickname = "";
        CtrlUsuario instance = new CtrlUsuario();
        Restaurante expResult = null;
        Restaurante result = instance.getRestauranteByNickname(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of devListaDC method, of class CtrlUsuario.
     */
    @Test
    public void testDevListaDC() {
        System.out.println("devListaDC");
        CtrlUsuario instance = new CtrlUsuario();
        Map expResult = null;
        Map result = instance.devListaDC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCat method, of class CtrlUsuario.
     */
    @Test
    public void testRegistrarCat() {
        System.out.println("registrarCat");
        String nombre = "";
        CtrlUsuario instance = new CtrlUsuario();
        instance.registrarCat(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of retColCat method, of class CtrlUsuario.
     */
    @Test
    public void testRetColCat() {
        System.out.println("retColCat");
        CtrlUsuario instance = new CtrlUsuario();
        Map expResult = null;
        Map result = instance.retColCat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of datosAdicionales method, of class CtrlUsuario.
     */
    @Test
    public void testDatosAdicionales_String() {
        System.out.println("datosAdicionales");
        String apellido = "";
        CtrlUsuario instance = new CtrlUsuario();
        instance.datosAdicionales(apellido);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
