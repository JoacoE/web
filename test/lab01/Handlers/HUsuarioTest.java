/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Handlers;

import java.util.Map;
import lab01.Clases.Cliente;
import lab01.Clases.Restaurante;
import lab01.Clases.Usuario;
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
public class HUsuarioTest {
    
    public HUsuarioTest() {
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
     * Test of getinstance method, of class HUsuario.
     */
    @Test
    public void testGetinstance() {
        System.out.println("getinstance");
        HUsuario expResult = null;
        HUsuario result = HUsuario.getinstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addUsuario method, of class HUsuario.
     */
    @Test
    public void testAddUsuario() {
        System.out.println("addUsuario");
        Usuario usu = null;
        HUsuario instance = null;
        instance.addUsuario(usu);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerColeccion method, of class HUsuario.
     */
    @Test
    public void testObtenerColeccion() {
        System.out.println("obtenerColeccion");
        HUsuario instance = null;
        Map expResult = null;
        Map result = instance.obtenerColeccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerUsuario method, of class HUsuario.
     */
    @Test
    public void testObtenerUsuario() {
        System.out.println("obtenerUsuario");
        String nickname = "";
        HUsuario instance = null;
        Cliente expResult = null;
        Cliente result = instance.obtenerUsuario(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerRestaurante method, of class HUsuario.
     */
    @Test
    public void testObtenerRestaurante() {
        System.out.println("obtenerRestaurante");
        String nickname = "";
        HUsuario instance = null;
        Restaurante expResult = null;
        Restaurante result = instance.obtenerRestaurante(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class HUsuario.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String nickname = "";
        String email = "";
        HUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.find(nickname, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of exists method, of class HUsuario.
     */
    @Test
    public void testExists() {
        System.out.println("exists");
        String nickname = "";
        HUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.exists(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
