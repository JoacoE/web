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
public class DataClienteTest {
    
    public DataClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        DataCliente instance = new DataCliente("nick", "Pedro", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        DataCliente inst = new DataCliente();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getNombre method, of class DataCliente.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DataCliente instance = new DataCliente("nick", "Pedro", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "Pedro";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class DataCliente.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        DataCliente instance = new DataCliente("nick", "Pedro", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "Perez";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getImagen method, of class DataCliente.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        DataCliente instance = new DataCliente("nick", "Pedro", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "hola";
        String result = instance.getImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMail method, of class DataCliente.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        DataCliente instance = new DataCliente("nick", "Pedro", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "j@j.com";
        String result = instance.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class DataCliente.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        DataCliente instance = new DataCliente("nick", "Pedro", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "nick";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class DataCliente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        DataCliente instance = new DataCliente("nick", "Pedro", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "Calle";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFNac method, of class DataCliente.
     */
    @Test
    public void testGetFNac() {
        System.out.println("getFNac");
        DataCliente instance = new DataCliente("nick", "Pedro", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        String expResult = "1/1/2000";
        String result = instance.getFNac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of dataCliACli method, of class DataCliente.
     */
    @Test
    public void testDataCliACli() {
        System.out.println("dataCliACli");
        DataCliente instance = new DataCliente("nick", "Pedro", "j@j.com", "Calle", "Perez", "hola", "1/1/2000");
        Usuario expResult = null;
        Usuario result = instance.dataCliACli();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
