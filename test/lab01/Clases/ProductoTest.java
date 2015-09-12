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
public class ProductoTest {
    
    public ProductoTest() {
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
     * Test of getNombre method, of class Producto.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Producto.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class Producto.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class Producto.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecio method, of class Producto.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        double expResult = 0.0;
        double result = instance.getPrecio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class Producto.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        double precio = 0.0;
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        instance.setPrecio(precio);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getImagen method, of class Producto.
     */
    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        String expResult = "";
        String result = instance.getImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setImagen method, of class Producto.
     */
    @Test
    public void testSetImagen() {
        System.out.println("setImagen");
        String imagen = "";
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        instance.setImagen(imagen);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     *
     */
    public class ProductoImpl extends Producto {

        public ProductoImpl(String nombre, String descripcion, double precio, int cantidad) {
            super(nombre, descripcion, precio, cantidad);
        }

        @Override
        public boolean prodDisponible(int cantidad) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void restarStock(int cantidad) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DataCarrito getDataCarrito(int cantidad) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    /**
     * Test of getCantidad method, of class Producto.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        int expResult = 0;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class Producto.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cant = 0;
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        instance.setCantidad(cant);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProdStock method, of class Producto.
     */
    @Test
    public void testGetProdStock() {
        System.out.println("getProdStock");
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        Producto_Stock expResult = null;
        Producto_Stock result = instance.getProdStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setProdStock method, of class Producto.
     */
    @Test
    public void testSetProdStock() {
        System.out.println("setProdStock");
        Producto_Stock prodStock = null;
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        instance.setProdStock(prodStock);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of prodDisponible method, of class Producto.
     */
    @Test
    public void testProdDisponible() {
        System.out.println("prodDisponible");
        int cantidad = 0;
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        boolean expResult = false;
        boolean result = instance.prodDisponible(cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDataCarrito method, of class Producto.
     */
    @Test
    public void testGetDataCarrito() {
        System.out.println("getDataCarrito");
        int cantidad = 0;
        Producto instance = new ProductoImpl("nombre", "descripcion", 125.0, 8);
        DataCarrito expResult = null;
        DataCarrito result = instance.getDataCarrito(cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
