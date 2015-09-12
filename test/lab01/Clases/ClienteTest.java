/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author martin
 */
public class ClienteTest {
    
    public ClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        Cliente instancia = new Cliente("nickname", "Juan", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        instancia.nickname = "nickname";
        instancia.imagen = "hola";
        
    }

    @After
    public void tearDown() throws Exception {
    }
    /**
     * Test of getApellido method, of class Cliente.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Cliente instancia = new Cliente("nickname", "Juan", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "Perez";
        String result = instancia.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getImagen method, of class Cliente.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        Cliente instancia = new Cliente("nickname", "Juan", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "hola";
        String result = instancia.getImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setApellido method, of class Cliente.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "Perez";
        Cliente instancia = new Cliente("nickname", "Juan", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        instancia.setApellido(apellido);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setImagen method, of class Cliente.
     */
    @Test
    public void testSetImagen() {
        System.out.println("setImagen");
        String img = "hola";
        Cliente instancia = new Cliente("nickname", "Juan", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        instancia.setImagen(img);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class Cliente.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Cliente instancia = new Cliente("nickname", "Juan", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "1/1/2000";
        String result = instancia.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class Cliente.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        String fecha = "1/1/2000";
        Cliente instancia = new Cliente("nickname", "Juan", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        instancia.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMail method, of class Cliente.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        Cliente instancia = new Cliente("nickname", "Juan", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "j@j.com";
        String result = instancia.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class Cliente.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        Cliente instancia = new Cliente("nickname", "Juan", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "nickname";
        String result = instancia.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ClienteADC method, of class Cliente.
     */
    @Test
    public void testClienteADC() {
        System.out.println("ClienteADC");
        Cliente instance = null;
        DataCliente expResult = null;
        DataCliente result = instance.ClienteADC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
