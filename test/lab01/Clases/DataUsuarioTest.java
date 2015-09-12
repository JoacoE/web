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
public class DataUsuarioTest {
    
    public DataUsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DataUsuario instance = new DataUsuario("Juan", "j@j.com");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class DataUsuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DataUsuario instance = new DataUsuario("Juan", "j@j.com");
        String expResult = "Juan";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class DataUsuario.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Juan";
        DataUsuario instance = new DataUsuario("Juan", "j@j.com");
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMail method, of class DataUsuario.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        DataUsuario instance = new DataUsuario("Juan", "j@j.com");
        String expResult = "j@j.com";
        String result = instance.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMail method, of class DataUsuario.
     */
    @Test
    public void testSetMail() {
        System.out.println("setMail");
        String mail = "j@j.com";
        DataUsuario instance = new DataUsuario("Juan", "j@j.com");
        instance.setMail(mail);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
