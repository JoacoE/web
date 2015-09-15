/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.Interfaces;

import java.text.SimpleDateFormat;
import lab01.Handlers.Fabrica;
import lab01.Clases.DataCliente;
import lab01.Clases.Cliente;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import lab01.Clases.DataIndividual;
import lab01.Clases.DataPedido;
import lab01.Clases.DataPromocional;
import lab01.Clases.DataRestaurante;
import lab01.Clases.Pedido;
import lab01.Clases.estados;
import lab01.Handlers.HUsuario;

/**
 *
 * @author martin
 */
public class CargarDatos extends javax.swing.JFrame {
    private ICtrlUsuario ICU;
    private ICtrlPedido ICPed;
    private ICtrlProducto ICProd;
    private HUsuario HU;
    /**
     * Creates new form CargarDatos
     */
    public CargarDatos() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getICtrlUsuario();
        ICPed = fabrica.getICtrlPedido();
        ICProd = fabrica.getICtrlProducto();
        HU = HUsuario.getinstance();
        CrearDatosPorDefecto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void CrearDatosPorDefecto(){

      //CLIENTES
      
      ICU.ingresarDatos("costas", "gcostas@gmail.com","Gerardo",  "Av. Italia 2078");
      ICU.registrarCliente("Costas", "C:\\Users\\mcastro\\Documents\\NetBeansProjects\\ProgramacionDeAplicaciones\\images\\costas.jpeg", "15/11/1983");
     
      ICU.ingresarDatos("roro", "rcotelo@yahoo.com","Rodrigo", "Pdte. Berro 1548");
      ICU.registrarCliente("Cotelo", "C:\\Users\\mcastro\\Documents\\NetBeansProjects\\ProgramacionDeAplicaciones\\images\\roro.jpeg", "02/08/1975");

      ICU.ingresarDatos("chechi", "cgarrido@hotmail.com","Cecilia", "Gral. Urquiza 1548");
      ICU.registrarCliente("Garrido", "C:\\Users\\mcastro\\Documents\\NetBeansProjects\\ProgramacionDeAplicaciones\\images\\chechi.jpeg", "12/09/1987");
     
      ICU.ingresarDatos("andy", "agarcia@gmail.com","Andrea", "Dr. Manuel Albo 4512");
      ICU.registrarCliente("García", "C:\\Users\\mcastro\\Documents\\NetBeansProjects\\ProgramacionDeAplicaciones\\imagesandy.jpeg", "28/07/1951");

      ICU.ingresarDatos("weiss", "aweiss@gmail.com","Adrián", "Monte Caseros 5615");
      ICU.registrarCliente("Weiss", "C:\\Users\\mcastro\\Documents\\NetBeansProjects\\ProgramacionDeAplicaciones\\images\\generico.jpeg", "23/12/1978");
 
      //CATEGORÍAS
     
      ICU.registrarCat("Chivitos");
      ICU.registrarCat("Minutas");
      ICU.registrarCat("Parrilla");
      ICU.registrarCat("Pizzas");
      ICU.registrarCat("Empanadas");
      ICU.registrarCat("Milanesas");
      ICU.registrarCat("Ensaladas");
      ICU.registrarCat("Pastas");
      ICU.registrarCat("Comida China");
      ICU.registrarCat("Picadas");
      ICU.registrarCat("Woks");
      ICU.registrarCat("Comida Mexicana");
      ICU.registrarCat("Entradas");
      ICU.registrarCat("Bebidas");
      ICU.registrarCat("Sushi");
     
      //RESTAURANTES
 
      Map Categorias1 = new HashMap();
      Categorias1.put("Chivitos", ICU.retColCat().get("Chivitos"));
      Categorias1.put("Minutas", ICU.retColCat().get("Minutas"));
      Categorias1.put("Parrilla", ICU.retColCat().get("Parrilla"));
      Categorias1.put("Pizzas", ICU.retColCat().get("Pizzas"));
      DataRestaurante res1 = new DataRestaurante();
      res1.setColCategoria(Categorias1);
      res1.setColProducto(null);
      res1.setDireccion("Av 8 de octubre 2704");
      res1.setEmail("mera@hotmail.com");
      res1.setLstImagen(null);
      res1.setNickname("mera");
      res1.setNombre("Pizzería Mera");
      ICU.registrarRestaurante(res1);
     
      Map Categorias2 = new HashMap();
      Categorias2.put("Chivitos", ICU.retColCat().get("Chivitos"));
      Categorias2.put("Minutas", ICU.retColCat().get("Minutas"));
      Categorias2.put("Pastas", ICU.retColCat().get("Pastas"));
      Categorias2.put("Pizzas", ICU.retColCat().get("Pizzas"));
      DataRestaurante res2 = new DataRestaurante();
      res2.setColCategoria(Categorias2);
      res2.setColProducto(null);
      res2.setDireccion("Bvar. Artigas 1601");
      res2.setEmail("bar.rossel@gmail.com");
      res2.setLstImagen(null);
      res2.setNickname("rossell");
      res2.setNombre("Bar Rossell");
      ICU.registrarRestaurante(res2);
     
      Map Categorias3 = new HashMap();
      Categorias3.put("Empanadas", ICU.retColCat().get("Empanadas"));
      DataRestaurante res3 = new DataRestaurante();
      res3.setColCategoria(Categorias3);
      res3.setColProducto(null);
      res3.setDireccion("18 de julio 2138");
      res3.setEmail("bocatti@gmail.com");
      res3.setLstImagen(null);
      res3.setNickname("bocatti");
      res3.setNombre("Empanadas Bocatti");
      ICU.registrarRestaurante(res3);
     
      Map Categorias4 = new HashMap();
      Categorias4.put("Woks", ICU.retColCat().get("Woks"));
      Categorias4.put("Pastas", ICU.retColCat().get("Pastas"));
      Categorias4.put("Comida China", ICU.retColCat().get("Comida China"));
      DataRestaurante res4 = new DataRestaurante();
      res4.setColCategoria(Categorias4);
      res4.setColProducto(null);
      res4.setDireccion("Libertad 2535");
      res4.setEmail("wok.in.box@hotmail.com");
      res4.setLstImagen(null);
      res4.setNickname("winb");
      res4.setNombre("Wok in Box");
      ICU.registrarRestaurante(res4);
     
      //PRODUCTOS INDIVIDUALES
     
      DataIndividual di1 = new DataIndividual("Asado", "Asado a la parrilla", 225.0, null, 300);
      ICProd.registrarProducto(di1, "mera", false);
     
      DataIndividual di2 = new DataIndividual("Milanesa de Carne", "Con lechuga, tomate, mayonesa y fritas", 180.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/milanesa-de-carne.jpg", 150);
      ICProd.registrarProducto(di2, "mera", false);
     
      DataIndividual di3 = new DataIndividual("Chivito canadiense", "Lomito, jamón, muzza, tomate, aceitunas, panceta, huevo, morrón y fritas", 305.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/chivito-canadiense.jpg", 49);
      ICProd.registrarProducto(di3, "mera", false);
     
      DataIndividual di4 = new DataIndividual("Pizza 2 gustos", "Pizza con dos gustos a elección", 130.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/generico.jpg", 100);
      ICProd.registrarProducto(di4, "mera", false);

      DataIndividual di5 = new DataIndividual("Chivito al plato", "Ensalada rusa, mixta, huevo, jamón, muzza, panceta, aceitunas y fritas", 324.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/generico.jpg", 115);
      ICProd.registrarProducto(di5, "rossell", false);
     
      DataIndividual di6 = new DataIndividual("Milanesa a caballo", "Milanesa con dos huevos fritos acompañado de fritas", 270.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/milanesa-a-caballo.jpg", 35);
      ICProd.registrarProducto(di6, "rossell", false);
     
      DataIndividual di7 = new DataIndividual("Pizza 2 gustos", "Pizza con dos gustos a elección", 103.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/generico.jpg", 45);
      ICProd.registrarProducto(di7, "rossell", false);
     
      DataIndividual di8 = new DataIndividual("Agnolotis", "Agnolotis de jamón y queso", 225.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/agnolotis.jpg", 50);
      ICProd.registrarProducto(di8, "rossell", false);
     
      DataIndividual di9 = new DataIndividual("Empanada de carne", "Carne, aceitunas, huevo duro, condimentos", 44.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/empanada-de-carne.jpg", 65);
      ICProd.registrarProducto(di9, "bocatti", false);     

      DataIndividual di10 = new DataIndividual("Empanada Americana", "Carne, panceta y huevo duro", 44.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/generico.jpg", 70);
      ICProd.registrarProducto(di10, "bocatti", false);
     
      DataIndividual di11 = new DataIndividual("Empanada QyC", "Empanada de Queso y Cebolla", 44.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/empanada-qyc.jpg", 333);
      ICProd.registrarProducto(di11, "bocatti", false);
     
      
      DataIndividual di12 = new DataIndividual("Empanada Capresse", "Queso, tomate y albahaca", 44.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/empanada-capresse.jpg", 230);
      ICProd.registrarProducto(di12, "bocatti", false);     
     
      DataIndividual di13 = new DataIndividual("Thai wok", "Cerdo, calamares, sweet chili, salsa de ostras, maní y jugo de lima, acompañado de tallarines o arroz.", 240.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/tahi-wok.jpg", 222);
      ICProd.registrarProducto(di13, "winb", false);
     
      DataIndividual di14 = new DataIndividual("China wok", "Tempura de cerdo, vegetales mixtos, almendras, salsa de soja y naranja, acompañado de tallarines o arroz.", 240.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/generico.jpg", 38);
      ICProd.registrarProducto(di14, "winb", false); 
     
      DataIndividual di15 = new DataIndividual("Classic wok de pollo", "Pollo, vegetales mixtos, salsa agridulce, salsa de soja y cebollita de verdeo, acompañado de tallarines o arroz.", 230.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/classic-wok-de-pollo.jpg", 44);
      ICProd.registrarProducto(di15, "winb", false);
     
      DataIndividual di16 = new DataIndividual("Classic wok de cerdo", "Cerdo, vegetales mixtos, jengibre, salsa de ostras y ralladura de lima, acompañado de tallarines o arroz.", 230.0, "/home/martin/NetBeansProjects/ProgAplicaciones/images/productos/generico.jpg", 65);
      ICProd.registrarProducto(di16, "winb", false);
      
      // Productos Promocionales
      
      Map indivProm1 = new HashMap();
      DataPromocional dprom1 = new DataPromocional();
      dprom1.setDataNombre("ChiviPizza");
      dprom1.setDataDescripcion("Chivito y Pizza");
      dprom1.setDescuento(20);
      String nomProd1Prom1 = "Chivito canadiense";
      int cantProd1Prom1 = 1;
      indivProm1.put(nomProd1Prom1, cantProd1Prom1);
      String nomProd2Prom1 = "Pizza 2 gustos";
      int cantProd2Prom1 = 1;
      indivProm1.put(nomProd2Prom1, cantProd2Prom1);
      ICProd.setPromo(indivProm1);
      ICProd.armarPromo("mera", dprom1.getDataNombre(), dprom1.getDataDescripcion(), dprom1.getDescuento());
      
      Map indivProm2 = new HashMap();
      DataPromocional dprom2 = new DataPromocional();
      dprom2.setDataNombre("MilaAsado");
      dprom2.setDataDescripcion("3 Milanesas + 1 Asado para compartir");
      dprom2.setDescuento(30);
      String nomProd1Prom2 = "Milanesa de Carne";
      int cantProd1Prom2 = 3;
      indivProm2.put(nomProd1Prom2, cantProd1Prom2);
      String nomProd2Prom2 = "Asado";
      int cantProd2Prom2 = 1;
      indivProm2.put(nomProd2Prom2, cantProd2Prom2);
      ICProd.setPromo(indivProm2);
      ICProd.armarPromo("mera", dprom2.getDataNombre(), dprom2.getDataDescripcion(), dprom2.getDescuento());
      
      Map indivProm3 = new HashMap();
      DataPromocional dprom3 = new DataPromocional();
      dprom3.setDataNombre("MilaPizza");
      dprom3.setDataDescripcion("2 Milanesas a caballo + 1 Pizzas 2 gustos");
      dprom3.setDescuento(30);
      String nomProd1Prom3 = "Milanesa a caballo";
      int cantProd1Prom3 = 2;
      indivProm3.put(nomProd1Prom3, cantProd1Prom3);
      String nomProd2Prom3 = "Pizza 2 gustos";
      int cantProd2Prom3 = 1;
      indivProm3.put(nomProd2Prom3, cantProd2Prom3);
      ICProd.setPromo(indivProm3);
      ICProd.armarPromo("rossell", dprom3.getDataNombre(), dprom3.getDataDescripcion(), dprom3.getDescuento());
      
      // Pedidos
      
      ICPed.setNickname("costas");
      ICPed.setMemCliente();
      ICPed.setMailCliente("gcostas@gmail.com");
      ICPed.setMemRestaurante("bocatti");
      boolean prod1ped1 = ICPed.selectProductos("Empanada de carne", 1);
      boolean prod2ped1 = ICPed.selectProductos("Empanada Americana", 2);
      boolean prod3ped1 = ICPed.selectProductos("Empanada QyC", 2);
      DataPedido ped1 = ICPed.altaPedido();
      ICPed.limpiarCtrl();
      
      Cliente c1 = HU.obtenerUsuario(ped1.getNickUsr());
      Pedido p1 = c1.getPedido(ped1.getId());
      p1.setFecha("12/8/2014");
      
      ICPed.setNickname("roro");
      ICPed.setMemCliente();
      ICPed.setMailCliente("rcotelo@yahoo.com");
      ICPed.setMemRestaurante("mera");
      boolean prod1ped2 = ICPed.selectProductos("Asado", 3);
      DataPedido ped2 = ICPed.altaPedido();
      ICPed.limpiarCtrl();
      
      Cliente c2 = HU.obtenerUsuario(ped2.getNickUsr());
      Pedido p2 = c2.getPedido(ped2.getId());
      p2.setFecha("19/8/2014");
      ICPed.actualizarEPedido(ped2.getNickUsr(), p2.getId(), estados.ENVIADO);
      
      ICPed.setNickname("chechi");
      ICPed.setMemCliente();
      ICPed.setMailCliente("cgarrido@hotmail.com");
      ICPed.setMemRestaurante("winb");
      boolean prod1ped3 = ICPed.selectProductos("Thai wok", 2);
      boolean prod2ped3 = ICPed.selectProductos("China wok", 3);
      DataPedido ped3 = ICPed.altaPedido();
      ICPed.limpiarCtrl();
      
      Cliente c3 = HU.obtenerUsuario(ped3.getNickUsr());
      Pedido p3 = c3.getPedido(ped3.getId());
      p3.setFecha("19/8/2014");
      ICPed.actualizarEPedido(ped3.getNickUsr(), p3.getId(), estados.RECIBIDO);
      
      ICPed.setNickname("andy");
      ICPed.setMemCliente();
      ICPed.setMailCliente("agarcia@gmail.com");
      ICPed.setMemRestaurante("mera");
      boolean prod1ped4 = ICPed.selectProductos("Chivito canadiense", 4);
      DataPedido ped4 = ICPed.altaPedido();
      ICPed.limpiarCtrl();
      
      Cliente c4 = HU.obtenerUsuario(ped4.getNickUsr());
      Pedido p4 = c4.getPedido(ped4.getId());
      p4.setFecha("22/8/2014");
      ICPed.actualizarEPedido(ped4.getNickUsr(), p4.getId(), estados.RECIBIDO);
      
      ICPed.setNickname("weiss");
      ICPed.setMemCliente();
      ICPed.setMailCliente("aweiss@gmail.com");
      ICPed.setMemRestaurante("rossell");
      boolean prod1ped5= ICPed.selectProductos("Agnolotis", 1);
      DataPedido ped5 = ICPed.altaPedido();
      ICPed.limpiarCtrl();
      
      Cliente c5 = HU.obtenerUsuario(ped5.getNickUsr());
      Pedido p5 = c5.getPedido(ped5.getId());
      p5.setFecha("25/8/2014");
      ICPed.actualizarEPedido(ped5.getNickUsr(), p5.getId(), estados.RECIBIDO);
      
        JOptionPane.showMessageDialog(null, "Los datos de prueba se cargaron con exito","EXITO",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CargarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
