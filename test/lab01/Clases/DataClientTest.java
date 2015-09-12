/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.Date;
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
public class DataClientTest {
    
    public DataClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        DataClient inst = new DataClient();
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
     * Test of getNickname method, of class DataClient.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        String expResult = "nickname";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class DataClient.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getfNac method, of class DataClient.
     */
    @Test
    public void testGetfNac() {
        System.out.println("getfNac");
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        Date expResult = null;
        Date result = instance.getfNac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class DataClient.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        String expResult = "apellido";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class DataClient.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        String expResult = "direccion";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMail method, of class DataClient.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        String expResult = "j@j.com";
        String result = instance.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getImagen method, of class DataClient.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        String expResult = "imagen";
        String result = instance.getImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNickname method, of class DataClient.
     */
    @Test
    public void testSetNickname() {
        System.out.println("setNickname");
        String nickname = "nickname";
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        instance.setNickname(nickname);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class DataClient.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "nombre";
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setApellido method, of class DataClient.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "apellido";
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        instance.setApellido(apellido);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setfNac method, of class DataClient.
     */
    @Test
    public void testSetfNac() {
        System.out.println("setfNac");
        Date fNac = null;
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        instance.setfNac(fNac);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class DataClient.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "direccion";
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMail method, of class DataClient.
     */
    @Test
    public void testSetMail() {
        System.out.println("setMail");
        String mail = "j@j.com";
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        instance.setMail(mail);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setImagen method, of class DataClient.
     */
    @Test
    public void testSetImagen() {
        System.out.println("setImagen");
        String imagen = "imagen";
        DataClient instance = new DataClient("nickname", "nombre", "apellido", null, "direccion", "j@j.com", "imagen");
        instance.setImagen(imagen);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
