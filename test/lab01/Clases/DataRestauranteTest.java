/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Clases;

import java.util.ArrayList;
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
public class DataRestauranteTest {
    
    public DataRestauranteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        DataRestaurante inst = new DataRestaurante();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dataResAres method, of class DataRestaurante.
     */
    @Test
    public void testDataResAres() {
        System.out.println("dataResAres");
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        Usuario expResult = null;
        Usuario result = instance.dataResAres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNickname method, of class DataRestaurante.
     */
    @Test
    public void testSetNickname() {
        System.out.println("setNickname");
        String nickname = "nick";
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        instance.setNickname(nickname);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class DataRestaurante.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        String expResult = "nick";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class DataRestaurante.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "pasiva";
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class DataRestaurante.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        String expResult = "pasiva";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class DataRestaurante.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String mail = "j@j.com";
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        instance.setEmail(mail);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class DataRestaurante.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        String expResult = "j@j.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class DataRestaurante.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "Calle";
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class DataRestaurante.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        String expResult = "Calle";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLstImagen method, of class DataRestaurante.
     */
    @Test
    public void testSetLstImagen() {
        System.out.println("setLstImagen");
        ArrayList<String> lstImagen = null;
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        instance.setLstImagen(lstImagen);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLstImagen method, of class DataRestaurante.
     */
    @Test
    public void testGetLstImagen() {
        System.out.println("getLstImagen");
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getLstImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColCategoria method, of class DataRestaurante.
     */
    @Test
    public void testSetColCategoria() {
        System.out.println("setColCategoria");
        Map colCategoria = null;
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        instance.setColCategoria(colCategoria);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColCategoria method, of class DataRestaurante.
     */
    @Test
    public void testGetColCategoria() {
        System.out.println("getColCategoria");
        DataRestaurante instance = new DataRestaurante("nickname", "nombre", "j@j.com", "direccion", null, null);
        Map expResult = null;
        Map result = instance.getColCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
