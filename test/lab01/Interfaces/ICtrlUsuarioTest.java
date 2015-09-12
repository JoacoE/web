/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;

import java.util.Map;
import lab01.Clases.DataCliente;
import lab01.Clases.DataRestaurante;
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
public class ICtrlUsuarioTest {
    
    public ICtrlUsuarioTest() {
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
     * Test of setNickname method, of class ICtrlUsuario.
     */
    @Test
    public void testSetNickname() {
        System.out.println("setNickname");
        String nick = "";
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        instance.setNickname(nick);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNickname method, of class ICtrlUsuario.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        String expResult = "";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarDatos method, of class ICtrlUsuario.
     */
    @Test
    public void testIngresarDatos() {
        System.out.println("ingresarDatos");
        String nickname = "";
        String email = "";
        String nombre = "";
        String direccion = "";
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        boolean expResult = false;
        boolean result = instance.ingresarDatos(nickname, email, nombre, direccion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCliente method, of class ICtrlUsuario.
     */
    @Test
    public void testRegistrarCliente() {
        System.out.println("registrarCliente");
        String apellido = "";
        String imagen = "";
        String fecha = "";
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        instance.registrarCliente(apellido, imagen, fecha);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarRestaurante method, of class ICtrlUsuario.
     */
    @Test
    public void testRegistrarRestaurante() {
        System.out.println("registrarRestaurante");
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        instance.registrarRestaurante(null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of datosAdicionales method, of class ICtrlUsuario.
     */
    @Test
    public void testDatosAdicionales() {
        System.out.println("datosAdicionales");
        String apellido = "";
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        instance.datosAdicionales(apellido);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarioByNickname method, of class ICtrlUsuario.
     */
    @Test
    public void testGetUsuarioByNickname() {
        System.out.println("getUsuarioByNickname");
        String nickname = "";
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        DataCliente expResult = null;
        DataCliente result = instance.getUsuarioByNickname(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRestauranteByNickname method, of class ICtrlUsuario.
     */
    @Test
    public void testGetRestauranteByNickname() {
        System.out.println("getRestauranteByNickname");
        String nickname = "";
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        Restaurante expResult = null;
        Restaurante result = instance.getRestauranteByNickname(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of devListaDC method, of class ICtrlUsuario.
     */
    @Test
    public void testDevListaDC() {
        System.out.println("devListaDC");
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        Map expResult = null;
        Map result = instance.devListaDC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCat method, of class ICtrlUsuario.
     */
    @Test
    public void testRegistrarCat() {
        System.out.println("registrarCat");
        String nombre = "";
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        instance.registrarCat(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of retColCat method, of class ICtrlUsuario.
     */
    @Test
    public void testRetColCat() {
        System.out.println("retColCat");
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        Map expResult = null;
        Map result = instance.retColCat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCat method, of class ICtrlUsuario.
     */
    @Test
    public void testSetCat() {
        System.out.println("setCat");
        Map cate = null;
        ICtrlUsuario instance = new ICtrlUsuarioImpl();
        instance.setCat(cate);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class ICtrlUsuarioImpl implements ICtrlUsuario {

        @Override
        public void setNickname(String nick) {
        }

        @Override
        public String getNickname() {
            return "";
        }

        @Override
        public boolean ingresarDatos(String nickname, String email, String nombre, String direccion) {
            return false;
        }

        @Override
        public void registrarCliente(String apellido, String imagen, String fecha) {
        }

        public void registrarRestaurante() {
        }

        @Override
        public void datosAdicionales(String apellido) {
        }

        @Override
        public DataCliente getUsuarioByNickname(String nickname) {
            return null;
        }

        @Override
        public Restaurante getRestauranteByNickname(String nickname) {
            return null;
        }

        @Override
        public Map devListaDC() {
            return null;
        }

        @Override
        public void registrarCat(String nombre) {
        }

        @Override
        public Map retColCat() {
            return null;
        }

        @Override
        public void setCat(Map cate) {
        }

        /**
         *
         * @return
         */
        @Override
        public Map listaDataRestaurantes() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void registrarRestaurante(DataRestaurante dt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
